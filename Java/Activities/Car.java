package activities;

public class Car {
    String color,transmission;
    int make;
    int tyres, doors;
    Car(){
        doors=4;
        tyres=4;
    }
    public void displayCharacteristics(){
        System.out.println(color);
        System.out.println(transmission);
        System.out.println(make);
        System.out.println(tyres);
        System.out.println(doors);

    }
    public void accelerates(){
        System.out.println("Car is moving forward");
    }
    public void brake(){
        System.out.println("Car has stopped");
    }

}
