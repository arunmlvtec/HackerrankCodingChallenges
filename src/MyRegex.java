import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class foodFactory extends Food{
	public foodFactory(){
		super();
	}
	public foodFactory(String food) {
		super(food);
		// TODO Auto-generated constructor stub
	}

	public Food getFood(String food){
		return new Food(food);
	}
}
class Food{
	String food;
	public Food(){
		food = null;
	}
	public Food(String food){
		this.food = food;
	}
	
	public void servesFood(){
		System.out.println("I'm serving "+food);
	}
}


class MyRegex
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        foodFactory myFoods = new foodFactory();
        Food food1 = myFoods.getFood("Fastfood");
        Food food2 = myFoods.getFood("Fruits");
        System.out.println("My name is: " + food1.getClass().getName());
        System.out.println("My name is: " + food2.getClass().getName());
        System.out.println("Our superclass is: " + food1.getClass().getName());
        food1.servesFood();
        food2.servesFood();

    }
}