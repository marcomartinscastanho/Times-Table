package com.martinscastanho.marco.timestables;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);
        final ArrayList<Integer> myNumbers = new ArrayList<>();
        for(int i=1; i<=10; i++){
            myNumbers.add(i);
        }
        final ArrayList<Integer> listNumbers = new ArrayList<>(myNumbers);
        final ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNumbers);
        myListView.setAdapter(myArrayAdapter);

        SeekBar mySeekBar = findViewById(R.id.seekBar);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(1);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if(i < min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }
                else{
                    timesTableNumber = i;
                }
                for(Integer index = 0; index < myNumbers.size(); index++){
                    listNumbers.set(index, myNumbers.get(index) * timesTableNumber);
                    myArrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
