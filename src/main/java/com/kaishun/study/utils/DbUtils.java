package com.kaishun.study.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Package: com.kaishun.study.utils
 * @ClassName: DbUtils
 * @Author: zhoukaishun
 * @CreateTime: 2021/9/24 15:55
 * @Description:
 */
@Component
@EnableScheduling
@Slf4j
public class DbUtils {

    @Value("${spring.profiles.active}")
    public String active;

    @Value("${spring.datasource.druid.username}")
    private String userName;

    @Value("${spring.datasource.druid.password}")
    private String userPassword;

    private static String dev_sql_Path = "C:\\Users\\admin\\Desktop\\zhoukaishun\\kaishun.sql";

    private static String prod_sql_path = "/usr/javaproject/study/sql/kaishun.sql";

    @Scheduled(cron = "0 0 0 * * ? ")
    public void handleSql() {
        try {
            Connection conn = getMySqlConnection();
            ScriptRunner runner = new ScriptRunner(conn);
            //设置字符集,不然中文乱码插入错误
            Resources.setCharset(Charset.forName("UTF-8"));
            //设置是否输出日志
            runner.setLogWriter(null);
            String path = "prod".equals(active) ? prod_sql_path : dev_sql_Path;
            // 绝对路径读取
            Reader read = new FileReader(path);
            // 从class目录下直接读取
            //Reader read = Resources.getResourceAsReader("kaishun.sql");
            runner.runScript(read);
            runner.closeConnection();
            conn.close();
            log.info("sql重置完毕,重置时间：{}", DateUtils.getTime());
        } catch (Exception e) {
            System.out.println("sql重置异常");
            e.printStackTrace();
        }

    }

    public Connection getMySqlConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/kaishun?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
        return DriverManager.getConnection(url, userName, userPassword);
    }


}
