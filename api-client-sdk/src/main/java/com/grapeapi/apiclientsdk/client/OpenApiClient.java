package com.grapeapi.apiclientsdk.client;

import com.grapeapi.apiclientsdk.model.User;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;


import java.util.HashMap;
import java.util.Map;

import static com.grapeapi.apiclientsdk.utils.SignUtils.genSign;
/**
 * 调用第三方接口的客户端
 *
 * @author
 */
public class OpenApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public OpenApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

//    public String getNameByGet(String name) {
//        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//    }

//    public String getNameByPost(String name) {
//        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", name);
//        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
//        System.out.println(result);
//        return result;
//    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//      hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

//    public String getUsernameByPost(User user) {
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        System.out.println(httpResponse.getStatus());
//        String result = httpResponse.body();
//        System.out.println(result);
//        return result;
//    }
    /**
     * 获取用户名
     * @param user
     * @return
     */
    public String getName(User user){
        String json = JSONUtil.toJsonStr(user);
        return HttpRequest.post(GATEWAY_HOST+"/api/interface/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute().body();
    }
    /**
     * 获取每日壁纸
     * @return
     */
    public String getDayWallpaperUrl(){
        return HttpRequest.post(GATEWAY_HOST+"/api/interface/day/wallpaper")
                .addHeaders(getHeaderMap("getDayWallpaperUrl"))
                .execute().body();
    }
    /**
     * 获取随机文本
     * @return
     */
    public String getRandomWork(){
        return HttpRequest.get(GATEWAY_HOST+"/api/interface/random/word")
                .addHeaders(getHeaderMap("getRandomWork"))
                .execute().body();
    }

    /**
     * 获取随机动漫图片
     * @return
     */
    public String getRandomImageUrl(){
        return HttpRequest.post(GATEWAY_HOST+"/api/interface/random/image")
                .addHeaders(getHeaderMap("getRandomWork"))
                .execute().body();
    }
}
