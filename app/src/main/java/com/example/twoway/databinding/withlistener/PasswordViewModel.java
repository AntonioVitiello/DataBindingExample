package com.example.twoway.databinding.withlistener;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.example.binding.BR;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */
public class PasswordViewModel extends BaseObservable {
    private static final String LOG_TAG = "PasswordViewModel";
    private String password;

    @Bindable
    public String getPasswordQuality() {
        if (password == null || password.isEmpty()) {
            return "Enter a password";
        } else if (password.equals("password")) {
            return "Very bad";
        } else if (password.length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }
    }

    public void setPassword(String password) {
        if (this.password != password) {
            this.password = password;
            notifyPropertyChanged(BR.passwordQuality);
        }
    }

    /**
     * Be careful about not binding a second TextWatcher!!
     * Never call notifyPropertyChanged(BR.passwordTextWatcher) or notifyChange(), or another TextWatcher will be added.
     * This will waste memory and drive into dramatically layout’s performance decrease,
     * becouse when the user types into the field there's an unnecessary amount of work.
     *
     * @return
     */
    @Bindable
    public TextWatcher getPasswordTextWatcher() {
        Log.d(LOG_TAG, "into getPasswordTextWatcher: should be just one time!!");
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        };
    }

}
