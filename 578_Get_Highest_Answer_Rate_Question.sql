select question_id as survey_log from
(select 
case when action='answer' then 1 else 0 end as answer,
case when action='show' then 1 else 0 end as showa,
question_id
from survey_log) a
group by question_id
order by sum(answer)/sum(showa) desc
limit 1