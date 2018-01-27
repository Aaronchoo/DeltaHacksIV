package com.example.android.safeeats;

/**
 * Created by ChooA on 8/15/2017.
 */

public class ListDetails  {

    //String that will hold the name
    private String mName;
    //Will hold the details/more info about the string
    private String mDetails;

    //Method that will allow the storage of the names/words
    public ListDetails(String name, String details){
        mName = name;
        mDetails=details;
    }
    //Allows the usage for the name
    public String getName(){
        return mName;
    }

    //Allows the usage for the details
    public String getDetails(){
        return mDetails;
    }
}
