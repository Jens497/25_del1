package game;
import java.lang.Math;

public class Die {

    int faceValue;

    public int roll(){
        this.faceValue = (int)(Math.random()*6) + 1;
        return this.faceValue;
    }

    public int getFaceValue(){
        return this.faceValue;
    }
}