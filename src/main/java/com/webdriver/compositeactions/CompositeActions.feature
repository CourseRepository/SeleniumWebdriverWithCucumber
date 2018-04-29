Feature: Working with Mouse and Keyboard actions

Background: Common step for the Scenario
	Given Actions_I navigate to the webpage "https://demos.telerik.com/kendo-ui/dragdrop/events"

Scenario: Working with context click
	When Actions_I create the composite action for context click
	Then Actions_I build the action
	And Actions_I perfomr the action
	And Actions_I take the screenshot
	When Actions_I call the quit method the browser will close
	
	
Scenario: Working with drang and drop action
 	When Actions_I create the composite action for drang and drop
 	Then Actions_I build the action
	And Actions_I perfomr the action
	When Actions_I call the quit method the browser will close
	
Scenario: Working with click and hold action
	When Actions_I create the composite action for click and hold
	Then Actions_I build the action
	And Actions_I perfomr the action
	When Actions_I call the quit method the browser will close
	
Scenario: Working with Keyboard action 
	# SHIFT + string
	When Actions_I create the composite action for keyboard
	Then Actions_I build the action
	And Actions_I perfomr the action
	When Actions_I call the quit method the browser will close
	