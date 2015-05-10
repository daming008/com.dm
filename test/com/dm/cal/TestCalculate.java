package com.dm.cal;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestCalculate {
	Calculate cal = null;
	
	@Before
	public void setUp(){
		cal = new Calculate();
	}
	@Test
	public void testAdd(){
		int rel = cal.add(10, 10);
		assertEquals("加法有问题", rel, 20);
	}
	
	@Test
	public void testMinus(){
		int rel = cal.minus(20, 10);
		assertEquals("减法有问题", rel, 10);
	}
	
	@Test
	public void testDevide(){
		int rel = cal.divide(20, 10);
		assertEquals("除法有问题", rel, 2);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDevideException(){
		int rel = cal.divide(10, 0);
	}
	
	@Test
	public void testHamcrest(){
		assertThat(50, greaterThan(20));
		assertThat("abc.txt", endsWith("txt"));
	}
}
