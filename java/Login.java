package com.sentila.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("로그인");

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // 로그인 처리
                if (isValidCredentials(email, password)) {
                    // 로그인 성공
                    Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                    // 다음 화면으로 이동하거나 추가 작업 수행
                } else {
                    // 로그인 실패
                    Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidCredentials(String email, String password) {
        // 이메일과 비밀번호 유효성 검사 로직을 구현하세요.
        // 예를 들어, 이메일과 비밀번호가 정상적인 조건을 충족하는지 확인하고
        // 서버로 인증 요청을 보내는 등의 처리를 수행합니다.

        // 예제에서는 간단히 이메일과 비밀번호가 "test@example.com"과 "password"인 경우에만 로그인 성공으로 처리합니다.
        return email.equals("test@example.com") && password.equals("password");
    }
}
