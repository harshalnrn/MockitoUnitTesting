package com.harshal.sample;

public class Feedback {
  public String getFeedback(String dish) throws WrongDishException{
if(dish.equals("dosa"))
      return "good";

else if(dish.equals("idli"))
    return "bad";

else
    throw new WrongDishException("no such dish available here");
  }
}
