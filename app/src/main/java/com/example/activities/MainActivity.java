package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] mobileArray = {"Add Note", "Delete Note"};
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> notes_array_list = new ArrayList<>();

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

        ListView lvNotes = findViewById(R.id.list_notes_main);
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                notes_array_list);
        lvNotes.setAdapter(arrayAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        File notes_file = new File(getApplicationContext().getFilesDir(), "notes.txt");
        notes_array_list.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(notes_file));
            String line;
            while ((line = br.readLine()) != null) {
                notes_array_list.add(line);
            }
            br.close();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        arrayAdapter.notifyDataSetChanged();
    }
}