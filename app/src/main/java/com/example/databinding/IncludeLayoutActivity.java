package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.binding.R;
import com.example.binding.databinding.ParentLayoutBinding;
import com.example.databinding.model.FirstDataModel;
import com.example.databinding.model.SecondDataModel;

public class IncludeLayoutActivity extends AppCompatActivity {

    private FirstDataModel firstDataModel;
    private SecondDataModel secondDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParentLayoutBinding parentBinding = DataBindingUtil.setContentView(this, R.layout.parent_layout);

//        ParentLayoutBinding parentBinding = ParentLayoutBinding.inflate(getLayoutInflater());
//        ChildLayoutBinding childBinding = ChildLayoutBinding.inflate(getLayoutInflater);

        firstDataModel = new FirstDataModel();
        secondDataModel = new SecondDataModel();

        parentBinding.setFirstModel(firstDataModel);
//        parentBinding.container.setFirstModel(firstDataModel);
        parentBinding.container.setSecondModel(secondDataModel);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        firstDataModel.setFirstMsg("Hello");
        firstDataModel.setSecondMsg("Android");
        secondDataModel.setThirdMsg("World");
    }
}
