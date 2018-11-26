package com.javatpoint.user.foodie.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.javatpoint.user.foodie.Home.HomeFoodieActivity;
import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.model.UsersModel;

import java.util.ArrayList;
import java.util.List;


public class SignIn extends AppCompatActivity {
    EditText editPhoneNumber,editPassword;
    Button SignIn;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPassword=findViewById(R.id.editPassword);
        editPhoneNumber=findViewById(R.id.editMobileNumber);
        SignIn=findViewById(R.id.SignIn);
        relativeLayout=findViewById(R.id.relative_signin_layout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkData();
            }
        });
    }

    private void checkData() {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        final List<UsersModel> arrayListUser = new ArrayList<>();

        final int[] flag = {0};

        database.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Log.d("response", "lkvlf");
                    UsersModel user = noteDataSnapshot.getValue(UsersModel.class);
                    arrayListUser.add(user);

                    System.out.println("phone no "+user.getPhone_Number()+"Password "+user.getPassword());
                    if (user.getPhone_Number().equals(editPhoneNumber.getText().toString())) {
                        if (user.getPassword().equals(editPassword.getText().toString())) {
                           /* SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(phoneno, et_mobile_no.getText().toString());
                            editor.commit();*/
                            flag[0] =1;

                            Toast.makeText(SignIn.this, "Login Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignIn.this, HomeFoodieActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

                if(flag[0] ==0)
                {
                    Toast.makeText(SignIn.this, "Phone number and password not found", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        for (int i = 0; i < arrayListUser.size(); i++) {
            System.out.println("iiii " + i);
        }

    }
    private void hideKeyboard(View view)
    {
        InputMethodManager inputMethodManager=(InputMethodManager)
                view.getContext().getSystemService(SignIn.this.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
