package com.example.mobileproject;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MyInfoMation extends AppCompatActivity {
    private EditText editName, editEmail, editid, editpassword, editpasswordchecking;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinformation);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editid = findViewById(R.id.editid);
        editpassword = findViewById(R.id.editpassword);
        editpasswordchecking = findViewById(R.id.editpasswordchecking);
        btnSave = findViewById(R.id.btnSave);

        // 기존 정보를 불러와서 EditText에 설정하는 로직을 추가해야 합니다.
        // 여기서는 간단히 예시로 기존 정보를 설정하지 않고, 저장 버튼 클릭 시 현재 입력된 정보를 출력하는 예시를 제시합니다.

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String password = editName.getText().toString();
                String passwordchecking = editEmail.getText().toString();
                String id = editName.getText().toString();

                // 정보 저장 로직을 추가해야 합니다.
                // 여기서는 간단히 제목과 내용을 출력해보는 예시를 제시합니다.
                Toast.makeText(MyInfoMation.this, "저장된 정보:id\n아이디: " + id + "password\n비밀번호: " +password+"passwordchecking\n재확인 비밀번호 : " + name + "\n이메일: " + email, Toast.LENGTH_SHORT).show();
            }
        });
    }
            }

