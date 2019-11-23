select customer_id 
from sales a
inner join products b on a.product_id = b.product_id
where brand_name in ('Fort West','Golden')
group by customer_id having count(distinct brand_name) > 1
order by customer_id;

select customer_id from 
(select distinct customer_id, product_key from customer) a
group by customer_id
having count(1) >= (select count(1) from product)

MYSQL DICTIONARY/SYNTAX HELPER:
    LIMIT X: Restricts output to X number of rows
    DATEDIFF(date_1, date_2): Returns number of days between 2 dates
    CURRENT_DATE(): Returns current date
    DAY() / MONTH() / YEAR(): Returns that part of the date

select max can use order by and limit 1

select count(a....), count(b...)
from a, b

or 

select (
(select count(1) from a) / (select count(1) from b)
) as xxx;