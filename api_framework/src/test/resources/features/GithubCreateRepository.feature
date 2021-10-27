Feature: Scenarios to Create github repository
  I want to use this template for my feature file

	Scenario Outline: Create a public repository
		This scenario will create public repository of an organization with POST request
		
		Given Header "Authorization" has value "<auth>"
		And Request payload has values "<name>" and "<description>"
		When "POST" request is executed
		Then Verify status code is <expected_status_code>
		And Verify body contains "name" as "<name>" and "description" as "<description>"
		
#The number of rows of data in Examples represents the number of times the scenario will be executed	
#The type of variable determines if the "" has to be given when replacing in the step from Examples	
#comments which describe the tests data
# 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 - test token which does not have the create repo scope
#new comment
	Examples:
		|name|description|auth|expected_status_code|
		|framework_repository_one|This is a repository from framework|Bearer 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|201|		
		
	
	Scenario Outline: Create a public repository with invalid token
		This scenario will create public repository of an organization with POST request
		
		Given Header "Authorization" has value "<auth>"
		And Request payload has values "<name>" and "<description>"
		When "POST" request is executed
		Then Verify status code is <expected_status_code>
		
	Examples:
		|name|description|auth|expected_status_code|
		|framework_repository_two|This is a repository from framework|Bearer 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|403|
		|framework_repository_three|This is a repository from framework|Bearer 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|403|
		
		
		