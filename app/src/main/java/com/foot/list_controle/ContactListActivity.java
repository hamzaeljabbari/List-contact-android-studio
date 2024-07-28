package com.foot.list_controle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private ArrayList<String> contacts;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ApplicationClass applicationClass = (ApplicationClass) getApplication();
        contacts = applicationClass.getContacts();

        Button addContactButton = findViewById(R.id.add_contact);
        ListView listView = findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);

        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        if (getIntent().hasExtra("contacts")) {
            ArrayList<String> newContacts = getIntent().getStringArrayListExtra("contacts");
            updateContacts(newContacts);
        }
    }

    public void updateContacts(ArrayList<String> newContacts) {
        contacts.clear();
        contacts.addAll(newContacts);
        adapter.notifyDataSetChanged();
    }
}

