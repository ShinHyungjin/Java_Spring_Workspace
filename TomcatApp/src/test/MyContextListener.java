package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("앱 가동됨");
		
		ServletContext context = sc.getServletContext();
		context.setAttribute("msg", "난 오래살아");
		
		String contextConfigLocation = context.getInitParameter("contextConfigLocation");
		System.out.println("앱 가동시 적재될 빈들은 " + contextConfigLocation);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("앱 종료됨");
	}

}
