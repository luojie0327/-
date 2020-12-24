package 动态代理实现原理;

public class RealSubject implements Subject{
		@Override
		public void sayHello(String s) {
			System.out.println(s);
			
		}
	
	
}
