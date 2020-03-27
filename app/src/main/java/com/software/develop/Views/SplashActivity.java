package com.software.develop.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.software.develop.Manager.FirebaseContactManager;
import com.software.develop.Model.Contact;
import com.software.develop.R;

public class SplashActivity extends AppCompatActivity implements ValueEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseContactManager.getInstance().getContactFromServer(this);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for (DataSnapshot contact: dataSnapshot.getChildren()) {
            FirebaseContactManager.getInstance().addContactHashMap(contact.getValue(Contact.class));
        }
        startMainActivity();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

        startMainActivity();
    }
    private void startMainActivity() {
        startActivity(new Intent(SplashActivity.this, ListActivity.class));
        finish();
    }
}
