package ��̬����ʵ��ԭ��;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	private Object target ; 
	
	 public DynamicProxy(Object source) {
		this.target = source;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
	print("��������ñ���������󷽷�ǰ");
	Object result = method.invoke(target, args);
	print("��������ñ���������󷽷���");
		return result;
	}

	private void print(String s){
		System.out.println(s);
	}

	

}
