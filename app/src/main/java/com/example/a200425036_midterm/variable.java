package com.example.a200425036_midterm;

public class variable {
    private String id;
    private String firstName;
    private String LastName;
    private String Winner;

    public  variable(){


    }
    public  variable(String id,String firstName,String LastName,String Winner ){
        this.id=id;
        this.firstName=firstName;
        this.LastName=LastName;
        this.Winner=Winner;
    }
    public String getId(){return id;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return LastName;}
    public String getWinner(){return Winner;}


}


