import java.util.ArrayList;

import org.testng.annotations.Test;

public class ExcelUtils {
	static Xls_Reader reader;
	
	@Test
	public static ArrayList<Object[]> readExcell() {
		ArrayList<Object[]>testData= new ArrayList<Object[]>();
		try {
		reader= new Xls_Reader("C:\\Users\\Sohail\\Hello-World\\Automation\\testData\\TestData.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int count=2;count<=reader.getRowCount("Sheet1");count++) {
			String Firstname=reader.getCellData("Sheet1", "FirstName", count);
			String LastName=reader.getCellData("Sheet1", "LastName", count);
			String Phone=reader.getCellData("Sheet1", "Phone", count);
			String Email=reader.getCellData("Sheet1", "Email", count);
			String Address1=reader.getCellData("Sheet1", "Address1", count);
			String Address2=reader.getCellData("Sheet1", "Address2", count);
			String City=reader.getCellData("Sheet1", "City", count);
			String State=reader.getCellData("Sheet1", "State", count);
			String Postcode=reader.getCellData("Sheet1", "Postcode", count);
			String Country=reader.getCellData("Sheet1", "Country", count);
			Object[] obj= new Object[] {Firstname, LastName,Phone,Email,Address1, Address2,City,State,Postcode,Country};
			//testData.add(new Object[] {Firstname, LastName,Phone,Email,Address1, Address2,City,State,Postcode,Country});
			
			testData.add(obj);
		}
		return testData;
	}
}


