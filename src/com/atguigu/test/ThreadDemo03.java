package com.atguigu.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData
{
	private int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition cod = lock.newCondition();
	
	public void increment() throws InterruptedException
	{
		lock.lock();
		try 
		{
			while(number != 0)
			{
				cod.await();//this.wait();//A...B...
			}
			++number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			cod.signalAll();//this.notifyAll();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void decrement() throws InterruptedException
	{
		lock.lock();
		try 
		{
			while(number == 0)
			{
				cod.await();//this.wait();//A...B...
			}
			--number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			cod.signalAll();//this.notifyAll();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}	
	
	
	/*public synchronized void increment() throws InterruptedException
	{
		while(number != 0)
		{
			this.wait();//A...B...
		}
		++number;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		this.notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException
	{
		while(number == 0)
		{
			this.wait();
		}
		--number;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		this.notifyAll();		
	}*/
}

/**
 * 题目：两个线程，轮替操作，实现一个线程对初始值为零的一个变量，实现一个线程加一，另外一个线程减一，来10轮
 * @author zhouyang
 * @version 创建时间：2017年7月29日  上午11:30:43
 */
public class ThreadDemo03 {

	public static void main(String[] args)
	{
		final ShareData sd = new ShareData();
		
	
		new Thread(() ->
		{
			for (int i = 1; i <=10; i++) 
			{
				try 
				{
					Thread.sleep(200);
					sd.increment();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "AA").start();
		
		new Thread(() ->
		{
			for (int i = 1; i <=10; i++) 
			{
				try {
					Thread.sleep(300);
					sd.decrement();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "BB").start();		
		
		new Thread(() ->
		{
			for (int i = 1; i <=10; i++) 
			{
				try {
					Thread.sleep(400);
					sd.increment();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "CC").start();	
		new Thread(() ->
		{
			for (int i = 1; i <=10; i++) 
			{
				try {
					Thread.sleep(500);
					sd.decrement();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "DD").start();			
		
		
	}

}
