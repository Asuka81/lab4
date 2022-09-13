package com.example.lab3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    private Change change;

    @RequestMapping(value = "/getChange/{a}", method = RequestMethod.GET)

    public Change getChange(@PathVariable("a") int a){
        double b;
        change = new Change();
        change.setB1000(a/1000);
        change.setB500((a%1000)/500);
        change.setB100(((a%1000)%500)/100);
        change.setB20((((a%1000)%500)%100)/20);
        change.setB10(((((a%1000)%500)%100)%20)/10);
        change.setB5((((((a%1000)%500)%100)%20)%10)/5);
        change.setB1(((((((a%1000)%500)%100)%20)%10)%5)/1);
        return change;

    }
}
