select name, bonus from
employee a
left join bonus b
on a.empId = b.empId
where bonus < 1000 or bonus is null;