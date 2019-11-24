package com.harshal.sample;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer implements Dish {


    private Feedback feedback=new Feedback();
    @Override
    public void eat(String dish) throws WrongDishException {
String dishFeedback=feedback.getFeedback(dish);
if(dishFeedback.equals("good"))
  System.out.println("I shall eat this");
    else
   System.out.println("I shall not eat this");
    }
}



//Allowed inputs: dosa, idli
//other inputs: exception