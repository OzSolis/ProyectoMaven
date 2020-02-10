#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)	
#""
## (Comments)
#Sample Feature Definition Template
@test
Feature: Login Page
  As a user i should be able to login to the page.
  So i can buy the product
	
	@ignore
  @test1
  Scenario: The user should be able to login
    Given The user is in the login page
		When The user enter username as "test800@hotmail.com"
		And The user enter password as "test123"
		And The user click on sign in button
		Then The user sould be logged correctly
		
	@ignore
	@test2
	Scenario: User should not be able to log
	Given User in login
	When The user is "asasas@hotmail.com"
	And The password is "asasas"
	And Click on sign in
	Then The user shuld not be able to login
	
	@ignore
	@test3
	Scenario: Error message blank fields
	Given User try to log wo both fields
	When User is empty ""
	And Password is empty ""
	And Click button
	Then Error message displayed
	
	@ignore
	@test4
	Scenario: Error message blank user
	Given User try to log with blank user
	When User is blank ""
	And Password is "test123"
	And Click sign in
	Then Error blank user
	
	@ignore
	@test5
	Scenario: Error message blank password
	Given User try to log with blank password
	When User is "test800@hotmail.com"
	And Password is blank ""
	And Click sign-in
	Then Error blank password
	
	
	@practicaCompra
	Scenario: Realizar una compra
	Given The user go to login
	When Using user "test800@hotmail.com" and password "test123"
	And Click in women menu
	And Proceed to checkout
	Then Fin