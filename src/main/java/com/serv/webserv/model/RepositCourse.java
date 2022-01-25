package com.serv.webserv.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.serv.webserv.Log.Loging;
import com.serv.webserv.service.GetCurrencies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@JacksonXmlRootElement(localName = "exchanges")
public class RepositCourse implements Reposit{

    @JacksonXmlProperty(localName = "currency")
    @JacksonXmlElementWrapper(useWrapping = false, localName = "dest")
       private List<Currency> currencyList;


    private final GetCurrencies getCurrencies;



    public RepositCourse(GetCurrencies getCurrencies) {
        currencyList = new ArrayList<>();
        this.getCurrencies = getCurrencies;
        update();
    }
    @Loging
    @Override
    public void updateCourses() {
        currencyList = getCurrencies.getCourses();
    }

    @Override
    public List<Currency> getCourseList() {
        return currencyList;
    }

    @Loging
    @Override
    public List<Currency> getCourseList(String val) {
        return currencyList.stream()
                .filter(c->c.getCode().equals(val)).collect(Collectors.toList());
    }

    @Loging
    private void update(){
        new Thread(() -> {
            while (true){
                updateCourses();
                try {
                    Thread.sleep(10800000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        }

}
