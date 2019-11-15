select dept_name, 
case when b.dept_id is null then 0 else count end as student_number
from department a
left join
(select dept_id, count(1) as count from student 
group by dept_id) b
on a.dept_id = b.dept_id
order by student_number desc, dept_name