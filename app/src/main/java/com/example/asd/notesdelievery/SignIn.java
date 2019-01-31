package com.example.asd.notesdelievery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import info.hoang8f.widget.FButton;

public class SignIn extends AppCompatActivity {

    MaterialEditText edtPhone,edtPassword;
    FButton btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword=findViewById(R.id.edtPassword);
        edtPhone=findViewById(R.id.edtPhone);
        btnSignIn=findViewById(R.id.btnSignIn);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                //Intent intent=new Intent(SignIn.this,.class);
                                Toast.makeText(SignIn.this, "Sign In successfully", Toast.LENGTH_SHORT).show();
                                //startActivity(intent);
                            } else {
                                Toast.makeText(SignIn.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this,"User does not exists in database",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}