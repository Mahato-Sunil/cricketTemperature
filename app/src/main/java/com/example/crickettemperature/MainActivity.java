package com.example.crickettemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // initialization of the components
    EditText inpt;
    Button btn;
    TextView info, tips, cardTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connecting java with xml code
        inpt = findViewById(R.id.inpt);
        info = findViewById(R.id.info);
        tips = findViewById(R.id.tips);
        cardTitle = findViewById(R.id.cardTitle);
        btn = findViewById(R.id.btn);

        // setting the values
        String title = "Do you Know ?";
        String resultTitle = "Predicted Temperature";
        String cardInfo = "Crickets chirp faster with increasing temperature and slower with decreasing temperatures.";
        String hints = "Tip:- Count the number of chrips for 25 seconds";
        String errorText = "Opps ! you forget to enter the number !!";
        cardTitle.setText(title);
        info.setText(cardInfo);
        tips.setText(hints);

        // adding the click event linstener
        btn.setOnClickListener(e -> {
            // getting user input
            String chrips = inpt.getText().toString();

                        // checking for the valid input
            if(chrips.isEmpty())
                tips.setText(errorText);
            else
            {
                try {
                    int inputChrips = Integer.parseInt(chrips);
                    float temperature = (float) (inputChrips / 3 + 4);
                    String result = "Predicted Temperature is " + "\n" + " [ " + temperature + " degree celcius  ] ";
                    info.setText(result);
                    cardTitle.setText(resultTitle);
                }
                catch(NumberFormatException err)
                {
                    System.out.println(err);
                }
            }
        });
    }
}