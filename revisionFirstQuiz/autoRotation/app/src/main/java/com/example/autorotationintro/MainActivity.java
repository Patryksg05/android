package com.example.autorotationintro;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView downArrow, upArrow;
    TextView textView;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("CzasZycia", "Metoda: onCreate()");

        textView = findViewById(R.id.textView);
        upArrow = findViewById(R.id.upArrow);
        downArrow = findViewById(R.id.downArrow);

        if(savedInstanceState != null ) {
            counter = savedInstanceState.getInt("counter", 0);
            textView.setText(Integer.toString(counter));
        }

//        upArrow.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        counter++;
//                        textView.setText(Integer.toString(counter));
//                    }
//                }
//        );
//
//        downArrow.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        counter--;
//                        String number = textView.getText().toString();
//                        if(Integer.valueOf(textView.getText().toString())<=0)
//                            counter = 0;
//                        textView.setText(Integer.toString(counter));
//                    }
//                }
//        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CzasZycia", "Metoda: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CzasZycia", "Metoda: onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CzasZycia", "Metoda: onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CzasZycia", "Metoda onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("CzasZycia", "Metoda: onSaveInstanceState()");
        outState.putInt("counter", counter);
    }

    public void reduceCounter(View view) {
        counter--;
        String number = textView.getText().toString();
        if(Integer.valueOf(textView.getText().toString())<=0)
            counter = 0;
        textView.setText(Integer.toString(counter));
    }

    public void increaseCounter(View view) {
        counter++;
        textView.setText(Integer.toString(this.counter));
    }
}