CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      
      select
        case when (select count(1) from (select distinct Salary from Employee) b) < N then 
            null
        else
            min(Salary) 
        end
      from (
          select distinct Salary from Employee
          order by Salary desc
          limit N
      ) a
  );
END