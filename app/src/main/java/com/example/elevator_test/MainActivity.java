package com.example.elevator_test;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity<cTime> extends AppCompatActivity {
    private TextView receiptDateText, receiptTimeText, arrivalDateText, arrivalTimeText, completeDateText, completeTimeText;
    private DatePickerDialog.OnDateSetListener callbackDateMethod;
    private TimePickerDialog.OnTimeSetListener callbackTimeMethod;
    private int cYear, cMonth, cDay, cHour, cMinute;
    private String cDate, cTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.InitializeButton();
        this.InitializeListener();
        this.InitializeCalendar();
    }

    public void InitializeView() {
        receiptDateText = (TextView) findViewById(R.id.TextView_receiptDateText);
        receiptTimeText = (TextView) findViewById(R.id.TextView_receiptTimeText);
        arrivalDateText = (TextView) findViewById(R.id.TextView_arrivalDateText);
        arrivalTimeText = (TextView) findViewById(R.id.TextView_arrivalTimeText);
        completeDateText = (TextView) findViewById(R.id.TextView_completeDateText);
        completeTimeText = (TextView) findViewById(R.id.TextView_completeTimeText);
    }

    public void InitializeButton() {
        findViewById(R.id.Button_arrivalDate).setOnClickListener(onClickListener);
        findViewById(R.id.Button_arrivalTime).setOnClickListener(onClickListener);
        findViewById(R.id.Button_receiptDate).setOnClickListener(onClickListener);
        findViewById(R.id.Button_receiptTime).setOnClickListener(onClickListener);
        findViewById(R.id.Button_completeDate).setOnClickListener(onClickListener);
        findViewById(R.id.Button_completeTime).setOnClickListener(onClickListener);
    }

    public void InitializeCalendar() {
        Calendar cal = Calendar.getInstance();
        cYear = cal.get(Calendar.YEAR);
        cMonth = cal.get(Calendar.MONTH);
        cDay = cal.get(Calendar.DAY_OF_MONTH);
        cHour = cal.get(Calendar.HOUR_OF_DAY);
        cMinute = cal.get(Calendar.MINUTE);
    }

    public void InitializeListener() {
        callbackDateMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                cDate = year + "년" + (monthOfYear + 1) + "월" + dayOfMonth + "일";
            }
        };

        callbackTimeMethod = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                cTime = hourOfDay + "시" + minute + "분";
            }
        };
    }

    private void setDateText(TextView tvText) {
        DatePickerDialog Dialog = new DatePickerDialog(MainActivity.this, callbackDateMethod, cYear, cMonth, cDay);
        Dialog.show();
    }

    private void setTimeText(TextView tvText) {
        TimePickerDialog Dialog = new TimePickerDialog(MainActivity.this, callbackTimeMethod, cHour, cMinute, true);
        Dialog.show();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                default:
                case R.id.Button_receiptDate:
                    setDateText(receiptDateText);
                    break;
                case R.id.Button_receiptTime:
                    setTimeText(receiptTimeText);
                    break;
//                case R.id.Button_arrivalDate:
//                    setDateText(arrivalDateText);
//                    break;
//                case R.id.Button_arrivalTime:
//                    setTimeText(arrivalTimeText);
//                    break;
//                case R.id.Button_completeDate:
//                    setDateText(completeDateText);
//                    break;
//                case R.id.Button_completeTime:
//                    setTimeText(completeTimeText);
//                    break;
            }
        }
    };


}