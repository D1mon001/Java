package exceptions;

public class CarNotFoundException extends Exception{

    public CarNotFoundException(){
        super("Such car doesn't exists");
    }

    public CarNotFoundException(String car){
        super("Car " + car + "doesn't exists");
    }

}
