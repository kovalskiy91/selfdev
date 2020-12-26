package kovalskiy91.selfdev.rxjava3.observables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableInterval;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class IntervalRunner {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> interval = Observable.interval(5, 1, TimeUnit.SECONDS);

        interval.subscribe(i -> System.out.println("S1:" + i + " :" + LocalDateTime.now()));

        Thread.sleep(10000);

        interval.subscribe(i -> System.out.println("S2:" + i + " :" + LocalDateTime.now()));

        Thread.sleep(10000);

        System.out.println("Completed");
    }

}
