Feature: Working with Iframe

Background: Common step for the Scenario
	Given IFrame_I navigate to the webpage "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe"
	
	
Scenario: Click on the element presetn in Iframe
	When IFrame_I perform the click on the element presetn in iframe, then it should click
	And IFrame_I perform the click action on the home button
	When IFrame_I call the quit method the browser will close
	
Scenario: Working with MultipleWindow 
	Given MultipleWindow_I open the web page "https://www.w3schools.com/js/js_popup.asp"
	Then MultipleWindow_I click on button and it will open the child browser window
	And MultipleWindow_I switch to child browser window and click on home button
	Then MultipleWindow_I click on the element present in parent window
	When IFrame_I call the quit method the browser will close