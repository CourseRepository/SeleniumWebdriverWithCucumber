@runtime
Feature: Browser Function

  Background: 
    Given BrowserFunction_I have chrome driver instance

  Scenario: Browser Function
    When BrowserFucnton_I call the quit method the browser will close

  Scenario: Browser Function Open Webpage
    And BrowserFucntion_I call the get with url "https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.html" then it should open the page
    When BrowserFucnton_I call the quit method the browser will close

  Scenario: Browser Function Back, Forward and Refresh
    And BrowserFucntion_I call the get with url "https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.html" then it should open the page
    And BrowserFucntion_I call the get with url "https://www.google.com" then it should open the page
    Then BrowserFunction_I call the back api this should navigate back in the browser
    Then BrowserFunction_I call the forward api this should move forward in the browser
    Then BrowserFunction_I call the refresh api this should refresh the webpage
    When BrowserFucnton_I call the quit method the browser will close
    
 	Scenario: Browser Function Maximize browse window while launching
 	When BrowserFunction_I call the maximize metho
 	 When BrowserFucnton_I call the quit method the browser will close