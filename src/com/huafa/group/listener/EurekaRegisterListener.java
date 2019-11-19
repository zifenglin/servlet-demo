package com.huafa.group.listener;

import com.huafa.group.eureka.EurekaClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.util.Properties;

public class EurekaRegisterListener implements ServletContextListener {

    private EurekaClient client = EurekaClient.EurekaClientFactory.getInstance();
    private Properties properties = new Properties();

    public void contextInitialized(ServletContextEvent contextEvent) {
        String basePath = contextEvent.getServletContext().getRealPath("WEB-INF");
        String filePath = basePath + File.separator + "eurekaConfig.properties";
        try (InputStream in = new FileInputStream(new File(filePath));
             Reader reader = new InputStreamReader(in, "UTF-8")) {
            properties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载eureka配置文件失败....");
        }
        System.out.println("eureka registering.....");
        client.registerEureka(properties);
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("eureka downing.....");
        client.downEureka(properties);
    }

}
