package com.example.android_memo_app

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import io.realm.Realm

class MemoApplication(): Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient("x87ygcqswh")
    }
}