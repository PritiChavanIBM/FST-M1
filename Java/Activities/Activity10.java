package activities;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        // Adding element to HashSet
        hs.add("Samruddhi");
        hs.add("Sanskar");
        hs.add("Aniket");
        hs.add("Aniruddha");
        hs.add("Samruddhi");
        hs.add("Akshay");

        //Print HashSet
        System.out.println("Original HashSet: " + hs);
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hs.size());

        //Remove element
        System.out.println("Removing Aniket from HashSet: " + hs.remove("Aniket"));
        //Remove element that is not present
        if(hs.remove("Priti")) {
            System.out.println("Priti removed from the Set");
        } else {
            System.out.println("Priti is not present in the Set");
        }

        //Search for element
        System.out.println("Checking if Samruddhi is present in the Set : " + hs.contains("Samruddhi"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);
    }
}