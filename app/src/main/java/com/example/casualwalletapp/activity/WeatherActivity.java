package com.example.casualwalletapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.adapter.WeatherAdapter;
import com.example.casualwalletapp.constant.Constant;
import com.example.casualwalletapp.models.weather.ResponseWeather;
import com.example.casualwalletapp.mvvm.MVVM;
import com.example.casualwalletapp.retrofit.RetrofitWeather;
import com.example.casualwalletapp.sourceApi.GetWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeatherActivity extends AppCompatActivity {

    Retrofit retrofit;
    WeatherAdapter weatherAdapter;
    GetWeather getWeather;
    ListView listView;
    ResponseWeather responseWeather;
    Call<ResponseWeather> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        fixElements();

        call.enqueue(new Callback<ResponseWeather>() {
            @Override
            public void onResponse(Call<ResponseWeather> call, Response<ResponseWeather> response) {

                System.out.println("Weather Kontrol " + "CODE " + response.code() + " SUCCESSS " + response.isSuccessful() + " BODY " + response.body());
                if (response.code() == 200 && response.body() != null && response.isSuccessful()) {
                    responseWeather = response.body();
                    weatherAdapter = new WeatherAdapter(WeatherActivity.this, responseWeather);
                    listView.setAdapter(weatherAdapter);
                } else {
                    Toast.makeText(WeatherActivity.this, "Şehir ismi yanlış girildi veya şehir sistemde kayıtlı değil", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(WeatherActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ResponseWeather> call, Throwable t) {
                System.out.println(t.getMessage() + " HATA VAR MI ???????????");
                ;
            }
        });

    }

    private void fixElements() {
        listView = findViewById(R.id.weatherListView);
        String aqi = "no";
        // url 'i http yapınca "CLEARTEXT communication to api.weatherapi.com not permitted by network security policy" hatası verdi
        retrofit = RetrofitWeather.createRetrofit("https://api.weatherapi.com/");
        getWeather = retrofit.create(GetWeather.class);
        call = getWeather.getResponseWeather(MVVM.weatherCityName, aqi);

    }
}