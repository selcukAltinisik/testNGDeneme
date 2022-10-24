package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//  UTILITY CLASS
public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext arg) {
        System.out.println("onStart - Tum testlerden ONCE 1 sefer cagirilir => "+arg.getName());
    }

    @Override
    public void onFinish(ITestContext arg) {
        System.out.println("onFinish - Tum testlerden SONRA 1 sefer cagirilir => "+arg.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Method sayisi kadar, Her bir @Test anotasyonundan once 1 kez calisir => "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - PASS olan method sayisi kadar, ve PASS edilen methodlardan SONRA 1 kez calisir => "+result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped - Skipped edilen method sayisi kadar, ve skipped edilen methodlardan SONRA 1 kez calisir => "+result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
//      System.out.println("onTestFailure - Failed edilen Method sayisi kadar, ve Failed edilen methodlardan SONRA bir kez calisir => "+result.getName());

        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
