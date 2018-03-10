Feature: Working with Java Script Popup

Background: Common step for the Scenario
	Given Alerts_I navigate to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert"
	
Scenario: Handling Alerts
	When Alerts_I click on try it button , it should show the alert
	And Alerts_I switch to alert and accept the alert
	Then Alerts_I switch to default content
	When Alerts_I call the quit method the browser will close
