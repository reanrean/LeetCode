delete from Person where Id not in 
(select id from (select min(Id) as id from Person group by Email) a)