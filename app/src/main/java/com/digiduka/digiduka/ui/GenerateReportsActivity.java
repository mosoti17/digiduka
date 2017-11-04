package com.digiduka.digiduka.ui;


import android.app.DatePickerDialog;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;




import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.digiduka.digiduka.R;
import com.digiduka.digiduka.utils.Constants;


import org.parceler.Parcels;

import java.util.Calendar;


public class GenerateReportsActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView daystart;
    private TextView dayend;
    private Button submitdate;
    private String fromdate;
    private String todate;
    int mDay,mMonth,mYear;
    ConstraintLayout generateReport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_reports);
        daystart=findViewById(R.id.daysprofit);
        dayend=findViewById(R.id.daysprofit2);
        generateReport=findViewById(R.id.generateReports);
        submitdate = findViewById(R.id.submitdate);
        submitdate.setOnClickListener(this);
        daystart.setOnClickListener(this);
        dayend.setOnClickListener(this);

        Calendar calendar=Calendar.getInstance();
        mDay=calendar.get(Calendar.DAY_OF_MONTH);mMonth=calendar.get(Calendar.MONTH);mYear=calendar.get(Calendar.YEAR);

    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            generateReport.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        if(view==daystart){
            DatePickerDialog datePicker=new DatePickerDialog(GenerateReportsActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month+=1;
                    daystart.setText(day + "/" + month + "/" + year);
                    fromdate=day + "/" + month + "/" + year;
                }
            },mYear,mMonth,mDay);
            datePicker.show();
        }
        if (view==dayend){
            DatePickerDialog datePicker=new DatePickerDialog(GenerateReportsActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month+=1;
                    dayend.setText(day + "/" + month + "/" + year);
                    day+=1;
                    todate=day + "/" + month + "/" + year;
                }
            },mYear,mMonth,mDay);
            datePicker.show();
        }
        if(view==submitdate){

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment = new ProfitReportFragment();
            Bundle bundle=new Bundle();
            bundle.putParcelable(Constants.START_DAY,Parcels.wrap(fromdate));
            bundle.putParcelable(Constants.END_DAY,Parcels.wrap(todate));
            myFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.generateReports, myFragment).addToBackStack(null).commit();
        }
    }

}
