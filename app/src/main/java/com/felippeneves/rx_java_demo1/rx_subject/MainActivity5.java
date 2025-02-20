package com.felippeneves.rx_java_demo1.rx_subject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.felippeneves.rx_java_demo1.R;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class MainActivity5 extends AppCompatActivity {

    public static final String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

//        asyncSubjectDemo1();
//        asyncSubjectDemo2();
//        behaviourSubjectDemo1();
//        behaviourSubjectDemo2();
//        publishSubjectDemo1();
//        publishSubjectDemo2();
//        replaySubjectDemo1();
        replaySubjectDemo2();
    }

    private void asyncSubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "JSON");
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        observable.subscribe(asyncSubject);

        asyncSubject.subscribe(getFirstObserver());
        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.subscribe(getThirdObserver());
    }

    private void asyncSubjectDemo2() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();

        asyncSubject.subscribe(getFirstObserver());

        asyncSubject.onNext("Java");
        asyncSubject.onNext("Kotlin");
        asyncSubject.onNext("XML");

        asyncSubject.subscribe(getSecondObserver());

        asyncSubject.onNext("JSON");
        asyncSubject.onComplete();

        asyncSubject.subscribe(getThirdObserver());
    }

    private void behaviourSubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "JSON");
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        observable.subscribe(behaviorSubject);

        behaviorSubject.subscribe(getFirstObserver());
        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.subscribe(getThirdObserver());
    }

    private void behaviourSubjectDemo2() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        behaviorSubject.subscribe(getFirstObserver());

        behaviorSubject.onNext("Java");
        behaviorSubject.onNext("Kotlin");
        behaviorSubject.onNext("XML");

        behaviorSubject.subscribe(getSecondObserver());

        behaviorSubject.onNext("JSON");
        behaviorSubject.onComplete();

        behaviorSubject.subscribe(getThirdObserver());
    }

    private void publishSubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "JSON");
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        PublishSubject<String> publishSubject = PublishSubject.create();
        observable.subscribe(publishSubject);

        publishSubject.subscribe(getFirstObserver());
        publishSubject.subscribe(getSecondObserver());
        publishSubject.subscribe(getThirdObserver());
    }

    private void  publishSubjectDemo2() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(getFirstObserver());

        publishSubject.onNext("Java");
        publishSubject.onNext("Kotlin");
        publishSubject.onNext("XML");

        publishSubject.subscribe(getSecondObserver());

        publishSubject.onNext("JSON");
        publishSubject.onComplete();

        publishSubject.subscribe(getThirdObserver());
    }

    private void replaySubjectDemo1() {
        Observable<String> observable = Observable.just("Java", "Kotlin", "XML", "JSON");
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        ReplaySubject<String> replaySubject = ReplaySubject.create();
        observable.subscribe(replaySubject);

        replaySubject.subscribe(getFirstObserver());
        replaySubject.subscribe(getSecondObserver());
        replaySubject.subscribe(getThirdObserver());
    }

    private void replaySubjectDemo2() {
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        replaySubject.subscribe(getFirstObserver());

        replaySubject.onNext("Java");
        replaySubject.onNext("Kotlin");
        replaySubject.onNext("XML");

        replaySubject.subscribe(getSecondObserver());

        replaySubject.onNext("JSON");
        replaySubject.onComplete();

        replaySubject.subscribe(getThirdObserver());
    }

    private Observer<String> getFirstObserver() {
        Observer<String> observer = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, " First observer onSubscribe ");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, " First observer Received " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, " First observer onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, " First observer onComplete ");
            }
        };

        return observer;
    }

    private Observer<String> getSecondObserver() {
        Observer<String> observer = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, " Second observer onSubscribe ");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, " Second observer Received " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, " Second observer onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, " Second observer onComplete ");
            }
        };

        return observer;
    }

    private Observer<String> getThirdObserver() {
        Observer<String> observer = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i(TAG, " Third observer onSubscribe ");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.i(TAG, " Third observer Received " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, " Third observer onError ");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, " Third observer onComplete ");
            }
        };

        return observer;
    }
}
