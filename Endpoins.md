
	Get all clients :
    curl -X GET "http://localhost:8080/api/stakeholders/clients"

	Saving client:
	curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"address":"av park 621","industry":"fishing","contactEmail": "sea.jersey@jmail.com"}' -X POST http://localhost:8080/api/stakeholders/clients

    UPDATE client:
	curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"address":"av wall 111","industry":"mining","contactEmail": "gold.smith@jmail.com"}' -X PUT http://localhost:8080/api/stakeholders/clients/2

	Get client by id :
	curl -X GET "http://localhost:8080/api/stakeholders/clients/2"

    Delete client id :
    curl -X DELETE "http://localhost:8080/api/stakeholders/clients/2"





	Get all employees:
	curl -X GET "http://localhost:8080/api/stakeholders/employees"

	Saving employee:
    curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"position":"engineer","name":"Antony","surname":"Smith","contactEmail": "smth.ant@jmail.com"}' -X POST http://localhost:8080/api/stakeholders/employees

	UPDATE employee:
    curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"position":"engineer","name":"Andres","surname":"Garcia","contactEmail": "smth.bks@jmail.com"}' -X PUT http://localhost:8080/api/stakeholders/employees/1

    Get employee by id :
    curl -X GET "http://localhost:8080/api/stakeholders/employees/1"

    Delete employee by id :
    curl -X DELETE "http://localhost:8080/api/stakeholders/employees/1"

