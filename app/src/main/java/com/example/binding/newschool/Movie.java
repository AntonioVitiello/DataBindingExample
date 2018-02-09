package com.example.binding.newschool;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.binding.BR;

/**
 * Created by Antonio on 08/02/2018.
 *
 * SELF VIEW-UPDATE on model change
 * Binding.setMovie(movie) NOT NEEDED for self view-update
 * instead use: BaseObservable, @Bindable, notifyPropertyChanged(BR.name);
 *
 * see: https://developer.android.com/topic/libraries/data-binding/index.html#data_objects
 *
 */

public class Movie extends BaseObservable {
    private String name, posterUrl, posterUrl2, trailerURL;

    private Movie() {
    }

    private Movie(Builder builder) {
        setName(builder.name);
        setPosterUrl(builder.posterUrl);
        setPosterUrl2(builder.posterUrl2);
        setTrailerURL(builder.trailerURL);
    }

    @Bindable public String getName() {
        return name;
    }

    @Bindable public String getPosterUrl() {
        return posterUrl;
    }

    @Bindable public String getPosterUrl2() {
        return posterUrl2;
    }

    @Bindable public String getTrailerURL() {
        return trailerURL;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
        notifyPropertyChanged(BR.posterUrl);
    }

    public void setPosterUrl2(String posterUrl2) {
        this.posterUrl2 = posterUrl2;
        notifyPropertyChanged(BR.posterUrl2);
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
        notifyPropertyChanged(BR.trailerURL);
    }

    public static final class Builder {
        private String name;
        private String posterUrl;
        private String posterUrl2;
        private String trailerURL;

        public Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder posterUrl(String val) {
            posterUrl = val;
            return this;
        }

        public Builder posterUrl2(String val) {
            posterUrl2 = val;
            return this;
        }

        public Builder trailerURL(String val) {
            trailerURL = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
