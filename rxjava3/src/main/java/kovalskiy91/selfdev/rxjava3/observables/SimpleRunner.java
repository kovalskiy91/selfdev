package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class SimpleRunner {

    public static void main(String[] args) {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        Observable.fromArray(
                "Bob",
                "Jane",
                "Sam"
        ).subscribe(observer);

        Observable.fromArray(
                "Car",
                "Bike",
                null,
                "Skate"
        ).subscribe(observer);

        System.out.println("Finished");
    }

}
