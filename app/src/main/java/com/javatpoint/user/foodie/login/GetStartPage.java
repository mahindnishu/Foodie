package com.javatpoint.user.foodie.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

public class GetStartPage extends AppCompatActivity {
    ImageView imageView;
    TextView txtSlogan;
    Button btnGetStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start_page);

        imageView=findViewById(R.id.imageFood);
        txtSlogan=findViewById(R.id.textSlogan);
        btnGetStart=findViewById(R.id.btn_get_started);

        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        txtSlogan.setTypeface(face);

        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GetStart=new Intent(GetStartPage.this,LoginActivity.class);
                startActivity(GetStart);
            }
        });


        }

    }

