package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button click;
    EditText name, value;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edt1);
        value = findViewById(R.id.edt2);
        click = findViewById(R.id.click);
        DatabaseRequestClass databaseRequestClass = DatabaseRequestClass.getDB(MainActivity.this);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString().trim();
                String Value = value.getText().toString().trim();
                insertValueInsideDatabase(databaseRequestClass, Name, Value);
                retriveValueFromDatabase(databaseRequestClass);
            }
        });
    }

    private void retriveValueFromDatabase(DatabaseRequestClass databaseRequestClass) {
        ArrayList<EntityClass> list = (ArrayList<EntityClass>) databaseRequestClass.dao().reteriveAllData();
        for (int i = 0; i < list.size(); i++) {
            Log.i("Data", "Name: " + list.get(i).getName() + " Amount: " + list.get(i).getValue());
        }
    }

    private void insertValueInsideDatabase(DatabaseRequestClass databaseRequestClass, String name, String value) {
        EntityClass entityClass = new EntityClass(name, value);
        databaseRequestClass.dao().insertData(entityClass);
    }

}