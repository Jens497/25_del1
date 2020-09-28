package game;
import java.lang.Math;

public class Die {

    static int faceValue;

    public static void main(String args[]){
        System.out.println(roll());

    }

    public static int roll(){
        faceValue = (int)Math.random()*6 + 1;
        return faceValue;
    }
}
