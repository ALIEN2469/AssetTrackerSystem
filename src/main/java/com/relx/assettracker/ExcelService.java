package com.relx.assettracker;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {
	
	
    
	public static void writeToExcelSheet() {
    	
		  String[] row_heading = {"Associate ID","Associate Name","Location","Department","Environment working on","Asset Type","Asset ID","Comments"};
		  
		  List<User> users = createUserData();

    	 XSSFWorkbook workbook = new XSSFWorkbook();
         
         XSSFSheet spreadsheet = workbook.createSheet( "User Details ");
			Row headerRow = spreadsheet.createRow(0);

         // Creating header
	        for (int i = 0; i < row_heading.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(row_heading[i]);
			}
	     // Creating data rows for each user
	        for(int i = 0; i < users.size(); i++) {
	        	Row dataRow = spreadsheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(users.get(i).getFirstName());
	        	dataRow.createCell(1).setCellValue(users.get(i).getLastName());
	        	dataRow.createCell(2).setCellValue(users.get(i).getAddress());
	        	dataRow.createCell(3).setCellValue(users.get(i).getEmail());
				dataRow.createCell(4).setCellValue(users.get(i).getEnvironment());
				dataRow.createCell(5).setCellValue(users.get(i).getAssetType());
				dataRow.createCell(6).setCellValue(users.get(i).getAssetID());
				dataRow.createCell(7).setCellValue(users.get(i).getComments());

	        } 
	        
	      //Write the workbook in file system
	        FileOutputStream out;
			try {
				out = new FileOutputStream( new File("C:/Work/cognizantassettracker/RELX Inventory.xlsx"));
				 
		        workbook.write(out);
		        out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    
	public static  List<User> createUserData() {

		List<User> users = new ArrayList<User>();
		users.add(new User("222420", "R,Kandan", "Chennai","ADM","PROD, STAGE, DEV and CERT","Laptop","LTIN357761","Working from office"));
		users.add(new User("518550", "Kannan V,Satheesh", "Chennai","ADM","PROD, STAGE, DEV and CERT","Laptop","LTIN123628","Working from office"));

		return users;
	}



	public List<User> ReadDataFromExcel(String path) {

		List<User> userList = new ArrayList<User>();

		try {
            XSSFWorkbook workbook = new XSSFWorkbook(path); 
			
			// Retrieving the number of sheets in the Workbook
	        //System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        //System.out.println("Retrieving Sheets using for-each loop");
	        for(Sheet sheet: workbook) {

	        	int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	        	System.out.println("Row Count: "  +  rowCount);
	        	 for (int i=1; i<=rowCount; i++) {
	        		 Row row = sheet.getRow(i);
	        		 System.out.println("Row No: "  +  row.getRowNum() );
	        		 String associateID = row.getCell(0).getStringCellValue();
	        		 String associateName = row.getCell(1).getStringCellValue();
	        		 String location = row.getCell(2).getStringCellValue();
	        		 String Dept = row.getCell(3).getStringCellValue();
					 String environment = row.getCell(4).getStringCellValue();
					 String assetType = row.getCell(5).getStringCellValue();
					 String assetID = row.getCell(6).getStringCellValue();
					 String comments = row.getCell(7).getStringCellValue();
	             	
	                 System.out.println("Associate ID: "  + associateID);
	                 System.out.println("Associate Name: "  + associateName);
	                 System.out.println("Location: "  + location);
	                 System.out.println("Dept: "  + Dept);
					 System.out.println("Environment working on: "  + environment);
					 System.out.println("AssetType: "  + assetType);
					 System.out.println("AssetID: "  + assetID);
					 System.out.println("Comments: "  + comments);

	                 
	              User user = new User();
	              user.setAssociateID(associateID);
	              user.setAssociateName(associateName);
	              user.setLocation(location);
	              user.setDept(Dept);
				  user.setEnvironment(environment);
				  user.setAssetType(assetType);
				  user.setAssetID(assetID);
				  user.setComments(comments);
	              
	              userList.add(user);   
	        	 }
	        	
	        }
		}catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	
		
		
	}
	
	

}
