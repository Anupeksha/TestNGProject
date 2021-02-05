package Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssterions
{
	@Test
	public void softAss()
	{
		Rectangle r1=new Rectangle(20, 50);
		Rectangle r2=new Rectangle(10, 30);
		r1=r2;
		Rectangle r3=null;
		
		SoftAssert soft=new SoftAssert();
		
		
		soft.assertEquals("XYZ", "XYZz");
		soft.assertEquals("XYZ", "XxYZ", "Actual isn't as expected");
		
		soft.assertNotEquals("ABC", "ABC");
		soft.assertNotEquals("ABC", "ABC", "Not as Expected");
		
		soft.assertNotNull(r3);
	
		soft.assertTrue(8>78);
		soft.assertTrue(67>890, "The condition is not true");
		
		soft.assertFalse(4<89);
		soft.assertFalse(9<89, "Condition is not false");
		
		soft.assertNotSame(r1, r2);
		
		soft.assertAll();
	}

}

class Rectangle
{
	int length;
	int breadth;
	
	public Rectangle(int l,int b)
	{
		this.length=l;
		this.breadth=b;
	}
}
