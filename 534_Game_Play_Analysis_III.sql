select player_id, event_date, sum(games_played) as games_played_so_far from 
(select a.player_id, a.event_date, b.games_played
from Activity a
left join Activity b
on a.event_date >= b.event_date and a.player_id = b.player_id) c
group by player_id, event_date;