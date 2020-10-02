package model;

import java.util.Objects;

public class Car {
    public enum Brand{
        Mercedes, BMW, Wolksvagen, Audi, Porsche;
    }
    private Brand brand;
    private String number;
    private int year;
    private User owner;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.number = builder.number;
        this.year = builder.year;
        this.owner = builder.owner;
    }

    public static class Builder {
        private Brand brand;
        private String number;
        private int year;
        private User owner;

        public Builder(String number) {
            this.number = number;
        }

        public Builder setBrand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setOwner(User owner) {
            this.owner = owner;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                brand == car.brand &&
                Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", owner=" + owner +
                '}';
    }
}
