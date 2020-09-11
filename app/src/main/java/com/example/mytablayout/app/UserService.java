package com.example.mytablayout.app;

import com.example.mytablayout.model.IQStudent;
import com.example.mytablayout.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("hours/")
    Call<List<Student>> getLearnersHours();


    @GET("skilliq/")
    Call<List<IQStudent>> getLearnersIq();
}
