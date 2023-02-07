package com.example.casualwalletapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitNews {

    private static RetrofitNews retrofitNews;
    private static Retrofit retrofit;

    private static  final String BASE_URL="https://api.collectapi.com";

    private RetrofitNews() {

        retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getSingletoneRetrofit(){
        if(retrofit==null){
            retrofitNews = new RetrofitNews();
        }
        return retrofitNews.retrofit;
    }
}
