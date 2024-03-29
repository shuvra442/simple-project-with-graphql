package com.springBootGraphql.helper;

public class Excpetions {

    public static RuntimeException throwResourceNotFounfException(){
        return new RuntimeException("Not found exception !!");
    }
}
