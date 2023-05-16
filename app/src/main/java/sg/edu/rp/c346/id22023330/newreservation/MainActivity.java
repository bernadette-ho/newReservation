package sg.edu.rp.c346.id22023330.newreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button cancel;
    Button confirm;
    RadioButton opt1;
    RadioButton opt2;

    TextView nameDisplay;
    TextView numberDisplay;
    TextView paxDisplay;
    TextView title1;
    TextView title2;

    EditText nameInp;
    EditText numberInp;
    EditText paxInp;

    DatePicker dp;
    TimePicker tp;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancel = findViewById(R.id.cancel);
        confirm = findViewById(R.id.confirm);
        opt1 = findViewById(R.id.smokingopt1);
        opt2 = findViewById(R.id.smokingopt2);

        nameInp = findViewById(R.id.nameInp);
        numberInp = findViewById(R.id.numberInp);
        paxInp = findViewById(R.id.paxInp);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        display = findViewById(R.id.tvDisplay);

        // String seatType;

       // if (opt1.isChecked()) {
            //seatType = "Smoking Area";
       // } else {
            //seatType = "Non-smoking Area";
       // }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int date = dp.getDayOfMonth()+1;
                int month = dp.getMonth();
                int year = dp.getYear();

                tp.setIs24HourView(true);
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();


                String nameOut = nameInp.getText().toString();
                String numberOut = numberInp.getText().toString();
                String paxOut = paxInp.getText().toString();
                String area = opt1.isChecked()?"Smoking":"Non-Smoking";

                String message = "Your booking is confirmed!\n \n Name: " + nameOut + "\nNumber: " + numberOut +
                        "\nNo. of pax: " + paxOut + "\nDate of reservation: " + date + "/" + month + "/" + year +
                        "\nTime of reservation: " + hour + ":" + min + "\nSeating area: " + area;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameInp.setText("");
                numberInp.setText("");
                paxInp.setText("");
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 06, 01);
                opt1.setChecked(false);
                opt2.setChecked(false);
            }
        });

    }
}