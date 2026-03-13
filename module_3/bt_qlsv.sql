USE QuanLySinhVien;

SELECT * 
FROM Student
WHERE StudentName LIKE 'H%';

SELECT * FROM Class
WHERE MONTH(StartDate) = 12;  

SELECT * FROM Subject
WHERE Credit >= 3 AND Credit <=5;


SELECT * 
FROM Student;

UPDATE Student
SET ClassID = 2
WHERE StudentID IN (1,2);

SELECT StudentName, SubName, Mark 
FROM Student
JOIN MARK ON Student.StudentID = Mark.StudentID
JOIN Subject ON Mark.SubID = Subject.SubID
ORDER BY Mark DESC, StudentName ASC;

