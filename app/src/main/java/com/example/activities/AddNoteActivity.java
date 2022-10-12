package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {

    static ArrayList<String> notes_array_list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText exit_text_title = findViewById(R.id.editTextTitle);

        FloatingActionButton save_button = findViewById(R.id.saveButton);
        save_button.setOnClickListener(v -> {
            notes_array_list.add(exit_text_title.getText().toString());
            finish();
        });
    }
}