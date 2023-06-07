package com.sentila.mobileproject;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class movielist extends AppCompatActivity {

    private GridView gridViewMovies;

    private CustomGridAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_movie);
        setTitle("게시글 목록");

        gridViewMovies =  findViewById(R.id.gridViewMovies);

        // 영화 데이터를 가상으로 생성 (예시)
        String[] movies = {
                "영화 제목 1",
                "영화 제목 2",
                "영화 제목 3",
                "영화 제목 4",
                "영화 제목 5"
        };

        Integer[] posterID = {
                R.drawable.mov01,
                R.drawable.mov02,
                R.drawable.mov03,
                R.drawable.mov04,
                R.drawable.mov05
        };

        // CustomGridAdapter를 사용하여 GridView에 데이터 연결
        movieAdapter = new CustomGridAdapter(this, movies, posterID);
        gridViewMovies.setAdapter(movieAdapter);

        // GridView 아이템 클릭 이벤트 처리
        gridViewMovies.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMovie = movies[position];
            Toast.makeText(movielist.this, selectedMovie, Toast.LENGTH_SHORT).show();
            // 선택한 영화에 대한 상세 정보 표시 등의 추가 작업 수행
        });
    }

    class CustomGridAdapter extends ArrayAdapter<String> {
        private final AppCompatActivity context;
        private final String[] movies;
        private final Integer[] posterID;

        public CustomGridAdapter(AppCompatActivity context, String[] movies, Integer[] posterID) {
            super(context, R.layout.grid_item_movie, movies);
            this.context = context;
            this.movies = movies;
            this.posterID = posterID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View gridViewItem = inflater.inflate(R.layout.grid_item_movie, parent, false);

            TextView textViewMovieTitle = gridViewItem.findViewById(R.id.textViewMovieTitle);
            ImageView imageViewPoster = gridViewItem.findViewById(R.id.imageViewPoster);

            textViewMovieTitle.setText(movies[position]);
            imageViewPoster.setImageResource(posterID[position]);

            return gridViewItem;
        }
    }
}