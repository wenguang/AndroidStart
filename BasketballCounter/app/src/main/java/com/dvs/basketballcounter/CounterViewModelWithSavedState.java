package com.dvs.basketballcounter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class CounterViewModelWithSavedState extends ViewModel {

    private SavedStateHandle handle;
    public final static String KEY_ATEAM_SCORE = "ATEAM_SCORE";
    public final static String KEY_BTEAM_SCORE = "BTEAM_SCORE";

    public CounterViewModelWithSavedState(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getATeamScore() {
        if (!handle.contains(KEY_ATEAM_SCORE)) {
            handle.set(KEY_ATEAM_SCORE, 0);
        }
        return handle.getLiveData(KEY_ATEAM_SCORE);
    }

    public MutableLiveData<Integer> getBTeamScore() {
        if (!handle.contains(KEY_BTEAM_SCORE)) {
            handle.set(KEY_ATEAM_SCORE, 0);
        }
        return handle.getLiveData(KEY_BTEAM_SCORE);
    }

    public void addATeamScore(int n) {
        MutableLiveData<Integer> aTeamScore = getATeamScore();
        aTeamScore.setValue(aTeamScore.getValue() + n);
        handle.set(KEY_ATEAM_SCORE, aTeamScore);
    }

    public void addBTeamScore(int n) {
        MutableLiveData<Integer> bTeamScore = getBTeamScore();
        bTeamScore.setValue(bTeamScore.getValue() + n);
        handle.set(KEY_BTEAM_SCORE, bTeamScore);
    }
}
