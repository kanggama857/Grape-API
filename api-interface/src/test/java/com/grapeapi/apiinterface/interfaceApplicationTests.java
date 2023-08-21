package com.grapeapi.apiinterface;

import com.grapeapi.apiclientsdk.client.OpenApiClient;
import com.grapeapi.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 测试类
 *
 * @author grape
 */
@SpringBootTest
class interfaceApplicationTests {

    @Resource
    private OpenApiClient openApiClient;

    @Test
    void contextLoads() {
        //String result = openApiClient.getNameByGet("grapeapi");
        User user = new User();
        user.setUsername(" https://space.bilibili.com/12890453/");
        String usernameByPost = openApiClient.getName(user);
        //System.out.println(result);
        System.out.println(usernameByPost);
    }

}
