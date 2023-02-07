package com.example.casualwalletapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.adapter.CurrencyAdapter;
import com.example.casualwalletapp.models.Currency;
import com.example.casualwalletapp.retrofit.RetrofitCurrency;
import com.example.casualwalletapp.sourceApi.GetCurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CurrencyActivity extends AppCompatActivity {
    Retrofit retrofit;
    GetCurrency getCurrency;
    CurrencyAdapter currencyAdapter;
    RecyclerView recyclerView;
    List<Map<String, String>> listCurrency;
    Currency currency;
    String url;
    Call<Currency> call ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        Toast.makeText(CurrencyActivity.this, "Altın gram değeri gösterilmektedir.", Toast.LENGTH_SHORT).show();

        fixElements();

        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                System.out.println("Currency Kontrol "+" CODE " + response.code() + " SUCCESSS " + response.isSuccessful() + " BODY " + response.body());
                if (response.code() == 200 && response.isSuccessful() && response.body() != null) {
                    currency = response.body();
                    listCurrency.add(currency.getUSD());
                    listCurrency.add(currency.getEUR());
                    listCurrency.add(currency.getGBP());
                    listCurrency.add(currency.getGA());
                    listCurrency.add(currency.getXU100());

                    currencyAdapter = new CurrencyAdapter(CurrencyActivity.this, listCurrency);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CurrencyActivity.this));
                    recyclerView.setAdapter(currencyAdapter);
                } else {
                    Toast.makeText(CurrencyActivity.this, "Beklenmeyen hata oluştu.Daha sonra deneyiniz.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CurrencyActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(CurrencyActivity.this, "Hata oluştu.", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void fixElements() {
        recyclerView = findViewById(R.id.currencyRecylerView);
        url = "https://api.genelpara.com/embed/";
        retrofit = RetrofitCurrency.createRetrofit(url);
        getCurrency = retrofit.create(GetCurrency.class);

        call = getCurrency.getCurrency();

        listCurrency = new ArrayList<Map<String, String>>();
    }
}