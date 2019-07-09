package com.dvs.start;

import android.content.Intent;
import android.os.Bundle;

import com.dvs.start.databinding.ActivitySecondBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        Intent intent = getIntent();
        binding.textView.setText(intent.getStringExtra("message"));
    }

}
