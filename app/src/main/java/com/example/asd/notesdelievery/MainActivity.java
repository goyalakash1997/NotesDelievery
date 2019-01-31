package com.example.asd.notesdelievery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    FButton btnSignIn, btnSignUp;
    //Button button;
    //private final static int LOGIN_PERMISSION=1000;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          /*  button=findViewById(R.id.button);
            mAuth = FirebaseAuth.getInstance();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),LOGIN_PERMISSION );
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode==LOGIN_PERMISSION){
                startNewActivity(resultCode,data);
            }
        }
    private void startNewActivity(int resultCode,Intent data){
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }*/
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent2);
            }
        });
    }
}
