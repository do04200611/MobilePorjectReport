package com.example.mobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BulletinBoardWriting extends AppCompatActivity {

    private EditText editTitle, editContent;
    private Button btnSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletinboardwriting);

        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String content = editContent.getText().toString();

                // 게시글 작성 로직을 추가해야 합니다.
                // 여기서는 간단히 제목과 내용을 출력해보는 예시를 제시합니다.
                Toast.makeText(BulletinBoardWriting.this, "제목: " + title + "\n내용: " + content, Toast.LENGTH_SHORT).show();
            }
        });

    }
}