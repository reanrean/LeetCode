select min_date as install_dt, count(cnt) as installs, round(sum(cnt)/count(cnt), 2) as Day1_retention from 
(select 
m.min_date, 
case when c.event_date is null then 0 else 1 end as cnt
from
(select a.player_id, b.min_date
from Activity a
inner join (select player_id, min(event_date) as min_date from Activity group by player_id) b
on a.player_id = b.player_id and a.event_date = b.min_date) m
left join Activity c
on m.player_id = c.player_id and date_add(m.min_date, interval 1 day) = c.event_date) retention
group by min_date