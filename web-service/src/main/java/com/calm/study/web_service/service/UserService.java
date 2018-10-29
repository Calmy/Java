package com.calm.study.web_service.service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.calm.study.web_service.entity.User;

@WebService(name = "userService" ,targetNamespace = "http://service.web_service.study.calm.com/")
public interface UserService {
    @WebMethod
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    User getUser(String userI);

    @WebMethod
    ArrayList<User> getAlLUser();
}