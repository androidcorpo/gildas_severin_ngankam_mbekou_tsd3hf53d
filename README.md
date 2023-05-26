# Secured resful API
---

School Management System with SpringBoot and api secure wit jwt.


characteristics
---

* Spring Boot;
* Spring Security for jwt authentication;
* Thymeleaf as view Template Engine;
* H2 as Database;
* Get student list with customisation;

Run the application:
---
We assume that You already installed maven and JDK 8 (minimum) on your environment.
1. Clone the repository: `git clone https://github.com/androidcorpo/gildas_severin_ngankam_mbekou_tsd3hf53d.git`
2. Go to the folder: `cd gildas_severin_ngankam_mbekou_tsd3hf53d`
3. Run the app: `mvn clean spring-boot:run`
4. Open Your favorite API Client, then call enpoint with this base url http://localhost:8081

ENPOINTS
---

* retrieve jwt via post request;
 ```
 POST /token
  Content-Type: application/json
    {
        "username": "anywr",
        "password": "password"
    }
    
  output
    {
        "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbnl3ciIsImV4cCI6MTY4NTIzNDUxMCwiaWF0IjoxNjg1MTI2NTEwfQ.KStOMeFZWmGbOquKu8t0oIj0FAJtgFrePA0sLgd1BDbVl6pBnu_pxT9W3tlkZlc1UMBHvqC_PGU49-4snZEjhg"
    }
```
* get default students list some combination are using jwt :
 ``` 
 GET /students
 GET /students/v1?itemPerPage=10
 GET /students/v1?page=0&itemPerPage=10
 GET /students/v1?classRoomName=value1&teacherFullName=value2
 GET /students/v1?classRoomName=value1&teacherFullName=value2
 
 output template
     {
      "item": [],
      "size": 0,
      "pages": 0,
      "currentPage": 0
    }
    
 {
  "item": [
    {
      "classRoomName": "dGhkagq",
      "teacherFirstName": "DTr",
      "studentLastName": "Ydl",
      "studentFirstName": "Z",
      "teacherLastName": "n"
    },
    {
      "classRoomName": "rQSqA3N",
      "teacherFirstName": "9UmG",
      "studentLastName": "xtN",
      "studentFirstName": "o",
      "teacherLastName": "Ta"
    },
    {
      "classRoomName": "rQSqA3N",
      "teacherFirstName": "9UmG",
      "studentLastName": "9uRT",
      "studentFirstName": "dS",
      "teacherLastName": "Ta"
    },
    {
      "classRoomName": "rQSqA3N",
      "teacherFirstName": "9UmG",
      "studentLastName": "kEJDl",
      "studentFirstName": "DRB",
      "teacherLastName": "Ta"
    }
  ],
  "size": 28,
  "pages": 3,
  "currentPage": 0
}
```
## Screenshot


