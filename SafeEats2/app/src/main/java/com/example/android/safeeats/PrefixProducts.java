package com.example.android.safeeats;

/**
 * Created by ChooA on 1/28/2018.
 */

public class PrefixProducts {
    //The image url
    private String mImage;
    //The name
    private String mName;
    private String mDescription;
    private  String mOriginalWeb;

    public PrefixProducts(String image, String name, String description, String web){
        mDescription = description;
        mName = name;
        mImage = image;
        mOriginalWeb = web;
    }

    public String getNameIngred(){return mName;}
    public String getImage() {return  mImage;}
    public String getDescription(){return mDescription;}
    public String getWebsite(){return mOriginalWeb;}

}
