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
	
Scenario: Working with text box 
	When WebElementFunction_I call the send keys api with value "abc.com" it should type in the textbox 
	When WebElementFunction_I call the get text api it should return the text 
	When WebElementFunction_I call the clear api it should clear the text box 
	When WebElementFunction_I call the quit method the browser will close 
