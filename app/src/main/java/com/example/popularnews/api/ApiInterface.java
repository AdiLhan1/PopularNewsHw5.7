package com.example.popularnews.api;

import com.example.popularnews.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<News> getnNws(
            @Query("country")String country,
            @Query("apikey")String apikey
    );
    @GET("everything")
    Call<News> getNewsSearch(
            @Query("q")String keyword,
            @Query("language")String language,
            @Query("sortBy")String sortby,
            @Query("apikey")String apikey
    );
}
