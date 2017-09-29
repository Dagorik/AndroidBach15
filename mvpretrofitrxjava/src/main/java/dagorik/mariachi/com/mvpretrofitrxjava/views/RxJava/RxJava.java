package dagorik.mariachi.com.mvpretrofitrxjava.views.RxJava;

import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * Created by Dagorik on 11/08/17.
 */

public class RxJava {

    public static void main(String[] args) {


        Integer[] numbers = {1, 3, 56, 7, 8, 4, 8, 6, 5, 8, 9};


        Observable.fromArray(numbers)
                .filter(number -> (number % 2) == 0)
                .subscribe(System.out::println);


        //loadNumber().map(numero -> numero + " ").subscribe(System.out::print);


    }


    private static Observable<Integer> loadNumber() {


        return Observable.create(suscriber -> {
            for (int i = 0; i < 10; i++) {
                suscriber.onNext(i);
            }
            suscriber.onComplete();
        });
    }


}
