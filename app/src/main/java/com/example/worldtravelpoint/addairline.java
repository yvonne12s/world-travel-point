package com.example.worldtravelpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addairline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addairline);

        EditText id = findViewById(R.id.id);
        EditText from = findViewById(R.id.from);
        EditText to = findViewById(R.id.to);
        EditText dt = findViewById(R.id.date);
        EditText seats = findViewById(R.id.seats);
        Button addairline = findViewById(R.id.addairline);
        Button back1 = findViewById(R.id.button2);
        DBHelper DB = new DBHelper(this);


        addairline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = addairline.getText().toString();
                String departure = from.getText().toString();
                String arrival = to.getText().toString();
                String date = dt.getText().toString();
                String total_seats = seats.getText().toString();

                if (id.equals("") || departure.equals("") || arrival.equals("") || date.equals("") || total_seats.equals("")) {
                    Toast.makeText(addairline.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkid = DB.checkid(id);
                    if (checkid == false) {
                        Boolean insert = DB.insertAirline(id, departure, arrival, date, total_seats);
                        if (insert == true) {
                            Toast.makeText(addairline.this, "seat has been added", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(addairline.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(addairline.this, "ID already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        /*back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });*/

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });
    }
        }
