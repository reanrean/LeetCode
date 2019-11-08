select a.player_id, a.device_id
from Activity a
inner join
(select player_id, min(event_date) as first_login
from Activity
group by player_id) b
on a.player_id = b.player_id
where a.event_date = b.first_login