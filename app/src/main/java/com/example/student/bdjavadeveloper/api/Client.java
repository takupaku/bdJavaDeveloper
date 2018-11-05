package com.example.student.bdjavadeveloper.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL="https://api.github.com/";
    private static Retrofit retrofit= null;
    public static  Retrofit getClient(){
        if(retrofit == null ){
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        }
        return retrofit;
    }
}
