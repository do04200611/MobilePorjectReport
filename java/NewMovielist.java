package com.example.mobileproject;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NewMovielist extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmovielist);
        setTitle("최신 영화 목록");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        NewMovielist.MyGridAdapter gAdapter = new NewMovielist.MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov44, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov82, R.drawable.mov18,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                R.drawable.mov02, R.drawable.mov03, R.drawable.mov14,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov77,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov40,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov33,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov66,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov19,
                R.drawable.mov10 };

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(
                            NewMovielist.this, R.layout.movieinformation, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            NewMovielist.this);
                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageview;
        }

    }
}


