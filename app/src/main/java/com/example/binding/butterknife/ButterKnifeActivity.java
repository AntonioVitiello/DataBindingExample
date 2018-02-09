package com.example.binding.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.binding.R;
import com.example.binding.newschool.DataBindingActivity;
import com.example.binding.newschool.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {
    @BindView(R.id.et1) EditText et1;
    @BindView(R.id.et2) EditText et2;
    @BindView(R.id.et3) EditText et3;
    @BindView(R.id.et4) EditText et4;
    @BindView(R.id.et5) EditText et5;
    @BindView(R.id.et6) EditText et6;
    @BindView(R.id.et7) EditText et7;
    @BindView(R.id.et8) EditText et8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);

        // ButterKnife INITIALIZATION!
        ButterKnife.bind(this);

        initializeView();
    }

    private void initializeView(){
        Movie movie = new Movie.Builder()
            .name("This is ButterKnifeActivity")
            .posterUrl("insert movie poster url")
            .posterUrl2("insert 2nd movie poster url")
            .trailerURL("insert movie trailer url")
            .build();

        et1.setHint(movie.getName());
        et2.setHint(movie.getPosterUrl());
        et3.setHint(movie.getPosterUrl2());
        et4.setHint(movie.getTrailerURL());
    }

    @OnClick(R.id.startNewDataBinding)
    public void startNewDataBinding(View view) {
        Intent intent = new Intent(this, DataBindingActivity.class);
        startActivity(intent);
    }
}
