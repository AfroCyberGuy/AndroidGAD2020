package com.example.mytablayout.app;

import com.example.mytablayout.model.IQStudent;
import com.example.mytablayout.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @GET("hours/")
    Call<List<Student>> getLearnersHours();


    @GET("skilliq/")
    Call<List<IQStudent>> getLearnersIq();

    @FormUrlEncoded()
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    public Call<String> addStudent(
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.1824927963") String email,
            @Field("entry.284483984") String projectLink);
}
