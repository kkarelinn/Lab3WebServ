package com.serv.webserv.controller;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.serv.webserv.Log.Loging;
import com.serv.webserv.model.Currency;
import com.serv.webserv.model.Reposit;
import com.serv.webserv.model.RepositCourse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
    @RequestMapping("/")
    public class MainController {
       private final  Reposit reposit;

    @Loging
        public MainController(RepositCourse reposit) {
            this.reposit = reposit;
        }
        @GetMapping("/currency")
        public List<Currency> getAll(@RequestParam(defaultValue = "all") String valCode) {
            if (!"all".equals(valCode)) return reposit.getCourseList(valCode);
            return reposit.getCourseList();
        }

}
