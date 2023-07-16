create table if not exists student
(
    id varchar(36) not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255),
    date_of_birth date 
)