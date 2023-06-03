package com.example.mobileproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView titleTextView;
    private TextView contentTextView;
    private ImageView imageView;
    private List<Post> postList;
    private PostAdapter.OnItemClickListener onItemClickListener;

    public PostViewHolder(@NonNull View itemView, List<Post> postList, PostAdapter.OnItemClickListener onItemClickListener) {
        super(itemView);
        this.postList = postList;
        this.onItemClickListener = onItemClickListener;
        titleTextView = itemView.findViewById(R.id.titleTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
        imageView = itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }

    public void bind(Post post) {
        titleTextView.setText(post.getTitle());
        contentTextView.setText(post.getContent());
        imageView.setImageResource(post.getImageResource());
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
            onItemClickListener.onItemClick(postList.get(position));
        }
    }
}
