package com.example.user.manupulatedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SaveInfo extends AppCompatActivity {

    EditText e_id,e_name,e_price,e_qty;
    String id,name,price,qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);

        e_id = (EditText)findViewById(R.id.d_id);
        e_name = (EditText)findViewById(R.id.d_name);
        e_price = (EditText)findViewById(R.id.d_price);
        e_qty = (EditText)findViewById(R.id.d_qty);



    }

    public void saveData(View view){

        id = e_id.getText().toString();
        name = e_name.getText().toString();
        price = e_price.getText().toString();
        qty = e_qty.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info",id,name,price,qty);
        finish();

    }
}
