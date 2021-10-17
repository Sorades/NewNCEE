package com.example.newncee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestBeforeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_before);
    }
    public void GoTest(View view) {
        startActivity(new Intent(TestBeforeActivity.this, SelectTestActivity.class));
    }

    public void SkipTest(View view) {
        startActivity(new Intent(TestBeforeActivity.this, MainActivity.class));
    }
}