package com.example.binding.newschool;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.binding.R;
import com.example.binding.databinding.ActivityDataBindingBinding;
import com.example.binding.oldschool.OldSchoolActivity;
import com.squareup.picasso.Picasso;

public class DataBindingActivity extends AppCompatActivity {

    private ActivityDataBindingBinding binding;
    private static Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        movie = new Movie.Builder()
                .name("This is DataBindingActivity")
                .posterUrl("http://i.imgur.com/DvpvklR.png")
                .posterUrl2("http://www.citynow.it/assets/uploads/2018/01/picasso.jpg")
                .trailerURL("http://movie.trailer.it")
                .build();

//      Not like this. Refactor that in Data Binding mode: in activity_data_binding.xml layout using "@{movie.posterUrl}"
//        binding.et1.setText(movie.getName());
//        binding.et2.setText(movie.getPosterUrl());
//        binding.et3.setText(movie.getTrailerURL());

        // Data Binding mode MAGIC!!!
        binding.setMovie(movie);
        binding.setTrailerHint("Here the trailer URL!");
        binding.setHandlers(new ClickHandlers());

        // Changing values
//        movie.setName("another movie name");
//        movie.setPosterUrl("http://i.imgur.com/DvpvklR.png");
//        movie.setPosterUrl2("https://i.imgur.com/AbMQ1Ag.png");
//        movie.setTrailerURL("another Trailer URL");
    }

    @BindingAdapter({"android:src"})
    public static void loadImageSrc(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.image_load_error)
                .into(view);
    }

    @BindingAdapter({"android:src", "android:placeholder", "android:error"})
    public static void loadImage(ImageView view, String imageUrl, Drawable placeholder, Drawable loadError){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(placeholder)
                .error(loadError)
                .into(view);
    }

    @BindingAdapter({"trailerHint"})
    public static void anotherImage(EditText view, String hint){
        view.setHint(hint);
    }

    public void onClickStartOldSchoolDataBinding(View view) {
        Intent intent = new Intent(this, OldSchoolActivity.class);
        startActivity(intent);
    }

/*
    public class MyHandlers {
        public void onClickChangeModelData(View view, Movie movie) {
            Toast.makeText(view.getContext(), "onClickInvertImage", Toast.LENGTH_SHORT).show();
            movie.setPosterUrl("https://i.imgur.com/C7BciC0.gif");
            movie.setPosterUrl2("http://i.imgur.com/HUzp3C5.gif");
            movie.setName("Ciao Ciao!");
            binding.setMovie(movie);
        }
    }
*/
}
