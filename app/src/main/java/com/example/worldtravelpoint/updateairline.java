package com.example.worldtravelpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class updateairline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateairline);


        EditText id = findViewById(R.id.id);
        EditText from = findViewById(R.id.from);
        EditText to = findViewById(R.id.to);
        EditText dt = findViewById(R.id.date);
        Button back = findViewById(R.id.button06);
        EditText seats = findViewById(R.id.seats);
        Button updateairline = findViewById(R.id.updateAirline);
        DBHelper DB = new DBHelper(this);

        updateairline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = id.getText().toString();
                String departure = from.getText().toString();
                String arrival = to.getText().toString();
                String date = dt.getText().toString();
                String total_seats = seats.getText().toString();

                if (id.equals("") || departure.equals("") || arrival.equals("") || date.equals("") || total_seats.equals(""))
                {
                    Toast.makeText(updateairline.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkid= DB.checkid(id);
                    if (checkid==true){
                        Boolean update = DB.updateAirline(id,departure,arrival,date,total_seats);
                        if (update==true){
                            Toast.makeText(updateairline.this, "Bus updated successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(updateairline.this, "New entry not updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(updateairline.this, "ID doesnot exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(i);
            }
        });
    }
}