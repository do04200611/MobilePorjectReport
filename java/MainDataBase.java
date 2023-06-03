package com.example.mobileproject.Database;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.mobileproject.R;

import java.util.List;

public class MainDataBase extends AppCompatActivity {
    private EditText editTitle;
    private EditText editContent;
    private TextView resultText;
    private TextView titleTextView;
    private TextView contentTextView;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletinboardwriting);

        editContent = findViewById(R.id.editContent);
        editTitle = findViewById(R.id.editTitle);
        resultText = findViewById(R.id.resultText);
        titleTextView = findViewById(R.id.titleTextView);
        contentTextView = findViewById(R.id.contentTextView);

        Intent intent = getIntent();
        String postTitle = intent.getStringExtra("postTitle");
        String postContent = intent.getStringExtra("postContent");

        // Set the data to the corresponding views
        titleTextView.setText(postTitle);
        contentTextView.setText(postContent);

        db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries()
                .build();

        updateResultText();

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.todoDao().insert(new Todo(editTitle.getText().toString(), editContent.getText().toString()));
                updateResultText();
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Todo> todos = db.todoDao().getAll();
                if (!todos.isEmpty()) {
                    Todo todo = todos.get(0);
                    todo.setEdittitle(editTitle.getText().toString());
                    todo.setEditcontent(editContent.getText().toString());
                    db.todoDao().update(todo);
                    updateResultText();
                }
            }
        });

        findViewById(R.id.Delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Todo> todos = db.todoDao().getAll();
                if (!todos.isEmpty()) {
                    Todo todo = todos.get(0);
                    db.todoDao().delete(todo);
                    updateResultText();
                }
            }
        });

        findViewById(R.id.ResetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitle.setText("");
                editContent.setText("");
            }
        });
        updateResultText();
    }

    private void updateResultText() {
        List<Todo> todos = db.todoDao().getAll();
        StringBuilder result = new StringBuilder();
        for (Todo todo : todos) {
            result.append(todo.toString()).append("\n");
        }
        resultText.setText(result.toString());
    }
}
