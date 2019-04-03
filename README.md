# About App
It's a simple Java application that provide endpoints and serve the relevant information
based on Google Books data read from a JSON file (books.json).

# Building

To build the project use following command in the directory of the project:

`mvn install`

# Running
After building the application run following command to start it:

`mvn spring-boot:run`
// Application runs on port :8080 

# Access
After running application you can run endpoints:

- **For getting book data with that isbn number.** <br />
`curl -v http://localhost:8080/books/isbn/{isbn_number}` **- from command line**<br />
or<br />
http://localhost:8080/books/isbn/{isbn_number} **- from your web browser**

- **For getting list of books data having this category.**<br />
`curl -v http://localhost:8080/books/category/{category}`<br />
or<br />
http://localhost:8080/books/category/{category}

- **For getting list of authors and ratings.**<br />
`curl -v http://localhost:8080/books/rating`<br />
or<br />
http://localhost:8080/books/rating

### Tech

Technology stack for my application:

* **Spring Boot** - for application configuration.
* **JUnit5** - for testing.
* **Jackson** - working with JSON formats.
* **Maven** - configuration for building, testing and running the application.
* **Singleton** - use for VolumeObjectMapper.class because theres no need to create instance of this class more than once.
