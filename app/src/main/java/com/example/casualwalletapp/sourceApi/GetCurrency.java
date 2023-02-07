package com.example.casualwalletapp.sourceApi;

import com.example.casualwalletapp.models.Currency;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCurrency {

    @GET("doviz.json")
    public Call<Currency> getCurrency();
}
