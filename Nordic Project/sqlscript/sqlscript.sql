CREATE DATABASE  IF NOT EXISTS `nordic` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nordic`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: den1.mysql1.gear.host    Database: nordic
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `idBooking` int(11) NOT NULL AUTO_INCREMENT,
  `bookingDate` varchar(45) NOT NULL,
  `bookingEndDate` varchar(45) NOT NULL,
  `pickup` varchar(45) DEFAULT NULL,
  `dropoff` varchar(45) DEFAULT NULL,
  `customerPhone` int(11) NOT NULL,
  `idMotorhome` int(11) NOT NULL,
  PRIMARY KEY (`idBooking`),
  UNIQUE KEY `idBooking_UNIQUE` (`idBooking`),
  KEY `idCustomer_idx` (`customerPhone`),
  KEY `idMotorhome_idx` (`idMotorhome`),
  CONSTRAINT `customerPhone` FOREIGN KEY (`customerPhone`) REFERENCES `customers` (`customerPhone`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idMotorhome` FOREIGN KEY (`idMotorhome`) REFERENCES `motorhomes` (`idMotorhome`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (11,'2020-06-10','2020-07-10','Nada','Nada',29934417,16),(12,'2020-06-06','2020-07-06','','',42600216,15),(13,'2020-07-11','2020-08-22','Måløv','Måløv',88888888,16),(14,'2020-08-05','2020-08-15','','',29934417,14);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerPhone` int(11) NOT NULL AUTO_INCREMENT,
  `customerFname` varchar(45) NOT NULL,
  `customerLname` varchar(45) NOT NULL,
  `customerEmail` varchar(45) NOT NULL,
  PRIMARY KEY (`customerPhone`),
  UNIQUE KEY `customerEmail_UNIQUE` (`customerEmail`),
  UNIQUE KEY `idCustomer_UNIQUE` (`customerPhone`)
) ENGINE=InnoDB AUTO_INCREMENT=99445567 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (29934417,'Hans Christian','Leth-Nissen','harzz3k@gmail.com'),(42600216,'Benjamin','Holmen','benjiz1337@gmail.com'),(44664495,'Frederik','Rans','Frederik@gmail.com'),(88888888,'Jonas','Kabell','Dillerdrengen@gmail.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorhomes`
--

DROP TABLE IF EXISTS `motorhomes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorhomes` (
  `idMotorhome` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `size` int(255) NOT NULL,
  PRIMARY KEY (`idMotorhome`),
  UNIQUE KEY `idMotorhome_UNIQUE` (`idMotorhome`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorhomes`
--

LOCK TABLES `motorhomes` WRITE;
/*!40000 ALTER TABLE `motorhomes` DISABLE KEYS */;
INSERT INTO `motorhomes` VALUES (14,'Luksus','Eagle','X-300',4),(15,'Standard','Mnt-Blaster','400xl',4),(16,'Simple','Volk','YMCA',2);
/*!40000 ALTER TABLE `motorhomes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'nordic'
--

--
-- Dumping routines for database 'nordic'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-03 13:36:53
