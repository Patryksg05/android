package com.example.kartkowka;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button losuj, zwieksz, zmniejsz;
    TextView liczba;

    int zwiekszenie, zmniejszenie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("wynik", "onCreate()");

        losuj = findViewById(R.id.losuj);
        zwieksz = findViewById(R.id.zwieksz);
        zmniejsz = findViewById(R.id.zmniejsz);
        liczba = findViewById(R.id.number);

        if(savedInstanceState != null) {
            int score = savedInstanceState.getInt("wynik", 0);
            Toast.makeText(this, String.valueOf(score), Toast.LENGTH_SHORT).show();
            liczba.setText(String.valueOf(score));
        }

        String wartosc = liczba.getText().toString();

        losuj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer wylosowano = (int) (Math.random() * 6 + 1);
                        liczba.setText(Integer.toString(wylosowano));
                        zwieksz.setVisibility(View.VISIBLE);
                        zmniejsz.setVisibility(View.VISIBLE);
                    }
                }
        );

        zwieksz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String input = liczba.getText().toString();
                        zwiekszenie = Integer.valueOf(input);
                        zwiekszenie++;
                        liczba.setText(Integer.toString(zwiekszenie));
                        zwieksz.setVisibility(View.INVISIBLE);
                        zmniejsz.setVisibility(View.INVISIBLE);
                    }
                }
        );

        zmniejsz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String input = liczba.getText().toString();
                        zmniejszenie = Integer.valueOf(input);
                        zmniejszenie--;
                        liczba.setText(Integer.toString(zmniejszenie));
                        zwieksz.setVisibility(View.INVISIBLE);
                        zmniejsz.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Wynik", "onSaveinstanceState()");
        String value = liczba.getText().toString();
        int valueAsNumber = Integer.valueOf(value);
        outState.putInt("wynik", valueAsNumber);
    }

}



    /**
     * KONWERT ZMIENNYCH:
     * string to int => Integer.valueOf && Integer.parseInt
     * int to string => Integer.toString && String.valueOf
     **/