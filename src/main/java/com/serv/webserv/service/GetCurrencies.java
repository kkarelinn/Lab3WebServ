package com.serv.webserv.service;

import com.serv.webserv.Log.Logging;
import com.serv.webserv.model.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GetCurrencies {


    @Value("${Url}")
    public String sourceUrl;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Logging
    public List<Currency> getCourses() {
        List<Currency> list = new ArrayList<>();
        try {
            Document answer = Jsoup.connect(sourceUrl).get();
            Elements tests = answer.getElementsByTag("currency");
            for (Element testElement : tests) {
                String name = Objects.requireNonNull(testElement.selectFirst("txt")).text();
                double rate = Double.parseDouble(Objects.requireNonNull(testElement.selectFirst("rate")).text());
                String code = Objects.requireNonNull(testElement.selectFirst("cc")).text();
                LocalDate localDate = LocalDate.parse(Objects.requireNonNull(testElement.selectFirst("exchangedate")).text(), formatter);
                list.add(new Currency(name, rate, code, localDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
