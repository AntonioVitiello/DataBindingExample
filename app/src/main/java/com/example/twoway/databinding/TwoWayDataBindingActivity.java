package com.example.twoway.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.binding.R;
import com.example.binding.databinding.TwoWayDatabindingBinding;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */
public class TwoWayDataBindingActivity extends AppCompatActivity {

    private TwoWayDatabindingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.two_way_databinding);
        mBinding.setViewModel(new PasswordViewModel());
    }

}
