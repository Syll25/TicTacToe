package syll25.tictactoe.demo;

public class Demo {

  class Human {
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
    }
  }

  public static void main(String[] args) {
    printWheelsNumber(new Bicycle());
    printWheelsNumber(new Car());

    Human human = new Human();
    human.setVehicle(new Bicycle());
    human.setVehicle(new Car());
  }

  static void  printWheelsNumber(Vehicle vehicle) {
    System.out.println(vehicle.wheels());
  }
}
