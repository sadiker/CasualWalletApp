package com.example.casualwalletapp.dialogBuilder;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;

import com.example.casualwalletapp.R;

public class MyDialog {

    public static AlertDialog.Builder createBuilder(Context context) {
        return new AlertDialog.Builder(new ContextThemeWrapper(context,
                R.style.ShowAlertDialogTheme));
    }

}
