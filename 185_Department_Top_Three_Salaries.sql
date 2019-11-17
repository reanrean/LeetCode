/*
This query is to get the rank of salary for each departmentid:

select a.salary, count(1), a.departmentid from 
employee a
left join (select distinct salary, departmentid from employee) b
on a.salary <= b.salary and a.departmentid = b.departmentid
group by a.id, a.departmentid

*/

select d.name as department, e.name as employee, rank.salary from
(select distinct a.salary, a.departmentid from 
employee a
left join (select distinct salary, departmentid from employee) b
on a.salary <= b.salary and a.departmentid = b.departmentid
group by a.id, a.departmentid
having count(1) <= 3) rank
inner join employee e on rank.salary = e.salary and rank.departmentid = e.departmentid
inner join department d on rank.departmentid = d.id

/*note: select distinct to remove duplicates!*/