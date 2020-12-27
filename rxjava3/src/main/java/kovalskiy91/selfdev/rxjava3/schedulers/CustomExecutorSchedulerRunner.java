package kovalskiy91.selfdev.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static kovalskiy91.selfdev.rxjava3.Utils.stringItems;

public class CustomExecutorSchedulerRunner {

    public static void main(String[] args) throws InterruptedException {
        String pattern = "Thread: %s value: %s\n";

        ExecutorService customExecutor = Executors.newFixedThreadPool(2);

        Disposable subscription = Observable.create(source -> {
            Stream.of(stringItems(100)).forEach(source::onNext);
        })
                .subscribeOn(Schedulers.from(customExecutor))
                .doFinally(customExecutor::shutdown)
                .subscribe(
                        s -> {
                            System.out.printf(pattern, Thread.currentThread().getName(), s);
                            Thread.sleep(100);
                        },
                        Throwable::printStackTrace
                );
    }

}
