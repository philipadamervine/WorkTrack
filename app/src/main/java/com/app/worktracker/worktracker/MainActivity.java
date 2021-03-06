package com.app.worktracker.worktracker;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   // @Override
   // public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu, this adds items to the action bar if present
   //    getMenuInflater().inflate(R.menu.menu_main, menu);
   //    return true;
   // }

    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.Blogin)
        {
            EditText a = (EditText)findViewById(R.id.TFemail);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){

                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("Email",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(MainActivity.this , "Email and password don't match!" , Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if (v.getId() == R.id.Bsignup) {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item){
      //  int id = item.getItemId();

        //if (id ==R.id.action_settings){
          //  return true;
        //}

       // return super.onOptionsItemSelected(item);
    //}

}
