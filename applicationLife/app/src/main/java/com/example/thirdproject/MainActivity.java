package com.example.thirdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     *  konfiguracja => auto obrot :)))
     */

    private int count = 0;  // licznik
    TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTextView = findViewById(R.id.textView);

        Log.i("CzasZycia", "Wywolano metode: onCreate()");
        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
            countTextView.setText(Integer.toString(count));
        }
    }

    public void increaseScore(View view) {
        count++; countTextView.setText(Integer.toString(count));
    }

    public void reduceScore(View view) {
        count--; countTextView.setText(Integer.toString(count));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CzasZycia", "Wywolano metode: onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CzasZycia", "Wywolano metode: onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CzasZycia", "Wywolano metode: onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CzasZycia", "Wywolano metode: onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CzasZycia", "Wywolano metode: onRestart()");
    }

    // przechowuje dane
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("CzasZycia", "Wywolano metode: onSaveinstanceState()");
        // zapisujemy wartosc ze zmiennej count => nasz licznik
        outState.putInt("count", count); // klucz wartosc
    }
}