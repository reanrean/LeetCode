select customer_id
from 
(select distinct customer_id, product_key from customer) a
group by customer_id
having count(1) >= (select count(1) from product)