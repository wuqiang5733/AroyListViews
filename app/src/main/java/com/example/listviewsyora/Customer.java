package com.example.listviewsyora;


import java.util.HashMap;

public class Customer {

    private final String firstName;
    private final String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    // 如果没有 toString 方法，输出的，将是类的地址
    @Override
    public String toString(){
        return firstName + "" + lastName;
    }

    public HashMap<String,String> toHashMap() {
        HashMap<String,String> returnValue = new HashMap<>();
        returnValue.put("FirstName",getFirstName());
        returnValue.put("LastName",getLastName());
        return returnValue;
    }
}
