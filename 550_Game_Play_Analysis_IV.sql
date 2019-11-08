select round(count(distinct a.player_id) / (select count(distinct player_id) from Activity c), 2) 
as fraction
from Activity a
inner join Activity b
on a.player_id = b.player_id and date_add(a.event_date, interval 1 day) = b.event_date
inner join (select player_id, min(event_date) as min_date from Activity group by player_id) c
on a.player_id = c.player_id and a.event_date = c.min_date