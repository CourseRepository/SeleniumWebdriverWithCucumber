@regression
Feature: Web driver wait fuction

Background: Common step for all the scenario
	Given WebdriverWaitFunction_I open the face book home page "https://www.facebook.com/"


# the wait duration will be constant
Scenario: Web driver wait - fixed wait 
		When WebdriverWaitFunction_I wait for "4000" , it should wait
		Then WebdriverWaitFunction_I click on login button
		When WebdriverWaitFunction_I call the quit method the browser will close 
		
		
Scenario: Web driver wait - Implicit wait
	When WebdriverWaitFunction_I set the implicit wait to "10" seconds, it should wait for element till 10 sec before throwing exception
	Then WebdriverWaitFunction_I click on login button
	And WebdriverWaitFunction_I send the "value" to the username text box
	When WebdriverWaitFunction_I call the quit method the browser will close 
	
Scenario: Web driver wait - Dynamic wait
	When WebdriverWaitFunction_I provide the dynamic wait with polling duration as 250 ms and timeout duration as 60 sec
	Then WebdriverWaitFunction_I click on login button
	And WebdriverWaitFunction_I send the "value" to the username text box
	When WebdriverWaitFunction_I call the quit method the browser will close 