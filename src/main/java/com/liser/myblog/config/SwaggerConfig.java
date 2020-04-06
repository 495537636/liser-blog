package com.liser.myblog.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Description Swagger在线文档配置类 </p>
 * <p>Company: http://www.uinnova.cn/ </p>
 * @author LiMG
 * @Date 2018/3/28 18:11
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = "system.debug", matchIfMissing = false, havingValue = "true")
public class SwaggerConfig {

    /**
     * Swagger配置
     * apiInfo - 自定义Swagger基础信息头
     * select - 选择哪些路径和API是需要生成document
     * apis API接口包扫描路径
     *   - 参数 : RequestHandlerSelectors.any() api接口包扫描路径，对所有api进行监控
     *   - 参数 : RequestHandlerSelectors.basePackage(...) 过滤其他包，仅对选中包进行监控
     *   - 参数 : RequestHandlerSelectors.withClassAnnotation(...) 通过类注解形式进行过滤监控
     *   - 参数 : RequestHandlerSelectors.withMethodAnnotation(...) 通过类注解形式进行过滤监控
     * paths 可以根据接口url路径设置哪些请求加入文档，忽略哪些请求
     *   - 参数 : PathSelectors.any() 对所有接口路径进行监控
     *   - 参数 : PathSelectors.regex("/com.*") 对接口路径进行过滤监控
     */
    @Bean
    public Docket mainApiDoc() {
        return mainDocket();
    }

    private Docket mainDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build().ignoredParameterTypes(Errors.class).apiInfo(mainApiInfo());
    }

    private ApiInfo mainApiInfo() {
        return new ApiInfoBuilder()
                .title("Liser博客接口文档")
                .description("Liser博客接口文档API")
                .version("1.0")
                .build();
    }

}
