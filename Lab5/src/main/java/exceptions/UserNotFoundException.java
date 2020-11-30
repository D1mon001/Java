package exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("Such user doesn't exists");
    }

    public UserNotFoundException(String user){
        super("User " + user + "doesn't exists");
    }
}
