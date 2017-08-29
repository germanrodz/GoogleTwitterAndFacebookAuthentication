package com.blovvme.googletwitterandfacebookauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    Button btnLogOut;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    //twitter


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnLogOut = (Button)findViewById(R.id.btnLogOut);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(SecondActivity.this, MainActivity.class));
                }
            }
        };

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
            }
        });

        //twitter
        String username = getIntent().getStringExtra("username");
       // TextView tvTwitter = (TextView)findViewById(R.id.tvTwitter);
        //tvTwitter.setText(username);
    }
}
