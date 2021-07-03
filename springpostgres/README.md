
## Spring Boot, Spring Security, PostgreSQL: JWT Authentication


### How it works:

## Technology
* Java 8
* Spring Boot 2.2.11 (with Spring Security, Spring Web, Spring Data JPA)
* jjwt 0.9.1
* PostgreSQL
* Maven 3.6.1

> Note: `--capt-add=SYS-ADMIN` User can signup new account, or login with username & password.
> By User’s role (admin, moderator, user), we authorize the User to access resources.


```sh
POST    /api/auth/signup   signup new account
POST    /api/auth/signin   login an account 
GET     /api/test/all      retrieve public content 
GET     /api/test/user     access User’s content 
GET     /api/test/mod      access Moderator’s content 
GET     /api/test/admin    access Admin’s contentt 
```


### security
security: we configure Spring Security & implement Security Objects here.

WebSecurityConfig extends WebSecurityConfigurerAdapter
UserDetailsServiceImpl implements UserDetailsService
UserDetailsImpl implements UserDetails
AuthEntryPointJwt implements AuthenticationEntryPoint
AuthTokenFilter extends OncePerRequestFilter
JwtUtils provides methods for generating, parsing, validating JWT

### controllers
controllers handle signup/login requests & authorized requests.

AuthController: @PostMapping(‘/signin’), @PostMapping(‘/signup’)
TestController: @GetMapping(‘/api/test/all’), @GetMapping(‘/api/test/[role]’)

### repository
repository has intefaces that extend Spring Data JPA JpaRepository to interact with PostgreSQL Database.

UserRepository extends JpaRepository<User, Long>
RoleRepository extends JpaRepository<Role, Long>

### models defines two main models for Authentication (User) & Authorization (Role). They have many-to-many relationship.

User: id, username, email, password, roles
Role: id, name
payload defines classes for Request and Response objects

We also have application.properties for configuring Spring Datasource, Spring Data JPA and App properties (such as JWT Secret string or Token expiration time).


##Run & Test
Run Spring Boot application with command: mvn spring-boot:run

Register some users with /signup API:

*	admin with ROLE_ADMIN
*	mod with ROLE_MODERATOR and ROLE_USER
*	zkoder with ROLE_USER


[By Bezkoder](https://bezkoder.com/spring-boot-vue-js-authentication-jwt-spring-security/)






