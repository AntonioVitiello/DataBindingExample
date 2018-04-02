package com.example.twoway.databinding.withlistener;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.binding.R;
import com.example.binding.databinding.TwoWayDatabindingWithListenerBinding;

public class TwoWayDataBindingActivity extends AppCompatActivity {


    private TwoWayDatabindingWithListenerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.two_way_databinding_with_listener);
        mBinding.setViewModel(new PasswordViewModel());
    }
}
