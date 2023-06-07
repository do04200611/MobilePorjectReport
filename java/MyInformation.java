package com.sentila.mobileproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyInformation extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;
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

        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.button1);

        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            String password = editpassword.getText().toString();
            String passwordchecking = editpasswordchecking.getText().toString();
            String id = editid.getText().toString();

            // 정보 저장 로직을 추가해야 합니다.
            // 여기서는 간단히 제목과 내용을 출력해보는 예시를 제시합니다.
            Toast.makeText(MyInformation.this, "저장된 정보:\n아이디: " + id + "\n비밀번호: " + password + "\n재확인 비밀번호: " + passwordchecking + "\n이름: " + name + "\n이메일: " + email, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu1, menu);

        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
        }
        return false;
    }
}
