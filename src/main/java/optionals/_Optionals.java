package optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class _Optionals {

    public static void main(String[] args) {

        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        Supplier<IllegalArgumentException> exception = ()
                -> new IllegalArgumentException("excption");

        Object value1 = Optional.ofNullable("Hello")
                .orElseThrow(exception);

        Consumer<String> println = email -> System.out.println("Sending email to " + email);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(println);

        Optional.ofNullable("john@gmail.com")
                .ifPresentOrElse(println,
                        () -> {
                            System.out.println("Cannot send email");
                        });
    }

}
