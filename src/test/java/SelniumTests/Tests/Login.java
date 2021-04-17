package SelniumTests.Tests;

import SelniumTests.Pages.*;
import SelniumTests.TestBase;
import SelniumTests.Utility.ConfigurationReader;
import SelniumTests.Utility.Driver;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Login extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        extentLogger =report.createTest("Login Test 1");
        String url=ConfigurationReader.get("url");
        driver.get(url);
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Object is created");
//        String user=ConfigurationReader.get("username");
//        String pass=ConfigurationReader.get("password");
//        loginPage.Username.sendKeys(user);
//        loginPage.Password.sendKeys(pass);
//        Thread.sleep(3000);
//        loginPage.LoginButton.click();
//        loginPage.login();
        loginPage.login("Ali","Kurall");
        extentLogger.pass("Everyhing works as expected");
    }
















    @Test
    public void test5() throws InterruptedException {
        String url=ConfigurationReader.get("url");
        driver.get(url);


        String brow=ConfigurationReader.get("browser");
        System.out.println(brow);


//        Driver.closeDriver();
        driver.get("https://www.saucedemo.com/");
        new LoginPage().login();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        System.out.println(new InventoryPage().ItemsList.get(3).getText());
        new InventoryPage().AddButtons.get(3).click();Thread.sleep(2000);
        new InventoryPage().AddButtons.get(4).click();
        new InventoryPage().ShoppingCart.click();Thread.sleep(5000);


        //        executor.executeScript("arguments[0].scrollIntoView();", new CartPage().ContinueShopping);
//        driver.findElement(By.id("checkout")).click();
////        executor.executeScript("arguments[0].click();", driver.findElement(By.id("checkout")));
//        wait.until(ExpectedConditions.elementToBeClickable(new CartPage().checkout));
//        System.out.println(new CartPage().checkout.getText());Thread.sleep(2000);
//        WebElement check;int a=0;
//        do{
//         check=driver.findElement(By.id("checkout"));
////         check=new CartPage().checkout;
////        System.out.println(new CartPage().checkout.getText());
//            System.out.println(++a);
//        }while(check==null);
//        check.click();
//
        new CartPage().checkout.click();
        new Checkout1Page().ConfirmInformation("a","bdd","c23");Thread.sleep(2000);
        new Checkout2Page().finishButton.click();
        new Checkout2Page().confirmOrder();
    }














    @DataProvider
    public Object[][] dataLogin(){
        Object [][] objects={{"user","password"},{"User"," "},{" ", "pass"}};
        return objects;
    }

    @Test(dataProvider = "excellData")
    public void LoginNegative(String a,String b){
        extentLogger =report.createTest("Negative Login");
        driver.get("https://www.saucedemo.com/");
        new LoginPage().login(a,b);
        extentLogger.info("Username="+a+" and Password="+b+" is typed");
        System.out.println(a+" "+b);
        extentLogger.pass("Everyhing works as expected");
    }


    @DataProvider
    public Object[][] excellData()  {
        Workbook wb=null;
        FileInputStream excellFile= null;
        try {
            excellFile = new FileInputStream("Resource/DataLogin.xlsx");
            wb= WorkbookFactory.create(excellFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet ws=wb.getSheet("sheet1");
        Row row=ws.getRow(0);

        int rowNum=ws.getLastRowNum();
        int columnNum=row.getLastCellNum();
        Object[][] data=new Object[rowNum][2];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<2;j++){
                Cell cell=ws.getRow(i).getCell(j);
                if(cell!=null){Object cellData=(Object)cell.toString();
                data[i][j]=cellData;
                    }
            }
        }
        System.out.println(Arrays.deepToString(data));

//        System.out.println(rowNum+" "+columnNum);
//        System.out.println(ws.getRow(1).getCell(0)+" -- "+ ws.getRow(1).getCell(1));
    return data;
    }



    @Test
    public void Writer() throws IOException {
        File file= new File("Resource/abcd.csv");
        file.createNewFile();
        FileWriter fw=new FileWriter(file);
        BufferedWriter writer=new BufferedWriter(fw);

        writer.write("1,2"); writer.newLine();
        writer.write("21,   22  "); writer.newLine();
        writer.write(" 311   ,333"); writer.newLine();
        writer.write("4111,4444"); writer.newLine();
        writer.write("51111,55555"); writer.newLine();
        writer.write("611111,666666"); writer.newLine();
        writer.close();
    }

//    @Test
    @DataProvider
    public Object[][] Reader() throws IOException {
        File file= new File("Resource/abcd.csv");
        FileReader fw=new FileReader(file);
        BufferedReader reader=new BufferedReader(fw);

        Object [][] data=new Object[6][2];

        for(int i=0;i<6;i++){
            String str=reader.readLine();
            String [] arr=str.split(",");
            for (int j=0;j<2;j++){
                data[i][j]=(Object)arr[j];
            }
        }
        reader.close();
        System.out.println(Arrays.deepToString(data));

        return data;
    }

    @Test(dataProvider = "Reader")
    public void LoginNegativetxt(String a,String b){
        driver.get("https://www.saucedemo.com/");
        new LoginPage().login(a,b);
        System.out.println(a+" "+b);
    }


}
