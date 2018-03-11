Feature: Working with Java Script Popup

Background: Common step for the Scenario
	Given Alerts_I navigate to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert"
	
Scenario: Handling Alerts
	When Alerts_I click on try it button , it should show the alert
	And Alerts_I switch to alert and accept the alert
	Then Alerts_I switch to default content
	When Alerts_I call the quit method the browser will close
	
Scenario: Working with confirmation popup
	Given Alerts_I open to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm"
	When Alerts_I click on try it button, it should open the confirmation popup
	And Alerts_I switch to popup and accept it
	When Alerts_I click on try it button, it should open the confirmation popup
	And Alerts_I switch to popup and cancel it
	Then Alerts_I switch to default content
	When Alerts_I call the quit method the browser will close
	
Scenario: Working with prompt
	Given Alerts_I open to the webpage "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
	When Alerts_I click on try it button, it should open the confirmation popup
	And Alerts_I provide string as "Sample Text"
	#And Alerts_I switch to popup and accept it
	When Alerts_I click on try it button, it should open the confirmation popup
	And Alerts_I get the string of the prompt
	And Alerts_I switch to popup and cancel it
	Then Alerts_I switch to default content
	When Alerts_I call the quit method the browser will close