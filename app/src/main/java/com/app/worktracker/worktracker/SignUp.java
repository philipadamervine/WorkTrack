package com.app.worktracker.worktracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import static com.app.worktracker.worktracker.R.id.Bsignupbtn;

/**
 * Created by Philip on 27/02/2017.
 */

public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }


    public void onSignUpClick(View v) {

        if (v.getId() == R.id.Bsignupbtn)
        {
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText sname = (EditText)findViewById(R.id.TFsname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText job = (EditText)findViewById(R.id.TFjob);
            EditText tel = (EditText)findViewById(R.id.TFtel);
            EditText start = (EditText)findViewById(R.id.TFstart);
            EditText finish = (EditText)findViewById(R.id.TFfinish);
            EditText rate = (EditText)findViewById(R.id.TFrate);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String snamestr = sname.getText().toString();
            String emailstr = email.getText().toString();
            String jobstr = job.getText().toString();
            String telstr = tel.getText().toString();
            String startstr = start.getText().toString();
            String finishstr = finish.getText().toString();
            String ratestr = rate.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                //popup message toast
                Toast pass = Toast.makeText(SignUp.this , "Passwords don't match!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert details in database
                Employee e = new Employee();
                e.setName(namestr);
                e.setSName(snamestr);
                e.setEmail(emailstr);
                e.setJob(jobstr);
                e.setTel(telstr);
                e.setStart(startstr);
                e.setFinish(finishstr);
                e.setRate(ratestr);
                e.setPass(pass1str);

                helper.insertEmployee(e);
            }
        }
    }

}
