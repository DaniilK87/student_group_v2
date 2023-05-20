create table lessons (
    id serial primary key,
    date varchar(150),
    name varchar(150),
    teacher_id serial,
    group_id serial,
    foreign key (group_id) references groups(id),
    foreign key (teacher_id) references teachers(id))