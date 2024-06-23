# Library Management API
#### GET /books
 Returns paginate list of books in the database in JSON format.

####GET /book/{{id}}/
Returns a detailed view of the specified book id.
Nest author details in JSON format.

####GET /authors
Returns a list of authors in the database in JSON format.

####GET /author/{{id}}
Returns a detailed view of the specified author id

####POST /author
Creates a new author with the specified details.
Expects a JSON body.

####POST /book
Creates a new book with the specified details.
Expects a JSON body

####PUT /author/{{id}}
Updates an existing author.
Expects a JSON body.

####PUT /book/{{id}}
Updates an existing book.
Expects a JSON body.

### Technologies
_java 17_<br>
_mysql 8_<br>

### Framework and Libraries
_Spring boot 3.3.1_ <br>
_lombok_<br>
_hibernate 6_<br>
_spring 6.1_<br>
_spring aop 6.1_<br>
_spring data 6.1_<br>
_Junit 5.1_<br>
