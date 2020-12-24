package 动态代理实现原理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	private Object target ; 
	
	 public DynamicProxy(Object source) {
		this.target = source;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
	print("代理类调用被代理类对象方法前");
	Object result = method.invoke(target, args);
	print("代理类调用被代理类对象方法后");
		return result;
	}

	private void print(String s){
		System.out.println(s);
	}

	

}
