package com.example.popularnews.ui.main;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.popularnews.R;
import com.example.popularnews.models.Article;
import com.example.popularnews.utils.Utils;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView title, desk, author, published_ad, source, time;
    ImageView imageView;
    ProgressBar progressBar;
    NewsAdapter.OnitemClickListener onItemClickListener;

    public MyViewHolder(@NonNull View itemView, NewsAdapter.OnitemClickListener onItemClickListener) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        desk = itemView.findViewById(R.id.desk);
        author = itemView.findViewById(R.id.author);
        published_ad = itemView.findViewById(R.id.publishedAt);
        source = itemView.findViewById(R.id.source);
        time = itemView.findViewById(R.id.time);
        imageView = itemView.findViewById(R.id.img);
        progressBar = itemView.findViewById(R.id.progress_load_photo);
        this.onItemClickListener = onItemClickListener;
    }


    @SuppressLint({"SetTextI18n", "CheckResult"})
    void bind(final Article model){

        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(itemView.getContext())
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        title.setText(model.getTitle());
        desk.setText(model.getDescription());
        source.setText(model.getSource().getSystemId());
        time.setText(" \u0202 "+Utils.DateToTimeFormat(model.getPublishedAt()));
        published_ad.setText(Utils.DateFormat(model.getPublishedAt()));
        author.setText(model.getAuthor());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(model);
            }
        });
    }
}
