package com.example.test_datepicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by <a href="mailto:aucd29@gmail.com">Burke Choi</a> on 2016. 10. 19.. <p/>
 */
public class DatePickerDlg extends DialogFragment {
    DatePicker mDatePicker;

    private int mYear;
    private int mMonth;
    private int mDayOfMonth;
    private DatePicker.OnDateChangedListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_datepicker, container);
        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);

        if (mYear == 0) {
            Calendar ca = Calendar.getInstance(Locale.getDefault());

            mYear  = ca.get(Calendar.YEAR);
            mMonth = ca.get(Calendar.MONTH);
            mDayOfMonth = ca.get(Calendar.DAY_OF_MONTH);
        }

        mDatePicker.init(mYear, mMonth, mDayOfMonth, mListener);

        return view;
    }

    public void setOnDateChangedListener(DatePicker.OnDateChangedListener listener) {
        mListener = listener;
    }

    public void updateDate(int year, int month, int dayOfMonth) {
        mYear = year;
        mMonth = month;
        mDayOfMonth = dayOfMonth;
    }
}
