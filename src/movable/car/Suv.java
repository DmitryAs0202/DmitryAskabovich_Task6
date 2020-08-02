package movable.car;

import enums.CarBrand;
import enums.FuelType;
import java.util.Date;

public class Suv extends Car {

  private int clearance;
  private boolean isExtraTrunk;
  private int tankVolume;
  private int litresInTank;
  private ExtraTrunk trunk;

  public Suv() {

  }

  public Suv(String name, int licensePlate, String color, Date dateOfManufacture,
      CarBrand carBrand, boolean isMoving, int price, byte numberOfWheels, FuelType type,
      int clearance, boolean isExtraTrunk, int tankVolume, int litresInTank) {
    super(name, licensePlate, color, dateOfManufacture, carBrand, isMoving, price, numberOfWheels,
        type);
    this.clearance = clearance;
    this.isExtraTrunk = isExtraTrunk;
    this.tankVolume = tankVolume;
    this.litresInTank = litresInTank;
    if (isExtraTrunk) {
      trunk = new ExtraTrunk(390);
    }
  }

  private class ExtraTrunk {

    private int capacity;

    public ExtraTrunk(int capacityLiters) {
      this.capacity = capacity;
    }
  }

  public void checkWay(int maxHeightOfSoil) {
    if (clearance > maxHeightOfSoil) {
      System.out.println("Есть возможность проехать");
    } else if (clearance == maxHeightOfSoil) {
      System.out.println("Возникнут проблемы с преодолением препятствий!!!");
    } else {
      System.out.println("Слишком низкий клиренс!!!");
    }
  }

  public void fillUp() {
    System.out.println(name + " заправлен");
  }

  public void fillUp(int numberOfLiters) {
    if (numberOfLiters <= 0) {
      System.out.println("Ошибка");
      return;
    }
    int maxLitres = tankVolume - litresInTank;
    if (numberOfLiters >= maxLitres) {
      System.out.println("Залит полный бак!");
      litresInTank = tankVolume;
    } else {
      System.out.println(
          "Залито " + numberOfLiters + " литров В баке " + (litresInTank + numberOfLiters)
              + " литров");
    }
  }


  @Override
  public void move() {
    if (isMoving) {
      System.out.println("Suv " + name + " is already moving...");
    } else {
      System.out.println("Suv " + name + " starts moving...");
      isMoving = true;
    }
  }

  @Override
  public void brake() {
    if (isMoving) {
      System.out.println("Suv " + name + " started braking...");
      isMoving = false;
    } else {
      System.out.println("Suv " + name + " has already been stopped");
    }
  }

  public int getClearance() {
    return clearance;
  }

  public void setClearance(int clearance) {
    this.clearance = clearance;
  }

  public boolean isExtraTrunk() {
    return isExtraTrunk;
  }

  public void setExtraTrunk(boolean extraTrunk) {
    isExtraTrunk = extraTrunk;
  }

  public int getTankVolume() {
    return tankVolume;
  }

  public void setTankVolume(int tankVolume) {
    this.tankVolume = tankVolume;
  }

  public int getLitresInTank() {
    return litresInTank;
  }

  public void setLitresInTank(int litresInTank) {
    this.litresInTank = litresInTank;
  }

}
