select 
case when b.id is null and a.id % 2 > 0 then a.id
when a.id % 2 = 0 then a.id - 1
else a.id + 1 end as id, a.student
from 
seat a
left join seat b
on a.id = b.id-1
order by id;

select 
case when a.id = (select max(id) from seat) and a.id % 2 > 0 then a.id
when a.id % 2 = 0 then a.id - 1
else a.id + 1 end as id, a.student
from seat a
order by id;