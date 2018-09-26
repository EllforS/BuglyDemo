package com.ellfors.buglydemo.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.widget.Toast;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * MyAppLike
 * 2018/9/26 14:49
 */
public class MyAppLike extends DefaultApplicationLike
{
    public MyAppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent)
    {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        //初始化Bugly
        Bugly.init(getApplication(), "f329cfb8a9", false);
        // 设置是否为开发设备
        Bugly.setIsDevelopmentDevice(getApplication(), false);
    }

    @Override
    public void onBaseContextAttached(Context base)
    {
        super.onBaseContextAttached(base);
        //分包
        MultiDex.install(base);

        initBugly();
    }

    private void initBugly()
    {
        // 安装tinker
        Beta.installTinker(this);
        // 设置是否开启热更新能力，默认为true
        Beta.enableHotfix = true;
        // 设置是否自动下载补丁
        Beta.canAutoDownloadPatch = true;
        // 设置是否提示用户重启
        Beta.canNotifyUserRestart = false;
        // 设置是否自动合成补丁
        Beta.canAutoPatch = true;
        // 补丁回调接口
        Beta.betaPatchListener = new BetaPatchListener()
        {
            @Override
            public void onPatchReceived(String url)
            {
                //获取补丁下载地址  url
            }

            @Override
            public void onDownloadReceived(long savedLength, long totalLength)
            {
                //下载中
                Toast.makeText(getApplication(), "下载中", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadSuccess(String s)
            {
                //下载成功
                Toast.makeText(getApplication(), "下载成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadFailure(String s)
            {
                //下载失败
                Toast.makeText(getApplication(), "下载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApplySuccess(String s)
            {
                //应用成功
                Toast.makeText(getApplication(), "应用成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onApplyFailure(String s)
            {
                //应用失败
                Toast.makeText(getApplication(), "应用失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPatchRollback()
            {

            }
        };
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks)
    {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }
}
