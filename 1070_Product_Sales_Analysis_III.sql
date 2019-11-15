select a.product_id, first_year, quantity, price from
(select product_id, min(year) as first_year
from sales
group by product_id) a
left join sales b on a.product_id = b.product_id and a.first_year = b.year