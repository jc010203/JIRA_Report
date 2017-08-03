package com.fmi.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by juan.hernandez on 8/3/17.
 */
public class TestConf {

    private static final Config BASE_CONFIG = ConfigFactory.load();
    private static final ObjectMapper MAPPER = buildObjectMapper();
    private static final TestConf TEST_CONF = buildTestConfSingleton(BASE_CONFIG);

    @Valid
    @Min(1)
    private Integer ajaxWaitSeconds;


    @Valid
    @NotNull
    private String searchUrl;

    @Valid
    @NotNull
    private String userName;

    @Valid
    @NotNull
    private String password;

    @Valid
    @NotNull
    private String email;

    public static TestConf getTestConf(){
        return TEST_CONF;
    }

    public Integer getAjaxWaitSeconds(){
        return ajaxWaitSeconds;
    }

    public String getSearchUrl(){
        return searchUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private static ObjectMapper buildObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    private static TestConf buildTestConfSingleton(Config config){
        // Extract config from config map and put in on a Map
        Map<String, Object> unwrappedConfig = config.root().unwrapped();
        // Map extracted properties to TestConfig class
        TestConf testConf = MAPPER.convertValue(unwrappedConfig, TestConf.class);

        return testConf;
    }
}
