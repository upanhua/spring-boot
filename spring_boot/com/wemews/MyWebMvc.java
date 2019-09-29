package spring_boot.com.wemews;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import spring_boot.com.wemews.config.MyConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * tomcat启动的时候会加载
 * @author lh
 * @version 1.0
 * @date 2019-09-27 16:40
 */
public class MyWebMvc implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /**
         * 这里的代码相当于
         * <servlet>
         *     <servlet-class>xxx</servlet-class>
         * </servlet>
         * 或者servlet3.0之后使用@webServlet注解
         */
        // 进行初始化
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(MyConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic dispatcherServlet1 = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dispatcherServlet1.setLoadOnStartup(1);
        dispatcherServlet1.addMapping("/*");
    }
}
