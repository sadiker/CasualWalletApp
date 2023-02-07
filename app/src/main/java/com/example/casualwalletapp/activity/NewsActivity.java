package com.example.casualwalletapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.adapter.CustomListViewAdapter;
import com.example.casualwalletapp.models.ReplyNews;
import com.example.casualwalletapp.retrofit.RetrofitNews;
import com.example.casualwalletapp.sourceApi.GetNews;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    CustomListViewAdapter customListViewAdapter;
    ListView listView;
    ReplyNews replyNews;

    GetNews getNews;
    Call<ReplyNews> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        listView = findViewById(R.id.localNewsListView);

        getNews = RetrofitNews.getSingletoneRetrofit().create(GetNews.class);

        call = getNews.getAllNews();

        call.enqueue(new Callback<ReplyNews>() {
            @Override
            public void onResponse(Call<ReplyNews> call, Response<ReplyNews> response) {
                replyNews = response.body();
                customListViewAdapter = new CustomListViewAdapter(NewsActivity.this, replyNews.getResult());
                listView.setAdapter(customListViewAdapter);
            }

            @Override
            public void onFailure(Call<ReplyNews> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "Hata oluştu..." + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}