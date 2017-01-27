package org.zf.util.testspring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import org.zf.util.testspring.Car;

public class BeanFactoryTest {
	public static void main(String[] args) throws Throwable{
// 1.BeanFactory
	   /*ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	   Resource res = resolver.getResource("classpath:org/zf/resources/beans.xml");
	   System.out.println(res.getURL());
       BeanFactory bf = new XmlBeanFactory(res);
       System.out.println("init BeanFactory.");
       Car car = bf.getBean("car",Car.class);*/
		
// 2.ApplicationContext
	   ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:org/zf/resources/beans.xml");
	   
	   Car car = ctx.getBean("car",Car.class);
       System.out.println("car bean is ready for use!");
       car.introduce();
	}
}
