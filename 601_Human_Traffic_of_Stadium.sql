select distinct a.* from 
stadium a 
inner join 
(select a.id
from stadium a
left join stadium b on a.id + 1 = b.id and b.people >= 100
left join stadium c on a.id + 2 = c.id and c.people >= 100
where b.visit_date is not null and c.visit_date is not null 
and a.people >= 100) s
on a.id = s.id
or s.id + 1 = a.id
or s.id + 2 = a.id