select team_id, team_name,
case when host_points is null then 0 else host_points end
+
case when guest_points is null then 0 else guest_points end
as num_points
from teams a
left join 
(select host_team,
sum(case when host_goals > guest_goals then 3
    when host_goals = guest_goals then 1
    else 0 end) as host_points
from matches group by host_team) b
on a.team_id = b.host_team
left join 
(select guest_team,
sum(case when host_goals > guest_goals then 0
    when host_goals = guest_goals then 1
    else 3 end) as guest_points
from matches group by guest_team) c
on a.team_id = c.guest_team
order by num_points desc, team_id
