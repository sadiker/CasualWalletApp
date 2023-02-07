package com.example.casualwalletapp.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.casualwalletapp.R;
import com.example.casualwalletapp.activity.NewsActivity;
import com.example.casualwalletapp.models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<News>   {

    private  LayoutInflater inflater;
    private  Context context;
    private  MyViewHolder holder;
    private  ArrayList<News> newsList;

    public CustomListViewAdapter(Context context, ArrayList<News> newsList) {
        super(context,0, newsList);
        this.context = context;
        this.newsList = newsList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.news_view, parent,false);
            this.holder = new MyViewHolder();
            holder.newsImageView = convertView.findViewById(R.id.newsImageView);
            holder.descriptionTextView =  convertView.findViewById(R.id.descriptionTextView);
            //ayrıca haberin adını koymak istemedim...
            //holder.nameTextView = convertView.findViewById(R.id.nameTextView);
            holder.urlButton=convertView.findViewById(R.id.urlButton);
            holder.sourceTextView=convertView.findViewById(R.id.sourceTextView);

            // bazı haberlerin resim url'ininin döndüğü değerin  hataya sebep vermemesi için
            if(newsList.get(position).getImage().equals("") || newsList.get(position).getImage()==null){
                ImageView imageViewNullCheck = new ImageView(parent.getContext());
                imageViewNullCheck.setImageResource(R.drawable.icon_casualwallet);
                holder.newsImageView=imageViewNullCheck;
            } else {
                Picasso.with(context).load(newsList.get(position).getImage()).into(holder.newsImageView);
            }

            holder.descriptionTextView.setText(newsList.get(position).getDescription()+"");
            //holder.nameTextView.setText( newsList.get(position).getName()+"");
            holder.sourceTextView.setText(newsList.get(position).getSource()+"");
            holder.urlButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(newsList.get(position).getUrl()));
                    context.startActivity(intent);
                }
            });


        return convertView;
    }

}
 class MyViewHolder {
    TextView sourceTextView,nameTextView,descriptionTextView ;
    Button urlButton;
    ImageView newsImageView;
}