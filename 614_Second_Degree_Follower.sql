select followee as follower, count(1) as num
from 
(select distinct followee, follower from follow) a
group by followee
having followee in (select follower from follow)