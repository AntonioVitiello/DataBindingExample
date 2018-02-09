package com.example.binding.newschool;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Antonio on 09/02/2018.
 *
 * Listener Bindings are binding expressions that run when an event happens.
 * They are similar to method references, but they let you run arbitrary data binding expressions.
 * This feature is available with Android Gradle Plugin for Gradle version 2.0 and later.
 *
 * see: https://developer.android.com/topic/libraries/data-binding/index.html#binding_data
 * see: https://developer.android.com/topic/libraries/data-binding/index.html#enable_v2
 *
 */

public class ClickHandlers {
    private int stateCount = 0;

    public void changeModelData(View view, Movie movie) {
        switch(stateCount){
            case 0:
                movie.setPosterUrl("https://i.imgur.com/C7BciC0.gif");
                movie.setPosterUrl2("http://i.imgur.com/HUzp3C5.gif");
                stateCount = 1;
                break;
            case 1:
                movie.setPosterUrl("http://i.imgur.com/DvpvklR.png");
                movie.setPosterUrl2("http://www.citynow.it/assets/uploads/2018/01/picasso.jpg");
                stateCount = 0;
                break;
        }

        movie.setName("Data Model Chaged: " + stateCount);
        Toast.makeText(view.getContext(), "Data Model changed!", Toast.LENGTH_SHORT).show();

//        Binding.setMovie(movie) NOT NEEDED for self view-update see:
//        https://developer.android.com/topic/libraries/data-binding/index.html#data_objects
//        activityDataBindingBinding.setMovie(movie);
    }
}
