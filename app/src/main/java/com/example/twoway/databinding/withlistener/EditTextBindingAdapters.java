package com.example.twoway.databinding.withlistener;

import android.databinding.BindingAdapter;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Vitiello Antonio on 02/04/2018.
 */
public class EditTextBindingAdapters {

    @BindingAdapter("textChangedListener")
    public static void bindTextWatcher(EditText editText, TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }

}
