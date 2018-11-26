package com.javatpoint.user.foodie.otherClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

public class SingleItemViewIntoList extends AppCompatActivity
{
    ScrollView scrollView;
    ImageView imageView;
    TextView tv1,tv2,tv3,tv4;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView=findViewById(R.id.imageviewItem);
        tv1=findViewById(R.id.textviewItemName);
        tv2=findViewById(R.id.textviewCategory);
        tv3=findViewById(R.id.textviewItemPrice);
        tv4=findViewById(R.id.textviewDescription);
        button=findViewById(R.id.btncart);


    }
}
