package com.atguigu.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket  // 实例变量+实例方法
{
	private int number = 30;
	private Lock lock = new ReentrantLock();//List list = new ArrayList();
	
	
	public void sale()
	{
		lock.lock();
		try 
		{
			if(number > 0)
			{
				System.out.println(Thread.currentThread().getName()+"卖出第：\t"+(number--)+"\t还剩下："+number);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

/**
 * 题目：三个售票员卖30张票
 * @author zhouyang
 * @version 创建时间：2017年7月28日  下午4:38:49
 * 
 * 1	线程	操作	资源类
 * 
 * 2	高内聚+低耦合
 * 
 */
public class ThreadDemo01
{
	public static void main(String[] args)
	{
		Ticket ticket = new Ticket();
		
		//Thread(Runnable target, String name) 	Allocates a new Thread object.
		
		//lambda
		new Thread(() -> {
			for (int i = 1; i <=40; i++) 
			{
				ticket.sale();
			}
		},"AA").start();
		
		new Thread(() -> {for (int i = 1; i <=40; i++) {ticket.sale();}},"BB").start();
		new Thread(() -> {for (int i = 1; i <=40; i++) {ticket.sale();}},"CC").start();
		
		
		/*new Thread(new Runnable() {
			@Override
			public void run()
			{
				
			}
		}, "AA").start();
		
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				
				for (int i = 1; i <=40; i++) 
				{
					ticket.sale();
				}
			}
		}, "BB").start();		
		
		new Thread(new Runnable() {
			@Override
			public void run()
			{
				
				for (int i = 1; i <=40; i++) 
				{
					ticket.sale();
				}
			}
		}, "CC").start();*/		
		
		
	}
}