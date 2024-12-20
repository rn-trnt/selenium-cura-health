package CURA;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CuraTest extends BaseTest {

  @Test(priority = 1)
  public void invalidLogin() throws InterruptedException {
    // 1.1 Login with invalid data

    page.clickAppointmentButton();
    Assert.assertTrue(page.getLoginContainer().isDisplayed());

    page.getUsernameField().clear();
    page.getUsernameField().sendKeys("Invalid Username");

    page.getPasswordField().clear();
    page.getPasswordField().sendKeys("Invalid Password");

    page.clickLoginButton();
    Assert.assertEquals(page.getLoginErrorMessage().getText(), "Login failed! Please ensure the username and password are valid.");

    Thread.sleep(1000);
  }

  @Test(priority = 2)
  public void validLogin() throws InterruptedException {
    // 1.2 Login with valid data

    page.clickAppointmentButton();
    Assert.assertTrue(page.getLoginContainer().isDisplayed());

    page.getUsernameField().clear();
    page.getUsernameField().sendKeys("John Doe");

    page.getPasswordField().clear();
    page.getPasswordField().sendKeys("ThisIsNotAPassword");

    page.clickLoginButton();
    Assert.assertTrue(page.getAppointmentContainer().isDisplayed());

    Thread.sleep(1000);
  }

  @Test(priority = 3)
  public void failedAppointment() throws InterruptedException {
    // 2.1 Make Appointment - without input mandatory field

    page.clickAppointmentButton();
    page.login();

    page.getHospitalReadmissionCheckbox().click();
    page.setCommentTextArea("This is a comment");

    page.clickBookButton();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", page.getDateField());

    Assert.assertEquals(validationMessage, "Please fill out this field.");

    Thread.sleep(1000);
  }

  @Test(priority = 4)
  public void successAppointment() throws InterruptedException {
    // 2.2 Make Appointment - Success

    String facility;
    boolean hospitalReadmission;
    String healthcareProgram;
    String visitDate = "12/12/2024";
    String comment;

    page.clickAppointmentButton();
    page.login();

    Select dropdown = new Select(page.getFacilityDropdown());
    dropdown.selectByVisibleText("Seoul CURA Healthcare Center");
    page.getHospitalReadmissionCheckbox().click();
    page.getNoneRadioButton().click();
    page.getDateField().sendKeys(visitDate);
    page.setCommentTextArea("This is success appointment comment");

    facility = dropdown.getFirstSelectedOption().getText();
    hospitalReadmission = page.getHospitalReadmissionCheckbox().isSelected();
    healthcareProgram = page.getNoneRadioButton().getDomProperty("value");
    comment = page.getCommentTextArea().getDomProperty("value");

    page.clickBookButton();
    page.getSummaryContainer().isDisplayed();

    Assert.assertEquals(page.getFacilityText(), facility);
    Assert.assertEquals(page.getProgramText(), healthcareProgram);
    Assert.assertEquals(page.getDateText(), visitDate);
    Assert.assertEquals(page.getCommentText(), comment);

    if (hospitalReadmission) {
      Assert.assertEquals(page.getHospitalReadmissionText(), "Yes");
    } else {
      Assert.assertEquals(page.getHospitalReadmissionText(), "No");
    }

    page.clickHomepageButton();
    Assert.assertTrue(page.getAppointmentContainer().isDisplayed());

    Thread.sleep(1000);
  }
}
