Feature: Validating Place API's

Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
				Given Add Place Payload "<name>" "<language>" "<address>"
				When User calls "AddPlaceAPI" with Post http request
				Then the API call got success with status code 200
				And "status" in response body is "OK"
				And "scope" in response body is "APP"
				
Examples: 
				|name   |language|address|		
				|Arihant|English |Hupari |		