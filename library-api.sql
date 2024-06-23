CREATE DATABASE  IF NOT EXISTS `library-api` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library-api`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: library-api
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `authors_s`
--

DROP TABLE IF EXISTS `authors_s`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors_s` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors_s`
--

LOCK TABLES `authors_s` WRITE;
/*!40000 ALTER TABLE `authors_s` DISABLE KEYS */;
INSERT INTO `authors_s` VALUES (6);
/*!40000 ALTER TABLE `authors_s` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_s`
--

DROP TABLE IF EXISTS `book_s`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_s` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_s`
--

LOCK TABLES `book_s` WRITE;
/*!40000 ALTER TABLE `book_s` DISABLE KEYS */;
INSERT INTO `book_s` VALUES (7);
/*!40000 ALTER TABLE `book_s` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_author`
--

DROP TABLE IF EXISTS `tbl_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_author`
--

LOCK TABLES `tbl_author` WRITE;
/*!40000 ALTER TABLE `tbl_author` DISABLE KEYS */;
INSERT INTO `tbl_author` VALUES (49,0,'2024-06-23 14:14:09.180000',NULL,'H.M','Kudaligama'),(50,0,'2024-06-23 14:14:09.183000',NULL,'Ediriweera','Sarachchandra'),(51,1,'2024-06-23 14:23:06.890000','2024-06-23 14:39:42.391000','T.B','Ilangarathne'),(52,1,'2024-06-23 14:35:39.638000','2024-06-23 14:40:53.514000','Mahagma','Sekara'),(53,0,'2024-06-23 14:40:17.133000',NULL,'Sugathapala','de Silva'),(54,0,'2024-06-23 14:41:35.895000',NULL,'Siri','Gunasinhe'),(55,0,'2024-06-23 14:47:42.069000',NULL,'Martin','Wickramasinghe');
/*!40000 ALTER TABLE `tbl_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book`
--

DROP TABLE IF EXISTS `tbl_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_book` (
  `author_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `version` int DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4cpsvhxp2cncfwwk948u4cvm6` (`isbn`),
  KEY `FK9x0bchwcr7nym8ydc4gt3nyy1` (`author_id`),
  CONSTRAINT `FK9x0bchwcr7nym8ydc4gt3nyy1` FOREIGN KEY (`author_id`) REFERENCES `tbl_author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book`
--

LOCK TABLES `tbl_book` WRITE;
/*!40000 ALTER TABLE `tbl_book` DISABLE KEYS */;
INSERT INTO `tbl_book` VALUES (50,55,0,'2024-06-23 14:37:24.823000',NULL,'333333','Heensaraya'),(49,56,0,'2024-06-23 14:38:29.657000',NULL,'33333346','Manikkawatha'),(49,57,0,'2024-06-23 14:44:53.991000',NULL,'1212','Madol doowa'),(49,59,0,'2024-06-23 14:47:07.729000',NULL,'12125','Yuganthaya'),(55,60,0,'2024-06-23 14:48:10.874000',NULL,'333335','Gamperaliya');
/*!40000 ALTER TABLE `tbl_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-23 14:49:26
