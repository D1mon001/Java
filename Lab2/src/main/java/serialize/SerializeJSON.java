package serialize;
import model.Car;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class SerializeJSON {
    ObjectMapper mapper;

    public SerializeJSON() {
        mapper = new ObjectMapper();
    }

    public void serializer(Car obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Car deserializer(File file) {
        try {
            return mapper.readValue(file, Car.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}



