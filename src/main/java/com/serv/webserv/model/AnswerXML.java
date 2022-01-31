package com.serv.webserv.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JacksonXmlRootElement(localName = "exchanges")
public class AnswerXML {
    @JacksonXmlProperty(localName = "currency")
    @JacksonXmlElementWrapper(useWrapping = false)

    private List<Currency> respList;

    public AnswerXML() {
    }

    public List<Currency> getRespList() {
        return respList;
    }

    public void setRespList(List<Currency> respList) {
        this.respList = respList;
    }

}
