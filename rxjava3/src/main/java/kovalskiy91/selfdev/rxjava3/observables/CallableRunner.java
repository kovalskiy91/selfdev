package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.core.Observable;

public class CallableRunner {

    public static void main(String[] args) {
        Observable.fromCallable(() -> "Hello")
                .map(s -> s + " World!")
                .subscribe(s -> System.out.println(s));
    }

}
