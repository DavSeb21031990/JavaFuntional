package funtionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValide("07000000000"));
        System.out.println(isPhoneNumberValide("0700000000"));
        System.out.println(isPhoneNumberValide("09009877300"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidePredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidePredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidePredicate.test("09009877300"));

        System.out.println("Is phone number valid and contains number 3 = "
                + isPhoneNumberValidePredicate.and(containsNumber3Predicate).test("07000000000"));
    }

    static boolean isPhoneNumberValide(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidePredicate =
            phoneNumber -> {
                return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
            };

    static Predicate<String> containsNumber3Predicate =
            phoneNumber -> {
                return phoneNumber.contains("3");
            };
}
