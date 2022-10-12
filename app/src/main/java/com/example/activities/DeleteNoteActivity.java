package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DeleteNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        ListView listViewNotes = (ListView) findViewById(R.id.list_notes);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                AddNoteActivity.notes_array_list );

        listViewNotes.setAdapter(arrayAdapter);

        listViewNotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                getDialog(pos, arrayAdapter).show();
                return true;
            }
        });
    }

    private AlertDialog getDialog(int selectedPos, ArrayAdapter<String> arrayAdapter){
        AlertDialog.Builder builder = new AlertDialog.Builder(DeleteNoteActivity.this);
        builder.setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddNoteActivity.notes_array_list.remove(selectedPos);
                        arrayAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }
}