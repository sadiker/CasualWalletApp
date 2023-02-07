package com.example.casualwalletapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWeather {

    private static RetrofitWeather retrofitWeather;
    private static Retrofit retrofit;


    private RetrofitWeather(String url ) {
        retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit createRetrofit(String url){
        if(retrofit==null){
            retrofitWeather= new RetrofitWeather(url);
        }
        return RetrofitWeather.retrofit;
    }

}
