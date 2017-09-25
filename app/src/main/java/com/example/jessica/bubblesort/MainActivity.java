package com.example.jessica.bubblesort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    TextView output2;
    TextView output3;
    ArrayList<EditText> sortList = new ArrayList<>();
    String displayList = "";
    String sortedList = "";
    String halfwaysorted = "";
    ArrayList<Double> doubleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.userInput);
        output = (TextView)findViewById(R.id.unsortedNums);
        output2 = (TextView)findViewById(R.id.sortedNums);
        output3 = (TextView)findViewById(R.id.printLines);
        Button b = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Log.d("second", input.getText().toString());
                if(input.length() != 0){

                    double dval = Double.parseDouble(input.getText().toString());
                    if(dval < 0 || dval > 10 || dval % 1 != 0){
                        Toast.makeText(getApplicationContext(), "Number must be integers between 0 and 9 ", Toast.LENGTH_SHORT).show();
                        input.setText("");
                    }
                    else {
                        sortList.add(input);
                        //output.setText(input.getText().toString());
                        displayList = displayList + "   " + input.getText().toString();
                        Log.d("second", input.getText().toString());
                        output.setText(displayList);
                        Log.d("double test", dval + "");
                        doubleList.add(dval);
                        input.setText(""); // adds text to arraylist and make edit text blank again
                    }
                }

///
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortList.clear();
                sortedList = "";
                output2.setText("");
                double temp;
                Log.d("testttttt", doubleList.size()+"");
                if(doubleList.size() > 1 && doubleList.size() < 9) {
                    halfwaysorted = displayList + System.getProperty("line.separator");
                /*
                for(int i = 0; i < doubleList.size()-1; i++){
                    //String str = Double.toString(doubleList.get(i));
                    for(int j = i+1; j < doubleList.size(); j++){

                        if(doubleList.get(i) > doubleList.get(j)  ){
                            temp = doubleList.get(j);
                            doubleList.set(j, doubleList.get(i) );
                            doubleList.set(i, temp);

                            for( double num : doubleList){

                                String str;
                                if( (int)num == num){
                                    str = Integer.toString((int) num);  // we only need this if / else if we want to take double values too
                                }
                                else{
                                    str = Double.toString(num);
                                }
                                halfwaysorted = halfwaysorted + "   " + str;
                            }
                            halfwaysorted = halfwaysorted + System.getProperty ("line.separator");
                        }
                    }
                 }
                 */
                    for (int i = 0; i < doubleList.size() - 1; i++) {
                        //String str = Double.toString(doubleList.get(i));
                        for (int j = 1; j < doubleList.size(); j++) {

                            if (doubleList.get(j - 1) > doubleList.get(j)) {
                                temp = doubleList.get(j - 1);
                                doubleList.set(j - 1, doubleList.get(j));
                                doubleList.set(j, temp);

                                for (double num : doubleList) {

                                    String str;
                                    if ((int) num == num) {
                                        str = Integer.toString((int) num);  // we only need this if / else if we want to take double values too
                                    } else {
                                        str = Double.toString(num);
                                    }
                                    halfwaysorted = halfwaysorted + "   " + str;
                                }
                                halfwaysorted = halfwaysorted + System.getProperty("line.separator");
                            }
                        }
                    }


                    for (double num : doubleList) {
                        Log.d("list", num + "");
                        String str;
                        if ((int) num == num) {
                            str = Integer.toString((int) num);
                        } else {
                            str = Double.toString(num);
                        }
                        sortedList = sortedList + "   " + str;
                    }

                    output2.setText(sortedList);
                    output3.setText(halfwaysorted);
                    doubleList.clear();
                    sortList.clear();
                    displayList = "";
                    output.setText("");
                    Log.d("final", sortedList);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter between 2 and 8 digits", Toast.LENGTH_SHORT).show();

                }

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");

                output2.setText("");
                output3.setText("");
                sortList.clear();
                displayList = "";
                sortedList = "";
                halfwaysorted = "";
                doubleList.clear();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
//


    }
}
