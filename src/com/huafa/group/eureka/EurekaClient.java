package com.huafa.group.eureka;

import java.util.Properties;

public class EurekaClient {

    private EurekaClient() {
    }

    public static class EurekaClientFactory {
        private static final EurekaClient client = new EurekaClient();

        public static EurekaClient getInstance() {
            return client;
        }
    }

    public void registerEureka(Properties properties) {
        new Thread(new RegisterThread(properties)).start();
    }

    public void downEureka(Properties properties) {

    }

    private static class RegisterThread implements Runnable {
        private Properties properties;

        public RegisterThread(Properties properties) {
            this.properties = properties;
        }

        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("registering....");

            } while (true);
        }
    }

}
