package combinatorPattern;

import POJOS.Customer;
import Enum.ValidatorResult;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2020, 1, 1)
        );

        System.out.println(new CustomerValideService().isValid(customer));

        ValidatorResult result = CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValide())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidatorResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }

}
