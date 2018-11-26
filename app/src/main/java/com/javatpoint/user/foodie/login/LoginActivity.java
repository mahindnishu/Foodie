package com.javatpoint.user.foodie.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

public class LoginActivity extends AppCompatActivity {
    Button SignIn,SignUp;
    TextView txtSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn=findViewById(R.id.SignIn);
        SignUp=findViewById(R.id.SignUp);
        txtSlogan=findViewById(R.id.textSlogan);

        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        txtSlogan.setTypeface(face);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignIn=new Intent(LoginActivity.this, com.javatpoint.user.foodie.login.SignIn.class);
                startActivity(SignIn);

            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignUp=new Intent(LoginActivity.this, com.javatpoint.user.foodie.login.SignUp.class);
                startActivity(SignUp);

            }
        });

    }
}
