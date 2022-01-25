package com.serv.webserv.model;

import java.util.List;

public interface Reposit {

    void updateCourses();
    List<Currency> getCourseList();
    List<Currency> getCourseList( String val);
  //  double getCourse(String val);
}
