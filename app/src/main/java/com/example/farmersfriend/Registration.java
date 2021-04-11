package com.example.farmersfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import android.content.Intent;
public class Registration extends AppCompatActivity implements View.OnClickListener {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        btn1 = (Button) findViewById(R.id.reg);
        btn2 = (Button) findViewById(R.id.clr);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v==btn2)
        {
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed6.setText("");
            Toast.makeText(getApplicationContext(), "Reset the form successfully", Toast.LENGTH_SHORT).show();
        }
        else if (v==btn1)
        {
            String first_name = ed1.getText().toString();
            String last_name = ed2.getText().toString();
            String phone_no = ed3.getText().toString();
            String address = ed4.getText().toString();
            String userName = ed5.getText().toString();
            String passWord = ed6.getText().toString();

            if (TextUtils.isEmpty(first_name)) {
                ed1.setError("please enter firstname");
            }
                /*else if (TextUtils.isEmpty(last_name)) {
                    textLastName.setError("please enter lastname");
                }*/
            else if (TextUtils.isEmpty(phone_no)) {
                ed2.setError("please enter phoneno");
            }

            else if (TextUtils.isEmpty(address)) {
                ed3.setError("enter address");
            }
            else if (TextUtils.isEmpty(userName)) {
                ed4.setError("please enter username");
            }
            else if (TextUtils.isEmpty(passWord)) {
                ed5.setError("enter password");
            }
            else {
                DBAdapter dbAdapter = new DBAdapter(Registration.this);
                Farmerbean b = new Farmerbean();
                b.setfarmer_firstname(first_name);
                b.setfarmer_lastname(last_name);
                b.setfarmer_mobilenumber(phone_no);
                b.setfarmer_address(address);
                b.setfarmer_username(userName);
                b.setfarmer_password(passWord);

                dbAdapter = new DBAdapter(Registration.this);
                dbAdapter.addUser(b);

                Toast.makeText(getApplicationContext(), "New Farmer added successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Registration.this,Login.class);
                intent.putExtra("m", userName);
                startActivity(intent);

            }
        }

    }

}

