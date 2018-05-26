Feature: Web Element Functions 

Background: Common Step for Web Element Fucntion 
	Given WebElementFunction_I open the face book home page "https://www.facebook.com/" 
	
	
Scenario: Webelement Function for single element 
	When WebElementFunction_I provide the unique location to findelement api 
	Then WebElementFunction_I should get webelement 
	When WebElementFunction_I call the quit method the browser will close 
	
Scenario: Webelement Function for multiple elements 
	When WebElementFunction_I provide non unique locator 
	Then WebElemetFunction_It should return the list of web element 
	When WebElementFunction_I call the quit method the browser will close 

@regression	
Scenario: Working with text box 
	When WebElementFunction_I call the send keys api with value "abc.com" it should type in the textbox 
	When WebElementFunction_I call the get text api it should return the text 
	When WebElementFunction_I call the clear api it should clear the text box 
	When WebElementFunction_I call the quit method the browser will close 

@regression
Scenario: Working with Button,CheckBox Hyperlink and Radio Button
	When  WebElementFunction_I the click method on button it should perform the click action on button
	When WebElementFunction_I call the click method on radio button it should select the radio button
	When WebElementFunction_I call the click method on hyper link it shoulc click on the hyper link
	When WebElementFunction_I call the quit method the browser will close 
	
Scenario: Working with drop down - Combo box
	When WebElementFunction_I call select by visible text on dropdown it should select the value based on ui
	When WebElementFunction_I call select by index text on dropdown it should select the value based on index
	When WebElementFunction_I call select by value text on dropdown it should select the value based on value attribute in drop down
	When WebElementFunction_I call getOptions on dropdown it should list all the vlaue in dropdown
	When WebElementFunction_I call the quit method the browser will close 
	