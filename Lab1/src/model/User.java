package model;

import java.time.LocalDate;
import java.util.Objects;

//TODO make all fields private
public class User {
    private String name;
    String surname;
    String address;
    LocalDate birthdate;

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

    private User(User.Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.birthdate = builder.birthdate;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String address;
        LocalDate birthdate;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public User.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User.Builder setBirthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public User build() {
            return new User(this);
        }
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
