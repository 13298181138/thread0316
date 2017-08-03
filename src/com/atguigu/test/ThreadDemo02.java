package com.atguigu.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class ThreadDemo02 {

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		
		//biz method
		
		
		FutureTask ft = new FutureTask(() -> {
			System.out.println("********come in call2");
			return 400;
		});
		new Thread(ft, "XXX").start();
		
		System.out.println("*******: "+ft.get());//hard task.....
		
		
	}
//	两个 接口，凡是接口一定要有实现类
}
