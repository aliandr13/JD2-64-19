package by.it.academy.offer.model;

import java.util.Objects;

public class Car {

    private long Id;
    private String carModel;
    private double priceForHour;
    private String color;
    private String engine;
    private int year;

    public Car(Long o, String carModel, Double price, String color, String engine, Integer year) {
    }

    public Car(long id, String carModel, double price, String color, String engine, int year) {
        this.Id = id;
        this.carModel = carModel;
        this.priceForHour = price;
        this.color = color;
        this.engine = engine;
        this.year = year;
    }

    public long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getPriceForHour() {
        return priceForHour;
    }

    public void setPriceForHour(double priceForHour) {
        this.priceForHour = priceForHour;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car product = (Car) o;
        return Id == product.Id &&
                Double.compare(product.priceForHour, priceForHour) == 0 &&
                year == product.year &&
                Objects.equals(carModel, product.carModel) &&
                Objects.equals(color, product.color) &&
                Objects.equals(engine, product.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, carModel, priceForHour, color, engine, year);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + Id +
                ", carModel='" + carModel + '\'' +
                ", price=" + priceForHour +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", year=" + year +
                '}';
    }
}
