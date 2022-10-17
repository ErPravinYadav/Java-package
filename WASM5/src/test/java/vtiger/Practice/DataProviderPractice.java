package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider= "getData")
	public void addToProduct(String name,String model,int price,int qty)
	{
		System.out.println(name +" "+model+" "+price + " "+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][]d= new Object[4][4];
		d[0][0]="Samsung";
		d[0][1]="A80";
		d[0][2]=3000;
		d[0][3]=12;
		
		d[1][0]="Vivo";
		d[1][1]="V1";
		d[1][2]=300;
		d[1][3]=15;
		
		d[2][0]="oppo";
		d[2][1]="O11";
		d[2][2]=30000;
		d[2][3]=10;
		
		d[3][0]="I phone";
		d[3][1]="13 pro";
		d[3][2]=15000;
		d[3][3]=20;
		return d;
	}
}
