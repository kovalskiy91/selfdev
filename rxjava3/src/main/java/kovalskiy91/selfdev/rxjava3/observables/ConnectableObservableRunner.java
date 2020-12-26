package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class ConnectableObservableRunner {

    public static void main(String[] args) {
        @NonNull final ConnectableObservable<String> just = Observable.just(
                "Alice",
                "Bob",
                "John"
        ).publish();

        just.subscribe(s -> System.out.println("Observer 1: " + s));
        just.subscribe(s -> System.out.println("Observer 2: " + s));

        just.connect();

    }

}
