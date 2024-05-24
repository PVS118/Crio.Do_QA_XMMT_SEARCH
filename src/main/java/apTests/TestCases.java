
package apTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

///

public class TestCases {
    WebDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    /* public void testCase01() {
         System.out.println("Start Test case: testCase01");

         // Navigate to Make My Trip website
         driver.get("https://www.makemytrip.com/");

         // Verify that the URL contains "makemytrip."
         String currentUrl = driver.getCurrentUrl();
         // Verify that the URL contains "makemytrip"
         if (currentUrl.contains("makemytrip")) {
             System.out.println("URL verification passed. The URL contains 'makemytrip.'");
         } else {
             System.out.println("URL verification failed. The URL does not contain 'makemytrip.'");
         }


         System.out.println("End Test case: testCase01");
     }

     public void testCase02() {
         System.out.println("Start Test case: testCase02");

         try  {
             driver.get("https://www.makemytrip.com/");

             // Close the customized window
             WebElement closeWindow = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
             closeWindow.click();

             // Select BLR as the departure location.
             WebElement fromDropdown = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
             fromDropdown.click();

             Thread.sleep(2000);

            WebElement departureLocation = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/label/p/span"));
              departureLocation.click();



             Thread.sleep(2000);

             // Select DEL as the arrival location.
             WebElement toDropdown = driver.findElement(By.xpath("//input[@placeholder='To']"));
             toDropdown.click();

             Thread.sleep(2000);

            WebElement arrivalLocation = driver.findElement(By.xpath("//label[@for='toCity']/p/span"));
             arrivalLocation.click();

             WebElement dateInput = driver.findElement(By.xpath("//label[@for='departure']/p[1]"));
             dateInput.sendKeys("20th January 2024");

             WebElement searchButton = driver.findElement(By.xpath("//p[@class='fsw_submit']/a"));
             searchButton.click();

             Thread.sleep(2000);



             // Wait for the flight details to load
             WebDriverWait wait = new WebDriverWait(driver, 20);
             WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"listing-id\"]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/div/div")));

             // Store the flight price (per adult).
             String flightPrice = priceElement.getText();

             // Expected Result
             if (!flightPrice.isEmpty()) {
                 System.out.println("Test Passed! Flight details obtained successfully. Price per adult: " + flightPrice);
             } else {
                 System.out.println("Test Failed! Unable to obtain flight details.");
             }

         } catch (Exception e) {
             System.out.println("Exception occurred: " + e.getMessage());
         }

         System.out.println("End Test case: testCase02");
     }


     public void testCase03() {
         System.out.println("Start Test case: testCase03");

         try  {
             driver.manage().window().maximize();
             driver.get("https://www.makemytrip.com/");

             // Wait for the page to load
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

             // Close the customized window
             WebElement closeWindow= driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
             closeWindow.click();

             WebElement fromDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"));
             fromDropdown.click();

             Thread.sleep(2000);

             // Step 1: Select YPR(Bangalore) as the departure location for the train.
             WebElement departureLocation = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label/p"));
             departureLocation.sendKeys("YPR");

             WebElement toDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
             toDropdown.click();

             Thread.sleep(2000);

             // Step 2: Select NDLS(New Delhi) as the arrival location for the train.
             WebElement arrivalLocation = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/label/p"));
             arrivalLocation.sendKeys("NDLS");

             // Step 3: Select the correct date (20th January 2024) for the train.
             WebElement dateInput = driver.findElement(By.xpath("//label[@for='train_depart_date']/p[1]"));
             dateInput.sendKeys("20th January 2024");

             // Step 4: Select the class as 3AC
             Select classSelect = new Select(driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/label/p")));
             classSelect.selectByVisibleText("3AC");

             Thread.sleep(2000);

             // Step 5: Click on the search button for the train.
             WebElement searchButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/p/a"));
             searchButton.click();

             Thread.sleep(2000);

             // Wait for the train details to load
             WebDriverWait wait = new WebDriverWait(driver, 20);
             WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"train_options_20-01-2024_0\"]/div[1]/div[2]")));

             // Step 6: Store the train price for 3AC.
             String trainPrice = priceElement.getText();

             // Expected Result: The correct train details are obtained.
             if (!trainPrice.isEmpty()) {
                 System.out.println("Test Passed! Train details obtained successfully. Price for 3AC: " + trainPrice);
             } else {
                 System.out.println("Test Failed! Unable to obtain train details.");
             }

         } catch (Exception e) {
             System.out.println("Exception occurred: " + e.getMessage());
         }

         System.out.println("End Test case: testCase03");
     }



     public void testCase04() {
         System.out.println("Start Test case: testCase04");

         try  {
             driver.manage().window().maximize();
             driver.get("https://www.makemytrip.com/");

             // Close the alert window
             WebElement closeWindow = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
             closeWindow.click();

             // Test Case 04: Verify that there are no buses from Bangalore to New Delhi

             WebElement fromDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"));
             fromDropdown.click();

             Thread.sleep(2000);


             // Step 1: Select Bangalore (search for "bangl") as the departure location for buses.
             WebElement departureLocation = driver.findElement(By.xpath("//*[@id='fromCity']"));
             departureLocation.sendKeys("bangl");
             Thread.sleep(2000);

             // Step 2: Select New Delhi (search for "del") as the arrival location for buses.
             WebElement toDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
             toDropdown.click();

             Thread.sleep(2000);

             WebElement arrivalLocation = driver.findElement(By.xpath("//*[@id='toCity']"));
             arrivalLocation.sendKeys("del");
             Thread.sleep(2000);

             // Step 3: Select the correct date (20th January 2024) for buses.
             WebElement dateInput = driver.findElement(By.xpath("//div[@class='dateInnerCell']/p/span[2]"));
             dateInput.sendKeys("20th January 2024");

             // Step 4: Click on the search button for buses.
             WebElement searchButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/p/a"));
             searchButton.click();

             Thread.sleep(2000);

             // Step 5: Verify that text displayed is equal to "No buses found for 20 Jan."
             WebDriverWait wait = new WebDriverWait(driver, 20);
             WebElement noBusesMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'No buses found for 20 Jan.')]")));
             String actualMessage = noBusesMessage.getText();
             String expectedMessage = "No buses found for 20 Jan.";

             // Expected Result: The message "No buses found" is displayed for the specified route and date.
             if (actualMessage.equals(expectedMessage)) {
                 System.out.println("Test Passed! No buses found message displayed.");
             } else {
                 System.out.println("Test Failed! Expected message: " + expectedMessage + ", Actual message: " + actualMessage);
             }

         } catch (Exception e) {
             System.out.println("Exception occurred: " + e.getMessage());
         }

         System.out.println("End Test case: testCase04");
     }

     }
     */
    public void testCase01() {
        System.out.println("Start Test case: testCase01");

        driver.get("https://www.makemytrip.com/");

        // retrieve the current url
        String currentUrl = driver.getCurrentUrl();

        //validating current url
        if (currentUrl.contains("makemytrip")) {
            System.out.println("url of the page contains makemytrip");
        } else {
            System.out.println("url of the page does not contain makemytrip");

            endTest();
        }

        //Closing pop-ups
        WebElement closepopups = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
        closepopups.click();

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {

        System.out.println("Start Test case: testCase02");

        //click on fromInputBox
        WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
        fromInput.click();

        //click on toInputBox
        WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
        fromSearchBox.click();

        // sending input as text
        fromSearchBox.sendKeys("blr");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement selectFromCity = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
        selectFromCity.click();

        //Validation
        WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/label/p/span"));

        //retrieve the value of from_input_box using getText();
        String from_input_value = from_input_box_validate.getText();

        //print the value of from_input_Box
        System.out.println(from_input_value);

        if (from_input_value.contains("BLR")) {
            System.out.println("sending blr as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        //click on toInputBox
        WebElement toInput = driver.findElement(By.xpath("//*[@id='toCity']"));
        toInput.click();

        //click on toSearchBox
        WebElement toSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/input"));
        toSearchBox.click();

        // sending input as text
        toSearchBox.sendKeys("del");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement selectToCity = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
        selectToCity.click();

        //Validation of to_input_box
        WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/p/span"));

        //retrieve the value of to_input_box using getText();
        String to_input_value = to_input_box_validate.getText();

        //print the value of to_input_Box
        System.out.println(to_input_value);

        if (to_input_value.contains("DEL")) {
            System.out.println("sending del as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        // click on Departure Date
        WebElement clickDeparture = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/span"));
        clickDeparture.click();

        Thread.sleep(2000);

        // click to the next set of dates according to the date of travel specified
        WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
        changeCalendar.click();

        Thread.sleep(2000);

        //Validation of Departure Date
        WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div"));

        String departure_month = month.getText();

        System.out.println(departure_month);

        if (departure_month.contains("January 2024")) {
            System.out.println("selecting January 2024 in the month of travel");
        } else {
            System.out.println("selecting invalid date in the month of travel");
        }

        // click on the speified date of travel
        WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
        clickDepartureDate.click();

        Thread.sleep(2000);

        //Clicking on Search button
        WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
        clickSearchbtn.click();

        // close pop-ups
        WebElement close_poup = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/span"));
        close_poup.click();

        //retrieve price per adult using getText();
        WebElement pricePerAdult = driver.findElement(By.xpath("//*[@id='listing-id']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/div/div"));
        String priceperadult = pricePerAdult.getText();
        System.out.println(priceperadult);

        // Expected Result
        if (!priceperadult.isEmpty()) {
            System.out.println("Test Passed! Flight details obtained successfully. Price per adult: " + priceperadult);
        } else {
            System.out.println("Test Failed! Unable to obtain flight details.");
        }


        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {

        System.out.println("Start Test case: testCase03");

        //clicking on trains link
        WebElement clickonTrains = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div/nav/ul/li[5]/span/a"));
        clickonTrains.click();

        // // closing pop-ups
        // WebElement closeads = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
        //  closeads.click();

        //click on fromInput Box
        WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
        fromInput.click();

        // click on fromSearchBox
        WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"));
        fromSearchBox.click();

        Thread.sleep(1000);

        // sending input as text
        fromSearchBox.sendKeys("ypr");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement fromCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
        fromCitySelect.click();

        //Validation of from_input_box
        WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label/p"));

        //retrieve the value of from_input_box using getText();
        String from_input_value = from_input_box_validate.getText();

        //print the value of from_input_box
        System.out.println(from_input_value);

        if (from_input_value.contains("YPR")) {
            System.out.println("sending ypr as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        Thread.sleep(2000);

        //click on toInput Box
        WebElement toInput = driver.findElement(By.xpath("//*[@id='toCity']"));

        //click on toInputSearchBox
        WebElement toInputSearchBox = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
        toInputSearchBox.click();

        // sending input as text
        toInputSearchBox.sendKeys("ndls");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement toCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
        toCitySelect.click();

        //Validation of to_input_box
        WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/label/p"));

        //retrieve the value of to_input_box using getText();
        String to_input_value = to_input_box_validate.getText();

        //printing the text from to_input_value
        System.out.println(to_input_value);

        if (to_input_value.contains("NDLS")) {
            System.out.println("sending ndls as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        // clicking on Departure Date
        WebElement clickDepature = driver.findElement(By.xpath("//*[@id='travelDate']"));
        clickDepature.click();

        Thread.sleep(2000);

        // clicking to the next set of dates according to the date of travel specified
        WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
        changeCalendar.click();

        Thread.sleep(2000);

        //Validation of Departure Date
        WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div"));

        String departure_month = month.getText();

        System.out.println(departure_month);

        if (departure_month.contains("January 2024")) {
            System.out.println("selecting January 2024 in the month of travel");
        } else {
            System.out.println("selecting invalid date in the month of travel");
        }

        // clicking on the speified date of travel
        WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
        clickDepartureDate.click();

        Thread.sleep(2000);

        //clicking on class type
        WebElement clickOnClass = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/label/span"));
        clickOnClass.click();

        //selecting the class type
        WebElement classType = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/ul/li[3]"));
        classType.click();

        Thread.sleep(2000);

        //click on Search Button
        WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
        clickSearchbtn.click();

        // retrieve the price of Class Type specified using getText();
        WebElement classTypePrice = driver.findElement(By.xpath("//*[@id='train_options_20-01-2024_0']/div[1]/div[2]"));
        String trainclassTypePrice = classTypePrice.getText();
        System.out.println(trainclassTypePrice);

        // Expected Result: The correct train details are obtained.
        if (!trainclassTypePrice .isEmpty()) {
            System.out.println("Test Passed! Train details obtained successfully. Price for 3AC: " + trainclassTypePrice );
        } else {
            System.out.println("Test Failed! Unable to obtain train details.");
        }


        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {

        System.out.println("Start Test case: testCase04");

        //click on buses link
        WebElement clickonBuses = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[6]/span/a"));
        clickonBuses.click();

        //clicking on fromInput box
        WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
        fromInput.click();

        //clicking on from search box
        WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
        fromSearchBox.click();

        // sending input as text
        fromSearchBox.sendKeys("bangl");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement fromCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
        fromCitySelect.click();

        Thread.sleep(2000);

        //Validation of from_input_box
        WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));

        //retrieve the value of from_input_box using getAttribute();
        String from_input_value = from_input_box_validate.getAttribute("value");

        //printing the text from from_input_box
        System.out.println(from_input_value);

        if (from_input_value.contains("Bangalore, Karnataka")) {
            System.out.println("sending blr as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        //clicking on toInputBox
        WebElement toInputBox = driver.findElement(By.xpath("//*[@id='toCity']"));
        // Thread.sleep(2000);
        // toInputBox.click();

        //clicking on toInputSearchbox
        WebElement toInputSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
        toInputSearchBox.click();

        // sending input as text
        toInputSearchBox.sendKeys("del");

        Thread.sleep(1000);

        //clicking on the list of cities
        WebElement toCitySelect = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]"));
        toCitySelect.click();

        //Validation of to_input_box
        WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"toCity\"]"));

        //retrieve the value of to_input_box using getAttribute();
        String to_input_value = to_input_box_validate.getAttribute("value");

        //print the value from to_input_Box
        System.out.println(to_input_value);

        if (to_input_value.contains("Delhi")) {
            System.out.println("sending ndls as departure location");
        } else {
            System.out.println("sending invalid state code as departure location");
        }

        // clicking on Departure Date
        WebElement clickDepature = driver.findElement(By.xpath("//*[@id='travelDate']"));
        //clickDepature.click();

        Thread.sleep(2000);

        // clicking to the next set of dates according to the date of travel specified
        WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
        changeCalendar.click();

        Thread.sleep(2000);

        //Validation of Departure Date
        WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div"));

        String departure_month = month.getText();

        System.out.println(departure_month);

        if (departure_month.contains("January 2024")) {
            System.out.println("selecting January 2024 in the month of travel");
        } else {
            System.out.println("selecting invalid date in the month of travel");
        }

        // clicking on the speified date of travel
        WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
        clickDepartureDate.click();

        Thread.sleep(2000);

        //click on Search Button
        WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"search_button\"]"));
        clickSearchbtn.click();

        // Validating bus search results page
        WebElement busSearch = driver.findElement(By.xpath("//*[@id='root']/div[1]/div[3]/div[1]/span[1]"));

        //retrieve the value using getText();
        String busSearchResult = busSearch.getText();

        if (busSearchResult.contains("No buses found for 20 Jan")) {
            System.out.println("No buses found for 20 Jan");
        }

        System.out.println("End Test case: testCase04");

    }

}



