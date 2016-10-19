package com.example.test_datepicker;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.activity_main)
    RelativeLayout mLayout;

    @BindView(R.id.button)
    Button mDefault;

    @BindView(R.id.button2)
    Button mDb;

    @BindView(R.id.button3)
    Button mClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mDefault.setOnClickListener(v -> {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                DatePickerDialog dlg = new DatePickerDialog(getBaseContext());
                dlg.setOnDateSetListener((view, year, month, dayOfMonth) -> {
                    Log.d(TAG, year + " " + month + " " + dayOfMonth);
                });
                dlg.show();
            } else {
                DatePickerDlg dlg = new DatePickerDlg();
                dlg.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                    Log.d(TAG, year + " " + monthOfYear + " " + dayOfMonth);
                });
                dlg.show(getSupportFragmentManager(), "datepicker");
            }
        });

        mDb.setOnClickListener(v -> {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                DatePickerDialog dlg = new DatePickerDialog(getBaseContext());
                dlg.updateDate(2014, 1, 4);
                dlg.setOnDateSetListener((view, year, month, dayOfMonth) -> {
                    Log.d(TAG, year + " " + month + " " + dayOfMonth);
                });
                dlg.show();
            } else {
                DatePickerDlg dlg = new DatePickerDlg();
                dlg.updateDate(2014, 1, 4);
                dlg.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                    Log.d(TAG, year + " " + monthOfYear + " " + dayOfMonth);
                });
                dlg.show(getSupportFragmentManager(), "datepicker");
            }
        });

        mClear.setOnClickListener(v -> {
            for (int i=0; i<mLayout.getChildCount(); ++i) {
                View view = mLayout.getChildAt(i);
                if (view instanceof DatePicker) {
                    mLayout.removeViewAt(i);
                }
            }
        });
    }
}
