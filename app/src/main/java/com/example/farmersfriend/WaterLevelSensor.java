package com.example.farmersfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class WaterLevelSensor extends AppCompatActivity {
    WebView browser;
    String m="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_level_sensor);
        ImageButton b1 = (ImageButton)findViewById(R.id.b1);
        Intent intent = getIntent();
        m = intent.getStringExtra("m");
// perform click event on button's
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                Intent i = new Intent(WaterLevelSensor.this, Select_Option.class);
                i.putExtra("m", m);
                startActivity(i);
            }
        });
        browser = (WebView) findViewById(R.id.browser);

        browser.loadUrl("http://www.tanmayacomputer.com/get_wdata.php");


    }
}