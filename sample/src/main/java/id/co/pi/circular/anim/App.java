package id.co.pi.circular.anim;

import android.app.Application;

import id.co.pi.circular.cA;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        cA.init(550, 350, R.color.colorPrimary);
    }
}
