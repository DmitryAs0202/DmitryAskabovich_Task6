package movable.car;

import enums.CarBrand;
import enums.FuelType;
import java.util.Date;

public class Minivan extends Car {

  private int numberOfSeats;
  private int maxTripDistance;
  private boolean isFull;
  private byte passengerCounter;

  public Minivan() {

  }

  public Minivan(String name, int licensePlate, String color, Date dateOfManufacture,
      CarBrand carBrand, boolean isMoving, int price, byte numberOfWheels, FuelType type,
      int numberOfSeats, int maxTripDistance, boolean isFull) {
    super(name, licensePlate, color, dateOfManufacture, carBrand, isMoving, price, numberOfWheels,
        type);
    this.numberOfSeats = numberOfSeats;
    this.maxTripDistance = maxTripDistance;
    this.isFull = isFull;
  }

  public static class CarrierCompany {

    String name;

    public CarrierCompany(String name) {
      this.name = name;
    }
  }

  public void addPassenger() {
    if (passengerCounter < numberOfSeats) {
      ++passengerCounter;
    }
    if (passengerCounter == numberOfSeats) {
      isFull = true;
    }
    if (passengerCounter >= numberOfSeats) {
      System.out.println("Все места в " + name + " уже заняты!");
    }
  }

  public void dropOff() {
    passengerCounter = 0;
  }

  public void dropOff(int number) {
    if (number <= passengerCounter && number > 0) {
      passengerCounter -= number;
      System.out.println("В " + name + " " + passengerCounter + " пассажиров");
    } else if (passengerCounter == 0) {
      System.out.println("В " + name + " нет пассажиров");
    } else {
      System.out.println("В " + name + " меньше пассажиров");
    }
  }

  @Override
  public void move() {
    if (isMoving) {
      System.out.println("Minivan " + name + " is already moving...");
    } else if (isFull) {
      System.out.println("Minivan " + name + " starts moving...");
      isMoving = true;
    } else {
      System.out.println("Not all seats are occupied");
    }
  }

  @Override
  public void brake() {
    if (isMoving) {
      System.out.println("Minivan " + name + " started braking...");
      isMoving = false;
    } else {
      System.out.println("Minivan " + name + " has already been stopped");
    }
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public int getMaxTripDistance() {
    return maxTripDistance;
  }

  public void setMaxTripDistance(int maxTripDistance) {
    this.maxTripDistance = maxTripDistance;
  }

  public boolean isFull() {
    return isFull;
  }

  public void setFull(boolean full) {
    isFull = full;
  }

  public byte getPassengerCounter() {
    return passengerCounter;
  }

}
