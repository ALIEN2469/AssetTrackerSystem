package com.relx.assettracker;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class delete {

    public void deleteUser() {

        String excelFilePath = "C:/Work/cognizantassettracker/RELX Inventory.xlsx";  // provide your excel file path

        try {

            FileInputStream fileInputStream = new FileInputStream(excelFilePath);

            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the row number you want to delete.");
            int RowNo = scan.nextInt();

            List<User> userList = getUserList();
            for (int i = 0; i < userList.size(); i++) {

                Row dataRow = sheet.createRow(RowNo);
                dataRow.createCell(0).setCellValue(userList.get(i).getFirstName());
                dataRow.createCell(1).setCellValue(userList.get(i).getLastName());
                dataRow.createCell(2).setCellValue(userList.get(i).getAddress());
                dataRow.createCell(3).setCellValue(userList.get(i).getEmail());
                dataRow.createCell(4).setCellValue(userList.get(i).getEnvironment());
                dataRow.createCell(5).setCellValue(userList.get(i).getAssetType());
                dataRow.createCell(6).setCellValue(userList.get(i).getAssetID());
                dataRow.createCell(7).setCellValue(userList.get(i).getComments());

            }

            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public List<User> getUserList(){


        List<User> userList = new ArrayList<User>();

        userList.add(new User("","","","","","","",""));


        return userList;

    }

}
