package com.sentila.mobile;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainDataBase extends AppCompatActivity {
    private EditText mTodoEditText;
    private TextView mResultTextView;
    private AppDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulletinboard);

        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.resultText);

        db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries()
                .build();

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
                updateResultText();
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(view -> {
            Todo todo = db.todoDao().getAll().get(0); // Assuming you want to update the first todo item
            todo.setTitle(mTodoEditText.getText().toString());
            db.todoDao().update(todo);
            updateResultText();
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
                mTodoEditText.setText(""); // Clear the EditText
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
        mResultTextView.setText(resultText.toString());
    }
}
