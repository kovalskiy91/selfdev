package kovalskiy91.selfdev.rxjava3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public final class Utils {

    private Utils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String[] stringItems(int amount) {
        return IntStream.range(0, 1000)
                .mapToObj(i -> String.format("Item-%d", i))
                .toArray(String[]::new);
    }


    public static class PrintingObserver implements Observer<Object> {
        private static final AtomicInteger idInitNumber = new AtomicInteger();

        private final int id;

        private PrintingObserver() {
            this.id = idInitNumber.incrementAndGet();
        }

        public static PrintingObserver create() {
            return new PrintingObserver();
        }

        @Override
        public void onSubscribe(@NonNull Disposable d) {
            System.out.printf("[Thread: %s] Observer: %d subscribed\n",
                    Thread.currentThread().getName(), id);
        }

        @Override
        public void onNext(@NonNull Object o) {
            System.out.printf("[Thread: %s] Observer %d: next: %s\n",
                    Thread.currentThread().getName(), id, o);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        @Override
        public void onError(@NonNull Throwable e) {
            System.out.printf("[Thread: %s] Observer %d: error: %s\n",
                    Thread.currentThread().getName(), id, e.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.printf("[Thread: %s] Observer %d: completed\n",
                    Thread.currentThread().getName(), id);
        }
    }
}
