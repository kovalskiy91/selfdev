package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.Scanner;

public class EmitterRunner {

    public static void main(String[] args) {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                final Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                while (!"END".equals(next)) {
                    if ("ERR".equals(next)) {
                        emitter.onError(new RuntimeException());
                        return;
                    }
                    emitter.onNext(next);
                    next = scanner.next();
                }
                emitter.onComplete();
            }
        });

        observable.subscribe(
                s -> System.out.println(s),
                e -> System.out.println("Error"),
                () -> System.out.println("Completed")
        );

        System.out.println("Finished");
    }
}
