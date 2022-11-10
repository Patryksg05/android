package com.example.basketball;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.basketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int points = 0;

    // deklarujemy ViewModel
    PointsViewModel pointsViewModel;

    // przechwytywanie danych: like LocalStorage

    private SharedPreferences pointsSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // podpinamy binding => ma zapisane wszystkie widoki (findViewByID)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        setContentView(R.layout.activity_main);
        setContentView(view);

        pointsSharedPreferences = getPreferences(MODE_PRIVATE); // tylko to moze odczytywac

//        pointsViewModel = new PointsViewModel(); nie ma zbyt sensu bo nie ma constru...
        pointsViewModel = new ViewModelProvider(this).get(PointsViewModel.class); // wlasciciel, pobieramy info z klasy viewModel

        getSharedPreferences();

//        binding.score.setText(Integer.toString(pointsViewModel.getPoints())); // zapisanie

        // binding pozwala na zapis textView bez samego zapisu SetText

        pointsViewModel.getPoints().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        binding.score.setText(String.valueOf(integer));
                    }
                }); // konteks, co mamy robic

        binding.plusOne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        points++;
                        pointsViewModel.addPoints(1);
//                        binding.score.setText(String.valueOf(points));
//                        binding.score.setText(Integer.toString(pointsViewModel.getPoints()));
                    }
                }
        );

        binding.plusTwo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        points++;
                        pointsViewModel.addPoints(2);
//                        binding.score.setText(String.valueOf(points));
//                        binding.score.setText(Integer.toString(pointsViewModel.getPoints()));
                    }
                }
        );

        binding.plusThree.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        points++;
                        pointsViewModel.addPoints(3);
//                        binding.score.setText(String.valueOf(points));
//                        binding.score.setText(Integer.toString(pointsViewModel.getPoints()));
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveSharedPreferences();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        getSharedPreferences();
    }

    // METODY TE ZAPISUJEMY W ON PAUSE && ONCREATE

    private void saveSharedPreferences()
    {
        SharedPreferences.Editor editor = pointsSharedPreferences.edit(); // otwieramy edytor do zapisywania SharedPrefer
        editor.putInt("points", pointsViewModel.getPoints().getValue());
        editor.apply();
    }

    private void getSharedPreferences()
    {
        int i = pointsSharedPreferences.getInt("points", 0);
        // musimy zapisac do viewModel
        Log.d("points", Integer.toString(i));
        pointsViewModel.setPoints(i);
    }
}