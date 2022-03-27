create database otus_testing;

create table questions (
    id serial not null
  , text varchar(250) not null
  , constraint pk_questions primary key (id)  
);

create table answers (
    id serial not null
  , text varchar(250) not null  
  , is_correct varchar(1) not null
  , question_id serial not null
  , constraint pk_answers primary key (id)  
  , constraint fk_answers$question_id foreign key (question_id) references questions(id) 
);

create index idx_answers$question_id on answers(question_id);

insert into questions values 
	(1, 'В файл с каким расширением компилируется java-файл?'),
	(2, 'С помощью какой команды git можно получить полную копию удаленного репозитория?'),
	(3, 'Какой применяется цикл, когда не известно количество итераций?');

insert into answers(id, text, is_correct, question_id) values 
	(1, 'css', 'N', 1),
	(2, 'java', 'N', 1),
	(3, 'class', 'Y', 1),
	(4, 'exe', 'N', 1),
	(5, 'commit', 'N', 2),
	(6, 'push', 'N', 2),
	(7, 'clone', 'Y', 2),
	(8, 'copy', 'N', 2),
	(9, 'while', 'N', 3),
	(10, 'for', 'N', 3),
	(11, 'loop', 'Y', 3);

	
select a.question_id
     , q."text" as question
     , a.id as answer_id
     , a."text" as answer
     , a.is_correct  
  from answers a 
  join questions q on q.id = a.question_id;
  

