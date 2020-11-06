package serialize;

import model.Car;

import java.io.*;

public class SerializeTXT {

    public void serializer(Car obj, File file) throws IOException {
        try(FileWriter fw = new FileWriter(file)){
            String str = "Brand: " + ((model.Car) obj).getBrand() + " Number: " + ((model.Car) obj).getNumber() + " Year: " + ((model.Car) obj).getYear();
            fw.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Car deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = fr.readLine()) != null && str.length() != 0) {
                String[] values = str.split(" ");
                return new Car.Builder(values[3]).setBrand(Car.Brand.valueOf(values[1])).setYear(Integer.parseInt(values[5])).build();
            }
            //return  new Car.Builder(values[3]).setBrand(Car.Brand.valueOf(values[1])).setYear(Integer.parseInt(values[5])).build();
        }
//        catch (IOException e) {
        throw new RuntimeException("File is empty");
//        }
    }
}
