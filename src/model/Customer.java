package model;

public class Customer {

    String firstName;
    String lastName;
    String email;


    public Customer(String firstName, String lastName, String email){
        if(isEmailValid(email)){
            throw new  IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    private boolean isEmailValid(String email){
        String regex = "(?i)^[\\w.-]+@[\\w-]+\\.(com|net|org)$";
        return !email.matches(regex);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
