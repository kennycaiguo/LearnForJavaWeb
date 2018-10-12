package cn.zzc.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	@Test
	public void test() {
		System.out.println("Hello Junit!");
	}
	
	@Before
	public void before() {
		System.out.println("Before!");
	}
	
	@After
	public void after() {
		System.out.println("After!");
	}
}
