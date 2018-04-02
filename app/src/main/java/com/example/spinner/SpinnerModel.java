package com.example.spinner;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.binding.BR;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */

public class SpinnerModel extends BaseObservable {
    private static final String LOG_TAG = "SpinnerModel";
    private int position;
    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        try {
            position = Integer.valueOf(text);
            this.text = text;
            notifyPropertyChanged(BR.text);
            notifyPropertyChanged(BR.position);
        } catch (final NumberFormatException exc) {
            Log.e(LOG_TAG, "Not a number: \"" + text + "\"");
        } catch (final IndexOutOfBoundsException exc) {
            Log.e(LOG_TAG, "Invalid Number: " + text);
        }
    }

    @Bindable
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        text = String.valueOf(position);
        notifyPropertyChanged(BR.position);
        notifyPropertyChanged(BR.text);
    }
}
