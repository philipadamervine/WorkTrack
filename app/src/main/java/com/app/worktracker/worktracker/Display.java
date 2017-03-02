package com.app.worktracker.worktracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Philip on 27/02/2017.
 */

public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String email = getIntent().getStringExtra("Email");

        TextView tv = (TextView)findViewById(R.id.TVemail);
        tv.setText(email);
    }
}
