CREATE DATABASE newsapi;
\c newsapi;

CREATE TABLE users(
 id serial PRIMARY KEY,
 name varchar,
 position varchar,
 departmentid int,
 role varchar
 );

CREATE TABLE generalnews(
id serial PRIMARY KEY,
 title varchar,
 content varchar,
 departmentid int
 );
 CREATE TABLE departmentnews(
 did serial PRIMARY KEY,
  title varchar,
  content varchar,
  departmentid int
  );

CREATE TABLE departments(
name varchar,
description varchar,
employees varchar,
id serial PRIMARY KEY
);

CREATE DATABASE newsapi_test WITH TEMPLATE newsapi;