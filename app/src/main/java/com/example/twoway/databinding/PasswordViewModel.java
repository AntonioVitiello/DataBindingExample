package com.example.twoway.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.binding.BR;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */
public class PasswordViewModel extends BaseObservable {
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

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(this.password != password) {
            this.password = password;
            notifyPropertyChanged(BR.password);
            notifyPropertyChanged(BR.passwordQuality);
        }
    }

}
