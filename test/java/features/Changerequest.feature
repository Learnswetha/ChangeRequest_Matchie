Feature: Change Request Management


Scenario: Get Change Request
When get Change Request
Then validate response code as 200

Scenario: Create Change Request
When create change request with String body '{"description": "added","short_description": "Value updated"}'
Then validate response code as 201

Scenario: Get changerequest with one query param
When get changerequest with queryparam "sysparm_fields" and "short_description,sys_id"
Then validate response code as 200

Scenario Outline: Create changerequest with Multiple File
When create changerequest with file "<fileName>"
Then validate response code as 201
Examples:
|fileName|
|changerequest1.json|


