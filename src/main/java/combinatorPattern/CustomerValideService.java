package combinatorPattern;

import POJOS.Customer;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValideService {

    private boolean isEmailValide(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValide(String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer){
        return isEmailValide(customer.getEmail()) &&
                isPhoneNumberValide(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }

}
