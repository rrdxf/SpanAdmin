package june_22;

public abstract class Vehicle {
    private String name;
    private double speed;

    public Vehicle(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }
    public String move(){
        return name+"在以"+speed+"公里每个小时的移动速度！";
    }
}
