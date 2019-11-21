
/*
first, distinct scores self join and count to get the rank of scores (4.00 - 1, 3.85 -2 etc) - table c
then use scores to join with c to get the rank.
*/
select s.score as Score, c.cnt as Rank from 
Scores s left join
(select a.score, count(1) as cnt from
(select distinct score as score from scores) a
inner join (select distinct score as score from scores) b
on a.score <= b.score
group by a.score) c
on s.score = c.score
order by s.score desc

/*Note: simple? but run slower*/

SELECT score,(SELECT COUNT(DISTINCT score) FROM Scores where score > a.score) + 1 rank
from Scores a
ORDER by score DESC;