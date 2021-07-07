package model.service.common;

import java.util.regex.Pattern;

public class ValidateService {
    public static String validateID(String id) {
        String regex = "^DV-[0-9]{4}$";
        return Pattern.matches(regex, id) ? null : "Invalid ID! Format: DV-xxxx";
    }

    public static String validateName(String name) {
        name = name.trim();
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex, name) ? null : "Invalid name! Uppercase each first character";
    }

}
