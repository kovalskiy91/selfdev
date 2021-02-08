package kovalskiy91.selfdev.rxjava3.buffering;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class BufferingWithTimerRunner {

    public static void main(String[] args) throws InterruptedException {
        Disposable subscription = Observable.interval(1, TimeUnit.SECONDS)
                .buffer(5,TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposed"))
                .subscribe(System.out::println);

        Thread.sleep(100000);

        Runtime.getRuntime().addShutdownHook(new Thread(subscription::dispose));
    }
}
