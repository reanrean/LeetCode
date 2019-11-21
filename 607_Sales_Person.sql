select name from salesperson where name not in
(select a.name
from salesperson a 
inner join orders b on a.sales_id = b.sales_id
inner join company c on b.com_id = c.com_id
where c.name = 'RED')

select s.name from salesperson s
left join 
    (select a.name
    from salesperson a 
    inner join orders b on a.sales_id = b.sales_id
    inner join company c on b.com_id = c.com_id
    where c.name = 'RED') b
    on s.name = b.name
where b.name is null
