package activities;

public class Activity2 {
    public static void main(String args[]){
        int arr[]={10, 77, 10, 54, -11, 10};
        int sum=0;
        for (int element:arr) {
            if(element==10){
               sum=sum+element;
            }
        }
        System.out.println("Is sum of all 10's in array = 30 : "+isSum30(sum));
    }
    public static boolean isSum30(int sum){
        if(sum==30){
            return true;
        }else{
            return false;
        }
    }

}
