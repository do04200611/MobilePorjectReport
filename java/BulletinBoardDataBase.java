package com.example.mobileproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import com.example.mobileproject.Database.AppDatabase;

import java.util.List;


public class BulletinBoardDataBase extends AppCompatActivity {
    private TextView titleTextView;
    private TextView contentTextView;
    private TextView resultText;
    private Button btnSubmit;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnReset;
    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletinboardwriting);

        titleTextView = findViewById(R.id.editTitle);
        contentTextView = findViewById(R.id.editContent);
        resultText = findViewById(R.id.resultText);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.Delete_button);
        btnReset = findViewById(R.id.ResetButton);
        // Retrieve the passed data from the intent
        Intent intent = getIntent();
        String postTitle = intent.getStringExtra("postTitle");
        String postContent = intent.getStringExtra("postContent");

        // Set the data to the corresponding views
        titleTextView.setText(postTitle);
        contentTextView.setText(postContent);

        db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries()
                .build();
        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.todoDao().insert(new Todo(titleTextView.getText().toString(), contentTextView.getText().toString()));
                updateResultText();
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Todo todo = db.todoDao().getAll().get(0); // Assuming you want to update the first todo item
                todo.setTitle(titleTextView.getText().toString(),contentTextView.getText().toString());
                db.todoDao().update(todo);
                updateResultText();
            }
        });
        findViewById(R.id.Delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Todo todo = db.todoDao().getAll().get(0); // Assuming you want to delete the first todo item
                db.todoDao().delete(todo);
                updateResultText();
            }
        });
        findViewById(R.id.ResetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleTextView.setText(""); // Clear the EditText
            }
        });
        updateResultText();
    }

        private void updateResultText() {
            List<Todo> todos = db.todoDao().getAll();
            StringBuilder resultText = new StringBuilder();
            for (Todo todo : todos) {
                resultText.append(todo.toString()).append("\n");
            }
            resultText.setText(resultText.toString());
    }


}
