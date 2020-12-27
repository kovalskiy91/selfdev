package kovalskiy91.selfdev.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.stream.Stream;

import static kovalskiy91.selfdev.rxjava3.Utils.stringItems;

public class SingleSchedulerRunner {

    public static void main(String[] args) throws InterruptedException {
        String pattern = "Thread: %s value: %s\n";

        Disposable subscription = Observable.create(source -> {
            Stream.of(stringItems(100)).forEach(source::onNext);
        })
                .subscribeOn(Schedulers.single())
                .subscribe(
                        s -> {
                            System.out.printf(pattern, Thread.currentThread().getName(), s);
                            Thread.sleep(100);
                        },
                        Throwable::printStackTrace
                );

        Thread.sleep(100000);

        subscription.dispose();
    }

}
