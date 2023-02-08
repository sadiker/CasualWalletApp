package com.example.casualwalletapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.adapter.CityImageAdapter;
import com.example.casualwalletapp.dialogBuilder.MyDialog;
import com.example.casualwalletapp.mvvm.MVVM;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button generalNewsButton, localNewsButton, currencyButton, weatherButton;
    Button button, button2, button3, button4, button5;
    ImageView imageView;
    RecyclerView recyclerView;
    CityImageAdapter cityImageAdapter;
    List<String> urlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlList = new ArrayList<String>();
        seedUrlList();
        fixElements();

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);


        generalNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
        localNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = MyDialog.createBuilder(MainActivity.this);
                builder.setTitle("CasualWallet");
                builder.setIcon(R.drawable.icon_casualwallet);
                builder.setMessage("Mesaj bölümü");
                EditText editText = new EditText(MainActivity.this);
                editText.setHint("Şehir ismini buraya yazınız...");
                builder.setView(editText);


                builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MVVM.newsCİtyName = editText.getText().toString();
                        Intent intent = new Intent(MainActivity.this, LocalNewsActivity.class);
                        startActivity(intent);
                    }
                });

                builder.show();

            }
        });
        currencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrencyActivity.class);
                startActivity(intent);

            }
        });
        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText1 = new EditText(MainActivity.this);
                editText1.setHint("Şehir ismini buraya yazınız...");
                AlertDialog.Builder builder = MyDialog.createBuilder(MainActivity.this);
                builder.setTitle("CasualWallet");
                builder.setMessage("Arama yaparken Türkçe karakter kullanmayınız...");
                builder.setIcon(R.drawable.icon_casualwallet);
                builder.setView(editText1);

                builder.setPositiveButton("Devam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MVVM.weatherCityName=editText1.getText().toString();
                        System.out.println(MVVM.weatherCityName);
                        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();

            }
        });
    }

    private void fixElements() {
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.icon_casualwallet);

        recyclerView = findViewById(R.id.recyclerView);

        cityImageAdapter = new CityImageAdapter(urlList, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(cityImageAdapter);

        generalNewsButton = findViewById(R.id.allNewsButton);
        localNewsButton = findViewById(R.id.localNewsButton);
        currencyButton = findViewById(R.id.currencyButton);
        weatherButton = findViewById(R.id.weatherButton);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
    }

    private void seedUrlList() {

        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/S%C3%BCmela_Manast%C4%B1r%C4%B1%2C_Trabzon.jpg/220px-S%C3%BCmela_Manast%C4%B1r%C4%B1%2C_Trabzon.jpg");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Pergamon_-_04.jpg/200px-Pergamon_-_04.jpg");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Ankara_and_mosque_wza.jpg/220px-Ankara_and_mosque_wza.jpg");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Diyarbakr%C4%B1_Ulu_cami.JPG/220px-Diyarbakr%C4%B1_Ulu_cami.JPG");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Alanya.jpg/250px-Alanya.jpg");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Three_tombs_-_%C3%9C%C3%A7_k%C3%BCmbetler_04.jpg/240px-Three_tombs_-_%C3%9C%C3%A7_k%C3%BCmbetler_04.jpg");
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Istanbul_asv2020-02_img47_Galata_Tower.jpg/208px-Istanbul_asv2020-02_img47_Galata_Tower.jpg");

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/sadiker"));
        startActivity(intent);
    }
}