package com.luthfihariz.homemade;

import android.app.Application;

import com.luthfihariz.homemade.di.AppModule;
import com.luthfihariz.homemade.di.AppComponent;
import com.luthfihariz.homemade.di.DaggerAppComponent;

/**
 * Created by luthfihariz on 02/02/18.
 */

public class HomemadeApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
