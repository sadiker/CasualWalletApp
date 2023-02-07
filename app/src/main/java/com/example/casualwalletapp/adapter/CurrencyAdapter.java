package com.example.casualwalletapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.casualwalletapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

    Context context;
  static List<Map<String,String>> listCurrency;

    public CurrencyAdapter(Context context, List<Map<String, String>> listCurrency) {
        this.context = context;
        this.listCurrency = listCurrency;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.currency_view,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView2.setText(listCurrency.get(position).get("satis"));
        holder.textView1.setText(listCurrency.get(position).get("alis"));

        //api kaynağında ikon yoktu,kendim atadım..
        switch (position){
            case 0 :
                holder.imageView.setImageResource(R.drawable.baseline_attach_money_24);
                break;
            case 1 :
                holder.imageView.setImageResource(R.drawable.baseline_euro_24);
                break;
            case 2 : holder.imageView.setImageResource(R.drawable.baseline_currency_pound_24);
                break;
            case 3 :
                Picasso.with(context).load("https://i.bigpara.com/resize/650x365/i/55big/spot_altin_28842.jpg").into(holder.imageView);
                break;
            case 4:
                Picasso.with(context).load("https://www.borsaistanbul.com/imgs/logo.png").into(holder.imageView);
                break;
            default:
                holder.imageView.setImageResource(R.drawable.icon_casualwallet);
        }
    }

    @Override
    public int getItemCount() {
        return listCurrency.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView=itemView.findViewById(R.id.currencyImageView);
            this.textView1=itemView.findViewById(R.id.alisCurrency);
            this.textView2=itemView.findViewById(R.id.satisCurrency);
        }
    }
}
