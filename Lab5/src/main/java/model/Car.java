package model;

import java.util.Objects;

public class Car implements Comparable<Car>{
    public enum Brand{
        Mercedes, BMW, Volkswagen, Audi, Porsche;
    }
    int id;
    private Brand brand;
    private String number;
    private int year;
    int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public Car(String number){
        this.number = number;
    }

    private Car(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.number = builder.number;
        this.year = builder.year;
        this.user_id = builder.user_id;
    }

    public static class Builder {
        private int id;
        private Brand brand;
        private String number;
        private int year;
        private int user_id;

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

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setUser_id(int user_id) {
            this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", user_id=" + user_id +
                '}';
    }
}
