package serialize;
import model.Car;


import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializeXML {
    XmlMapper object;

    public SerializeXML() {
        object = new XmlMapper();
    }

    public void serializer(Car obj, File file) throws IOException {
        try {
            object.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Car deserializer(File file) {
        try {
            return object.readValue(file, Car.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}