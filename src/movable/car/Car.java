package movable.car;

import enums.CarBrand;
import enums.FuelType;
import java.io.Serializable;
import movable.Movable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Car implements Movable, Serializable {

  public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

  protected String name;
  protected int licensePlate;
  protected String color;
  protected Date dateOfManufacture;
  protected CarBrand carBrand;
  protected boolean isMoving;
  protected int price;
  protected FuelType fuelType;
  private byte numberOfWheels;


  public Car() {

  }

  public Car(String name, int licensePlate, String color, Date dateOfManufacture,
      CarBrand carBrand, boolean isMoving, int price, byte numberOfWheels, FuelType type) {
    this.name = name;
    this.licensePlate = licensePlate;
    this.color = color;
    this.dateOfManufacture = dateOfManufacture;
    this.carBrand = carBrand;
    this.isMoving = isMoving;
    this.price = price;
    this.numberOfWheels = numberOfWheels;
    Motor motor = new Motor(type);
  }

  private class Motor {

    FuelType fuelType;

    public Motor(FuelType fuelType) {
      this.fuelType = fuelType;
    }
  }

  public abstract void move();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(int licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getDateOfManufacture() {
    return DATE_FORMAT.format(this.dateOfManufacture);
  }

  public void setDateOfManufacture(Date dateOfManufacture) {
    this.dateOfManufacture = dateOfManufacture;
  }

  public CarBrand getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(CarBrand carBrand) {
    this.carBrand = carBrand;
  }

  public boolean isMoving() {
    return isMoving;
  }

  public void setMoving(boolean moving) {
    isMoving = moving;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public byte getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(byte numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Car{");
    sb.append("name= '").append(name).append("', ");
    sb.append("licensePlate='").append(licensePlate).append("', ");
    sb.append("color='").append(color).append("', ");
    sb.append("dateOfManufacture= ").append(getDateOfManufacture()).append(", ");
    sb.append("carBrand= ").append(carBrand.getName()).append(", ");
    sb.append("isMoving= ").append(isMoving).append(", ");
    sb.append("number of wheels= ").append(numberOfWheels);
    sb.append(", ").append("PRICE ").append(price).append("}");
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(getName(), car.getName()) &&
        Objects.equals(getColor(), car.getColor()) &&
        getCarBrand() == car.getCarBrand();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getColor(), getCarBrand());
  }

}
