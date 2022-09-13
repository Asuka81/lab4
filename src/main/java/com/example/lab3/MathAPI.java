package com.example.lab3;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {

    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public String MyPlus(@PathVariable("n1") double a,
                      @PathVariable("n2") double b) {
        double ans;
        ans = a + b;

        return ans + "";

    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public String MyMinus(@PathVariable("n1") double a,
                        @PathVariable("n2") double b) {
        double ans;
        ans = a - b;
        return ans + "";
    }

    @RequestMapping(value = "/multiply/{n1}/{n2}", method = RequestMethod.GET)
    public String MyMulti(@PathVariable("n1") double num1,
                           @PathVariable("n2") double num2) {
        double ans;
        ans = num1 * num2;
        return ans + "";
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String MyDivide(@PathVariable("n1") double num1,
                         @PathVariable("n2") double num2) {
        double ans;
        ans = num1 / num2;
        return ans + "";
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String MyMod(@PathVariable("n1") double num1,
                        @PathVariable("n2") double num2){
        double ans;
        ans = num1 % num2;
        return ans+ "";
    }

    @RequestMapping(value = "max", method = RequestMethod.POST)
    public double myMax(@RequestParam("num1") double a, @RequestParam("num2") double b){
        if (a > b){
            return a;
        }
        else {
            return b;
        }
    }
}

