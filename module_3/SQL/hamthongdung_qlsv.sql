USE QuanLySinhVien;

SELECT Address, COUNT(StudentID) AS 'So luong hoc vien'
FROM Student
GROUP BY Address;

SELECT 	S.StudentID, S.StudentName, AVG(Mark)
FROM Student S JOIN Mark M ON S.StudentID = M.StudentID
GROUP BY S.StudentID, S.StudentName;

SELECT S.StudentID, S.StudentName, AVG(Mark)
FROM Student S JOIN Mark M ON S.StudentID = M.StudentID
GROUP BY S.StudentID, S.StudentName
HAVING AVG(Mark) > 15;

SELECT S.StudentID, S.StudentName, AVG(Mark)
FROM Student S JOIN Mark M ON S.StudentID = M.StudentID
GROUP BY S.StudentID, S.StudentName;

SELECT S.StudentID, S.StudentName, AVG(Mark)
FROM Student S JOIN Mark M ON S.StudentID = M.StudentID
GROUP BY S.StudentID, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentID)
