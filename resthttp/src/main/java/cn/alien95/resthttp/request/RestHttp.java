package cn.alien95.resthttp.request;

import android.content.Context;

import java.util.Map;

import cn.alien95.resthttp.image.cache.DiskCache;
import cn.alien95.resthttp.request.callback.HttpCallback;
import cn.alien95.resthttp.util.DebugUtils;
import cn.alien95.resthttp.util.Util;


/**
 * Created by linlongxin on 2015/12/26.
 */
public abstract class RestHttp {

    /**
     * 初始化Http框架
     *
     * @param context
     */
    public static void initialize(Context context) {
        Util.init(context);
        ServerCache.checkCacheRoot();
    }

    public static void setDiskCacheSize(long maxStoreSize) {
        DiskCache.setMaxStoreSize(maxStoreSize);
    }

    /**
     * GET请求
     *
     * @param url
     * @param callBack
     */
    public abstract void get(String url, HttpCallback callBack);

    /**
     * POST请求
     *
     * @param url
     * @param params
     * @param callBack
     */
    public abstract void post(String url, Map<String, String> params, HttpCallback callBack);

    /**
     * 设置开启调试模式，默认是关闭
     *
     * @param isDebug
     * @param tag
     */
    public static void setDebug(boolean isDebug, String tag) {
        DebugUtils.setDebug(isDebug, tag);
    }


}