package com.zhicall.hax.net;

import com.zhicall.hax.MyApplication;
import com.zhicall.hax.R;
import com.zhicall.hax.utils.ToastManager;
import java.util.Map;
import java.util.WeakHashMap;
import retrofit.RestAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Xingchen on 2016/1/11.
 * Email:huangjinxin@zhicall.cn
 * 获取json数据获取的方法类
 */
public final class Data {
  private static RestAdapter mInfoRestAdapter =                               //获取药品信息
      new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
          .setEndpoint(MyApplication.getContext().getResources().getString(R.string.medical_url))
          .build();
  private static Map services = new WeakHashMap<String, BaseService>();

  public static <T> Func1<Observable<T>, Observable<T>> flatmaper(Observable<T> mObservabler) {
    return new Func1<Observable<T>, Observable<T>>() {
      @Override public Observable<T> call(Observable<T> observable) {
        return observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
      }
    };
  }

  public static <T> T service(Class<T> clazz) {
    T service = (T) services.get(clazz.getName());
    if (service == null) {
      service = (T) mInfoRestAdapter.create(IMedicalService.class);
      services.put(clazz, clazz.getName());
      return service;
    }
    return service;
  }

  public static Action1<Throwable> errorHanlder() {
    return e -> ToastManager.showToast(e.getMessage());
  }
}