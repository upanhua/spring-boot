package spring_boot.com.wemews;

import org.apache.catalina.startup.Tomcat;

/**
 * @author lh
 * @version 1.0
 * @date 2019-09-27 18:18
 */
public class SpringApplication {

    static void run() throws Exception{
        // 实例化tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8989);
        // 是不是webapp需要由tomcat容器进行决定
        tomcat.addWebapp("/","d:\\");
        tomcat.start();
    }
}
