package com.dotplays.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDatePicker(View view) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        String ketqua = year + "/" + (month+1) + "/" + day;
                        Toast.makeText(MainActivity.this,ketqua,Toast.LENGTH_LONG).show();
                    }
                }, year, month, day);

        datePickerDialog.show();

    }

    public void openTimePicker(View view) {

        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog =
                new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(MainActivity.this,i + ":" + i1,
                                Toast.LENGTH_LONG).show();
                    }
                }
                , hour, minute, false);

        timePickerDialog.show();

    }

    public void openProgressDialog(View view) {

        ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading...");

        progressDialog.setCancelable(false);

        progressDialog.show();

        //progressDialog.hide();



    }

    public String[] food = {"FPT", "FBI", "FSHARE", "FSTORE", "FU", "FTU", "FLC"};

    public void openSingleChoice(View view) {

        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);

        builder.setSingleChoiceItems(food, 0,
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,phone[i],Toast
                        .LENGTH_LONG).show();
            }
        });

        builder.show();

    }

    public void openMultiChoice(View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);

        builder.setMultiChoiceItems(food, null,
                new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this,phone[i],Toast
                        .LENGTH_LONG).show();
            }
        });

        builder.show();

    }

    public void openToast(View view) {

        Toast.makeText(MainActivity.this,
                "Hello, I am Jerry", Toast.LENGTH_SHORT).show();

        Toast toast = new Toast(MainActivity.this);
        // thoi gian hien thi
        toast.setDuration(Toast.LENGTH_LONG);

        // khoi tao giao dien moi cho toast

        View myToast = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.my_toast,null);

        toast.setView(myToast);

        toast.show();



    }

    public void openAlertDialogCustomize(final View view) {

        AlertDialog.Builder builder
                 = new AlertDialog.Builder(MainActivity.this);
        View myToast = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.my_toast,null);

        builder.setView(myToast);

        TextView tvText = myToast.findViewById(R.id.tvText);

        tvText.setText("Hello Jerry!!!");

        tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openToast(view);
            }
        });

        builder.show();


    }

    String[] phone = {"Nokia","Samsung","Sony","Iphone","Xiaomi","Huawei","HTC"};
    public void openAlertDialogList(View view) {

        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);

        builder.setItems(phone, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,phone[i],Toast
                .LENGTH_LONG).show();
            }
        });

        builder.show();

    }
}
