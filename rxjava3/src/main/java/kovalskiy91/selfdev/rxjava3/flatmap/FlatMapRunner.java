package kovalskiy91.selfdev.rxjava3.flatmap;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class FlatMapRunner {

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("[Thread: %d] main\n", Thread.currentThread().getId());
        Disposable disposable = Observable.just(100, 200, 300, 400, 500)
                .flatMap(val -> Observable.just(val)
                        .subscribeOn(Schedulers.computation())
                        .map(FlatMapRunner::increment)
                ) //WTF: there are 5 threads created
                .subscribe(val -> System.out.printf(
                        "[Thread: %d] incremented: %d\n",
                        Thread.currentThread().getId(), val));
        Thread.sleep(10000);
        disposable.dispose();


    }

    private static int increment(Integer val) {
        System.out.printf("[Thread: %d] incrementing %d\n", Thread.currentThread().getId(), val);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return val + 1;
    }

}
