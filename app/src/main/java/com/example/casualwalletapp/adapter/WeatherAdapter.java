package com.example.casualwalletapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.models.weather.ResponseWeather;
import com.squareup.picasso.Picasso;

public class WeatherAdapter extends BaseAdapter {

    Context context;
    ResponseWeather responseWeather;
    ImageView imageView;
    TextView  temp_cText,cityNameText,condition_textText,localtimeText,lastupdateText,humidityText,wind_kphText,pressure_mbText,countryText;

    public WeatherAdapter(Context context, ResponseWeather responseWeather) {
        this.context = context;
        this.responseWeather = responseWeather;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView =inflater.inflate(R.layout.weather_view,parent,false);
        }

        imageView = convertView.findViewById(R.id.weatherIconView);
        temp_cText=convertView.findViewById(R.id.temp_cText);
        cityNameText=convertView.findViewById(R.id.cityNameText);
        condition_textText=convertView.findViewById(R.id.condition_textText);
        localtimeText=convertView.findViewById(R.id.localtimeText);
        lastupdateText=convertView.findViewById(R.id.lastupdateText);
        humidityText=convertView.findViewById(R.id.humidityText);
        wind_kphText=convertView.findViewById(R.id.wind_kphText);
        pressure_mbText=convertView.findViewById(R.id.pressure_mbText);
        countryText=convertView.findViewById(R.id.countryText);


        temp_cText.setText(responseWeather.getCurrent().getTemp_c()+" °C");
        cityNameText.setText(responseWeather.getLocation().getName());
        condition_textText.setText(responseWeather.getCurrent().getCondition().getText());
        Picasso.with(context).load("https:"+responseWeather.getCurrent().getCondition().getIcon()).into(imageView);
        localtimeText.setText("Yerel Tarih/Saat: " +responseWeather.getLocation().getLocaltime());
        lastupdateText.setText("Son Güncelleme: "+responseWeather.getCurrent().getLast_updated());
        humidityText.setText(responseWeather.getCurrent().getHumidity());
        wind_kphText.setText(responseWeather.getCurrent().getWind_kph());
        pressure_mbText.setText(responseWeather.getCurrent().getPressure_mb());
        countryText.setText(responseWeather.getLocation().getCountry());

        return convertView;
    }
}
