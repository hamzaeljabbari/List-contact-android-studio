package com.foot.list_controle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> contacts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationClass applicationClass = (ApplicationClass) getApplication();
        contacts = applicationClass.getContacts();

        EditText nomPrenom = findViewById(R.id.nom_prenom);
        EditText numeroTelephone = findViewById(R.id.numero_telephone);
        Button addButton = findViewById(R.id.add);
        Button listButton = findViewById(R.id.list);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact = nomPrenom.getText().toString() + " - " + numeroTelephone.getText().toString();
                contacts.add(contact);
                nomPrenom.setText("");
                numeroTelephone.setText("");
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                intent.putStringArrayListExtra("contacts", contacts);
                startActivity(intent);
            }
        });
    }
}
