create table students (
    id serial primary key,
    accept_date varchar(40),
    student_fio varchar(90),
    grants int,
    rating int,
    group_id serial,
    foreign key (group_id) references groups(id))