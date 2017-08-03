package com.atguigu.test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyQueue
{
	private Object obj;
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	
	public void read()
	{
		rwLock.readLock().lock();
		try
		{
			System.out.println(Thread.currentThread().getName()+"\t"+this.obj);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwLock.readLock().unlock();
		}
	}
	
	public void write(Object obj)
	{
		rwLock.writeLock().lock();
		try 
		{
			this.obj = obj;
			System.out.println(Thread.currentThread().getName()+"\t"+obj);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwLock.writeLock().unlock();
		}
	}	
	
}

/**
 * 题目：一个线程在写，100个线程在读
 * @author zhouyang
 * @version 创建时间：2017年7月29日  下午4:14:35
 */
public class ThreadDemo06 
{
	public static void main(String[] args)
	{
		/*MyQueue q = new MyQueue();
		
		new Thread(() ->
		{
			q.write(316);
		}, "writeThread").start();
		
		
		for (int i = 1; i <=100; i++) 
		{
			new Thread(() ->
			{
				q.read();
			},String.valueOf(i)).start();
		}*/
		
		//jdk1.7
		String s2 = "abc";
		String s1 = new String("abc");
		String s3 = new String("abc");
		
		
		
		System.out.println(new Random().nextInt(90));
		
		
	}
}
