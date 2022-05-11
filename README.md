# Sporty-Shoes
An e-Commerce site where users can shop for sporty shoes. Admin can login to manage the products in the store, including
categorizing them and can browse the list of users who have signed up and be able to search for users. Moreover, admin 
can see purchase reports filtered by date and category. Admin has the option to update the user details along with 
changing password of the user.

# Frameworks and Technologies used

1. Maven
2. Java
3. Spring Boot 
4. Spring Data JPA
5. HTML
6. CSS
7. PostgreSQL
8. Javascript
9. jQuery
10.DataTables
11.Bootstrap CSS and JS
12.XML
13.Git and Github
14.Agile Scrum Methodology

# Concepts and Algorithms used

1. Object-Oriented Programing - To Create objects and so on.
2. List, ArrayList - To store and access data easily.   
3. Streams - To make the code easy to read, and it reduces no.of lines.
4. Collections - To store and perform looping, searching, and sorting operations.

# Database and Structure

In the project root directory I've added a database.png image, in that you will find out the structure of the database.
Also, I've a provided database.sql file which contains the database, table creation and data that required to run
the program as well.

If you want to start from scratch without using the data in the database.sql file you can it, but you must create
a database and tables accordingly, then you can register yourself in the application by choosing the sign-up option. If you
sign-up using "prakashnaidupn7@gmail.com" you will get admin rights by default, if not you will be registered as regular user with
no special rights. I recommend registering using "prakashnaidupn7@gmail.com" email id with any data in other fields.

NOTE:

1. I'm using PostgreSQL database and, I've designed the database.sql file related to PostgreSQL database. Please
   make necessary changes if you are using different database.
2. Please make changes in application.yaml file in the root directory. It contains the database related configuration 
   like driver, url, username and, password, please do make changes in that file as well as per user database.

# Website roadmap

1. http://localhost:5555/                       ___ @Home page
2. http://localhost:5555/home                   ___ @Home page
3. http://localhost:5555/login                  ___ @Login page 
4. http://localhost:5555/user/sign-up           ___ @Sign-UP page
5. http://localhost:5555/user/all               ___ @To view list of all users
6. http://localhost:5555/user/view/1            ___ @To view detailed report of a particular user
7. http://localhost:5555/user/edit/2            ___ @To edit a particular user
8. http://localhost:5555/product/add            ___ @To add products
9. http://localhost:5555/product/all            ___ @To view list of all products
10. http://localhost:5555/product/view/2         ___ @To view and edit a particular product
11. http://localhost:5555/order/all              ___ @To view the list of all orders
12. http://localhost:5555/order/view/1           ___ @To view the detailed report of a particular order
13. http://localhost:5555/product/all/men       ___ @To view list of all Men shoes
14. http://localhost:5555/logout                ___ @To logout (It will be redirected to Home page after logout)
    
15. http://localhost:5555/product/all/men/running       ___ @To view list of all Men Running shoes
16. http://localhost:5555/product/all/men/hiking        ___ @To view list of all Men Hiking shoes
17. http://localhost:5555/product/all/men/workout       ___ @To view list of all Men Workout shoes
18. http://localhost:5555/product/all/women             ___ @To view list of all Women shoes
19. http://localhost:5555/product/all/men/running       ___ @To view list of all Women Running shoes
20. http://localhost:5555/product/all/men/hiking        ___ @To view list of all Women Hiking shoes
21. http://localhost:5555/product/all/men/workout       ___ @To view list of all Women Workout shoes
22. http://localhost:5555/product/all/kids              ___ @To view list of all Kids shoes
23. http://localhost:5555/product/all/brand             ___ @To view list of all Brand shoes
24. http://localhost:5555/product/all/brand/adidas      ___ @To view list of all Adidas Brand shoes
25. http://localhost:5555/product/all/brand/nike        ___ @To view list of all Nike Brand shoes
26. http://localhost:5555/product/all/brand/puma        ___ @To view list of all Puma Brand shoes
27. http://localhost:5555/product/all/brand/reebok      ___ @To view list of all Reebok Brand shoes
28. http://localhost:5555/product/view/Kids/Running/2   ___ @To view a particular product based on the type and brand
29. http://localhost:5555/product/buy/2                 ___ @To buy a particular product based on the product id

# Project Flow

Step - 1.0 : A welcome page will be shown to User, where user find all the possible options to choose.

Step - 1.1 : User will only be allowed to view Home page and Login page if user is not logged in.

Step - 1.2 : To view any page except home and login page user must log in.

Step - 1.3 : Based on the user role application will provide additional option if the user has admin rights.

Step - 1.4 : If you are not existing user, you will option to register yourself. By default you will get user rights.

Step - 2.0 : To log out user can click on logout button.

Step - 3.0 : Admin will get an option to view all the registered user.

Step - 3.1 : Admin has the rights to view the user details.

Step - 3.2 : Admin has the rights to update the user details along with the password.

Step - 3.3 : Admin has the rights to add products.

Step - 3.4 : Admin has the rights update the product details.

Step - 3.5 : Admin has the rights to view all the products available.

Step - 3.6 : Admin has the rights to view all the order list.

Step - 3.7 : Admin has the rights to view all the order details.

Step - 4.0 : Based on the links provided you can choose to view product.

Step - 4.1 : You can choose any product and buy it.
