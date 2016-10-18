TP Desarrollo de Aplicaciones

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d070eef2c19f4eb29b4f3dafca93b6c3)](https://www.codacy.com/app/mauroeportillo/desapp-groupf-backend?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=meportillo/desapp-groupf-backend&amp;utm_campaign=Badge_Grade)


[![Build Status](https://travis-ci.org/meportillo/desapp-groupf-backend.svg?branch=master)](https://travis-ci.org/meportillo/desapp-groupf-backend)


HEROKU: https://desapp-groupf.herokuapp.com/

Mocks Pantallas Home-Busqueda de Eventos: https://moqups.com/mportillo@grupolpa.com/ssi8lToK/p:a13cd84ab


Ejemplo de google maps: https://desapp-groupf.herokuapp.com/mapExample.html

FrontEnd: https://github.com/Pablo-Avalos/desaapp-groupf-frontend/


API REST METODOS Y EJEMPLOS PARA CORRER EN FORMA LOCAL:

************************************PROFILE************************************
Post: 
CREATE
https://desapp-groupf.herokuapp.com/rest/profile/addprofile/mauro

header:
Content-Type: application/json
accept: application/json

dataExample:

{
"idProfile":null,
"musicalGeneres":null,
"moviegeneres":null,
"foodTastes":null,
"otherLikes":null,
"amountMax":0,
"conveyance":"Automovil",
"startTime":null,
"nik":"mauro"
}
---------------------------------------------------
PUT
UPDATE
https://desapp-groupf.herokuapp.com/rest/profile/updateprofile

header:
Content-Type: application/json
accept: application/json

{
"idProfile":3,
"musicalGeneres":null,
"moviegeneres":null,
"foodTastes":null,
"otherLikes":null,
"amountMax":0,
"conveyance":"A Pie",
"startTime":null,
"nik":"mauro"
}

---------------------------------------------------
List 
https://desapp-groupf.herokuapp.com/rest/profile/profiles
Delete
https://desapp-groupf.herokuapp.com/rest/profile/deleteProfile/1
get by ID
https://desapp-groupf.herokuapp.com/rest/profile/getprofile/2



************************************PROFILE************************************



************************************EVENT************************************
_________________________________________________________________________________
Create Event Food

https://desapp-groupf.herokuapp.com/rest/event/addfoodevent

header:
Content-Type: application/json
accept: application/json

example Data:
{"idEvent":null,"title":"test event","starTime":null,"endTime":null,"date":null,"description":null,"idsSuggestionsRelation":null,"price":null,"alone":null,"inTwosome":null,"inGruop":null,"typeFood":null}
__________________________________________________________________________________
Create Event MOVIE

https://desapp-groupf.herokuapp.com/rest/event/addmovieevent

header:
Content-Type: application/json
accept: application/json

example Data:
{"idEvent":null,"title":"test event","starTime":null,"endTime":null,"date":null,"description":null,"idsSuggestionsRelation":null,"price":null,"alone":null,"inTwosome":null,"inGruop":null,"genere":null}
__________________________________________________________________________________
Create Event MUSICAL

https://desapp-groupf.herokuapp.com/rest/event/addmusicalevent

headers:
Content-Type: application/json
accept: application/json

example data:
{"idEvent":null,"title":"test event","starTime":null,"endTime":null,"date":null,"description":null,"idsSuggestionsRelation":null,"price":null,"alone":null,"inTwosome":null,"inGruop":null, "gender":null}
___________________________________________________________________________________
Create Event Other


https://desapp-groupf.herokuapp.com/rest/event/addotherevent

headers:
Content-Type: application/json
accept: application/json

example data:
{"idEvent":null,"title":null,"starTime":null,"endTime":null,"date":null,"description":null,"idsSuggestionsRelation":null,"price":null,"alone":null,"inTwosome":null,"inGruop":null}___________________________________________________________________________________
LIST
GET
https://desapp-groupf.herokuapp.com/rest/event/events

DELETE
https://desapp-groupf.herokuapp.com/rest/event/deleteevent/ { algun id}

GET BY ID:

https://desapp-groupf.herokuapp.com/rest/event/getEvent/ { algun id}
************************************EVENT************************************



