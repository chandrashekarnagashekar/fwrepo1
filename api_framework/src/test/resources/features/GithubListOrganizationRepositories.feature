Feature: List the organization repositories
	Description of the feature.
	
	@listorg
	Scenario: List repositories of organization
		This scenario will list all the repositories of an organization with GET request
		
		Given Header "Authorization" has value "Bearer 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"
		When "GET" request is executed
		Then Verify status code is 200
		
	@listorg
	Scenario: List private repositories of organization
		This scenario will list all the private repositories of an organization with GET request
		
		Given Header "Authorization" has value "Bearer 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"
		And Query parameter "type" has value "private"
		When "GET" request is executed
		Then Verify status code is 400
		
	@listorg
	Scenario: List private repositories of organization with limit
		This scenario will list all the private repositories of an organization with GET request and per page limit
		
		Given Header "Authorization" has value "Bearer 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"
		And Query parameter "type" has value "private"
		And Query parameter "per_page" has value "2"
		And Query parameter "page" has value 3		
		When "GET" request is executed
		Then Verify status code is 200
		
		
		
		
		