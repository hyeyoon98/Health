package com.example.health;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.Utility;

public class GlobalApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //SDK 초기화
        KakaoSdk.init(this, "{NATIVE_APP_KEY}");
    }
}
