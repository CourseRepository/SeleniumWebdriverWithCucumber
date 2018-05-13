Feature: Data Driven Testing 

Scenario: Data Driven using Data Table 
	Given DataDriven_I am at the Bugzilla home page 
	Then DataDriven_I click on File a bug link and navigate to login page 
	Then DataDriven_I log into the application and navigate to enter bug page 
	Then DataDriven_I click on testng link and navigate to bug detail page 
	And DataDriven_I provide the following information in the detail page 
		|Component|Version|Severity|Hardware|Operating|Summary|Description|
		|Logging and results|6.9.13.3|trivial|All|Windows|Bug Summary|Test Description|
		|Logging and results|6.9.13.3|trivial|All|Windows|Bug Summary|Test Description|
	And DataDriven_I click on submit bug button 
	And DataDriven_The title should contain "Bug Summary" 
	And DataDriven_I am at the summary page and I click the logout button 
	
	
Scenario: Data Driven using Excel file 
	Given DataDriven_I am at the Bugzilla home page 
	Then DataDriven_I click on File a bug link and navigate to login page 
	Then DataDriven_I log into the application and navigate to enter bug page 
	Then DataDriven_I click on testng link and navigate to bug detail page 
	And DataDriven_I provide the following information in the detail page from excel file "TestData.xlsx" 
	And DataDriven_I click on submit bug button 
	And DataDriven_The title should contain "Bug Summary" 
	And DataDriven_I am at the summary page and I click the logout button 
	
Scenario Outline: Data Driven using scenario outline
	Given DataDriven_I am at the Bugzilla home page 
	Then DataDriven_I click on File a bug link and navigate to login page 
	Then DataDriven_I log into the application and navigate to enter bug page 
	Then DataDriven_I click on testng link and navigate to bug detail page 
	And DataDriven_I provide the details as component as "<component>" version as "<version>" severity as "<severity>" hardware as "<hardware>" 
	And DataDriven_I provide other details operating system as "<operating>" summary as "<summary>" and description as "<description>" 
	And DataDriven_I click on submit bug button 
	And DataDriven_I title should contain "<title>" 
	And DataDriven_I am at the summary page and I click the logout button 
	
	Examples: 
		| component | version | severity |hardware|operating|summary|description|title|
		| Logging and results | 6.9.13.3 | trivial |All|Windows|Bug Summary one|Test Description one | Bug Summary one|
		| Groups of groups | 6.9.13.6 | critical |Macintosh|Linux|Bug Summary two|Test Description two | Bug Summary two|
		| Method Interceptors | 6.9.13.4 | normal |Other|Mac OS|Bug Summary three|Test Description three | Bug Summary three|