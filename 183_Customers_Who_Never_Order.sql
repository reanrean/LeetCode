select Name as Customers
from Customers a
left join (select distinct CustomerId as CustomerId from Orders) b
on a.Id = b.CustomerId
where b.CustomerId is null;
