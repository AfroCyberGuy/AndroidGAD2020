package com.example.mytablayout.app;

public class APIUtils {


    public APIUtils() {
    }


    public static final String API_URL =  "https://gadsapi.herokuapp.com/api/";


    public static UserService getLeadingLearners() {

        return StudentClient.getClient(API_URL).create(UserService.class);
    }


    public  static UserService getLearnersIQ(){

        return StudentClient.getClient(API_URL).create(UserService.class);
    }


}
