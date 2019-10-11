# Write your MySQL query statement below
select class from 
(select count(1) as cnt, class from 
 (select distinct student, class from courses) c
group by class) a
where cnt >= 5;