package com.example.student.bdjavadeveloper.api;

import com.example.student.bdjavadeveloper.model.javaDeveloperModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("search/users?q=language:java+location:dhaka")
    //json to pojo--->converts json to to Api

    Call<javaDeveloperModel> getAllItem();
}
