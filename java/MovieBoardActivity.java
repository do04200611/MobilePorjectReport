package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
import android.content.Intent;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.mobileproject.Database.MainDataBase;

import java.util.ArrayList;
import java.util.List;

public class MovieBoardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Post> postList = new ArrayList<>();
        postList.add(new Post("게시글 제목 1", "게시글 내용 1", R.drawable.mov01));
        postList.add(new Post("게시글 제목 2", "게시글 내용 2", R.drawable.mov02));
        postList.add(new Post("게시글 제목 3", "게시글 내용 3", R.drawable.mov03));
        postAdapter = new PostAdapter(postList);
        recyclerView.setAdapter(postAdapter);
        postAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Post post) {
                // Handle item click event here
                Intent intent = getIntent(); // 수정: getIntent() 호출 추가
                intent.putExtra("postTitle", post.getTitle());
                intent.putExtra("postContent", post.getContent());
                startActivity(intent);
            }
        });
    }

    private void setupMenu(Menu menu) {
        // 상단 메뉴바 인플레이션
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item1) {
            // 메뉴 아이템1 클릭 시 PostWriteActivity로 전환
            Intent intent = new Intent(this, MainDataBase.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_item2) {
            // 메뉴 아이템2 클릭 시 MyInfoActivity로 전환
            Intent intent = new Intent(this, MyInfoMation.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
