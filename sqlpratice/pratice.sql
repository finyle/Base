select t1.sname,t1.sid,t2.avgscore from student as t1 inner join (select sc.sid,avg(sc.score) as avgscore from sc group by sc.sid having avgscore > 60) as t2 on t1.sid = t2.sid;

select student.sid,student.sname,t1.coursesum,t1.sumscore from student inner join (select sc.sid,count(sc.cid) as coursesum, sum(sc.score) as sumscore from sc group by sc.sid) as t1 on student.sid = t1.sid;

select student.* from student where student.sid in (select DISTINCT sc.sid from sc);

select * from student where EXISTS(SELECT * FROM SC WHERE student.sid = sc.sid);

select * from teacher where teacher.Tname like '李%';

select student.* from student, sc where student.sid = sc.sid and sc.cid in (select cid from course, teacher where course.tid = teacher.tid and Tname = '张三');

select student.* from student, (select sid, count(cid) as coursecount from sc group by sid) as t1 where student.sid = t1.sid and
                                                                                                        t1.coursecount<>3;

select DISTINCT student.* from (select student.sid, course.cid from student,course) as t1 left join (select sc.sid, sc.cid from sc) as t2 on t1.sid = t2.sid and
                                                                                                                                                         t1.cid = t2.cid,student where t2.sid is null and t1.sid = student.sid;

select distinct student.* from sc,student where sc.cid in (select cid from sc where sid = '01') and sc.sid = student.sid;
select distinct student.* from sc,student where sc.cid in (select cid from sc where sid = '01') and sc.sid = student.sid;

select distinct student.* from (select student.sid,t.cid from student,(select sc.cid from sc where sc.sid='01') as t) as t1 left join sc on t1.sid = sc.sid and t1.cid=sc.cid,
                               student where sc.sid is not null and t1.sid = student.sid and t1.sid<>'01';

select distinct student.* from (select student.sid,t.cid from student, (select sc.cid from sc where sc.sid='01') as t) as t1 left join sc on t1.sid = sc.sid and t1.cid=sc.cid,student where sc.sid is not null
and t1.sid = student.sid and t1.sid <> '01';

select * from student where student.sid not in (select student.sid from(select student.sid,t.cid from (select course.cid from course,teacher where course.tid =
    teacher.tid and teacher.tname = '张三') as t, student) as t1 where t1.sid = student.sid);

select student.sid,student.sname,t2.avgscore
from student, (select sc.sid,avg(sc.score) as avgscore from sc group by sc.sid) as t2
where student.sid = t2.sid
  and student.sid in (select t1.sid from (select * from sc where sc.score < 60) as t1 group by t1.sid having count(*) >= 2);

select student.*, t1.score from student, (select * from sc where sc.cid = '01' and sc.score < 60 ) as t1 where student.sid = t1.sid order by t1.score desc

select sc.*,t1.avgscore from sc left join (select sc.sid, avg(sc.score) as avgscore from sc group by sc.sid) as t1 on sc.sid = t1.sid
order by t1.avgscore desc;

select sc.cid,max(sc.score) as '最高分', min(sc.score) as '最低分', avg(sc.score) as '平均分',
       count(*) as '选修人数', sum(case when sc.score >= 60 then 1 else 0 end) / count(*) as '及格率',
       sum(case when sc.score >= 70 and sc.score < 80 then 1 else 0 end) / count(*) as '中等率' from sc group by sc.cid;

select *, RANK() over(partition by sc.cid order by sc.score desc)排名 from sc;
SELECT *, RANK() OVER(PARTITION BY sc.cid ORDER BY sc.score DESC)排名
FROM sc;
SELECT *, DENSE_RANK() OVER(PARTITION BY sc.cid ORDER BY sc.score DESC)排名
FROM sc;


select sc.CId, sum(case when sc.score >=85 then 1 else 0 end) as num_100_85,
       sum(case when sc.score >=70 and sc.score <85 then 1 else 0 end) as num_85_70,
       sum(case when sc.score >= 60 and sc.score < 70 then 1 else 0 end) as num_70_60,
       sum(case when sc.score < 60 then 1 else 0 end) as num_60_0,
       sum(case when sc.score >=85 then 1 else 0 end)/count(*) as p_100_85,
       sum(case when sc.score >=70 and sc.score <85 then 1 else 0 end) /count(*) as p_85_70,
       sum(case when sc.score >= 60 and sc.score < 70 then 1 else 0 end)/count(*) as p_70_60,
       sum(case when sc.score < 60 then 1 else 0 end)/count(*) as p_60_0
from sc
group by sc.CId;

select * from (select *, rank() over (partition by sc.cid order by sc.score) as r from sc) as A where A.r <= 3;

SELECT *

FROM(

        SELECT *, RANK() OVER (PARTITION BY sc.CId ORDER BY sc.score) as r

        FROM sc) as A

WHERE A.r <= 3;

select sc.cid,count(*) from sc group by sc.cid;

select student.sname,student.sid from student, (select sc.sid, count(*) as a from sc group by (sc.sid)) as A where student.sid = A.sid and A.a = 2;

select ssex, COUNT(*) from student group by student.ssex;

select * from student where student.sname like '%风%';

select student.sid, student.sname,t.avgscore from student, (select sc.sid,avg(sc.score) as avgscore from sc group by sc.sid) as t 
where student.sid = t.sid and t.avgscore >= 85;

