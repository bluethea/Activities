package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {

    static ArrayList<String> notes_array_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText exit_text_title = findViewById(R.id.editTextTitle);
        EditText exit_text_note = findViewById(R.id.editTextNote);

        FloatingActionButton save_button = findViewById(R.id.saveButton);
        save_button.setOnClickListener(v -> {
            notes_array_list.add(exit_text_title.getText().toString());
            if (exit_text_title.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), R.string.no_title, Toast.LENGTH_LONG).show();
            }
            else {
                try {
                    File notes_file = new File(getApplicationContext().getFilesDir(), "notes.txt");
                    FileWriter writer = new FileWriter(notes_file, true);
                    String record = exit_text_title.getText().toString() + ";" + exit_text_note.getText().toString() + "\n";
                    writer.write(record);
                    writer.flush();
                    writer.close();
                    finish();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}