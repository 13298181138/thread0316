package com.atguigu.test.up;

public class TestString {
	public static void main(String[] args) {
		String p1=new String("abc");
		String p2="abc";
		String p3=new String("abc");
		System.out.println(p1==p2);
		System.out.println(p1==p3);
		System.out.println(p2==p3);
	}
}
