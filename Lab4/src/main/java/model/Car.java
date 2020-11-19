package model;

import validators.CarRightNumber;

import javax.validation.constraints.*;
import java.util.Objects;

public class Car implements Comparable<Car>{
    public enum Brand{
        Mercedes, BMW, Volkswagen, Audi, Porsche;
    }
    @NotNull
    private Brand brand;

    //@Pattern(regexp = "[A-Za-z1-9]{8}")
    @CarRightNumber
    private String number;

    @Min(value = 1960, message = "Must be not lower then 1960")
    @Max(value = 2020, message = "Must be not higher then 2020")
    private int year;


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

    public Car(){
    }

    public Car(Brand brand, String number, int year){
        this.brand = brand;
        this.number = number;
        this.year = year;
    }

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.number = builder.number;
        this.year = builder.year;
    }

    public static class Builder {
        private Brand brand;
        private String number;
        private int year;

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
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if (this.brand == o.brand){
            if (this.year == o.year){
                if(this.number == o.number){
                    return this.number.compareTo(o.number);
                }
                return this.number.length() - o.number.length();
            }
            return this.year - o.year;
        }
        return this.brand.compareTo(o.brand);
    }
}
