package kovalskiy91.selfdev.rxjava3.buffering;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class BufferingWithSkipRunner {

    public static void main(String[] args) throws InterruptedException {
        Disposable subscription = Observable.interval(1, TimeUnit.SECONDS)
                .buffer(2, 1)
                .doOnDispose(() -> System.out.println("Disposed"))
                .subscribe(System.out::println);

        Thread.sleep(10000);

        Runtime.getRuntime().addShutdownHook(new Thread(subscription::dispose));
    }
}
