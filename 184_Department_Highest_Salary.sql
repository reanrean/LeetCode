select b.Name as Department, c.Name as Employee, a.Salary
from 
(select DepartmentId, max(Salary) as Salary from Employee
 group by DepartmentId) a
left join Department b
on a.DepartmentId = b.Id
left join Employee c
on c.Salary = a.Salary and c.DepartmentId = a.DepartmentId
where b.Name is not null and c.Name is not null and a.Salary is not null
