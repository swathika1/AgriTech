package com.example.farmersfriend;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Farmer_Details extends AppCompatActivity {
    String m="";
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer__details);
        Intent intent = getIntent();
        m = intent.getStringExtra("m");
        t =(TextView)findViewById(R.id.txtv);
        ImageButton b1 = (ImageButton)findViewById(R.id.b1);

// perform click event on button's
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                Intent i = new Intent(Farmer_Details.this, Select_Option.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });


        DBAdapter myDb = new DBAdapter(Farmer_Details.this);
        Cursor res = myDb.getFarmerDetails(m);
        if(res.getCount() == 0) {
            // show message
            t.setText("No Farmer Details Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("    FARMER DETAILS    \n");
        buffer.append("============================\n");
        if (res.moveToNext()) {
            buffer.append("USER_ID    : "+ res.getInt(0) +"\n");
            buffer.append("FIRST NAME : "+ res.getString(1) +"\n");
            buffer.append("LAST NAME  : "+ res.getString(2) +"\n");
            buffer.append("MOBILE NO  : "+ res.getString(3) +"\n");
            buffer.append("ADDRESS    : "+ res.getString(4) +"\n");
            buffer.append("USERNAME  : "+ res.getString(5) +"\n");

            buffer.append("============================\n");

        }
        myDb.close();


        // Show all data
        t.setText(buffer.toString());

    }

}

