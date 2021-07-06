package common;

import java.util.regex.Pattern;

public class ValidateCustomer {

    public static String validateName(String name){
        name = name.trim();
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex,name) ? null : "Invalid name!";
    }

    public static String validatePhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.trim();
        String regex = "^0[0-9]{9}$";
        return Pattern.matches(regex,phoneNumber) ? null : "Invalid phone number!";
    }

    public static String validateEmail(String email){
        email = email.trim();
        String regex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]+$";
        return Pattern.matches(regex, email) ? null : "Invalid email!";
    }

//    public boolean validateID(String id) {
//        String regex = "^[0-9]{3} [0-9]{3} [0-9]{3}$";
//        return Pattern.matches(regex, id);
//    }

}
