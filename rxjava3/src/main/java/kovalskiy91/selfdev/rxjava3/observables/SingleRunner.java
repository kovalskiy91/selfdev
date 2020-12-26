package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.core.Single;

public class SingleRunner {

    public static void main(String[] args) {
        Single.just("Hello World!")
                .subscribe(s -> System.out.println(s));

        Single.fromCallable(() -> {
            throw new RuntimeException("Unexpected error");
        }).subscribe(
                s -> {
                },
                e -> System.out.println(e.getMessage())
        );
    }

}
