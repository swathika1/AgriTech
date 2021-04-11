package com.example.farmersfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.widget.Toast;

public class CropWaterOP extends AppCompatActivity {
String m="";
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_water_op);
        ImageButton b1 = (ImageButton)findViewById(R.id.b1);
        Intent intent = getIntent();
        m = intent.getStringExtra("m");
        String crop = intent.getStringExtra("crop_name_string");
// perform click event on button's
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                Intent i = new Intent(CropWaterOP.this, Select_Option.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
        t =(TextView)findViewById(R.id.txtv);


        DBAdapter myDb = new DBAdapter(CropWaterOP.this);
        Cursor res = myDb.getCropWaterDetails(crop);
        if(res.getCount() == 0) {
            // show message
            t.setText("No Crop Details Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(" CROP WATER CONSUMPTION DETAILS  \n");
        buffer.append("==========================\n");
        if (res.moveToNext()) {
            buffer.append("CROP NAME : "+ crop +"\n");
            buffer.append("CROP WATER NEEDED MIN (mm) : "+ res.getDouble(2) +"\n");
            buffer.append("CROP WATER NEEDED MAX (mm) : "+ res.getDouble(3) +"\n");
            buffer.append("==========================\n");

        }
        myDb.close();

        // Show all data
        t.setText(buffer.toString());

    }

}

