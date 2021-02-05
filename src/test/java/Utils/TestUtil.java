package Utils;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUtil 
{
	static XLSReader xls;

	public static void main(String[] args)
	{
		ArrayList<Object[]> myData = TestUtil.getDataFromExcel("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx", "Amity");
		Iterator< Object[]> itr=myData.iterator();
		while(itr.hasNext())
		{
			Object[] x = itr.next();
			for (int i=0; i<x.length;i++ ) 
			{
				System.out.print(x[i]+"\t");
			}
			System.out.println();
		}
	}


	public static ArrayList<Object[]> getDataFromExcel(String path,String SheetName)
	{
		//xls=new XLSReader("/home/anu/Workspace IntelliJ/TestNG/src/test/java/TestDataxls/TestData.xlsx");
		xls=new XLSReader(path);
		//String SheetName="HalfEbay_Registration";
		ArrayList<Object[]> data=new ArrayList<Object[]>();
		int columnCount=xls.getColumnCount(SheetName);
		int rowCount=xls.getRowCount(SheetName);
		Object[] Obj;

		for(int row=2;row<=rowCount;row++)
		{
			Obj=new Object[columnCount];
			for(int col=1;col<=columnCount;col++)
			{
				Obj[col-1]=xls.getCellData(SheetName, row, col);
				//System.out.print(Obj[col-1]+"\t");
			}
			data.add(Obj);
		}

		return data;
	}


}
