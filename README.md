**About the project:**

**Automation testing Project of an E-Commerce website using Selenium with Java**
![image](https://user-images.githubusercontent.com/66517017/199646048-6c2ae05b-5be4-406a-824e-0611ff768e76.png)

**This project implements hybrid framework based on TestNG and Data Driven Testing.**

![image](https://user-images.githubusercontent.com/66517017/199646039-600df7e4-bd84-4834-b042-d605d89e6161.png)

**Getting Started**

**To clone the repo using following URL:**

[**https://github.com/Ninja-Cyborg/SeleniumAutomationTesting.git**](https://github.com/Ninja-Cyborg/SeleniumAutomationTesting.git)

**Prerequisites:**

- **Java 8**
- **Jenkins**

![image](https://user-images.githubusercontent.com/66517017/199646108-3cc7ca67-fb8d-4fbb-b29f-8715d0323c3b.png)
**Framework Features:**

1. **Run tests parallel**
2. **Read configuration from xml and properties file**
3. **HTML Reports**
4. **Screenshots captures for failed Tests**
5. **Read data from Excel File(.xlsx)**
6. **Output test logs implemented through log4j**
7. **Jenkins integration**
8. **ActionImpl combining Actions methods**

![image](https://user-images.githubusercontent.com/66517017/199646031-289ffc57-a89e-4228-97fa-7e07283a117e.png)

![image](https://user-images.githubusercontent.com/66517017/199646116-2344dbcb-0646-4476-a7bb-b48bd9c01648.png)
1. **Run test parallel**

Test running config are store in testing\_\*.xml files

To run test concurrently, run testing\_crossBrowser.xml file

Further, there are 3 test groups, regression, smoke, sanity, and each has own test running xml file.

2. Read configuration form cml and properties file
3. **HTML Reports:**

Reports are generated through ExtentReports library and configuration for html are stored in extent-config.xml file. Reports can be found in /webapptestproject/test-output/ExtentReport

4. **Screenshots captures for failed Tests**

Listeners class implement ITestListerner to record Test Failure and capture screen. The screenshots are stored in ScreenShots folder.

(![image](https://user-images.githubusercontent.com/66517017/199645876-e7510ec9-159d-4bcc-b89b-16ad85520f88.png))

(![image](https://user-images.githubusercontent.com/66517017/199645902-d42c2d4c-d9cd-49a1-aad5-a52b65dd1156.png))

5. **Read data from Excel File(.xlsx)**

DataProviders class read the data from testData.xlsx using ExcelSheet object from Utility package. It includes data to create new account, login credentials, search product name and size. testData.xlsx is located under /webapptestproject/src/test/resources/TestData

6. **Output test logs implemented through log4j**

The logs are setup through Logs class under Utility, log4j.xml includes config settings

7. **Jenkins integration**

The Jenkins configuration code could be found in pom.xml

(Commented out to in present repo)

To publish html reports with Jenkins add following plugin:

HTML Publisher

8. **ActionImpl combines Actions methods**

The code in ActionImpl methods is mimic some of Actions class methods provided by Selenium. It takes additional Paramter and may include m

With ActionImpl class methods have combined methods from Action class;

For example, click method of ActionImpl not only perform click but first perform moveToElement() method

**public**** void** click(WebDriver driver, WebElement element) {

Actions actions = **new** Actions(driver);

actions.moveToElement(element).click().build().perform();

}

The documentation can be found at [Actions API | Selenium](https://www.selenium.dev/documentation/webdriver/actions_api/)

![image](https://user-images.githubusercontent.com/66517017/199646015-2254329a-2404-4ea6-91fd-f174036c6a20.png)

**Links:**

- [Jenkins Download](https://www.jenkins.io/download/)
- [Automation Practice Page Website](http://automationpractice.com/index.php?controller=my-account)
