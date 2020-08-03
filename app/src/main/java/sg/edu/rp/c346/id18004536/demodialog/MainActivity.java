package sg.edu.rp.c346.id18004536.demodialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemoExcercise3;
    Button btnDemo4;
    Button btnDemo5;


    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvDemoExcercise3;
    TextView tvDemo4;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnDemoExcercise3 = findViewById(R.id.buttonDemoExcercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);


        tvDemo2 = findViewById(R.id.TextViewDemo2);
        tvDemo3 = findViewById(R.id.TextViewDemo3);
        tvDemoExcercise3 = findViewById(R.id.TextViewDemoExcercise3);
        tvDemo4 = findViewById(R.id.TextViewDemo4);
        tvDemo5 = findViewById(R.id.TextViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

//                myBuilder.setTitle("Demo 1- Simple dialog");
//                myBuilder.setMessage("I can develop Andorid app");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close", null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a single Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demon 2 Button Dialog");
                myBuilder.setMessage("Select one of the button below");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected positive");
                    }
                });


                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected negative");
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText eInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String message = eInput.getText().toString();

                        tvDemo3.setText(message);
                    }
                });

                myBuilder.setNeutralButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemoExcercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.excercise3, null);

                final EditText eInput1 = viewDialog.findViewById(R.id.editTextInput1);
                final EditText eInput2 = viewDialog.findViewById(R.id.editTextInput2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Excercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int message1 = Integer.parseInt(eInput1.getText().toString());
                        int message2 =   Integer.parseInt(eInput2.getText().toString());

                        int sum = message1+message2;

                        tvDemoExcercise3.setText("The sum is " +sum);
                    }
                });


                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });




        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: "+ dayOfMonth + "/"+ month+ "/"+year);
                    }
                };

//                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener,
//                        2014, 11,31);
                Calendar c = Calendar.getInstance();
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));

                myDateDialog.show();
            }
        });


        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        tvDemo5.setText("Time: "+hourOfDay+" : "+minute);

                    }
                };
//
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener,
//                        20,00,false);

                Calendar c = Calendar.getInstance();
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener,
                        c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false);

                myTimeDialog.show();
            }
        });
    }
}
