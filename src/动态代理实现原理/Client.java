package 动态代理实现原理;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client {

	public static void main(String[] args) throws Exception {
	 //设置代理类的本地存放路劲
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
	//获得代理类的class对象
		Class proxyClass = Proxy.getProxyClass(Client.class.getClassLoader(), Subject.class);
		System.out.println(proxyClass.toString());
	//获取代理类的构造器
		Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
	//根据构造器创建代理类对象
		RealSubject realSubject = new RealSubject();
		InvocationHandler invocationHandler = new DynamicProxy(realSubject);
		Subject proxySubject =(Subject) constructor.newInstance(invocationHandler);
		//proxySubject.sayHello("Hello world !");
		
		
		Subject proxSubject2 = (Subject)Proxy.newProxyInstance(Client.class.getClassLoader(),
																new Class[]{Subject.class} , 
																new DynamicProxy(realSubject));
		proxSubject2.sayHello("Hello world !");
	
	}

}
