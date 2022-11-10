package com.example.basketball;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PointsViewModel extends ViewModel {
    // rozszerzamy klasy ViewModel

    // dodajem dane obserwowane
//    private int points;
    private MutableLiveData<Integer> points = new MutableLiveData<>(); // dane obserwujace

    public MutableLiveData<Integer> getPoints() {
        if(points == null) {
            points = new MutableLiveData<Integer>(); // ma tylko get i set Mutable
            points.setValue(0); // domyslna wartosc
        }
        return points;
    }

    public void setPoints(int points) {
//        this.points = points;
        this.points.setValue(points);
    }

    public void addPoints(int n) {
        if(this.points != null) {
            this.points.setValue(points.getValue()+n);
        }
    }
}
