package com.example.casualwalletapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.adapter.CustomListViewAdapter;
import com.example.casualwalletapp.models.ReplyNews;
import com.example.casualwalletapp.mvvm.MVVM;
import com.example.casualwalletapp.retrofit.RetrofitNews;
import com.example.casualwalletapp.sourceApi.GetNews;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LocalNewsActivity extends AppCompatActivity {

    CustomListViewAdapter customListViewAdapter;
    ListView listView ;
    ReplyNews replyNews;
    GetNews getNews;
    Retrofit retrofit;
    Call<ReplyNews> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_news);

        fixElements();

        call.enqueue(new Callback<ReplyNews>() {
            @SuppressLint("ResourceType")
            @Override
            public void onResponse(Call<ReplyNews> call, Response<ReplyNews> response) {

                //yerel haber isteği API kaynağı tarafından karşılanmayınca
                if(response.body().isSuccess()==false || response.body().getResult().size()==0 || response.body().getResult()==null) {
                    Toast toast = new Toast(LocalNewsActivity.this);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setText("Üzgünüz, haber kaynağı iptal olmuş");
                    toast.show();
                    Intent intent = new Intent(LocalNewsActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
                replyNews=response.body();
                customListViewAdapter=new CustomListViewAdapter(LocalNewsActivity.this,replyNews.getResult());
            }
            @Override
            public void onFailure(Call<ReplyNews> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(LocalNewsActivity.this,"Hata oluştu..."+t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void fixElements() {
        listView=findViewById(R.id.localNewsListView);

        retrofit= RetrofitNews.getSingletoneRetrofit();
        getNews=retrofit.create(GetNews.class);

        call = getNews.getLocalNews(MVVM.newsCİtyName);

    }
}