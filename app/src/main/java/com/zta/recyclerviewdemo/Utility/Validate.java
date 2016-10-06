package com.zta.recyclerviewdemo.Utility;

/**
 * Created by Zee Abbasi on 9/29/2016.
 */

public class Validate {

    //validate name
    public static boolean validateName( String firstName )
    {
        return firstName.matches( "[a-zA-Z][a-zA-Z]*" );
    }
}
