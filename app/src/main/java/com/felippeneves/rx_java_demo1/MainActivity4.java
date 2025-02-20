package com.felippeneves.rx_java_demo1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity4 extends AppCompatActivity {

    public static final String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Observable<Integer> myObservable = Observable.range(1, 20);

        Observable<Integer> numbersObservable = Observable.just(1, 2, 3, 7, 5, 3, 5, 5, 4, 4);

        myObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // Buffer operator
//                .buffer(4)
//                .subscribe(new Observer<>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull List<Integer> integers) {
//                        Log.i(TAG, " Came to onNext ");
//
//                        for (Integer i: integers) {
//                            Log.i(TAG, " int value is " + i);
//                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.i(TAG, " Came to onComplete ");
//                    }
//                });

                // Filter operator
                .filter(integer -> integer % 3 == 0)
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i(TAG, " onNext invoked: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, " onComplete invoked ");
                    }
                });

        numbersObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                // Distinct operator
//                .distinct()

                // Skip operator
//                .skip(6)

                .skipLast(6)
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i(TAG, " came to onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, " came to onComplete");
                    }
                });
    }
}
