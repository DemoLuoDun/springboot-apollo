package com.example.apollo.controller;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.example.apollo.bean.ApolloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author demoluo
 * Date 2019/11/15
 */
@RestController
@RequestMapping("/apollo")
public class ApolloController {

    @Autowired
    private ApolloBean apolloBean;

    @Value("${timeout:100}")
    private String timeout;

   /* @Autowired
    private ApolloConfig apolloConfig;*/

    @ApolloConfig("application")
    private Config config;

    /**
     * 测试xmlBean
     *
     * @return
     */
    @RequestMapping("/getApolloBean")
    public String getApolloBean() {
        return apolloBean.toString();
    }

    /**
     * 测试spring-apollo
     */
    @RequestMapping("/getTimeout")
    public String getTimeout() {
        return this.timeout;
    }

 /*   @RequestMapping("/getApolloConfig")
    public String getApolloConfig() {
        return this.apolloConfig.toString();
    }*/

    @RequestMapping("/getConfig")
    public String getConfig() {
        return JSON.toJSONString(this.config);
    }
}
