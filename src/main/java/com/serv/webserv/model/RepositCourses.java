package com.serv.webserv.model;

import com.serv.webserv.Log.Logging;
import com.serv.webserv.service.GetCurrencies;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositCourses implements Reposit{

    private List<Currency> currencyList;
    private final GetCurrencies getCurrencies;

    @Logging
    public RepositCourses(GetCurrencies getCurrencies) {
        currencyList = new ArrayList<>();
        this.getCurrencies = getCurrencies;
        update();
    }
    @Logging
    @Override
    public void updateCourses() {
        currencyList = getCurrencies.getCourses();
    }

    @Logging
    @Override
    public List<Currency> getCourseList() {
        return currencyList;
    }

    @Logging
    @Override
    public List<Currency> getCourseList(String val) {
        return currencyList.stream()
                .filter(c->c.getCode().equals(val)).collect(Collectors.toList());
    }

    @Logging
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
