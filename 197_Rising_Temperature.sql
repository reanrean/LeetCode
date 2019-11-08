select a.Id from 
Weather a
left join Weather b
on a.RecordDate = date_add(b.RecordDate, interval 1 day)
where a.Temperature > b.Temperature