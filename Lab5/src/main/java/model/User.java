package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//TODO make all fields private
public class User {
    int id;
    private String name;
    String surname;
    String address;
    LocalDate birthdate;

    private List<Car> transports;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Car> getTransports() {
        return transports;
    }

    public void setTransports(List<Car> transports) {
        this.transports = transports;
    }

    public User(){
    }

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.birthdate = builder.birthdate;
        this.transports = builder.transports;
    }

    public static class Builder {
        int id;
        private String name;
        private String surname;
        private String address;
        LocalDate birthdate;
        private List<Car> transports;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder setTransports(List<Car> transports){
            this.transports = transports;
            return this;
        }

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", transports=" + transports +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        //return name.equalsIgnoreCase(user.name);
        return name.equalsIgnoreCase(user.name) &&
                surname.equalsIgnoreCase(user.surname) &&
                Objects.equals(birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), surname.toLowerCase(), birthdate);
    }

}
