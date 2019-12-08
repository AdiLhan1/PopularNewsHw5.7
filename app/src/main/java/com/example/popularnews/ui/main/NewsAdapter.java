package com.example.popularnews.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.popularnews.R;
import com.example.popularnews.models.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<Article> articles;
    private OnitemClickListener onItemClickListener;

    public NewsAdapter(OnitemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.bind(articles.get(position));
    }

    void setItems( List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemClickListener(OnitemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnitemClickListener {
        void onItemClick(Article model);

    }
}
