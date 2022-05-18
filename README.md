# News Api

#### By **[JOSEPH MAINA](https://github.com/JOSEPHMAINA1995)**

## Description

This is an API for querying and retrieving news and information. It contains news/articles/posts that are available to all employees without navigating into any department, and others that are housed/classified within departments. To Post and Get all the detils we are using postman application.

## Setup/Installation Requirements

- Make sure you have stable internet connection- Wifi or Cellular. Connect using your Mobile phone or Computer.
- To access the application, form the repository by clicking the form button. Go ahead to clone it on your local machine.
- use git clone command followed by the link: 
* git clone https://github.com/JOSEPHMAINA1995/News-API.git
- After succesfully cloning, open the application on Intellij
- Downlaod postman **[postman(https://www.postman.com/downloads/)** follow the instructions given on the site.

## Database Set Up
 
 * Type in psql
* CREATE DATABASE newsapi;
* \c newsapi;

* CREATE TABLE users(
 id serial PRIMARY KEY,
 name varchar,
 position varchar,
 departmentid int,
 role varchar
 );

* CREATE TABLE generalnews(
id serial PRIMARY KEY,
 title varchar,
 content varchar,
 departmentid int
 );
*  CREATE TABLE departmentnews(
 did serial PRIMARY KEY,
  title varchar,
  content varchar,
  departmentid int
  );

* CREATE TABLE departments(
id serial PRIMARY KEY,
name varchar,
description varchar,
employees varchar
);
* CREATE TABLE user_department(
id SERIAL PRIMARY KEY,
userid int,
departmentid int
);

* CREATE DATABASE newsapi_test WITH TEMPLATE newsapi;

## Contribution
You may also want to contribute to enhance a functionality:
* Fork the repository to your github account
* Create a new branch (git switch -c ft-development)
* Make the changes you intend
* Add changes to reflect the changes made
* Commit your changes (git commit -m 'additional info')
* Push to the branch (git push origin ft-develop)
* Create a Pull Request.


## Behavior Driven Development(BDD)

The user is able to.

* Open the Application on InteliJ IDE (most preffered).

* Copy the routes provided ie post("/departments/new") and paste it on post man. Create the OBject. select body then raw. In the space provided add your object {
    "title":"james",
    "content":"male",
    "departmentid":10
}
Click on send to post the data.

* To retrieve the data. copy the get route, paset it on post man and send.

* Reapeat the same to all the routing provided.


## Technologies Used

* Java - source language.

* Gradle for dependency management and running tasks.

* Bootstrap.

* Maven

* Cascading Style Sheets.
 
### LiveLink 

N/A

### License


MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.<br>

Copyright (c) 2022 **[JOSEPH MAINA](https://github.com/JOSEPHMAINA1995)**
