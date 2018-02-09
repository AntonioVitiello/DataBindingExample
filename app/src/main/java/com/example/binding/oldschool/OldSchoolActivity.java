package com.example.binding.oldschool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.binding.R;
import com.example.binding.butterknife.ButterKnifeActivity;
import com.example.binding.newschool.Movie;

public class OldSchoolActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_school);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);

        initializeView();
    }

    private void initializeView(){
        Movie movie = new Movie.Builder()
            .name("This is OldSchoolActivity")
            .posterUrl("insert movie poster url")
            .posterUrl2("insert 2nd movie poster url")
            .trailerURL("insert movie trailer url")
            .build();

        et1.setHint(movie.getName());
        et2.setHint(movie.getPosterUrl());
        et3.setHint(movie.getPosterUrl2());
        et4.setHint(movie.getTrailerURL());
    }

    public void startButterKnife(View view) {
        Intent intent = new Intent(this, ButterKnifeActivity.class);
        startActivity(intent);
    }
}
