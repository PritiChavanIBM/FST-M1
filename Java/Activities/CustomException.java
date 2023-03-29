package activities;

import java.security.PublicKey;

public class CustomException extends Exception{
    private String message=null;

    public  CustomException(String exception){
        this.message="Hello I am custom exception class";
    }

    @Override
    public String getMessage() {
        return message;
    }

    }

