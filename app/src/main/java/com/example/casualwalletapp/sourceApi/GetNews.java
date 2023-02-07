package com.example.casualwalletapp.sourceApi;

import com.example.casualwalletapp.BuildConfig;
import com.example.casualwalletapp.constant.Constant;
import com.example.casualwalletapp.models.ReplyNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetNews {

    @Headers({
            "content-type:application/json",
            "authorization:apikey" + Constant.API_KEY_NEWS
    })

    @GET("/news/getNews?country=tr&tag=general")
    Call<ReplyNews> getAllNews();

    //Dinamik parametre  yazma bu şekilde değil....Aşağıdaki gibi olacak
    // @GET("/news/getNewsLocal?city={localCity}")
    // Call<ReplyNews> getLocalNews1(@Path("localCity") String localCity);

    @Headers({
            "content-type:application/json",
            "authorization:apikey" + Constant.API_KEY_NEWS
    })
    @GET("/news/getNewsLocal?")
    Call<ReplyNews> getLocalNews(@Query("localCity") String localCity);

}
