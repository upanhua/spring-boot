package spring_boot.com.wemews;

import spring_boot.com.wemews.dao.UserDao;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * tomcat启动的时候会执行的方法(在mate-inf进行了配置的)
 * @author lh
 * @version 1.0
 * @date 2019-09-27 17:26
 */
@HandlesTypes(UserDao.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("--------MyServletContainerInitializer------");
        for (Class<?> aClass : set) {
            System.out.println(aClass.getName());
        }
    }
}
