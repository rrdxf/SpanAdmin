package june_22;

public class Car extends Vehicle{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String name, double speed, String color) {
        super(name, speed);
        this.color = color;
    }

    @Override
    public String move() {
        return this.color+super.move();
    }
}
