-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: newdb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `idClass` int NOT NULL,
  `classType` varchar(45) DEFAULT NULL,
  `classNumber` varchar(45) DEFAULT NULL,
  `classTitle` varchar(60) DEFAULT NULL,
  `Section` varchar(45) DEFAULT NULL,
  `Room` varchar(45) DEFAULT NULL,
  `Days` varchar(45) DEFAULT NULL,
  `classStartTime` varchar(45) DEFAULT NULL,
  `classEndTime` varchar(45) DEFAULT NULL,
  `classMaxSize` varchar(45) DEFAULT NULL,
  `CurrentSize` varchar(45) DEFAULT NULL,
  `Instructor_idInstructor` int NOT NULL,
  `Year` varchar(45) DEFAULT NULL,
  `Semester` varchar(45) DEFAULT NULL,
  `Credits` varchar(45) DEFAULT NULL,
  `Prerequisite1` varchar(45) DEFAULT NULL,
  `Prerequisite2` varchar(45) DEFAULT NULL,
  `Prerequisite3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClass`,`Instructor_idInstructor`),
  KEY `fk_Classe_Instructor_idx` (`Instructor_idInstructor`),
  CONSTRAINT `fk_Classe_Instructor` FOREIGN KEY (`Instructor_idInstructor`) REFERENCES `instructor` (`idInstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (25122,'CSC','471','Compiler Construction I','01-LEC','Alternative Instruction','Mo We','5:30PM','6:45PM','20','0',136,'2020','Fall','3','CSC 221','CSC 311','MAT 191'),(45993,'ANT','102','Ancient Civilizations','01-LEC','Alternative Instruction','Mo We','4:00PM','5:15PM','20','0',158,'2020','Fall','3',NULL,NULL,NULL),(46010,'CSC','600','Graduate Continuation Course','01-SUP','Alternative Instruction','TBA',NULL,NULL,'20','0',145,'2020','Fall','1',NULL,NULL,NULL),(46601,'ANT','100','Introduction to Cultural Anthropology','02-LEC','Alternative Instruction','Mo We','4:30AM','5:45AM','20','0',156,'2020','Fall','3',NULL,NULL,NULL),(46614,'ANT','101','Intro to Biological Anthro','02-LEC','Alternative Instruction','Fr','11:30AM','2:15PM','20','0',157,'2020','Fall','3',NULL,NULL,NULL),(46720,'AFS','205','Introduction to Hip Hop','01-LEC','Alternative Instruction','Mo We','10:00AM','11:15AM','20','0',160,'2020','Fall','3',NULL,NULL,NULL),(46731,'AFS','310','The African American Experience in the US','01-LEC','Alternative Instruction','Mo We','11:30AM','12:45PM','20','0',161,'2020','Fall','3',NULL,NULL,NULL),(46753,'APP','212','Introduction to Comparative Ethnic and Global Societies','01-LEC','Alternative Instruction','Fr','11:30AM','2:15PM','20','0',165,'2020','Fall','3',NULL,NULL,NULL),(46928,'MAT','191','Calculus I','01-DIS','Alternative Instruction','Mo We Fr','1:00PM','2:25PM','20','0',146,'2020','Fall','5',NULL,NULL,NULL),(46931,'MAT','193','Calculus II','01-DIS','Alternative Instruction','Mo We Fr','1:00PM','2:25PM','20','1',147,'2020','Fall','5','MAT 191',NULL,NULL),(46965,'MAT','271','Foundations Of Higher Math','02-DIS','Alternative Instruction','Mo We','5:30PM','6:45PM','20','0',148,'2020','Fall','3','MAT 193',NULL,NULL),(46967,'MAT','321','Probability and Statistics','01-DIS','Alternative Instruction','Tu Th','8:30AM','9:45AM','20','0',150,'2020','Fall','3','MAT 193','MAT 271',NULL),(47000,'MAT','281','Discrete Mathematics','01-DIS','Alternative Instruction','Tu Th','5:30PM','6:45PM','20','0',149,'2020','Fall','3','MAT 191','CSC 121',NULL),(47128,'BIO','103','General Biology Laboratory','01-LAB','Alternative Instruction','TBA','TBA','TBA','20','0',159,'2020','Fall','1',NULL,NULL,NULL),(47191,'CSC','101','Introduction to Computer Education ','01-LEC','Alternative Instruction 42','Tu Th','8:30AM','9:45AM','2','2',123,'2020','Fall','4',NULL,NULL,NULL),(47192,'CSC','101','Introduction to Computer Education','40-LEC','INTERNET','TBA','TBA','TBA','2','0',131,'2020','Fall','4',NULL,NULL,NULL),(47198,'CSC','111','Intro to Computers and Basic Programming ','01-LEC','Alternative Instruction 113','Tu Th','5:30PM','6:45PM','2','0',132,'2020','Fall','4',NULL,NULL,NULL),(47199,'CSC','111','Intro to Computers and Basic Programming ','02-LEC','Alternative Instruction 151','Mo We','10:00AM','11:15AM','2','0',123,'2020','Fall','4',NULL,NULL,NULL),(47210,'CSC','115','Introduction to Programming Concepts','01-LEC','Alternative Instruction 116','Mo We ','4:00PM','5:15PM','2','0',133,'2020','Fall','4',NULL,NULL,NULL),(47212,'CSC','115','Introduction to Programming Concepts','03-LEC','Alternative Instruction 151','Tu Th ','10:00AM','11:15AM','2','0',123,'2020','Fall','4',NULL,NULL,NULL),(47213,'CSC','115','Introduction to Programming Concepts ','04-LEC','Alternative Instruction 38','Tu Th ','1:00PM','2:15PM','2','0',134,'2020','Fall','4',NULL,NULL,NULL),(47219,'CSC','116','Introduction to Computer Hardware and Tools','01-LEC','Alternative Instruction 32','Fr','5:30PM','8:15PM','2','0',135,'2020','Fall','4',NULL,NULL,NULL),(47220,'CSC','116','Introduction to Computer Hardware and Tools','02-LEC','Alternative Instruction 32','Mo We','1:00PM','2:15PM','2','0',128,'2020','Fall','4',NULL,NULL,NULL),(47244,'CSC','121','Intro to Computer Science and Programming I','01-LEC','Alternative Instruction 163','Mo We','5:30PM','6:45PM','2','2',124,'2020','Fall','4',NULL,NULL,NULL),(47245,'CSC','121','Introduction to Computer Science and Programming I','02-ACT','Alternative Instruction','Mo We','5:30PM','6:45PM','20','0',125,'2020','Fall','4',NULL,NULL,NULL),(47256,'CSC','123','Introduction to Computer Science and Programming II','01-LEC','Alternative Instruction 117','Mo We','5:30PM','8:15PM','20','0',127,'2020','Fall','4','CSC 121',NULL,NULL),(47258,'CSC','123','Introduction to Computer Science and Programming II','03-LEC','Alternative Instruction','Tu Th','10:00AM','12:45PM','20','0',126,'2020','Fall','4','CSC 121',NULL,NULL),(47260,'CSC','123','Introduction to Computer Science and Programming II','05-LEC','Alternative Instruction','Sa','12:30PM','4:45PM','20','0',128,'2020','Fall','4','CSC 121',NULL,NULL),(47279,'HIS','355','American Civil Rights History','01-LEC','Alternative Instruction','Mo We','4:00PM','5:15PM','20','0',168,'2020','Fall','3','ENG 110',NULL,NULL),(47307,'BIO','340','Genetics','01-DIS','Alternative Instruction','Mo We','11:30AM','12:45PM','20','0',169,'2020','Fall','3','ENG 110',NULL,NULL),(47378,'ENG','110','Freshman Composition Accelerated','06-DIS','Alternative Instruction','Tu Th','8:30AM','9:45AM','20','0',153,'2020','Fall','3',NULL,NULL,NULL),(47514,'THE','120','Fundamentals Of Speech','01-SEM','Alternative Instruction','Mo We','7:00AM','8:15AM','20','0',154,'2020','Fall','3',NULL,NULL,NULL),(47572,'CHE','102','Chemistry For The Citizen','02-LEC','Alternative Instruction','Mo We','10:30AM','11:45AM','20','0',155,'2020','Fall','3',NULL,NULL,NULL),(47654,'ART','100','Looking At Art','02-LEC','Alternative Instruction','TBA','TBA','TBA','20','1',162,'2020','Fall','3',NULL,NULL,NULL),(47933,'PHI','101','Moral Problems','31-LEC','Alternative Instruction','Fr','11:30AM','12:45PM','20','0',163,'2020','Fall','3',NULL,NULL,NULL),(47939,'PHI','102','Humanity, Nature & God','32-LEC','Alternative Instruction','We','11:30AM','12:45PM','20','0',164,'2020','Fall','3',NULL,NULL,NULL),(48118,'PHY','130','General Physics I','02-DIS','Alternative Instruction','Mo We Fr','8:30AM','9:40AM','20','0',151,'2020','Fall','5','MAT 191',NULL,NULL),(48182,'PHY','132','General Physics II','04-DIS','Alternative Instruction','Mo We Fr','1:00PM','2:10PM','20','0',152,'2020','Fall','5','MAT 193','PHY 130',NULL),(48358,'CSC','221','Assembly Language and Introduction to Computer Organization','01-DIS','Alternative Instruction 116','Tu Th','2:30PM','3:45PM','20','1',129,'2020','Fall','3','CSC 121',NULL,NULL),(48359,'CSC','251','C Language Programming and Unix','01-DIS','Alternative Instruction 86','Mo We ','4:00PM','5:15PM','2','0',130,'2020','Fall','4','CSC 121',NULL,NULL),(48360,'CSC','255','Dynamic Web Programming','01-LEC','Alternative Instruction 116','Mo We','5:30PM','6:45PM','2','1',123,'2020','Fall','4',NULL,NULL,NULL),(48361,'CSC','255','Dynamic Web Programming','02-LEC','Alternative Instruction 116','Mo We','11:30AM','12:45PM','2','0',123,'2020','Fall','4',NULL,NULL,NULL),(48362,'CSC','281','Discrete Structures','01-LEC','Alternative Instruction 151','Tu Th','2:30PM','3:45PM','2','0',136,'2020','Fall','4','CSC 121','MAT 153',NULL),(48363,'CSC','300','Software Development','01-LEC','Alternative Instruction 116','Tu Th','4:00PM','5:15PM','2','0',127,'2020','Fall','4','CSC 213',NULL,NULL),(48364,'CSC','301','Computers And Society','01-DIS','Alternative Instruction 162 ','Tu Th ','7:00PM','8:15PM','2','2',137,'2020','Fall','4',NULL,NULL,NULL),(48369,'CSC','311','Data Structures','04-LEC','Alternative Instruction 69','Fr','11:30AM','2:15PM','20','1',138,'2020','Fall','3','CSC 123','MAT 281',NULL),(48370,'CSC','321','Programming Languages','01-LEC','Alternative Instruction 117','Tu Th','1:00PM','2:15PM','20','0',129,'2020','Fall','3','CSC 123',NULL,NULL),(48372,'CSC','331','Computer Organization','01-LEC','Alternative Instruction 66','Tu','7:00PM','9:45PM','20','0',139,'2020','Fall','3','CSC 221','MAT 281',NULL),(48373,'CSC','341','Operating Systems','01-LEC','Alternative Instruction 117','Mo We','4:00PM','5:15PM','20','0',140,'2020','Fall','3','CSC 311','CSC 331','MAT 321'),(48374,'CSC','401','Analysis Of Algorithms','01-LEC','Alternative Instruction','Mo','7:00PM','9:45PM','20','0',139,'2020','Fall','3','CSC 311',NULL,NULL),(48375,'CSC','411','Artificial Intelligence','01-LEC','Alternative Instruction','Sa','9:00AM','11:45PM','20','1',141,'2020','Fall','3','CSC 311','CSC 321',NULL),(48376,'CSC','451','Computer Networks','01-LEC','Alternative Instruction','Mo We','4:00PM','5:15PM','20','0',134,'2020','Fall','3','CSC 311','MAT 281',NULL),(48377,'CSC','453','Data Management','01-LEC','Alternative Instruction','Mo We','5:30PM','6:45PM','20','0',142,'2020','Fall','3','CSC 311',NULL,NULL),(48379,'CSC','481','Software Engineering','01-LEC','Alternative Instruction','Tu Th','5:30PM','6:45PM','20','0',140,'2020','Fall','3','CSC 301','CSC 311','CSC 321'),(48380,'CSC','492','Senior Design','01-LEC','Alternative Instruction','We','7:00PM','9:45PM','20','1',143,'2020','Fall','3','CSC 301','CSC 321','CSC 481'),(48382,'CSC','501','Design and Analysis Of Algorithms','01-LEC','Alternative Instruction','Mo','7:00PM','9:45PM','20','0',139,'2020','Fall','3','CSC 401',NULL,NULL),(48383,'CSC','511','Artificial Intelligence and Expert Systems','01-LEC','Alternative Instruction','Sa','12:00PM','2:45PM','20','0',141,'2020','Fall','3','CSC 411',NULL,NULL),(48384,'CSC','541','Advanced Operating Systems','01-LEC','Alternative Instruction','Th','7:00PM','9:45PM','20','0',143,'2020','Fall','3','CSC 341',NULL,NULL),(48385,'CSC','551','Data Communications and Computer Networks','01-LEC','Alternative Instruction','Mo We','4:00PM','5:15PM','20','0',134,'2020','Fall','3','CSC 451',NULL,NULL),(48387,'CSC','581','Advanced Software Engineering','01-LEC','Alternative Instruction','Tu Th','5:30PM','6:45PM','20','0',141,'2020','Fall','3','CSC 481',NULL,NULL),(48388,'CSC','582','Object-Oriented Analysis and Design','01-LEC','Alternative Instruction','Fr','5:30PM','8:15PM','20','0',140,'2020','Fall','3','CSC 481',NULL,NULL),(48389,'CSC','583','Software Engineering Processes ','01-LEC','Alternative Instruction','Tu','7:00PM','9:45PM','20','0',144,'2020','Fall','3','CSC 581',NULL,NULL),(48390,'CSC','590','Master Project','01-DIS','Alternative Instruction','Mo We','8:30AM','9:45AM','20','0',142,'2020','Fall','3',NULL,NULL,NULL),(48391,'CSC','599','Master Thesis','01-DIS','Alternative Instruction','Mo We','8:30AM','9:45AM','20','0',142,'2020','Fall','3',NULL,NULL,NULL),(48466,'GEO','100','Human Geography','01-LEC','Alternative Instruction','Mo We','1:00PM','2:15PM','20','0',166,'2020','Fall','3',NULL,NULL,NULL),(48700,'BUS','100','Entrepreneurship For Everyone','01-LEC','Alternative Instruction','TBA','TBA','TBA','20','0',167,'2020','Fall','3',NULL,NULL,NULL),(49196,'CSC','495','Selected Topics: Data Mining & Machine Learning','01-DIS','Alternative Instruction','We','7:00PM','9:45PM','20','0',144,'2020','Fall','3','CSC 311',NULL,NULL),(49197,'CSC','595','Special Topics in Computer Science ','01-LEC','Alternative Instruction','We','7:00PM','9:45PM','20','0',144,'2020','Fall','3',NULL,NULL,NULL),(49202,'CSC','115','Introduction to Programming Concepts','80-LEC','Alternative Instruction 152','Mo We ','2:30PM','3:45PM','2','0',133,'2020','Fall','4',NULL,NULL,NULL),(49399,'CSC','395','Sel Topics in Computer Science','41-LEC','Alternative Instruction','We','4:00PM','6:00PM','20','1',136,'2020','Fall','3',NULL,NULL,NULL),(49466,'CSC','401','Analysis Of Algorithms','02-LEC','Alternative Instruction','Sa','12:00PM','2:45PM','20','0',136,'2020','Fall','3','CSC 311',NULL,NULL),(49467,'CSC','501','Design and Analysis Of Algorithms','02-LEC','Alternative Instruction','Sa','12:00PM','2:45PM','20','0',136,'2020','Fall','3','CSC 401',NULL,NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cs_requirements`
--

DROP TABLE IF EXISTS `cs_requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cs_requirements` (
  `classType` varchar(9) DEFAULT NULL,
  `classNumber` varchar(9) DEFAULT NULL,
  `classTitle` varchar(99) DEFAULT NULL,
  `Credits` varchar(1) DEFAULT NULL,
  `Prerequisite1` varchar(36) DEFAULT NULL,
  `Prerequisite2` varchar(36) DEFAULT NULL,
  `Prerequisite3` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cs_requirements`
--

LOCK TABLES `cs_requirements` WRITE;
/*!40000 ALTER TABLE `cs_requirements` DISABLE KEYS */;
INSERT INTO `cs_requirements` VALUES ('CSC','331','Computer Organization','3',NULL,NULL,NULL),('CSC','321','Programming Languages','3',NULL,NULL,NULL),('CSC','311','Data Structures','3',NULL,NULL,NULL),('CSC','341','Operating Systems','3',NULL,NULL,NULL),('CSC','481','Software Engineering','3',NULL,NULL,NULL),('MATH','321','Probability and Statistics','3',NULL,NULL,NULL),('CSC','471','Compiler Construction I','3',NULL,NULL,NULL),('CSC','301','Computers And Society','3',NULL,NULL,NULL),('CSC','492','Senior Design','3',NULL,NULL,NULL),('CSC','401','Analysis Of Algorithms','3',NULL,NULL,NULL),('CSC','121','Introduction to Computer Science and Programming I','4',NULL,NULL,NULL),('MATH','281','Discrete Structures','3',NULL,NULL,NULL),('CSC','123','Introduction to Computer Science and Programming II','4',NULL,NULL,NULL),('CSC','221','Assembly Language and Introduction to Computer Organization','3',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cs_requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `idInstructor` int NOT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Room` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (123,'Jason','Halasa','JHalasa@toromail.csudh.edu','Alternate In 52','(313)333-3333'),(124,'Payman','Khani','PKhani@toromail.csud.edu','Alternate In 51','(000)000-0000'),(125,'Juan ','Leon','JLeon@toromail.csudh.edu','Alternate In 53','(111)111-1111'),(126,'Massound','Ghyamkhah','MGhyamkhah@toromail.csudh.edu','Alternate 54','(999)999-9999'),(127,'Howard','Rosenthal','HRosenthal@toromail.csudh.edu','Alternate 55','(888)888-8888'),(128,'William','Blankenship','WBlankenship@toromail.csudh.edu','Alternate 55','(123)123-4567'),(129,'Malcolm','McCullough','MMcCullough@toromail.csudh.edu','Alternate In 54','(999)999-9999'),(130,'Garrett','Poppe','GPoppe@toromail.csudh.edu','Alternate In 66','(999)999-9999'),(131,'Kamal','Amirheshmat','KAmirheshmat@toromail.csudh.edu','Alternate In 77','(999)999-9999'),(132,'Gerald','Fenwick','GFenwick@toromail.csudh.edu','Alternate In 21','(999)999-9999'),(133,'Brian','Smith','BSmith@toromail.csudh.edu','Alternate In 5','(999)999-9999'),(134,'Sanaz','Moosavi','SMoosavi@toromail.csudh.edu','Alternate In 88','(999)999-9999'),(135,'Jobert','Nombrado','JNombrado@toromail.csudh.edu',NULL,NULL),(136,'Liudong','Zuo','LZuo@toromail.csudh.edu',NULL,NULL),(137,'Marek','Suchenek','MSuchenek@toromail.csudh.edu',NULL,NULL),(138,'Ali','Jalooli','AJalooli@toromail.sudh.edu',NULL,NULL),(139,'Khondaker','Salehin','KSalehin@toromail.sudh.edu',NULL,NULL),(140,'Brad','Hollister','BHollister@toromail.sudh.edu',NULL,NULL),(141,'Roman','Tankelevich','RTankelevich@toromail.sudh.edu',NULL,NULL),(142,'Alireza','Izaddoost','AIzaddoost@toromail.sudh.edu',NULL,NULL),(143,'Amlan','Chatterjee','AChatterjee@toromail.sudh.edu',NULL,NULL),(144,'Jianchao','Han','JHan@toromail.sudh.edu',NULL,NULL),(145,'Mohsen','Beheshti','MBeheshti@toromail.sudh.edu',NULL,NULL),(146,'Cynthia','Sanchez Tapia','CTapia@toromail.sudh.edu',NULL,NULL),(147,'Serban','Raianu','SRaianu@toromail.sudh.edu',NULL,NULL),(148,'Kristen','Rovira','KRovira@toromail.csudh.edu',NULL,NULL),(149,'Wai','Pong','WPong@toromail.csudh.edu',NULL,NULL),(150,'Yi','Wang','YWang@toromail.csudh.edu',NULL,NULL),(151,'Horace','Crogman','HCrogman@toromail.csudh.edu',NULL,NULL),(152,'James','Hill','JHill@toromail.csudh.edu',NULL,NULL),(153,'John','Rosewall','JRosewall@toromail.csudh.edu',NULL,NULL),(154,'Brian','Stevens','BStevens@toromail.csudh.edu',NULL,NULL),(155,'Kenneth','Rodriguez','KRodriguez@toromail.csudh.edu',NULL,NULL),(156,'Ambyr','Hardy','AHardy@toromail.csudh.edu',NULL,NULL),(157,'Alberto','Vigil Jr','AVigilJr@toromail.csudh.edu',NULL,NULL),(158,'Jerry','Moore','JMoore@toromail.csudh.edu',NULL,NULL),(159,'Stacy','Zamora','SZamora@toromail.csudh.edu',NULL,NULL),(160,'Judith','Fisher','JFisher@toromail.csudh.edu',NULL,NULL),(161,'Mali','Collins-White','MCollins-White@toromail.csudh.edu',NULL,NULL),(162,'Anglea','Lessing','ALessing@toromail.csudh.edu',NULL,NULL),(163,'Gwynn','Markle','GMarkle@toromail.csudh.edu',NULL,NULL),(164,'Jung','Kwon','JKwon@toromail.csudh.edu',NULL,NULL),(165,'Soo','Kim','SKim@toromail.csudh.edu',NULL,NULL),(166,'Tianjun','Lu','TLu@toromail.csudh.edu',NULL,NULL),(167,'Gary','Polk','GPolk@toromail.csudh.edu',NULL,NULL),(168,'Thomas','Alvarez','TAlvarez@toromail.csudh.edu',NULL,NULL),(169,'Yiwen','Fang','YFang@toromail.csudh.edu',NULL,NULL);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `studentID` int NOT NULL,
  `studentFirstName` varchar(45) DEFAULT NULL,
  `studentLastName` varchar(45) DEFAULT NULL,
  `studentEmail` varchar(45) DEFAULT NULL,
  `studentPhone` varchar(45) DEFAULT NULL,
  `studentPassword` varchar(45) DEFAULT NULL,
  `studentHandle` varchar(45) DEFAULT NULL,
  `studentAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (11111,'First','Student','FStudent1@toromail.csudh.edu','(111)222-3333','password1','FStudent1','A NEW ADDRESS'),(22222,'Second','Student','SStudent1@toromail.csudh.edu','(000)000-0000','password1','SStudent1','1242 Real St Somewhere CA 90210'),(33333,'Third','Student','TStudent1@toromail.csudh.edu','(111)111-1212','password1','TStudent1','1345 Fake st. Los Angeles CA'),(44444,'Fourth','Student','FStudent2@toromail.csudh.edu','(123)123-1234','password1','FStudent2','123 real st'),(55555,'Eduardo','Santos','esantos26@toromail.csudh.edu','(310)710-5555','password1','esantos26',NULL);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_has_classes`
--

DROP TABLE IF EXISTS `students_has_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_has_classes` (
  `Students_idStudents` int NOT NULL,
  `Classe_idClasse` int NOT NULL,
  `Classe_Instructor_idInstructor` int NOT NULL,
  PRIMARY KEY (`Students_idStudents`,`Classe_idClasse`,`Classe_Instructor_idInstructor`),
  KEY `fk_Students_has_Classe_Classe1_idx` (`Classe_idClasse`,`Classe_Instructor_idInstructor`),
  KEY `fk_Students_has_Classe_Students1_idx` (`Students_idStudents`),
  CONSTRAINT `fk_Students_has_Classe_Classe1` FOREIGN KEY (`Classe_idClasse`, `Classe_Instructor_idInstructor`) REFERENCES `classes` (`idClass`, `Instructor_idInstructor`),
  CONSTRAINT `fk_Students_has_Classe_Students1` FOREIGN KEY (`Students_idStudents`) REFERENCES `students` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_has_classes`
--

LOCK TABLES `students_has_classes` WRITE;
/*!40000 ALTER TABLE `students_has_classes` DISABLE KEYS */;
INSERT INTO `students_has_classes` VALUES (11111,48360,123),(11111,48375,141),(11111,48380,143),(22222,48364,137),(22222,48369,138),(22222,49399,136),(33333,46931,147),(33333,48358,129),(44444,47244,124),(44444,47654,162);
/*!40000 ALTER TABLE `students_has_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_record_of_classes`
--

DROP TABLE IF EXISTS `students_record_of_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_record_of_classes` (
  `Students_idStudents` int NOT NULL,
  `Classe_idClasse` int NOT NULL,
  `Classe_Instructor_idInstructor` int NOT NULL,
  `Grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Students_idStudents`,`Classe_idClasse`,`Classe_Instructor_idInstructor`),
  KEY `fk_Students_has_Classe1_Classe1_idx` (`Classe_idClasse`,`Classe_Instructor_idInstructor`),
  KEY `fk_Students_has_Classe1_Students1_idx` (`Students_idStudents`),
  CONSTRAINT `fk_Students_has_Classe1_Classe1` FOREIGN KEY (`Classe_idClasse`, `Classe_Instructor_idInstructor`) REFERENCES `classes` (`idClass`, `Instructor_idInstructor`),
  CONSTRAINT `fk_Students_has_Classe1_Students1` FOREIGN KEY (`Students_idStudents`) REFERENCES `students` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_record_of_classes`
--

LOCK TABLES `students_record_of_classes` WRITE;
/*!40000 ALTER TABLE `students_record_of_classes` DISABLE KEYS */;
INSERT INTO `students_record_of_classes` VALUES (11111,25122,136,'A'),(11111,45993,158,'A'),(11111,46601,156,'A'),(11111,46614,157,'A'),(11111,46720,160,'A'),(11111,46731,161,'A'),(11111,46928,146,'A'),(11111,46931,147,'A'),(11111,46965,148,'A'),(11111,46967,150,'A'),(11111,47000,149,'A'),(11111,47128,159,'A'),(11111,47244,124,'A'),(11111,47256,127,'A'),(11111,47279,168,'A'),(11111,47307,169,'A'),(11111,47378,153,'A'),(11111,47514,154,'A'),(11111,47572,155,'A'),(11111,47933,163,'A'),(11111,47939,164,'A'),(11111,48118,151,'A'),(11111,48182,152,'A'),(11111,48358,129,'A'),(11111,48364,137,'A'),(11111,48369,138,'A'),(11111,48370,129,'A'),(11111,48372,139,'A'),(11111,48373,140,'W'),(11111,48374,139,'A'),(11111,48379,140,'A'),(11111,48466,166,'A'),(11111,48700,167,'A'),(11111,49399,136,'A'),(22222,45993,158,'B'),(22222,46601,156,'B'),(22222,46614,157,'B'),(22222,46720,160,'B'),(22222,46928,146,'B'),(22222,46931,147,'B'),(22222,46965,148,'B'),(22222,47000,149,'B'),(22222,47128,159,'B'),(22222,47244,124,'B'),(22222,47256,127,'B'),(22222,47378,153,'B'),(22222,47514,154,'B'),(22222,47572,155,'B'),(22222,47933,163,'B'),(22222,47939,164,'B'),(22222,48118,151,'B'),(22222,48182,152,'B'),(22222,48358,129,'B'),(22222,48360,123,'B'),(33333,45993,158,'B'),(33333,46601,156,'B'),(33333,46720,160,'B'),(33333,46928,146,'B'),(33333,47244,124,'B'),(33333,47256,127,'B'),(33333,47378,153,'B'),(33333,47514,154,'B'),(33333,47933,163,'B'),(33333,48118,151,'B'),(44444,46928,146,'W');
/*!40000 ALTER TABLE `students_record_of_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'newdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 17:44:17
