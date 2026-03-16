USE QuanLySinhVien;

SELECT SubID, SubName, Credit
FROM Subject
GROUP BY SubID, SubName, Credit
HAVING credit >= ALL (SELECT Credit FROM Subject);


SELECT S.SubID, S.SubName, M.Mark
FROM Subject S JOIN Mark M ON S.SubID = M.SubID
GROUP BY S.SubID, S.SubName, M.Mark
HAVING M.Mark >= ALL (SELECT Mark FROM Mark);

SELECT Student.StudentID, Student.StudentName, AVG(Mark) AS AVGMark
FROM Student
JOIN Mark ON Student.StudentID = Mark.StudentID
GROUP BY Student.StudentID, Student.StudentName
ORDER BY AVGMark DESC;

