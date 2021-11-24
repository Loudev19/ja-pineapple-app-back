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
# Body request
{
    "username": "John",
    "password": "123456",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": ["admin"]
}

# Response
{
    "id": 1,
    "username": "John",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": [{id: 1, name: 'ADMIN_ROLE'}]
}
```

Sign in endpoint and example

```bash
# Auth
POST /api/auth/signin # Login user with username and password, then return the user with the access token
# Body request
{
    "username": "John",
    "password": "123456"
}

# Response
# Response
{
    "id": 1,
    "username": "John",
    "accessToken": "skjabskdjb",
    "typeToken": "Bearer",
    "role": [{id: 1, name: 'ADMIN_ROLE'}]
}
```
Forgot password endpoint which receive email and return the user
```bash
GET /api/auth/forgot_password/{email} # Search a user by email and return user 
# Response
{
    "id": 1,
    "username": "John",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": [{id: 1, name: 'ADMIN_ROLE'}]
}
```

Reset password endpoint which receive id and password to update user 
```bash
PUT /api/auth/reset_password/{id} # Search a user by email and return user 
# Body request
email@gmail.com
```

### User
```bash
GET /api/users/{IdUser} # Get a single
# Response
{
    "id": 1,
    "username": "John",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": [{id: 1, name: 'ADMIN_ROLE'}]
}

PUT /api/users/{IdUser} # Update
# Response
{
    "id": 1,
    "username": "John",
    "name": "John",
    "surname": "Doe",
    "email": "john@gmail.com",
    "role": [{id: 1, name: 'ADMIN_ROLE'}]
}

DELETE /api/users/{IdUser} # Delete

GET /api/users # Get all
# Response
[
    {
        "id": 1,
        "username": "John",
        "name": "John",
        "surname": "Doe",
        "email": "john@gmail.com",
        "role": [{id: 1, name: 'ADMIN_ROLE'}]
    }
]
```


### Products
```bash
POST /api/product # Create

# Body request
{
    "name": "Coca Cola",
    "description": "Bebida gasificada",
    "category": "Bebidas",
    "quantity": 10,
    "unitPrice": 5.8,
}

# Response
{
    "id": 1,    
    "name": "Coca Cola",
    "description": "Bebida gasificada",
    "category": "Bebidas",
    "quantity": 10,
    "unitPrice": 5.8,
}

GET /api/product/{IdProduct} # Get a single 
# Response
{
    "id": 1,    
    "name": "Coca Cola",
    "description": "Bebida gasificada",
    "category": "Bebidas",
    "quantity": 10,
    "unitPrice": 5.8,
}

PUT /api/product/{IdProduct} # Update
# Response
{
    "id": 1,    
    "name": "Coca Cola",
    "description": "Bebida gasificada",
    "category": "Bebidas",
    "quantity": 10,
    "unitPrice": 5.8,
}

DELETE /api/product/{IdProduct} # Delete

GET /api/product # Get all
# Response
[
{
    "id": 1,    
    "name": "Coca Cola",
    "description": "Bebida gasificada",
    "category": "Bebidas",
    "quantity": 10,
    "unitPrice": 5.8,
}
]
```
