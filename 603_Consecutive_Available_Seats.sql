select distinct a.seat_id
from cinema a
left join cinema b on a.seat_id + 1 = b.seat_id or a.seat_id - 1 = b.seat_id
where (a.free = 1 and b.free = 1)