package kovalskiy91.selfdev.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class ObserveOnRunner {

    public static void main(String[] args) throws InterruptedException {
        Observable.just(
                "WHISKEY/27653/TANGO",
                "6555/BRAVO",
                "235789/979524/FOXTROT"
        )
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .doOnNext(s -> System.out.printf("[%s] Split out: %s\n", Thread.currentThread().getName(), s))
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .doOnSuccess(sum -> System.out.printf("[%s] Sum: %s\n", Thread.currentThread().getName(), sum))
                .observeOn(Schedulers.io())
                .map(String::valueOf)
                .doOnSuccess(sum -> System.out.printf("[%s] Writing to file sum: %s\n", Thread.currentThread().getName(), sum))
                .subscribe(sum -> {
                    System.out.println("Written: " + sum);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
        Thread.sleep(100000);
    }

}