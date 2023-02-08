package com.example.casualwalletapp.adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.casualwalletapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CityImageAdapter extends RecyclerView.Adapter<CityImageAdapter.ImageViewHolder> {

    private List<String> urlList;
    Context context;

    public CityImageAdapter(List<String> urlList, Context context) {
        this.context = context;
        this.urlList = urlList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_imageview, parent, false);
        return new ImageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Picasso.with(context).load(urlList.get(position)).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bu  animasyon...
                /*Animation animation = AnimationUtils.loadAnimation(context,R.anim.zoom_in);
                ImageView imageViewAlert = new ImageView(context);
                imageViewAlert.startAnimation(animation);*/

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                ImageView imageView = new ImageView(context);
                imageView.setMinimumWidth(500);
                imageView.setMinimumHeight(550);

                Picasso.with(context).load(urlList.get(holder.getAdapterPosition())).into(imageView);
                builder.setView(imageView);
                builder.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return urlList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.gridImageView);

        }
    }

}
