package com.example.spinner;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */

public class SpinnerBindingAdapters {
    private static final String LOG_TAG = "SpinnerBindingAdapters";

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static int captureSelectedValue(AppCompatSpinner spinner) {
Log.d(LOG_TAG, "captureSelectedValue: " + spinner.getSelectedItem());
        return spinner.getSelectedItemPosition();
    }

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner spinner, int newSelectedPosition, final InverseBindingListener inverseBindingListener) {
Log.d(LOG_TAG, "bindSpinnerData: newSelectedPosition = " + newSelectedPosition);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inverseBindingListener.onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if(newSelectedPosition < spinner.getCount()) {
            spinner.setSelection(newSelectedPosition, true);
Log.d(LOG_TAG, "bindSpinnerData: position = " + newSelectedPosition);
        }
    }

/*
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static String captureSelectedValue(AppCompatSpinner spinner) {
        Log.d(LOG_TAG, "captureSelectedValue: " + spinner.getSelectedItem());
        return (String) spinner.getSelectedItem();
    }

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner spinner, String newSelectedValue, final InverseBindingListener inverseBindingListener) {
        Log.d(LOG_TAG, "bindSpinnerData: newSelectedValue = " + newSelectedValue);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inverseBindingListener.onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        if (newSelectedValue != null) {
            int position = ((ArrayAdapter<String>) spinner.getAdapter()).getPosition(newSelectedValue);
            spinner.setSelection(position, true);
            Log.d(LOG_TAG, "bindSpinnerData: position = " + position);
        }
    }
*/

}
