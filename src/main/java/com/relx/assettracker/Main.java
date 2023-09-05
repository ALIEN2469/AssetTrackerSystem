package com.relx.assettracker;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {

        int value=1;
        while(value!=6){
            System.out.println( "Asset Tracker System\n" );
            System.out.println("1: Add a User\n2: Update a user\n3: Delete a user\n4: View all users\n5: View all users in Excel\n6: Exit\n7: Create new users");
            Scanner sc = new Scanner(System.in);
            value=sc.nextInt();


            if(value!=1 &&value!=2 &&value!=3 &&value!=4 &&value!=5 &&value!=6 &&value!=7){
                System.out.println("Select a valid option!");
                continue;
            }


            if(value==6){
                break;
            }


            else if (value==1) {
                System.out.println("Adding a user!");

                ExcelUpdateService excelService = new ExcelUpdateService();
                excelService.updateExcelFile();

                System.out.println("User is added successfully!");
            }


            else if (value==2) {
                System.out.println("Updating a user!");

                update up = new update();
                up.updateUser();

                System.out.println("User Updated");

            }


            else if (value==3) {
                System.out.println("Deleting a user!");
                delete del = new delete();
                del.deleteUser();

                System.out.println("User Deleted");
            }


            else if (value==4) {
                System.out.println("Viewing all users!");
                ExcelService servie1 = new ExcelService();
                List<User> userList = servie1.ReadDataFromExcel("C:/Work/cognizantassettracker/RELX Inventory.xlsx");
            }


            else if (value==5) {
                System.out.println("Viewing all users in Excel!\nPlease open 'C:/Work/cognizantassettracker/RELX Inventory.xlsx' to view all users in Excel.");
            }
            else if (value== 7) {

                ExcelService servie = new ExcelService();
                servie.writeToExcelSheet(); //Add row to excel

                System.out.println("Users are added successfully!");
            }
        }
        System.out.println("Asset Tracker System closed successfully!");
        //ExcelService servie = new ExcelService();
        //servie.writeToExcelSheet(); //Add row to excel
        //List<User> userList = servie.ReadDataFromExcel("C:/Work/AssetTrackerSystem/user.xlsx"); //Read from excel


    }



}