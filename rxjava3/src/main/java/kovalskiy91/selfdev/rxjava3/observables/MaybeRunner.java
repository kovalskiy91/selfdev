package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.core.Maybe;

public class MaybeRunner {

    public static void main(String[] args) {
        Maybe.just("Hello World!")
                .subscribe(
                        s -> System.out.println(s),
                        e -> {
                        },
                        () -> System.out.println("Completed")
                );

        Maybe.fromCallable(() -> {
            throw new NullPointerException("Unexpected error!");
        }).subscribe(
                o -> {
                },
                e -> System.out.println(e.getMessage()),
                () -> {
                }
        );

        Maybe.empty()
                .subscribe(
                        o -> {
                        },
                        e -> {
                        },
                        () -> System.out.println("Completed")
                );
    }

}
