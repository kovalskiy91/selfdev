package kovalskiy91.selfdev.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kovalskiy91.selfdev.rxjava3.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static kovalskiy91.selfdev.rxjava3.Utils.stringItems;

public class CustomExecutorSchedulerRunner {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService customExecutor = Executors.newFixedThreadPool(2);

        Observable<Object> observable = Observable.create(
                source -> Stream.of(stringItems(100)).forEach(source::onNext)
        )
                .subscribeOn(Schedulers.from(customExecutor))
                .doFinally(customExecutor::shutdown);

        observable.subscribe(Utils.PrintingObserver.create());
        observable.subscribe(Utils.PrintingObserver.create());
    }

}
