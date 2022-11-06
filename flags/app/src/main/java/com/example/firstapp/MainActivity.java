package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int licznik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onclick function, dostep klasa R (wszystko gdy posiada ID)
    public void zlaOdpowiedz(View view) {
        Toast.makeText(MainActivity.this, R.string.zla_odp,
                Toast.LENGTH_SHORT).show(); // || sam THIS
    }

    public void poprawnaOdpowiedz(View view) {
        Toast.makeText(MainActivity.this, R.string.pop_odp ,
                Toast.LENGTH_SHORT).show();
        view.setVisibility(View.INVISIBLE);
        licznik++;
        if(licznik == 5){
            // dostep do id
            TextView pytanieTextView = findViewById(R.id.pytanieTextView);
            pytanieTextView.setText(R.string.end);
        }
    }
}