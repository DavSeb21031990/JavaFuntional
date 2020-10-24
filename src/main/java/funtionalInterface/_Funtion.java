package funtionalInterface;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class _Funtion {

    public static void main(String[] args) {

//Funtion take 1 argument and produce 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment1 = incrementByOneFunction.apply(0);
        System.out.println(increment1);

        int multipleBy10 = multiplyBy10Function.apply(increment1);
        System.out.println(multipleBy10);

        Function<Integer, Integer> addBy1AndMultiply10Function =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndMultiply10Function.apply(1));

        //BiFuntion take 2 arguments and produce 1 result
        System.out.println(
                incrementByOneAndMultiply.apply(1, 10)
        );
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (number, multiply) -> (number + 1) * multiply;

    static int incrementByOneAndMultply(int number, int multiply) {
        return (number + 1) * multiply;
    }

}
