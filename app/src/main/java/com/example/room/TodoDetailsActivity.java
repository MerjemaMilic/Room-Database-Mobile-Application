package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TodoDetailsActivity extends AppCompatActivity {
   private EditText titleInput, descriptionInput;
   private Button button2,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);
        titleInput = findViewById(R.id.title_input);
        descriptionInput = findViewById(R.id.description_input);
        Bundle extras = getIntent().getExtras();


        if(extras != null) {
            button2 = findViewById(R.id.button2);
            button2.setText("DELETE");
            button1 = findViewById(R.id.button);
            button1.setText("UPDATE");
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            titleInput.setText(todo.getTitle());
            descriptionInput.setText(todo.getDescription());
            AppDatabase.getInstance(this).todoDao().deleteAll(todo);
            AppDatabase.getInstance(this).todoDao().updateTodo(todo);



        }

    }

    public void onSave(View view){
     Todo todo = new Todo(titleInput.getText().toString(),descriptionInput.getText().toString());
     AppDatabase.getInstance(this).todoDao().add(todo);
     Intent intent = new Intent(this,MainActivity.class);
     startActivity(intent);

    }

    public void onCancel(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
