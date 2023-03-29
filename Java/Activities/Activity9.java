package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Akshay");
        myList.add("Priti");
        myList.add("Ruturaj");
        //Adding object at specific index
        myList.add(3, "Hrishikesh");
        myList.add(1, "Bhupali");

        System.out.println("Elements in the list are : ");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("Third element in the list is : " + myList.get(2));
        System.out.println("Is Rutu is in list: " + myList.contains("Rutu"));
        System.out.println("Size of ArrayList is : " + myList.size());

        myList.remove("Priti");

        System.out.println("New Size of ArrayList: " + myList.size());
    }
}