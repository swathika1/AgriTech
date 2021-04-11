package com.example.farmersfriend;

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

public class FarmerOutput extends AppCompatActivity {
    String m="";
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_output);
        t =(TextView)findViewById(R.id.txtv);
        ImageButton b1 = (ImageButton)findViewById(R.id.b1);
        Intent intent = getIntent();
        m = intent.getStringExtra("m");
        String crop = intent.getStringExtra("crop_name_string");
        String stype = intent.getStringExtra("soil_type_string");
        String area = intent.getStringExtra("area");
// perform click event on button's
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                Intent i = new Intent(FarmerOutput.this, Select_Option.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
       // Intent intent = getIntent();


       DBAdapter myDb = new DBAdapter(FarmerOutput.this);
        Cursor res = myDb.getCropDetails(crop);
        if(res.getCount() == 0) {
            // show message
            t.setText("No Crop Details Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("    CROP GROWTH RATE DETAILS    \n");
        buffer.append("============================\n");
        if (res.moveToNext()) {
        buffer.append("CROP NAME : "+ crop +"\n");
        buffer.append("SOIL TYPE : "+ stype +"\n");
        buffer.append("NUTRIENT LEVEL :"+ area +"\n");
        buffer.append("NUTRIENT LEVEL IS PERFECT!" + "\n");
        buffer.append("Check out out TIPS page for manure ideas :)");
        buffer.append("HAPPY FARMING!");
            buffer.append("============================\n");

        }
        myDb.close();

        // Show all data
        t.setText(buffer.toString());

    }

}

