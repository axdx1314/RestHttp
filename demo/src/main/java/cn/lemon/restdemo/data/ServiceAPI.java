package cn.lemon.restdemo.data;


import cn.lemon.restdemo.data.bean.UserInfo;
import cn.lemon.resthttp.request.callback.RestCallback;
import cn.lemon.resthttp.request.rest.method.GET;
import cn.lemon.resthttp.request.rest.method.POST;
import cn.lemon.resthttp.request.rest.param.Field;
import cn.lemon.resthttp.request.rest.param.Query;

/**
 * Created by linlongxin on 2016/3/23.
 */
public interface ServiceAPI {

    /**
     * 同步请求方式：不能包含Callback参数
     * @param name
     * @param password
     * @return 返回一个经过Gson解析后的对象
     */

    @POST("/v1/users/login.php")
    UserInfo loginPostSync(@Field("name")
                   String name,
                           @Field("password")
                   String password);

    /**
     * 异步请求：必须有一个Callback参数作为回调
     * @param name
     * @param password
     * @param restCallback  回调泛型类
     */

    @POST("/v1/users/login.php")
    void loginAsyn(@Field("name")
                String name,
                   @Field("password")
                String password, RestCallback<UserInfo> restCallback);

    @GET("/v1/users/login_get.php")
    UserInfo loginGetSync(@Query("name")
                          String name,
                          @Query("password")
                          String password);

    @GET("/v1/users/login_get.php")
    void loginGetAsyn(@Query("name")
                          String name,
                          @Query("password")
                          String password,RestCallback<UserInfo> restCallback);


    @GET("/213-4")
    void getMusicData(@Query("topid") int topId,
                      @Query("showapi_appid") String showapiAppId,
                      @Query("showapi_sign") String secretKey,
                      RestCallback<String> callback);
}
