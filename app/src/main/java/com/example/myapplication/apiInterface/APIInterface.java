package com.example.myapplication.apiInterface;

import com.example.myapplication.model.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

 public interface APIInterface {
    
    @GET("/images/q-110/data.json")
    Call <ArrayList<Root>>  doGetUserList();
}