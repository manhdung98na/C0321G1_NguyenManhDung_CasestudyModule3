package model.service.common;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateCustomer {

    public static String validateID(String id) {
        String regex = "^KH-[0-9]{4}$";
        return Pattern.matches(regex, id) ? null : "Invalid ID! Format: KH-xxxx";
    }

    public static String validateName(String name) {
        name = name.trim();
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex, name) ? null : "Invalid name! Need to upper case EACH FIRST CHARACTER";
    }

    public static String validatePhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        String regex = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$";
        return Pattern.matches(regex, phoneNumber) ? null : "Invalid phone number! Format: 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx | (84)+91xxxxxxx";
    }

    public static String validateIdCard(String idCard) {
        idCard = idCard.trim();
        String regex = "^([0-9]{9}|[0-9]{12})$";
        return Pattern.matches(regex, idCard) ? null : "Invalid ID Card! Format: (9 or 12 digital characters)";
    }

    public static String validateEmail(String email) {
        email = email.trim();
        String regex = "^\\w+([._]*\\w+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        return Pattern.matches(regex, email) ? null : "Invalid email! Format: abc@xyz.zyt";
    }

    public static String validateBithday(String birthday) {
        String[] dates = birthday.split("-");
        String currentDate = LocalDate.now().toString();
        String[] currentDateArr = currentDate.split("-");
        if (Integer.parseInt(dates[0]) > Integer.parseInt(currentDateArr[0])) {
            return "Birthday must be a day in the past!";
        }
        if (Integer.parseInt(dates[0]) == Integer.parseInt(currentDateArr[0])) {
            if (Integer.parseInt(dates[1]) > Integer.parseInt(currentDateArr[1])) {
                return "Birthday must be a day in the past!";
            }
            if (Integer.parseInt(dates[1]) == Integer.parseInt(currentDateArr[1])) {
                if (Integer.parseInt(dates[2]) > Integer.parseInt(currentDateArr[2])) {
                    return "Birthday must be a day in the past!";
                }
            }
        }
        return null;
    }
}
