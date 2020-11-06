import model.Car;
import serialize.SerializeJSON;
import serialize.SerializeTXT;
import serialize.SerializeXML;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.Builder("AU3454CE").setBrand(Car.Brand.Mercedes).setYear(2010).build();
        Car car2 = new Car.Builder("BC1166CE").setBrand(Car.Brand.Porsche).setYear(2015).build();
        Car car3 = new Car.Builder("BO1111CE").setBrand(Car.Brand.BMW).setYear(2018).build();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        //System.out.println(car1);

        SerializeJSON serialize1 = new SerializeJSON();
        SerializeXML serialize2 = new SerializeXML();
        SerializeTXT serialize3 = new SerializeTXT();

       try {
            serialize1.serializer(car1, new File("1.json"));
            serialize2.serializer(car2, new File("1.XML"));
            serialize3.serializer(car3, new File("1.txt"));
       }
       catch (Exception error){
            error.printStackTrace();
       }

        try {
            car4 = serialize1.deserializer(new File("1.json"));
            car5 = serialize2.deserializer(new File("1.XML"));
            car6 = serialize3.deserializer(new File("1.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        System.out.println(car4);
        System.out.println(car5);
        System.out.println(car6);
        
        
        //System.out.println(user1.equals(user2));
    }
}
