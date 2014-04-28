CREATE DATABASE  IF NOT EXISTS `modular_prueba` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `modular_prueba`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: modular_prueba
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `identifier` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(5) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `dtCreation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dtLastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `idCompany` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `dtInvCreation` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dtInvExpiration` timestamp NULL DEFAULT NULL,
  `idObjectType` int(11) NOT NULL,
  `idObjectStatus` int(11) NOT NULL,
  PRIMARY KEY (`identifier`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_company_invoice_idx` (`idCompany`),
  KEY `fk_object_type_invoice_idx` (`idObjectType`),
  KEY `fk_object_status_invoice_idx` (`idObjectStatus`),
  KEY `fk_user_invoice_idx` (`idUser`),
  CONSTRAINT `fk_user_invoice` FOREIGN KEY (`idUser`) REFERENCES `user` (`identifier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_invoice` FOREIGN KEY (`idCompany`) REFERENCES `company` (`identifier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_object_status_invoice` FOREIGN KEY (`idObjectStatus`) REFERENCES `object_status` (`identifier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_object_type_invoice` FOREIGN KEY (`idObjectType`) REFERENCES `object_type` (`identifier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-26 23:14:12
