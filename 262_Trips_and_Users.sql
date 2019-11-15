select Day, round(sum(status)/sum(count), 2) as "Cancellation Rate" from
(select 
case when status = 'completed' then 0 else 1 end as status,
1 as count,
request_at as Day
from trips a
left join users b on a.client_id = b.users_id
left join users c on a.driver_id = c.users_id
where b.banned = 'No' and c.banned = 'No'
and request_at between '2013-10-01' and '2013-10-03') s
group by Day

/*
Note: when calculating rates, convert them into 1 and 0 and directly calculating sum is a very good approach!
*/