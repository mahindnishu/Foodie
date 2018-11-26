package com.javatpoint.user.foodie.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.model.UsersModel;

public class SignUp extends AppCompatActivity {

    EditText editName,editPassword, editMobileNumber,editEmail;
    Button SignUp;

    ScrollView relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editName = findViewById(R.id.editName);
        editPassword = findViewById(R.id.editPassword);
        editMobileNumber = findViewById(R.id.editPhoneNumber);
        editEmail = findViewById(R.id.editEmailId);

        SignUp = findViewById(R.id.SignUp);
        relativeLayout = findViewById(R.id.relative_signup_layout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(view);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog=new ProgressDialog(SignUp.this);
                mDialog.setMessage("please waiting....");

                DatabaseReference mRef=FirebaseDatabase.getInstance().getReference("user");

                // Creating new user node, which returns the unique key value
                // new user node would be /users/$userid/
                String userId = mRef.push().getKey();

                // creating user object
                UsersModel user = new UsersModel(editMobileNumber.getText().toString(),editName.getText().toString(),editPassword.getText().toString(),editEmail.getText().toString());

                // pushing user to 'users' node using the userId
                mRef.child(userId).setValue(user);

                Toast.makeText(SignUp.this,"Account created successfully",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SignUp.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
    private void hideKeyboard(View view)
    {
        InputMethodManager inputMethodManager=(InputMethodManager)
                view.getContext().getSystemService(SignUp.this.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
