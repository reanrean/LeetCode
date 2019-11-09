select max(Salary) as SecondHighestSalary from 
    (select * from Employee a where a.Salary <> (select max(Salary) from Employee)) b;

/*solution on leetcode:*/
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary;

select max(Salary) as SecondHighestSalary
from Employee
where Salary < (select max(Salary) from Employee);