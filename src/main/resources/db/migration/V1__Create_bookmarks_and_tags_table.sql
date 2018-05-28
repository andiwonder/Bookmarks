create table BOOKMARKS (
    ID SERIAL PRIMARY KEY ,
    title varchar(80) NOT NULL,
    description varchar(200) NOT NULL,
    url varchar(300)
);

create table TAGS (
    ID SERIAL primary key,
    type varchar(20) NOT NULL,
    bookmark_id integer REFERENCES bookmarks (id)
);

