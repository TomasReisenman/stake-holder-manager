
	Obtener todos los titulares juridico:
    curl -X GET "http://localhost:8080/api/titular/juridico"

	Realizando POST titular juridico:
	curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"razonSocial":"tecnologo","foundationYear":"1990","cuit": "1111"}' -X POST http://localhost:8080/api/titular/juridico

    Realizando UPDATE titular juridico:
	curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"razonSocial":"Comercial","foundationYear":"1990","cuit": "44444"}' -X PUT http://localhost:8080/api/titular/juridico/2

	Obtener titular juridico por id :
	curl -X GET "http://localhost:8080/api/titular/juridico/2"

    Borrar titular juridico por id :
    curl -X DELETE "http://localhost:8080/api/titular/juridico/2"





	Obtener todos los titulares fisicos:
	curl -X GET "http://localhost:8080/api/titular/fisico"

	Realizando POST titular fisico:
    curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"dni":"45472","nombre":"Carlos","apellido":"Perez","cuit": "71717"}' -X POST http://localhost:8080/api/titular/fisico

	Realizando UPDATE titular fisico:
    curl -H 'Content-Type: application/json' -H 'Accept: application/json' -d '{"dni":"123897","nombre":"Andres","apellido":"Garcia","cuit": "434343"}' -X PUT http://localhost:8080/api/titular/fisico/1

    Obtener titular fisico por id :
    curl -X GET "http://localhost:8080/api/titular/fisico/1"

    Borrar titular fisico por id :
    curl -X DELETE "http://localhost:8080/api/titular/fisico/1"

