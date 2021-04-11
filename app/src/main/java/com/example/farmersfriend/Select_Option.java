package com.example.farmersfriend;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Select_Option extends AppCompatActivity {
    String m="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__option);
        Intent intent = getIntent();
        m = intent.getStringExtra("m");
// initiate view's
        ImageButton b1 = (ImageButton)findViewById(R.id.b1);
        ImageButton b2 = (ImageButton)findViewById(R.id.b2);
        ImageButton b3 = (ImageButton)findViewById(R.id.b3);
        ImageButton b4 = (ImageButton)findViewById(R.id.b4);
        ImageButton b5 = (ImageButton)findViewById(R.id.b5);
        ImageButton b6 = (ImageButton)findViewById(R.id.b6);
        ImageButton b7 = (ImageButton)findViewById(R.id.b7);

// perform click event on button's
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                Intent i = new Intent(Select_Option.this, Login.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Crop Info Button",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, FarmerInput.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Soil Moisture Sensor",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, Soil_Moisture.class);
                i.putExtra("m", m);

                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Crop Water Button",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, CropWater_Input.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Farmer Button",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, Farmer_Details.class);
                i.putExtra("m", m);
                startActivity(i);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Heat Humidity Sensor",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, HeatSensor.class);
                i.putExtra("m", m);
                startActivity(i);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Water Level Sensor",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                Intent i = new Intent(Select_Option.this, WaterLevelSensor.class);
                i.putExtra("m", m);
                startActivity(i);

            }
        });
    }


}