package com.example.apollo.test;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

/**
 * 启动测试类需要在jvm参数设定必要的参数
 * -Dapp.id=springboot-apollo -Dapollo.env=DEV -Dapollo.meta=http://localhost:8080
 *
 * @author demoluo
 * Date 2019/11/15
 */
public class ApolloTest {
    public static void main(String[] args) throws InterruptedException {
        Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        String someKey = "timeout";
        String someDefaultValue = "20";
        String value = config.getProperty(someKey, someDefaultValue);
        System.out.println("查询到的值：" + value);


        Config config2 = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        config2.getPropertyNames().forEach(s -> System.out.println("配置" + s));
        config2.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                System.out.println("Changes for namespace " + changeEvent.getNamespace());
                for (String key : changeEvent.changedKeys()) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
                }
            }
        });

        // 阻塞线程，查看监听
        Thread.sleep(200000);
    }
}
