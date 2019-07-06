package com.dvs.basketballcounter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    public int number;

    private MutableLiveData<Integer> ATeamScore;
    private MutableLiveData<Integer> BTeamScore;

    public MutableLiveData<Integer> getATeamScore() {
        if (ATeamScore == null) {
            ATeamScore = new MutableLiveData<>();
            ATeamScore.setValue(0);
        }
        return  ATeamScore;
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if (BTeamScore == null) {
            BTeamScore = new MutableLiveData<>();
            BTeamScore.setValue(0);
        }
        return  BTeamScore;
    }

    public void addATeamScore(int n) {
        ATeamScore.setValue(ATeamScore.getValue() + n);
    }

    public void addBTeamScore(int n) {
        BTeamScore.setValue(BTeamScore.getValue() + n);
    }

    public void add() {
        number += 1;
    }
}
