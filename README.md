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

```bash
# Auth
POST /api/auth/signup # Sign up user
POST /api/auth/signin # Login user
```
