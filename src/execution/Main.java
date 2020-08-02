package execution;

import enums.CarBrand;
import enums.FuelType;
import java.util.Date;
import movable.car.Car;
import movable.car.Minivan;
import movable.car.Minivan.CarrierCompany;
import movable.car.Suv;
import movable.car.Truck;
import store.Store;

public class Main {

  public static void main(String[] args) {
    Store<Car> autoHouse = new Store<>();
    autoHouse.setProducts(addCarRange());

    autoHouse.printProducts();
    Car purchase1 = autoHouse.purchase(4, 35000);
    System.out.println(purchase1);
    autoHouse.printProducts();
    System.out.println(autoHouse.getMoneyAmount());
    Car car = new Suv("BMW X5", 2587, "White",
        new Date("4 July 2014"), CarBrand.BMW, false, 30000, (byte) 4,
        FuelType.GASOLINE, 209, true, 100, 0);
    autoHouse.sell(car, 29000);
    autoHouse.printProducts();
    System.out.println(autoHouse.getMoneyAmount());
    Car car1 = new Truck("SCANIA P410", 8745, "Red",
        new Date("18 September 2019 15:36"), CarBrand.SCANIA, false, 70000,
        (byte) 4, FuelType.DIESEL , 10300, true, "EURO 6");
    autoHouse.sell(car1, 65000);
    autoHouse.printProducts();
    System.out.println(autoHouse.getMoneyAmount());
    Car purchase2 = autoHouse.purchase(2, 26000);
    System.out.println(purchase2.getName());
    autoHouse.printProducts();
    System.out.println(autoHouse.getMoneyAmount());
    Minivan.CarrierCompany company = new CarrierCompany("West Trans Auto");


  }

  public static Car[] addCarRange() {
    Car[] productList = new Car[5];
    productList[0] = new Truck("МАЗ-555025", 1236, "Red",
        new Date("18 December 2019 15:36"), CarBrand.MAZ, false, 20000, (byte) 4,
        FuelType.DIESEL, 10300, false, "EURO 5");
    productList[1] = new Minivan("Mercedes-Benz V Class", 2635,
        "Black", new Date("2 August 2016 15:15"), CarBrand.MERCEDES, false,
        25000, (byte) 4, FuelType.GASOLINE , 7, 800,
        false);
    productList[2] = new Suv("BMW X5", 1254, "White",
        new Date("4 July 2014"), CarBrand.BMW, false, 30000, (byte) 4,
        FuelType.GASOLINE, 209, true, 100, 0);
    productList[3] = new Suv("Toyota Land Cruiser Prado", 5698, "Brown",
        new Date("14 November 2016 08:36"), CarBrand.TOYOTA, false, 40000,
        (byte) 4, FuelType.GASOLINE , 215, true, 90, 0);
    productList[4] = new Minivan("Toyota Alphard", 2145, "Silver",
        new Date("19 November 2019 08:36"), CarBrand.TOYOTA, false, 68000,
        (byte) 4, FuelType.GASOLINE , 7, 750, false);
    return productList;
  }
}
