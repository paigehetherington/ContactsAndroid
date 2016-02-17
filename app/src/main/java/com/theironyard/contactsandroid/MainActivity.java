package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> contacts;

    //create variables
    ListView list;
    EditText name;
    EditText phone;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect variables to their respective views
        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); //connecting to listview
        list.setAdapter(contacts);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String contact = name.getText().toString() + " " + phone.getText().toString();

        //look at your contactsDesktop project to add a conditinal statement to make sure you can't create a contact without a name or phone #
        if (!name.getText().toString().equals("")  && !phone.getText().toString().equals("")) { //only adds if both fields filled in
            contacts.add(contact);
        }

        name.setText("");// clears fields regardless
        phone.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { //removes item long clicked
        String contact = contacts.getItem(position);
        contacts.remove(contact);

        return true;
    }
}
