package com.example.activities;

import static com.example.activities.DeleteNoteActivity.notes_array_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {"Add Note", "Delete Note"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = findViewById(R.id.list_menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((arg0, arg1, pos, id) -> {
            Intent i;
            if(pos == 0) {
                i = new Intent(getApplicationContext(), AddNoteActivity.class);
            }
            else {
                i = new Intent(getApplicationContext(), DeleteNoteActivity.class);
            }
            startActivity(i);
        });

        ///--------------------

        ListView lvNotes = findViewById(R.id.list_notes_main);
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                notes_array_list);

        lvNotes.setAdapter(arrayAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        arrayAdapter.notifyDataSetChanged();
    }
}