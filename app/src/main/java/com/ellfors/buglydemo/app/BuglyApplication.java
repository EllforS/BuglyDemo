package com.ellfors.buglydemo.app;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * 替换自己的Application  使用这个
 * 2018/9/26 14:40
 */
public class BuglyApplication extends TinkerApplication
{
    public BuglyApplication()
    {
        super(ShareConstants.TINKER_ENABLE_ALL,
                "com.ellfors.buglydemo.app.MyAppLike",      //只修改这个就行，替换成自己的ApplicationLike
                "com.tencent.tinker.loader.TinkerLoader",
                false);
    }
}