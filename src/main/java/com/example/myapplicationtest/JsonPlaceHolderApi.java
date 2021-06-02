package com.example.myapplicationtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {


    @GET("todos")

    Call<List<Todo>> getTodos();

    @GET("users")

    Call<List<Users>> getUsers();



}
