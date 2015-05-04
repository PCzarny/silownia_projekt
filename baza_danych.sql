-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: silownia
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dimensions`
--

DROP TABLE IF EXISTS `dimensions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dimensions` (
  `DIMENSION_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'IMG_PATH JEST OPCJONALNE, MOZE ZAWIERAC ADRES DO ZDJECIA SYLWETKI Z ZAZNACZONYM WYMIAREM',
  `NAME` varchar(45) DEFAULT NULL,
  `UNIT` enum('kg','cm') DEFAULT NULL,
  PRIMARY KEY (`DIMENSION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dimensions`
--

LOCK TABLES `dimensions` WRITE;
/*!40000 ALTER TABLE `dimensions` DISABLE KEYS */;
INSERT INTO `dimensions` VALUES (1,'waga','kg'),(2,'wzrost','cm'),(3,'obwód pasa','cm'),(4,'',NULL);
/*!40000 ALTER TABLE `dimensions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercise` (
  `EXERCISE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `URL` varchar(45) DEFAULT NULL,
  `PERMISSION` tinyint(4) DEFAULT '0',
  `USER_USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`EXERCISE_ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`),
  KEY `fk_EXERCISE_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_EXERCISE_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'Wykroki w przód','Miesień czwórgłowy uda',NULL,0,1),(2,'Wykroki w bok','Mięsień czwórgłowy',NULL,0,2);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fittnes_club`
--

DROP TABLE IF EXISTS `fittnes_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fittnes_club` (
  `CLUB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `INFORMATION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CLUB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fittnes_club`
--

LOCK TABLES `fittnes_club` WRITE;
/*!40000 ALTER TABLE `fittnes_club` DISABLE KEYS */;
/*!40000 ALTER TABLE `fittnes_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `USER_USER_ID` int(11) NOT NULL,
  `FRIEND_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_USER_ID`,`FRIEND_ID`),
  KEY `fk_USER_has_USER_USER2_idx` (`FRIEND_ID`),
  KEY `fk_USER_has_USER_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_USER_has_USER_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_USER_USER2` FOREIGN KEY (`FRIEND_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal`
--

DROP TABLE IF EXISTS `meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal` (
  `MEAL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `KCAL` int(11) DEFAULT NULL COMMENT 'WARTOSCI ODZYWCZE NA 100G',
  `PROT` int(11) DEFAULT NULL,
  `CARB` int(11) DEFAULT NULL,
  `FAT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_day`
--

DROP TABLE IF EXISTS `meal_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_day` (
  `MEAL_DAY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MEAL_PLAN_MEAL_PLAN_ID` int(11) NOT NULL,
  `DAY_NR` int(11) DEFAULT NULL,
  PRIMARY KEY (`MEAL_DAY_ID`),
  KEY `fk_MEAL_DAY_MEAL_PLAN1_idx` (`MEAL_PLAN_MEAL_PLAN_ID`),
  CONSTRAINT `fk_MEAL_DAY_MEAL_PLAN1` FOREIGN KEY (`MEAL_PLAN_MEAL_PLAN_ID`) REFERENCES `meal_plan` (`MEAL_PLAN_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_day`
--

LOCK TABLES `meal_day` WRITE;
/*!40000 ALTER TABLE `meal_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_day_has_meal`
--

DROP TABLE IF EXISTS `meal_day_has_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_day_has_meal` (
  `MEAL_DAY_MEAL_DAY_ID` int(11) NOT NULL,
  `MEAL_MEAL_ID` int(11) NOT NULL,
  `TIME` datetime NOT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MEAL_DAY_MEAL_DAY_ID`,`MEAL_MEAL_ID`,`TIME`),
  KEY `fk_MEAL_DAY_has_MEAL_MEAL1_idx` (`MEAL_MEAL_ID`),
  KEY `fk_MEAL_DAY_has_MEAL_MEAL_DAY1_idx` (`MEAL_DAY_MEAL_DAY_ID`),
  CONSTRAINT `fk_MEAL_DAY_has_MEAL_MEAL1` FOREIGN KEY (`MEAL_MEAL_ID`) REFERENCES `meal` (`MEAL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MEAL_DAY_has_MEAL_MEAL_DAY1` FOREIGN KEY (`MEAL_DAY_MEAL_DAY_ID`) REFERENCES `meal_day` (`MEAL_DAY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_day_has_meal`
--

LOCK TABLES `meal_day_has_meal` WRITE;
/*!40000 ALTER TABLE `meal_day_has_meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_day_has_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_history`
--

DROP TABLE IF EXISTS `meal_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_history` (
  `MEAL_HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_USER_ID` int(11) NOT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`MEAL_HISTORY_ID`),
  KEY `fk_MEAL_HISTORY_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_MEAL_HISTORY_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_history`
--

LOCK TABLES `meal_history` WRITE;
/*!40000 ALTER TABLE `meal_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_history_has_meal`
--

DROP TABLE IF EXISTS `meal_history_has_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_history_has_meal` (
  `MEAL_HISTORY_MEAL_HISTORY_ID` int(11) NOT NULL,
  `MEAL_MEAL_ID` int(11) NOT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MEAL_HISTORY_MEAL_HISTORY_ID`,`MEAL_MEAL_ID`),
  KEY `fk_MEAL_HISTORY_has_MEAL_MEAL1_idx` (`MEAL_MEAL_ID`),
  KEY `fk_MEAL_HISTORY_has_MEAL_MEAL_HISTORY1_idx` (`MEAL_HISTORY_MEAL_HISTORY_ID`),
  CONSTRAINT `fk_MEAL_HISTORY_has_MEAL_MEAL1` FOREIGN KEY (`MEAL_MEAL_ID`) REFERENCES `meal` (`MEAL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_MEAL_HISTORY_has_MEAL_MEAL_HISTORY1` FOREIGN KEY (`MEAL_HISTORY_MEAL_HISTORY_ID`) REFERENCES `meal_history` (`MEAL_HISTORY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_history_has_meal`
--

LOCK TABLES `meal_history_has_meal` WRITE;
/*!40000 ALTER TABLE `meal_history_has_meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_history_has_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_plan`
--

DROP TABLE IF EXISTS `meal_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal_plan` (
  `MEAL_PLAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OWNER_USER_ID` int(11) NOT NULL,
  `PERIOD` int(11) NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`MEAL_PLAN_ID`),
  KEY `fk_MEAL_PLAN_USER1_idx` (`OWNER_USER_ID`),
  CONSTRAINT `fk_MEAL_PLAN_USER1` FOREIGN KEY (`OWNER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_plan`
--

LOCK TABLES `meal_plan` WRITE;
/*!40000 ALTER TABLE `meal_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_best`
--

DROP TABLE IF EXISTS `personal_best`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_best` (
  `USER_USER_ID` int(11) NOT NULL,
  `EXERCISE_EXERCISE_ID` int(11) NOT NULL,
  `VALUE` int(11) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_USER_ID`,`EXERCISE_EXERCISE_ID`),
  KEY `fk_USER_has_EXERCISE_EXERCISE1_idx` (`EXERCISE_EXERCISE_ID`),
  KEY `fk_USER_has_EXERCISE_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_USER_has_EXERCISE_EXERCISE1` FOREIGN KEY (`EXERCISE_EXERCISE_ID`) REFERENCES `exercise` (`EXERCISE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_EXERCISE_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_best`
--

LOCK TABLES `personal_best` WRITE;
/*!40000 ALTER TABLE `personal_best` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_best` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `POST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_USER_ID` int(11) NOT NULL,
  `POSTED_ON` datetime DEFAULT NULL,
  `CONTENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`POST_ID`),
  KEY `fk_POST_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_POST_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size_target`
--

DROP TABLE IF EXISTS `size_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size_target` (
  `SIZE_TARGET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIMENSIONS_DIMENSION_ID` int(11) NOT NULL,
  `USER_USER_ID` int(11) NOT NULL,
  `VALUE` int(11) NOT NULL,
  `DEADLINE` datetime DEFAULT NULL,
  PRIMARY KEY (`SIZE_TARGET_ID`),
  KEY `fk_SIZE_TARGET_DIMENSIONS1_idx` (`DIMENSIONS_DIMENSION_ID`),
  KEY `fk_SIZE_TARGET_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_SIZE_TARGET_DIMENSIONS1` FOREIGN KEY (`DIMENSIONS_DIMENSION_ID`) REFERENCES `dimensions` (`DIMENSION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SIZE_TARGET_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size_target`
--

LOCK TABLES `size_target` WRITE;
/*!40000 ALTER TABLE `size_target` DISABLE KEYS */;
INSERT INTO `size_target` VALUES (1,1,1,80,'2015-08-01 00:00:01'),(2,1,2,65,'2015-08-01 00:00:01');
/*!40000 ALTER TABLE `size_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_day`
--

DROP TABLE IF EXISTS `training_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_day` (
  `TRAINING_DAY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRAINING_PLAN_TRAINING_PLAN_ID` int(11) NOT NULL,
  `DAY_NR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TRAINING_DAY_ID`),
  KEY `fk_TRAINING_DAY_TRAINING_PLAN1_idx` (`TRAINING_PLAN_TRAINING_PLAN_ID`),
  CONSTRAINT `fk_TRAINING_DAY_TRAINING_PLAN1` FOREIGN KEY (`TRAINING_PLAN_TRAINING_PLAN_ID`) REFERENCES `training_plan` (`TRAINING_PLAN_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_day`
--

LOCK TABLES `training_day` WRITE;
/*!40000 ALTER TABLE `training_day` DISABLE KEYS */;
INSERT INTO `training_day` VALUES (1,1,'1'),(2,1,'2'),(3,1,'3');
/*!40000 ALTER TABLE `training_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_day_has_exercise`
--

DROP TABLE IF EXISTS `training_day_has_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_day_has_exercise` (
  `TRAINING_DAY_TRAINING_DAY_ID` int(11) NOT NULL,
  `EXERCISE_EXERCISE_ID` int(11) NOT NULL,
  `SERIES` int(11) DEFAULT NULL,
  `VALUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`TRAINING_DAY_TRAINING_DAY_ID`,`EXERCISE_EXERCISE_ID`),
  KEY `fk_TRAINING_DAY_has_EXERCISE_EXERCISE1_idx` (`EXERCISE_EXERCISE_ID`),
  KEY `fk_TRAINING_DAY_has_EXERCISE_TRAINING_DAY1_idx` (`TRAINING_DAY_TRAINING_DAY_ID`),
  CONSTRAINT `fk_TRAINING_DAY_has_EXERCISE_EXERCISE1` FOREIGN KEY (`EXERCISE_EXERCISE_ID`) REFERENCES `exercise` (`EXERCISE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRAINING_DAY_has_EXERCISE_TRAINING_DAY1` FOREIGN KEY (`TRAINING_DAY_TRAINING_DAY_ID`) REFERENCES `training_day` (`TRAINING_DAY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_day_has_exercise`
--

LOCK TABLES `training_day_has_exercise` WRITE;
/*!40000 ALTER TABLE `training_day_has_exercise` DISABLE KEYS */;
INSERT INTO `training_day_has_exercise` VALUES (1,1,3,10),(1,2,4,10),(2,2,2,20),(3,1,2,20),(3,2,2,12);
/*!40000 ALTER TABLE `training_day_has_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_history`
--

DROP TABLE IF EXISTS `training_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_history` (
  `TRAINING_HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_USER_ID` int(11) NOT NULL,
  `DONE_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`TRAINING_HISTORY_ID`),
  KEY `fk_TRAINING_HISTORY_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_TRAINING_HISTORY_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_history`
--

LOCK TABLES `training_history` WRITE;
/*!40000 ALTER TABLE `training_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_history_has_exercise`
--

DROP TABLE IF EXISTS `training_history_has_exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_history_has_exercise` (
  `TRAINING_HISTORY_TRAINING_HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EXERCISE_EXERCISE_ID` int(11) NOT NULL,
  `SERIES` int(11) DEFAULT NULL,
  `VALUE` int(11) DEFAULT NULL COMMENT 'TRZEBA SIE ZASTANOWIC, CZY MA BYC MOZLIWA ROZNA LICZBA POWTORZEN W POSZCZEGOLNYCH SERIACH',
  `DONE_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`TRAINING_HISTORY_TRAINING_HISTORY_ID`,`EXERCISE_EXERCISE_ID`),
  KEY `fk_TRAINING_HISTORY_has_EXERCISE_EXERCISE1_idx` (`EXERCISE_EXERCISE_ID`),
  KEY `fk_TRAINING_HISTORY_has_EXERCISE_TRAINING_HISTORY1_idx` (`TRAINING_HISTORY_TRAINING_HISTORY_ID`),
  CONSTRAINT `fk_TRAINING_HISTORY_has_EXERCISE_EXERCISE1` FOREIGN KEY (`EXERCISE_EXERCISE_ID`) REFERENCES `exercise` (`EXERCISE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRAINING_HISTORY_has_EXERCISE_TRAINING_HISTORY1` FOREIGN KEY (`TRAINING_HISTORY_TRAINING_HISTORY_ID`) REFERENCES `training_history` (`TRAINING_HISTORY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_history_has_exercise`
--

LOCK TABLES `training_history_has_exercise` WRITE;
/*!40000 ALTER TABLE `training_history_has_exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_history_has_exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_plan`
--

DROP TABLE IF EXISTS `training_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_plan` (
  `TRAINING_PLAN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OWNER_USER_ID` int(11) NOT NULL,
  `PERIOD` int(11) NOT NULL,
  PRIMARY KEY (`TRAINING_PLAN_ID`),
  KEY `fk_TRAINING_PLAN_USER1_idx` (`OWNER_USER_ID`,`PERIOD`),
  CONSTRAINT `fk_TRAINING_PLAN_USER1` FOREIGN KEY (`OWNER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_plan`
--

LOCK TABLES `training_plan` WRITE;
/*!40000 ALTER TABLE `training_plan` DISABLE KEYS */;
INSERT INTO `training_plan` VALUES (1,1,3);
/*!40000 ALTER TABLE `training_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_target`
--

DROP TABLE IF EXISTS `training_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_target` (
  `TARGET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EXERCISE_EXERCISE_ID` int(11) NOT NULL,
  `USER_USER_ID` int(11) NOT NULL,
  `VALUE` int(11) NOT NULL,
  `DEADLINE` datetime DEFAULT NULL,
  PRIMARY KEY (`TARGET_ID`),
  KEY `fk_TRAINING_TARGET_EXERCISE1_idx` (`EXERCISE_EXERCISE_ID`),
  KEY `fk_TRAINING_TARGET_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_TRAINING_TARGET_EXERCISE1` FOREIGN KEY (`EXERCISE_EXERCISE_ID`) REFERENCES `exercise` (`EXERCISE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_TRAINING_TARGET_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_target`
--

LOCK TABLES `training_target` WRITE;
/*!40000 ALTER TABLE `training_target` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45),
  `SURNAME` varchar(45),
  `LOGIN` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `create_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_LOGIN_UNIQUE` (`LOGIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Bartosz','Nikodem','barni','12345','b@gmail.com','2015-04-14 15:58:16'),(2,'Michał','Sztuka','traacert','12345','m@gmail.com','2015-04-14 16:01:35');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_dimensions`
--

DROP TABLE IF EXISTS `user_dimensions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_dimensions` (
  `USER_USER_ID` int(11) NOT NULL COMMENT 'MOZNA DOLOZYC KOLUMNY ZE STATUSEM, CZY JEST AKTUALNY - BOOL, TO MOZE ULATWIC WYSZUKIWANIE AKTUALNEJ WARTOSCI',
  `DIMENSIONS_DIMENSION_ID` int(11) NOT NULL,
  `CREATED_ON` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `VALUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_USER_ID`),
  KEY `fk_USER_has_DIMENSIONS_DIMENSIONS1_idx` (`DIMENSIONS_DIMENSION_ID`),
  KEY `fk_USER_has_DIMENSIONS_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_USER_has_DIMENSIONS_DIMENSIONS1` FOREIGN KEY (`DIMENSIONS_DIMENSION_ID`) REFERENCES `dimensions` (`DIMENSION_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_DIMENSIONS_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dimensions`
--

LOCK TABLES `user_dimensions` WRITE;
/*!40000 ALTER TABLE `user_dimensions` DISABLE KEYS */;
INSERT INTO `user_dimensions` VALUES (1,1,'2015-04-14 17:41:10',90),(2,1,'2015-04-14 17:42:15',70);
/*!40000 ALTER TABLE `user_dimensions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_fittnes_club`
--

DROP TABLE IF EXISTS `user_has_fittnes_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_fittnes_club` (
  `USER_USER_ID` int(11) NOT NULL,
  `FITTNES_CLUB_CLUB_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_USER_ID`,`FITTNES_CLUB_CLUB_ID`),
  KEY `fk_USER_has_FITTNES_CLUB_FITTNES_CLUB1_idx` (`FITTNES_CLUB_CLUB_ID`),
  KEY `fk_USER_has_FITTNES_CLUB_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_USER_has_FITTNES_CLUB_FITTNES_CLUB1` FOREIGN KEY (`FITTNES_CLUB_CLUB_ID`) REFERENCES `fittnes_club` (`CLUB_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_FITTNES_CLUB_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_fittnes_club`
--

LOCK TABLES `user_has_fittnes_club` WRITE;
/*!40000 ALTER TABLE `user_has_fittnes_club` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_fittnes_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_training_plan`
--

DROP TABLE IF EXISTS `user_has_training_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_training_plan` (
  `USER_USER_ID` int(11) NOT NULL,
  `TRAINING_PLAN_TRAINING_PLAN_ID` int(11) NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `CURRENT_DAY` int(11) NOT NULL DEFAULT '1',
  `IS_ACTIVE` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`USER_USER_ID`,`TRAINING_PLAN_TRAINING_PLAN_ID`),
  KEY `fk_USER_has_TRAINING_PLAN_TRAINING_PLAN1_idx` (`TRAINING_PLAN_TRAINING_PLAN_ID`),
  KEY `fk_USER_has_TRAINING_PLAN_USER1_idx` (`USER_USER_ID`),
  CONSTRAINT `fk_USER_has_TRAINING_PLAN_TRAINING_PLAN1` FOREIGN KEY (`TRAINING_PLAN_TRAINING_PLAN_ID`) REFERENCES `training_plan` (`TRAINING_PLAN_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_TRAINING_PLAN_USER1` FOREIGN KEY (`USER_USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_training_plan`
--

LOCK TABLES `user_has_training_plan` WRITE;
/*!40000 ALTER TABLE `user_has_training_plan` DISABLE KEYS */;
INSERT INTO `user_has_training_plan` VALUES (1,1,'2015-04-14 18:01:35',1,1);
/*!40000 ALTER TABLE `user_has_training_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-29 22:14:11
