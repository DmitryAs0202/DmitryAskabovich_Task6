package movable.car;

import enums.CarBrand;
import driver.Driver;
import enums.FuelType;
import java.util.Date;

public class Truck extends Car {

  public static final int TRAILER_CAPACITY = 5000;
  public static final byte TRAILER_WHEELS = 4;

  private Driver[] drivers = new Driver[2];
  private int loadCapacity;
  private boolean isCargoTrailer;
  private String exhaustStandard;
  private CargoTrailer trailer;


  public Truck() {

  }

  public Truck(String name, int licensePlate, String color, Date dateOfManufacture,
      CarBrand carBrand, boolean isMoving, int price, byte numberOfWheels, FuelType type,
      int loadCapacity, boolean isCargoTrailer, String exhaustStandard) {
    super(name, licensePlate, color, dateOfManufacture, carBrand, isMoving, price, numberOfWheels,
        type);
    this.loadCapacity = loadCapacity;
    this.isCargoTrailer = isCargoTrailer;
    this.exhaustStandard = exhaustStandard;
    if (isCargoTrailer) {
      trailer = new CargoTrailer(TRAILER_CAPACITY, TRAILER_WHEELS);
    }
  }

  private class CargoTrailer {

    int loadCapacity;
    byte numberOfWheels;

    public CargoTrailer(int loadCapacity, byte numberOfWheels) {
      this.loadCapacity = loadCapacity;
      this.numberOfWheels = numberOfWheels;
    }
  }

  public void addCargoTrailer(int TrailerLoadCapacity, byte trailerWheels) {
    if (isCargoTrailer) {
      System.out.println(name + " is already with the trailer");
    } else {
      isCargoTrailer = true;
      loadCapacity += TrailerLoadCapacity;
      trailer = new CargoTrailer(TrailerLoadCapacity, trailerWheels);
    }
  }

  public void addDriver(Driver driver) {
    if (!driver.isTruckLicence()) {
      System.out.println("У водителя нет прав для управления грузовиком");
      return;
    }
    if (drivers[0] == null) {
      drivers[0] = driver;
    } else if (drivers[1] == null) {
      drivers[1] = driver;
    } else {
      System.out.println("У грузовика уже 2 водителя!");
    }
  }

  public double fillUpPrice(int numberOfLiters) {
    return numberOfLiters * 1.78;
  }

  @Override
  public void move() {
    if (isMoving) {
      System.out.println("Truck " + name + " is already moving...");
    } else {
      System.out.println("Truck " + name + " starts moving...");
      isMoving = true;
    }
  }

  public void move(int distanceInKilometers) {
    if (isMoving) {
      System.out.println("Truck " + name + " is already moving...");
    } else {
      System.out.println("Truck " + name + " starts moving...");
      isMoving = true;
      brake();
      System.out.println("Truck " + name + " passed " + distanceInKilometers + " kilometres");
    }
  }

  @Override
  public void brake() {
    if (isMoving) {
      System.out.println("Truck " + name + " started braking...");
      isMoving = false;
    } else {
      System.out.println("Truck " + name + " has already been stopped");
    }
  }

  public int getLoadCapacity() {
    return loadCapacity;
  }

  public void setLoadCapacity(int loadCapacity) {
    this.loadCapacity = loadCapacity;
  }

  public boolean isCargoTrailer() {
    return isCargoTrailer;
  }

  public void setCargoTrailer(boolean cargoTrailer) {
    if (cargoTrailer) {
      System.out.println("Use addCargoTrailer method!!!");
      return;
    }
    isCargoTrailer = cargoTrailer;
  }

  public String getExhaustStandard() {
    return exhaustStandard;
  }

  public Driver[] getDrivers() {
    return drivers;
  }

  public void setExhaustStandard(String exhaustStandard) {
    this.exhaustStandard = exhaustStandard;

  }

  public CargoTrailer getTrailer() {
    return trailer;
  }
}
