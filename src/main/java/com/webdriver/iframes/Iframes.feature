Feature: Working with Iframe

Background: Common step for the Scenario
	Given IFrame_I navigate to the webpage "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe"
	
	
Scenario: Click on the element presetn in Iframe
	When IFrame_I perform the click on the element presetn in iframe, then it should click
	And IFrame_I perform the click action on the home button
	When IFrame_I call the quit method the browser will close