package com.example.casualwalletapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCurrency {

    private static RetrofitCurrency retrofitCurrency;
    private static Retrofit retrofit;

    private RetrofitCurrency(String url ) {
        retrofit=new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit createRetrofit(String url){
        if(retrofit==null){
            retrofitCurrency= new RetrofitCurrency(url);
        }
        return retrofitCurrency.retrofit;
    }

}
