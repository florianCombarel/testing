package main.fr.ut2j.m1ice.ootesting;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestMyPoint {
	
	private MyPoint point;
	private MyPoint point2;
	private MyPoint point3;
	private MyPoint point4;
	
	@Before
	public void setUp() {
		point = new MyPoint();
		point2 = new MyPoint(1.23,5.689);
		point3 = new MyPoint(point2);
		point4 = new MyPoint(null);
	}
	
	@Test
	public void testAccesorX() {
		assertEquals(0,point.getX(),0.001);
		point.setX(7.56);
		assertEquals(7.56,point.getX(),0.001);
	}
	
	@Test
	public void testAccesorY() {
		assertEquals(0,point.getY(),0.001);
		point.setY(9.12);
		assertEquals(9.12,point.getY(),0.001);
	}
	
	@Test
	public void testSetXNaN() {
		Double valAvantSet = point.getX();
		point.setX(Double.NaN);
		assertEquals(valAvantSet,point.getX(),0.001);
	}
	
	@Test
	public void testSetYNaN() {
		Double valAvantSet = point.getY();
		point.setY(Double.NaN);
		assertEquals(valAvantSet,point.getY(),0.001);
	}
	
	@Test
	public void testConstructor1() {
		assertEquals(0,point.getX(),0.001);
		assertEquals(0,point.getY(),0.001);
	}
	
	@Test
	public void testConstructor2() {
		assertEquals(1.23,point2.getX(),0.001);
		assertEquals(5.689,point2.getY(),0.001);
	}
	
	@Test
	public void testConstructor3() {
		assertEquals(point2.getX(),point3.getX(),0.001);
		assertEquals(point2.getY(),point3.getY(),0.001);
		assertEquals(0,point4.getX(),0.001);
		assertEquals(0,point4.getY(),0.001);
	}
	
	@Test
	public void testScale() {
		MyPoint test = point2.scale(3);
		assertEquals(point2.getX()*3,test.getX(),0.001);
		assertEquals(point2.getY()*3,test.getY(),0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHorizontalSymmetry() {
		MyPoint test1 = point2.horizontalSymmetry(point);
		MyPoint test2 = point2.horizontalSymmetry(null);
		assertEquals(-1.23,test1.getX(),0.001);
		assertEquals(5.689,test1.getY(),0.001);
	}
}
