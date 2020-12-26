package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.core.Observable;

public class ErrorRunner {

    public static void main(String[] args) {
        Observable.error(new RuntimeException("Error!"))
                .subscribe(
                        o -> {
                        },
                        e -> e.printStackTrace());
    }

}
