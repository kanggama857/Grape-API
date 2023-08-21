package com.grapeapi.apiclientsdk;

import com.grapeapi.apiclientsdk.client.OpenApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * openapi 客户端配置
 *
 * @author grape
 */
@Configuration
@ConfigurationProperties("grapeapi.client")
@Data
@ComponentScan
public class OpenApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public OpenApiClient openapiClient() {
        return new OpenApiClient(accessKey, secretKey);
    }

}
