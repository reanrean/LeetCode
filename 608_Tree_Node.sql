select id,
case when p_id is null then 'Root'
    when id in (
        select a.id
        from tree a 
        left join tree b on a.id = b.p_id
        where b.id is null) then 'Leaf'
    else 'Inner' end as Type
from tree

/*Note: union is really faster!*/

    select id, 'Root' as Type
    from tree where p_id is null
union
    select a.id, 'Leaf' as Type
    from tree a left join tree b on a.id=b.p_id
    where b.id is null and a.p_id is not null
union
    select distinct a.id, 'Inner' as Type
    from tree a inner join tree b on a.id=b.p_id
    where a.p_id is not null
order by id