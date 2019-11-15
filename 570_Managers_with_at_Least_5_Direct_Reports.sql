select Name from
(select managerId 
from employee
group by managerId
having count(1) >= 5) a
inner join Employee b
on a.ManagerId = b.Id