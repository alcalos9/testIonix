# testIonix
A continuación se especifica el detalle de los servicios que contiene el proyecto:

## Servicios:
### put createUser: http://localhost:8888/user/createUser
    Request:
      {
          "name": "Peter Robert Ironman",
          "username": "pri",
          "email": "pruebaI@ctt.cl",
          "phone": 34567
      }
    Response OK:
      {
          "result": true,
          "message": "saved"
      }
### get allUser: http://localhost:8888/user/allUser
    Response:
      {
          "result": true,
          "message": "ok",
          "users": [
              {
                  "id": 3,
                  "name": "Peter Robert Ironman",
                  "username": "pri",
                  "email": "pruebaI@ctt.cl",
                  "phone": 34567
              }
          ]
      }
### get userByEmail: http://localhost:8888/user/userByEmail
  Request:

    {
      "email":"pruebaI@ctt.cl"
    }
  Response:
  
    {
      "result": true,
      "message": "ok",
      "users": [
          {
              "id": 1,
              "name": "Peter Robert Thor",
              "username": "prt",
              "email": "prueba@ctt.cl",
              "phone": 34567
          }
      ]
    }
### post cifrado: http://localhost:8888/cifrado?rut=1-9
  Response:
  
    {
      "responseCode": 0,
      "description": "OK",
      "elapsedTime": 290,
      "result": {
          "registerCount": 3
      }
    }
    
