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

import java.util.Collections;

public class FarmerInput extends AppCompatActivity implements View.OnClickListener {
    String m="";
    EditText ed;
    Button btn1, btn2;
    Spinner crop;
    Spinner soil;
    String crop_name_string, soil_type_string;
    private String[] crop_name = new String[]{"Wheat", "Maize", "Millet", "Sorghum", "Barley", "Tomato", "Potato", "Vegetables", "Alfalfa", "Dates", "Citrus", "Grapes"};
    private String[] soil_type = new String[]{"Sandy", "Clayey","Loamy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_input);
        ed = findViewById(R.id.ed);
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

        soil=(Spinner)findViewById(R.id.soil);
        ArrayAdapter<String> a1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,soil_type);
        soil.setAdapter(a1);
        soil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {@Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int arg2, long arg3) {


            soil_type_string=(String) soil.getSelectedItem();

        }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<String> adapter_role2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, soil_type);
        adapter_role2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soil.setAdapter(adapter_role2);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == btn2) {
            ed.setText("");
            Toast.makeText(getApplicationContext(), "Reset the form successfully", Toast.LENGTH_SHORT).show();
        } else if (v == btn1) {
            String area = ed.getText().toString();

            if (TextUtils.isEmpty(area)) {
                ed.setError("Please enter area!");
            } else {
                //CropBean b = new CropBean();
                Toast.makeText(getApplicationContext(), "Input taken successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(FarmerInput.this,FarmerOutput.class);
   intent.putExtra("crop_name_string", crop_name_string);
                 intent.putExtra("soil_type_string", soil_type_string);
                intent.putExtra("area", area);
                intent.putExtra("m", m);
                  startActivity(intent);

            }
        }

    }
}