package CURA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

  public PageObjects(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  // =====================================
  // Login Page
  // =====================================

  @FindBy(xpath = "//a[@id='btn-make-appointment']")
  WebElement appointmentButton;

  @FindBy(xpath = "//section[@id='login']//div[@class='row']")
  WebElement loginContainer;

  @FindBy(xpath = "//input[@id='txt-username']")
  WebElement usernameField;

  @FindBy(xpath = "//input[@id='txt-password']")
  WebElement passwordField;

  @FindBy(xpath = "//button[@id='btn-login']")
  WebElement loginButton;

  @FindBy(xpath = "//p[@class='lead text-danger']")
  WebElement loginErrorMessage;

  public void clickAppointmentButton() {
    appointmentButton.click();
  }

  public WebElement getLoginContainer() {
    return loginContainer;
  }

  public WebElement getUsernameField() {
    return usernameField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public void clickLoginButton() {
    loginButton.click();
  }

  public WebElement getLoginErrorMessage() {
    return loginErrorMessage;
  }

  public void login() {
    usernameField.clear();
    usernameField.sendKeys("John Doe");

    passwordField.clear();
    passwordField.sendKeys("ThisIsNotAPassword");

    loginButton.click();
  }

  // =====================================
  // Appointment Page
  // =====================================

  @FindBy(xpath = "//section//div[@class='container']")
  WebElement appointmentContainer;

  @FindBy(xpath = "//select[@id='combo_facility']")
  WebElement facilityDropdown;

  @FindBy(xpath = "//label[normalize-space()='Apply for hospital readmission']//input")
  WebElement hospitalReadmissionCheckbox;

  @FindBy(xpath = "//input[@id='radio_program_medicare']")
  WebElement medicareRadioButton;

  @FindBy(xpath = "//input[@id='radio_program_medicaid']")
  WebElement medicaidRadioButton;

  @FindBy(xpath = "//input[@id='radio_program_none']")
  WebElement noneRadioButton;

  @FindBy(xpath = "//input[@id='txt_visit_date']")
  WebElement dateField;

  @FindBy(xpath = "//textarea[@id='txt_comment']")
  WebElement commentTextArea;

  @FindBy(xpath = "//button[@id='btn-book-appointment']")
  WebElement bookButton;

  public WebElement getAppointmentContainer() {
    return appointmentContainer;
  }

  public WebElement getFacilityDropdown() {
    return facilityDropdown;
  }

  public WebElement getHospitalReadmissionCheckbox() {
    return hospitalReadmissionCheckbox;
  }

  public WebElement getMedicareRadioButton() {
    return medicareRadioButton;
  }

  public WebElement getMedicaidRadioButton() {
    return medicaidRadioButton;
  }

  public WebElement getNoneRadioButton() {
    return noneRadioButton;
  }

  public WebElement getDateField() {
    return dateField;
  }

  public WebElement getCommentTextArea() {
    return commentTextArea;
  }

  public void setCommentTextArea(String comment) {
    commentTextArea.clear();
    commentTextArea.sendKeys(comment);
  }

  public void clickBookButton() {
    bookButton.click();
  }

  // =====================================
  // Confirmation Page
  // =====================================

  @FindBy(xpath = "//section[@id='summary']//div[@class='container']")
  WebElement summaryContainer;

  @FindBy(xpath = "//p[@id='facility']")
  WebElement facilityText;

  @FindBy(xpath = "//p[@id='hospital_readmission']")
  WebElement hospitalReadmissionText;

  @FindBy(xpath = "//p[@id='program']")
  WebElement programText;

  @FindBy(xpath = "//p[@id='visit_date']")
  WebElement dateText;

  @FindBy(xpath = "//p[@id='comment']")
  WebElement commentText;

  @FindBy(xpath = "//a[normalize-space()='Go to Homepage']")
  WebElement homepageButton;

  public WebElement getSummaryContainer() {
    return summaryContainer;
  }

  public String getFacilityText() {
    return facilityText.getText();
  }

  public String getHospitalReadmissionText() {
    return hospitalReadmissionText.getText();
  }

  public String getProgramText() {
    return programText.getText();
  }

  public String getDateText() {
    return dateText.getText();
  }

  public String getCommentText() {
    return commentText.getText();
  }

  public void clickHomepageButton() {
    homepageButton.click();
  }

}
