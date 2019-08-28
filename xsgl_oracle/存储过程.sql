--------------------------------------------------------
--  文件已创建 - 星期二-十二月-11-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package FUN_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."FUN_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  function upordel_func(upordel_sql varchar2)
    return number; 
  function select_func(select_sql varchar2)
    return cursor0;
end fun_package; 

/
--------------------------------------------------------
--  DDL for Package COURSES_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."COURSES_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  procedure get_courses(col1 varchar2,val varchar2,rs out cursor0); 
end courses_package; 

/
--------------------------------------------------------
--  DDL for Package LOGIN_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."LOGIN_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  procedure login(num varchar2,pw varchar2,state out number,rs out cursor0,rs1 out cursor0,rs2 out cursor0);
  procedure tea_login(num varchar2,pw varchar2,state out number,rs out cursor0,rs1 out cursor0,rs2 out cursor0,rs3 out cursor0,rs4 out cursor0);
end login_package;

/
--------------------------------------------------------
--  DDL for Package SCORE_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."SCORE_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  procedure get_score(col1 varchar2,val varchar2,val1 varchar2,rs out cursor0); 
end score_package; 

/
--------------------------------------------------------
--  DDL for Package STUDENT_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."STUDENT_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  procedure get_student(col1 varchar2,val varchar2,rs out cursor0); 
end student_package; 

/
--------------------------------------------------------
--  DDL for Package TEACHER_PACKAGE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "C##SCOTT"."TEACHER_PACKAGE" 
as 
  type cursor0 is ref cursor; 
  procedure get_teacher(col1 varchar2,val varchar2,rs out cursor0); 
end teacher_package; 

/
