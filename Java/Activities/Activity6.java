package activities;
public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(50);

        plane.onboard("Priti");
        plane.onboard("Ruturaj");
        plane.onboard("Meera");


        System.out.println("Plane take off time is : " + plane.takeOff());
        System.out.println("People on the plane: " + plane.getPassengers());
        System.out.println("In the air..........");
        Thread.sleep(15000);
        plane.land();
        System.out.println("Plane landed on: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}