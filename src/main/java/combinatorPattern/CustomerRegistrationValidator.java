package combinatorPattern;

import POJOS.Customer;
import Enum.ValidatorResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidatorResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                ValidatorResult.SUCCESS : ValidatorResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValide() {
        return customer ->  customer.getPhoneNumber().startsWith("+0") ?
                ValidatorResult.SUCCESS : ValidatorResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer ->  Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                ValidatorResult.SUCCESS : ValidatorResult.IS_NOT_AN_ADULT;
    }

     default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidatorResult result = this.apply(customer);
            return result.equals(ValidatorResult.SUCCESS) ? other.apply(customer) : result;
        };
     }

}
