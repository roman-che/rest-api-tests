# REST API testing automation project

The project presents examples and approaches to API testing.
[Allure Report](#allure-report) includes autotests for GET and POST requests presented without logs, with various options for logs, specifications and models.
___

## The project is built with following technologies:

<p  align="center">
<img width="5%" title="IntelliJ IDEA" src="img/logo/IDEA-logo.svg">
<img width="5%" title="Java" src="img/logo/java-logo.svg">
<img width="5%" title="Selenide" src="img/logo/selenide-logo.svg">
<img width="5%" title="Selenoid" src="img/logo/selenoid-logo.svg">
<img width="5%" title="Gradle" src="img/logo/gradle-logo.svg ">
<img width="5%" title="JUnit5" src="img/logo/junit5-logo.svg">
<img width="5%" title="Allure Report" src="img/logo/allure-Report-logo.svg">
<img width="5%" title="Allure TestOps" src="img/logo/allure-ee-logo.svg">
<img width="5%" title="Github" src="img/logo/git-logo.svg">
<img width="5%" title="Jenkins" src="img/logo/jenkins-logo.svg">
<img width="5%" title="Jira" src="img/logo/jira-logo.svg">
<img width="5%" title="Telegram" src="img/logo/Telegram.svg">
</p>

___

## API tests for [reqres.in](https://reqres.in/):

Contains the tests for GET and POST requests. These are the tests which check these 'handlers' functionality. They are created with special specification.
You may look them in Allure as Suit 'ApiRequestsTest':

<p align="center">
  <img src="img/screenshots/allureRequresTest.png">
</p>

___

## API tests for [demowebshop](http://demowebshop.tricentis.com):

The tests demonstrate the use of preparation REST steps to checking web content. They use special specifications, user's templates and response model. Also there're the examples of using cookies for API testing.
In Allure they're in Suit 'DemowebshopTest':

<p align="center">
  <img src="img/screenshots/allureDemoWebshopTest.png">
</p>

___

## API tests for BookShop on [https://demoqa.com](https://demoqa.com):

The tests are for examples API testing without logs, with some or all logs, use data requests and response models, user's templates or listener:
They're in Suit 'BooksShopTest'

<p align="center">
  <img src="img/screenshots/allureBookShopTest.png">
</p>

___

## Run tests from terminal locally

### Run tests with filled remote properties:

```bash
gradle clean test
```

### Run tests remote with parameters:

where:
> + ALLURE_NOTIFICATIONS_VERSION - select Allure notification version. By default - 2.2.3
> + PROJECT_NAME - description text that will be represented in telegram notification

<p align="center">
  <img src="img/screenshots/jenkinsBuildWithParameters.png">
</p>

### Serve report:

```bash
allure serve build/allure-results
```

___

## Results analysis

The test results can be found in:
+ [Jenkins](#jenkins)
+ [Allure Report](#allure-report)
+ [Allure TestOps](#allure-testOps)
+ [Jira](#jira)

### [Jenkins](https://jenkins.autotests.cloud/job/09-roman-che-rest-api-tests/)

Once the launch finished you may watch statistics and open the `Allure Report` <img width="2%" title="Allure Report" src="img/logo/Allure_Report_icon.svg">

<p align="center">
  <img src="img/screenshots/jenkinsBuildProjectDashboard.png">
</p>

### Allure Report

The example of a test build report grouped by suits is presented below.

<p align="center">
  <img src="img/screenshots/allureResults.png">
</p>

### Allure TestOps

Allure TestOps is used as a storage for all tests cases (automated and manual), launches, their results. You may watch statistic and reports by all launches and results

Dashboards:

<p align="center">
  <img src="img/screenshots/allureTestOpsDashboardOverview.png">
</p>

List of launches:

<p align="center">
  <img src="img/screenshots/allureTestOpsListOfLaunches.png">
</p>

List of tests grouped by features and launch history:

<p align="center">
  <img src="img/screenshots/ListOfTestsGroupedByLaunchHistory.png">
</p>

### Jira

Also Jira integration is implemented in the project:

<p align="center">
  <img src="img/screenshots/jiraIssueExport.png">
</p>

___

## Example of video with test running in Allure Report

A video example showing simultaneous REST and UI test is presented below. This video was attached automatically to the Allure report.

https://github.com/roman-che/rest-api-tests/blob/main/img/screenshots/demoWebShopTestVideo.mp4

___

## Notifications in Telegram channel

The project is configured to send notifications with the launch results from Jenkins to Telegram channel. 
The project can be configured to send notifications by Email, Slack, Skype and Mattermost as well.

<p align="center">
  <img src="img/screenshots/telegramBotResponse.png">
</p>

___
