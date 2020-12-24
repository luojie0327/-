package ��̬����ʵ��ԭ��;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client {

	public static void main(String[] args) throws Exception {
	 //���ô�����ı��ش��·��
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
	//��ô������class����
		Class proxyClass = Proxy.getProxyClass(Client.class.getClassLoader(), Subject.class);
		System.out.println(proxyClass.toString());
	//��ȡ������Ĺ�����
		Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
	//���ݹ������������������
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
