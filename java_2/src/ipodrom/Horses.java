package ipodrom;

import java.util.Random;

public class Horses {
    private String name;
    private double speed;
    private int  position;

    {
        this.position = 0;
    }

    public Horses(String name) {
        this.name = name;
        this.speed = setSpeed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    public double setSpeed(){
        double random = new Random().nextDouble();
        return 0.5 + random;
    }
}
