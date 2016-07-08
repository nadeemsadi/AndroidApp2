package com.example.user.manupulatedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_product_layout);

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");
    }
}
