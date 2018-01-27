package com.example.android.safeeats;

/**
 * Created by ChooA on 1/27/2018.
 */

public class listAllergies {

    private String mAllergies;
    private int mChecked;

    public listAllergies(String allergy, int checked) {

        mAllergies = allergy;
        //0 means not checked and 1 means checked
        mChecked = checked;
    }

    public String getAllergies() {return  mAllergies;}
    public int getChecked() {return mChecked;}
}
