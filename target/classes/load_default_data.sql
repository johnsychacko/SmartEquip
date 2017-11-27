
CREATE DATABASE  IF NOT EXISTS `SmartEquip`;
USE `SmartEquip`;

LOCK TABLES `tbl_question` WRITE;
insert ignore into tbl_question set questionId=1,question='Sum of 1 and 2 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=2,question='Sum of 2 and 4 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=3,question='Sum of 1 and 34 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=4,question='Sum of 8 and 2 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=5,question='Sum of 2, 4 and 9 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=6,question='Sum of 9 and 89 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=7,question='Sum of 90 and 43 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=8,question='Sum of 20 and 41 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=9,question='Sum of 23 and 49 is ?',insertTime=1511661674291;
insert ignore into tbl_question set questionId=10,question='Sum of 22 and 44 is ?',insertTime=1511661674291;
UNLOCK TABLES;

---------------------------------------------------------------------------------------------















