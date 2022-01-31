package com.serv.webserv.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
//@JacksonXmlRootElement(localName = "currency")
public class Currency {

    @JacksonXmlProperty(localName = "txt")
    private String name;
    @JacksonXmlProperty
    private double rate;
    @JacksonXmlProperty(localName = "cc")
    private String code;
    @JacksonXmlProperty(localName = "exchangedate")
    private LocalDate localDate;


    public Currency() {
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", code='" + code + '\'' +
                ", localDate=" + localDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Double.compare(currency.rate, rate) == 0 && Objects.equals(name, currency.name) && code.equals(currency.code) && localDate.equals(currency.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, code, localDate);
    }

    public Currency(String name, double rate, String code, LocalDate localDate) {
        this.name = name;
        this.rate = rate;
        this.code = code;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}
