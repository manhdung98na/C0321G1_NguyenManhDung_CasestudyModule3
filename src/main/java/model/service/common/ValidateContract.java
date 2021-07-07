package model.service.common;

import java.sql.Date;

public class ValidateContract {
    public static String validateMoney(double deposit, double totalMoney) {
        if (deposit < 0 || totalMoney < 0) {
            return "Số tiền không được là số âm!";
        }
        if (deposit > totalMoney) {
            return "Tiền đặt cọc không được vượt quá tiền thanh toán!";
        }
        return null;
    }

    public static String validateTime(Date startDate, Date endDate) {
        if (startDate.after(new java.util.Date())) {
            return "Start-date phải là ngày trong quá khứ";
        }
        if (endDate.before(startDate)) {
            return "End-date không thể sau Start-date";
        }
        return null;
    }

    public static String validateCustomerId(String customerId) {
        return ValidateCustomer.validateID(customerId);
    }

    public static String validateServiceId(String serviceId) {
        return ValidateService.validateID(serviceId);
    }
}
