package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ChainRunner {

    public static void main(String[] args) {
        @NonNull final Observable<String> observable = Observable.fromArray(
                "Bob",
                "Jane",
                "John"
        );

        observable.subscribe(s -> System.out.println(s));

        observable
                .map(String::length)
                .filter(s -> s >= 1)
                .subscribe(s -> System.out.println(s));
    }

}
