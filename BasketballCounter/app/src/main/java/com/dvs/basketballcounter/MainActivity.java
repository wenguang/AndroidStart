package com.dvs.basketballcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.dvs.basketballcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    CounterViewModel viewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

//        binding.setVm(viewModel);
//        binding.setLifecycleOwner(this);

        viewModel.getATeamScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textViewScoreA.setText(String.valueOf(integer));
            }
        });
        viewModel.getBTeamScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textViewScoreB.setText(String.valueOf(integer));
            }
        });

        binding.buttonAdd1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addATeamScore(1);
            }
        });
        binding.buttonAdd2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addATeamScore(2);
            }
        });
        binding.buttonAdd3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addATeamScore(3);
            }
        });
        binding.buttonAdd1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addBTeamScore(1);
            }
        });
        binding.buttonAdd2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addBTeamScore(2);
            }
        });
        binding.buttonAdd3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addBTeamScore(3);
            }
        });

    }
}