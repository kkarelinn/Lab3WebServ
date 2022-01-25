package com.serv.webserv.controller;

import com.serv.webserv.Log.Logging;
import com.serv.webserv.model.AnswerXML;
import com.serv.webserv.model.Reposit;
import com.serv.webserv.model.RepositCourses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Logging
@RestController
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public class MainController {
       private final Reposit reposit;
       private final AnswerXML answerXML;

        public MainController(RepositCourses reposit, AnswerXML answerXML) {
            this.reposit = reposit;
            this.answerXML = answerXML;
        }

    @GetMapping(value = "/currency")
    public AnswerXML getCur(@RequestParam(required = false) String code) {

        if (code == null) answerXML.setRespList(reposit.getCourseList());
        else answerXML.setRespList(reposit.getCourseList(code));
        return (answerXML.getRespList().size() < 1) ? null : answerXML;
    }

}


