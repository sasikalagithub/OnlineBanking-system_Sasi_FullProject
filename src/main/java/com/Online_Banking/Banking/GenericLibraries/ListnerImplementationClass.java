package com.Online_Banking.Banking.GenericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + "--->passed");
		Reporter.log(methodName + "------>script executed successfully");

	}

	public void onTestFailure(ITestResult result) {
		String Failedscript = result.getMethod().getMethodName();
		String fScript = Failedscript + new Java_Utility().getSystemDateINFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		 File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+ fScript +".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + "--->skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName + "------>testscript execution skipped");
	}

	public void onStart(ITestContext context) {

		// Execution stars from here
		// configure the report

		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("Online Banking System");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Online Banking Execution Report");

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Base_url", "http://rmgtestingserver/domain/Online_Banking_System/");
		report.setSystemInfo("ReporterName", "Sasikala");

	}

	
	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName + "--testscript execution started--");
	}

}

