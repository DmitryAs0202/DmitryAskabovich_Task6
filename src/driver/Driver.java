package driver;

public class Driver {

  private String name;
  private int age;
  private boolean truckLicence;

  public Driver(String name, int age, boolean truckLicence) {
    this.name = name;
    this.age = age;
    this.truckLicence = truckLicence;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isTruckLicence() {
    return truckLicence;
  }

  public void setTruckLicence(boolean truckLicence) {
    this.truckLicence = truckLicence;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Driver {");
    sb.append("Name: ").append(name).append(", ");
    sb.append("Age: ").append(age).append(", ");
    sb.append("Truck License: ").append(truckLicence).append("}");
    return sb.toString();
  }

}
