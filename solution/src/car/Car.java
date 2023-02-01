package car;

public class Car {
    private String carNumber;

    public Car() {
    }

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public void turnOnFrontLight(){
        System.out.println("打开车灯");
    }
    public void turnOffFrontLight(){
        System.out.println("关闭车灯");
    }
    public static void main(String[] args) {
        Car car = new Car("123");
        car.turnOnFrontLight();
        car.turnOffFrontLight();
        Car car2 = new Car("1134");
        car2.turnOnFrontLight();
        car2.turnOffFrontLight();
    }
}
