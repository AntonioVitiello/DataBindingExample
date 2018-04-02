package com.example.spinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.binding.R;
import com.example.binding.databinding.ActivitySpinnerBinding;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySpinnerBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_spinner);

        SpinnerModel mSpinnerModel = new SpinnerModel();
//        mSpinnerModel.setText("Wednesday");
        mSpinnerModel.setText("5");
        mBinding.setViewModel(mSpinnerModel);
    }

}
