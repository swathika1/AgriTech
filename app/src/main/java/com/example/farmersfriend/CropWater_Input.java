package com.example.farmersfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CropWater_Input extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    Spinner crop;

    String crop_name_string,m="";
    private String[] crop_name = new String[]{"Wheat", "Maize", "Millet","Banana","Cabbage", "Onion","Pepper","Sorghum", "Barley", "Tomato", "Potato", "Rice","Vegetables", "Alfalfa", "Sugarcane","Sunflower"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_water__input);

        Intent intent = getIntent();
        m = intent.getStringExtra("m");
        crop=(Spinner)findViewById(R.id.crop);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,crop_name);
        crop.setAdapter(a);
        crop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {@Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int arg2, long arg3) {


            crop_name_string=(String) crop.getSelectedItem();

        }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,crop_name);
        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(adapter_role);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == btn2) {

            Intent intent =new Intent(CropWater_Input.this,FarmerInput.class);

            startActivity(intent);
        }
        else if (v == btn1) {


                //CropBean b = new CropBean();
              //  Toast.makeText(getApplicationContext(), "Input taken successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(CropWater_Input.this,CropWaterOP.class);
                intent.putExtra("crop_name_string", crop_name_string);
            intent.putExtra("m", m);
                               startActivity(intent);

            }
        }

    }
