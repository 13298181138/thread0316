package com.atguigu.test.up;


//@FunctionalInterface
interface MyFoo
{	
	public int print(int x);
	
	default int add(int x,int y)
	{
		return x + y;
	}
	default int div(int x,int y)
	{
		return x/y;
	}
	
	
	public static void print2()
	{
		System.out.println("########hello 0316");
	}

}
/**
 * 1 	(参数) -> {方法体} ,如果只有一个形参，括号+声明类型可以省略，方法体只有一个行也可以省略
 * 2	函数式接口才可以用lambda表达式，里面只有一个public abstract
 * 3	@FunctionalInterface函数式接口的注解
 * 4	default方法的新增，可以有定义+实现
 * 5	static方法的新增，可以静态调用。
 * @author zhouyang
 * @version 创建时间：2017年7月29日  上午9:51:27
 */
public class LambdaDemo {

	public static void main(String[] args)
	{
		MyFoo test = new MyFoo() {
			@Override
			public int print(int x)
			{
				System.out.println("******:"+x);
				return 2 + x;
			}
		};
		test.print(333);
		
		test = (x) -> {
			return 2 + x;
		}; 
	
		System.out.println(	test.print(5));
		
		int result = test.add(1, 3);
		System.out.println("********: "+result);
		
		MyFoo.print2();
	}

}
