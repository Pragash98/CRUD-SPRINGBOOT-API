# RESTFUL APIs USING SPRINGBOOT FOR CRUD OPERTAION

CRUD Operation built using SpringBoot + PostgresSQL

### Endpoints 
BASE-URL [http://localhost:8080/](http://localhost:8080/) 

### REST Service
|HTTP Method|URL|Description|
|---|---|---|
|`GET`|http://localhost:8080/api/students | Get All Student List |
|`GET`|http://localhost:8080/api/students/{id} | Get Student by ID |
|`POST`|http://localhost:8080/api/students | Create new Student |
|`PUT`|http://localhost:8080/api/students/{id} | Update Student by ID |
|`DELETE`|http://localhost:8080/api/students/{id} | Delete Student by ID |
|`GET`|http://localhost:8080/api/students?name="{value}"&classes="{value}" | Search Student with Name or class |


### Run COMMENT 
```
mvn spring-boot:run
```

