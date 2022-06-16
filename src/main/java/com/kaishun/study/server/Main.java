package com.kaishun.study.server;

/**
 * @ClassName: Main
 * @Package: com.kaishun.study.server
 * @Description:
 * @Datetime: 2020/11/20   15:02
 * @author: kaishun.zhou
 */
public class Main {
    public static void main(String[] args)throws Exception {
        Server server = new Server();
        server.copyTo();
        System.out.println(server.toString());
    }
}
