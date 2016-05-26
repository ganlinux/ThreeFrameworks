package com.example.ganmt.threeframeworks.net;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * @author ganmt
 *
 */
public class ServiceGenerator {
    public static final String API_BASE_URL = "https://d.apicloud.com";
    public static final String API_Cloud_AppKey = generateAPICloudAppKey();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
//"X-APICloud-AppId": "A6919603831577",
                    //"X-APICloud-AppKey": "your appkey"
                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", authToken)
                            .header("X-APICloud-AppId", "A6919603831577")
                            .header("X-APICloud-AppKey", API_Cloud_AppKey)
                            .header("Content-Type","application/x-www-form-urlencoded")
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }
    public static String generateAPICloudAppKey(){
        String appKey = null;
        Date dt= new Date();
        Long time= dt.getTime();
        //SHA1（你的应用ID + 'UZ' + 你的应用KEY +'UZ' + 当前时间毫秒数）.当前时间毫秒数
        appKey = SHA.SHA1("A6919603831577" + "UZ" + "93214B42-D652-A8D3-FF03-7FA2D4D8AB0D"+"UZ" +time)+"."+time;

        return appKey;
    }
}
