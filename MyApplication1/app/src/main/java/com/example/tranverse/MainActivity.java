package com.example.tranverse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    boolean[] selectedDisease;
    ArrayList<Integer> diseaseList = new ArrayList<>();
    String[] diseaseArray = {"Disease1", "Disease2", "Disease3", "Disease4", "Disease5", "Disease6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable
        textView = findViewById(R.id.textView3);

        // initialize selected language array
        selectedDisease = new boolean[diseaseArray.length];

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // set title
                builder.setTitle("Select");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(diseaseArray, selectedDisease, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        if (b) {
                            diseaseList.add(i);
                            Collections.sort(diseaseList);
                        } else {
                            diseaseList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < diseaseList.size(); j++) {
                            // concat array value
                            stringBuilder.append(diseaseArray[diseaseList.get(j)]);
                            // check condition
                            if (j != diseaseList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selectedDisease.length; j++) {
                            // remove all selection
                            selectedDisease[j] = false;
                            // clear language list
                            diseaseList.clear();
                            // clear text view value
                            textView.setText("");
                        }
                    }
                });
                // show dialog
                builder.show();
            }
        });
    }
}