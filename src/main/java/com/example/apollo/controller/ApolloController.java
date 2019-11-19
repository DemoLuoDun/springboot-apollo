package com.example.apollo.controller;

import com.example.apollo.bean.ApolloBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/getApolloBean")
    public String getApolloBean() {
        return apolloBean.toString();
    }
}
