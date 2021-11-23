# ja-pineapple-app-back

This is a repository to save backend web application to manage inventory of fictional supermarket Pineapple which is developed as a challenge in Junior Achievment - IBM program

## Test and Build

```bash
mvn package
```

## Run locally
Before run locally, create a postgres database with info specified in file /resources/application-dev.properties, change /resources/application.properties "prod" key by "dev" key. Then you should be able to run app locally.
```bash
mvn spring-boot:run
```
API was published using Heroku on the next link https://ja-pineapple-app.herokuapp.com/

## Available endpoints

### Auth
Sign up endpoint and example

```bash
# Auth
POST /api/auth/signup # Sign up user
{
    "username": "John",
    "password": "123456",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": ["admin"]
}
```

Sign in endpoint and example

```bash
# Auth
POST /api/auth/signin # Login user
{
    "username": "John",
    "password": "123456"
}
```
### Forgot password
```bash
GET /api/users/{email} # Search a user by email and return user 
```

### User
```bash
GET /api/users/{IdUser} # Get a single 
PUT /api/users/{IdUser} # Update
DELETE /api/users/{IdUser} # Delete
GET /api/users # Get all
```


### Products
```bash
POST /api/product # Create
GET /api/product/{IdProduct} # Get a single 
PUT /api/product/{IdProduct} # Update
DELETE /api/product/{IdProduct} # Delete
GET /api/product # Get all
```
