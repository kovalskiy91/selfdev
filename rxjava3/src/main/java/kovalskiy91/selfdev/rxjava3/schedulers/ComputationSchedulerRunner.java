package kovalskiy91.selfdev.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kovalskiy91.selfdev.rxjava3.Utils.PrintingObserver;

import java.util.stream.Stream;

import static kovalskiy91.selfdev.rxjava3.Utils.stringItems;

public class ComputationSchedulerRunner {

    public static void main(String[] args) throws InterruptedException {

        Observable<Object> observable = Observable.create(
                source -> Stream.of(stringItems(100)).forEach(source::onNext)
        ).subscribeOn(Schedulers.computation());

        observable.subscribe(PrintingObserver.create());
        observable.subscribe(PrintingObserver.create());

        Thread.sleep(100000);
    }

}
