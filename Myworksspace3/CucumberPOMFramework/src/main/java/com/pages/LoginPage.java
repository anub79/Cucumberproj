package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	// 1. by locators

	private By txtusrname = By.name("email");
	private By password = By.id("passwd");
	private By button_Login = By.xpath("//i[@class='icon-lock left']");
	private By forgotpswd_link = By.xpath("//a[contains(text(),' Forgot Your')]");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// 3. Page actions:features(behavior) of the page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotpswd_link).isDisplayed();
	}
	public void enterUserName(String username) {
		driver.findElement(txtusrname).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void cickOnLogin() {
		driver.findElement(button_Login).click();
	}
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("Login with: "+un+" "+pwd);
		driver.findElement(txtusrname).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(button_Login).click();
		return new AccountsPage(driver);
	}
	
}
