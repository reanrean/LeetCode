select sum(tiv_2016) as tiv_2016
from insurance i
inner join 
(select tiv_2015
from insurance
group by tiv_2015
having count(1) > 1)a on a.tiv_2015 = i.tiv_2015
inner join
(select concat(lat,lon) as location, count(1)
from insurance
group by concat(lat,lon)
having count(1) = 1) b on b.location = concat(i.lat,i.lon)