select b.Name from
(select CandidateId, count(1) as cnt from Vote
group by CandidateId
order by cnt desc
limit 1) a
inner join Candidate b on a.CandidateId = b.id

/*Note: limit x = fetch first x rows*/