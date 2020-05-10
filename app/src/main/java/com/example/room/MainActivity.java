package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    public static final String EXTRA_TODO_ID = "MainActivity/EXTRA_TODO_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view_container);
        setupListAdapter();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long todoId = parent.getItemIdAtPosition(position);
                Intent intent = new Intent(MainActivity.this,TodoDetailsActivity.class);
                intent.putExtra(EXTRA_TODO_ID,todoId);
                startActivity(intent);
            }
        });


    }



    private void setupListAdapter() {
        List<Todo> todos = AppDatabase.getInstance(this).todoDao().getAll();

        ToDoListAdapter adapter = new ToDoListAdapter(this,todos);
        listView.setAdapter(adapter);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this,TodoDetailsActivity.class);
        startActivity(intent);
    }
}
