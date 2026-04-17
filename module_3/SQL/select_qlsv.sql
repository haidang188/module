USE QuanLySinhVien;

SELECT * FROM Student;

SELECT * 
FROM Student 
WHERE Status = true;

SELECT * 
FROM Subject
WHERE Credit < 10;

SELECT S.StudentID, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassID = C.ClassID;

SELECT S.StudentID, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassID = C.ClassID
WHERE C.ClassName = 'A1';

SELECT S.StudentID, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentID = M.StudentID join Subject Sub on M.SubID = Sub.SubID;

SELECT S.StudentID, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentID = M.StudentID join Subject Sub on M.SubID = Sub.SubID
WHERE Sub.SubName = 'CF';



