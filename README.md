# ja-pineapple-app-back

This is a repository to save backend web application to manage inventory of fictional supermarket Pineapple which is developed as a challenge in Junior Achievment - IBM program

## Test and Build

```bash
mvn package
```

## Run locally
Before run locally, create a mariadb database with info specified in file /resources/application.properties. You can follow the next tutorial [How to create mariadb user](https://phoenixnap.com/kb/how-to-create-mariadb-user-grant-privileges).
```bash
mvn spring-boot:run
```

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
