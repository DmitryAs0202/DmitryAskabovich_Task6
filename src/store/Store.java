package store;


import movable.Movable;


public class Store<T> {

  private int moneyAmount = 200000;
  private T[] products;

  public Store() {

  }

  public Store(T[] products) {
    this.products = products;
  }

  public void printProducts() {
    for (int i = 0; i < products.length; i++) {
      int number = i + 1;
      System.out.println(number + ". " + products[i]);
    }
  }

  public T purchase(int number, int moneyForPurchase) {
    Movable item = (Movable) products[number - 1];
    if (moneyForPurchase < item.getPrice()) {
      System.out.println("Недостаточно денег для покупки " + item.getName());
      return null;
    }
    moneyAmount += item.getPrice();

    products[number - 1] = products[products.length - 1];
    products[products.length - 1] = (T) item;
    System.out.println("Вы успешно приобрели: " + item.getName());

    T[] remainingProducts = (T[]) new Movable[products.length - 1];

    for (int i = 0; i < remainingProducts.length; i++) {
      remainingProducts[i] = products[i];
    }
    products = remainingProducts;
    return (T) item;
  }

  public void sell(T item, int offeredPrice) {
    Movable tempItem = (Movable) item;
    if (offeredPrice >= tempItem.getPrice()) {
      System.out.println("Данная покупка невыгодна для автохауса");
      return;
    }
    for (int i = 0; i < products.length; i++) {
      Movable tempItem2 = (Movable) products[i];
      if (tempItem.equals(tempItem2)) {
        if (offeredPrice >= tempItem2.getPrice()) {
          System.out.println("Данная покупка невыгодна для автохауса");
          return;
        }
      }
    }
    if (offeredPrice < moneyAmount) {
      moneyAmount -= offeredPrice;
      T[] newProducts = (T[]) new Movable[products.length + 1];
      for (int i = 0; i < products.length; i++) {
        newProducts[i] = products[i];
      }
      newProducts[newProducts.length - 1] = item;
      products = newProducts;
      System.out.println("Автомобиль " + tempItem.getName() + " выкуплен");
    } else {
      System.out.println("В кассе Автохауса недостаточно средств для выкупа " + tempItem.getName());
    }
  }

  public int getMoneyAmount() {
    return moneyAmount;
  }

  public T[] getProducts() {
    return products;
  }

  public void setProducts(T[] products) {
    this.products = products;
  }
}
