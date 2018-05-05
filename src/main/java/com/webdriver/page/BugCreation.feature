Feature: Create bug in bugzila application

Scenario: Bug Creation
	Given Bugzilla_I am at the Bugzilla home page
	Then Bugzilla_I click on File a bug link and navigate to login page
	Then Bugzilla_I log into the application and navigate to enter bug page
	Then Bugzilla_I click on testng link and navigate to bug detail page
	And Bugzilla_I provide the details as component as "Logging and results" version as "6.9.13.3" severity as "trivial" hardware as "All"
	And Bugzilla_I provide other details operating system as "Windows" summary as "Bug Summary" and description as "Test Description"
	And Bugzilla_I click on submit bug button
