package com.atguigu.test;

import java.util.concurrent.TimeUnit;

class Phone
{
	public static synchronized void getIOS() throws Exception
	{
//		TimeUnit.SECONDS.sleep(4);
		System.out.println("-----getIOS");
	}
	public synchronized void getAndroid() throws Exception
	{
		System.out.println("-----getAndroid");
	}
	public void getHello() throws Exception
	{
		System.out.println("-----getHello");
	}
}



/**
 * 题目：8锁
 * 1	标准访问，先打印苹果还是Android            I
 * 2	新增休息4秒钟，先打印苹果还是Android        I
 * 3	新增hello方法，先打印苹果还是hello			H
 * 4	有两部手机，先打印苹果还是Android			A
 * 5	静态同步方法，有一部手机，先打印苹果还是Android	I
 * 6	静态同步方法，有2部手机，先打印苹果还是Android	I
 * 7	一个普通同步方法，一个静态同步方法，有1部手机，先打印苹果还是Android	A
 * 8	一个普通同步方法，一个静态同步方法，有2部手机，先打印苹果还是Android	A
 * @author zhouyang
 * @version 创建时间：2017年7月29日  下午2:36:50
 * 
 * 一个对象里面如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中的一个synchronized方法了，
 * 其它的线程都只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法

	锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它的synchronized方法

 * 
 * 
 */
public class ThreadDemo04 {

	public static void main(String[] args)
	{
		Phone sr = new Phone();
		Phone sr2 = new Phone();
		new Thread(() ->
		{
			try 
			{
				sr.getAndroid();
				//sr.getHello();
//				sr2.getAndroid();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}, "B").start();
		new Thread(() ->
		{
			try 
			{
				sr.getIOS();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}, "A").start();
		
				
		
		
	}

}
