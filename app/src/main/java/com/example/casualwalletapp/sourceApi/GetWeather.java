package com.example.casualwalletapp.sourceApi;


import com.example.casualwalletapp.constant.Constant;
import com.example.casualwalletapp.models.weather.ResponseWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetWeather {

    @GET("v1/current.json?key="+ Constant.API_KEY_WEATHER)
    Call<ResponseWeather> getResponseWeather(@Query("q") String cityName,@Query("aqi") String aqi);

}
