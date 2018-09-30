-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: cap_petroleum_dbms
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `actual_demurrage_cost_table`
--

DROP TABLE IF EXISTS `actual_demurrage_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actual_demurrage_cost_table` (
  `actual_demurrage_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `actual_demurrage_cost_product_id` int(11) NOT NULL,
  `actual_demurrage_cost_day` varchar(15) NOT NULL,
  `actual_demurrage_cost_date` int(11) NOT NULL,
  `actual_demurrage_cost_month` varchar(15) NOT NULL,
  `actual_demurrage_cost_year` int(11) NOT NULL,
  `actual_demurrage_cost_value` double NOT NULL,
  `actual_demurrage_cost_exchangerate` int(11) NOT NULL,
  `actual_demurrage_cost_waa_conversion_factor` int(11) NOT NULL,
  `actual_demurrage_cost_atr_small` int(11) NOT NULL,
  `actual_demurrage_cost_atr_big` int(11) NOT NULL,
  PRIMARY KEY (`actual_demurrage_cost_id`),
  KEY `FK_actual_demurrage_cost_product_id_idx` (`actual_demurrage_cost_product_id`),
  KEY `FK_actual_demurrage_cost_exchangerate_idx` (`actual_demurrage_cost_exchangerate`),
  KEY `FK_actual_demurrage_cost_waa_conversion_factor_idx` (`actual_demurrage_cost_waa_conversion_factor`),
  KEY `FK_actual_demurrage_cost_atr_small_idx` (`actual_demurrage_cost_atr_small`),
  KEY `FK_actual_demurrage_cost_atr_big_idx` (`actual_demurrage_cost_atr_big`),
  CONSTRAINT `FK_actual_demurrage_cost_atr_big` FOREIGN KEY (`actual_demurrage_cost_atr_big`) REFERENCES `df_vessel_cost_table` (`df_vessel_cost_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_actual_demurrage_cost_atr_small` FOREIGN KEY (`actual_demurrage_cost_atr_small`) REFERENCES `df_vessel_cost_table` (`df_vessel_cost_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_actual_demurrage_cost_exchangerate` FOREIGN KEY (`actual_demurrage_cost_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_actual_demurrage_cost_product_id` FOREIGN KEY (`actual_demurrage_cost_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_actual_demurrage_cost_waa_conversion_factor` FOREIGN KEY (`actual_demurrage_cost_waa_conversion_factor`) REFERENCES `waa_conversion_factor_table` (`waa_conversion_factor_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atr_big_vessel_table`
--

DROP TABLE IF EXISTS `atr_big_vessel_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atr_big_vessel_table` (
  `atr_big_vessel_id` int(11) NOT NULL AUTO_INCREMENT,
  `atr_big_vessel_product_id` int(11) NOT NULL,
  `atr_big_vessel_day` varchar(15) NOT NULL,
  `atr_big_vessel_date` int(11) NOT NULL,
  `atr_big_vessel_month` varchar(15) NOT NULL,
  `atr_big_vessel_year` int(11) NOT NULL,
  `atr_big_vessel_value` double NOT NULL,
  `atr_big_vessel_days_delayed` int(11) NOT NULL,
  `atr_big_vessel_delayed_cost` double NOT NULL,
  `atr_big_vessel_demurrage_value` double NOT NULL,
  `atr_big_vessel_volume` varchar(15) NOT NULL,
  PRIMARY KEY (`atr_big_vessel_id`),
  KEY `FK_atr_big_vessel_product_id_idx` (`atr_big_vessel_product_id`),
  CONSTRAINT `FK_atr_big_vessel_product_id` FOREIGN KEY (`atr_big_vessel_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atr_main_table`
--

DROP TABLE IF EXISTS `atr_main_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atr_main_table` (
  `atr_main_id` int(11) NOT NULL AUTO_INCREMENT,
  `atr_main_product_id` int(11) NOT NULL,
  `atr_main_day` varchar(15) NOT NULL,
  `atr_main_date` int(11) NOT NULL,
  `atr_main_month` varchar(15) NOT NULL,
  `atr_main_year` int(11) NOT NULL,
  `atr_main_value` double NOT NULL,
  `atr_small_vessel_value` int(11) NOT NULL,
  `atr_big_vessel_value` int(11) NOT NULL,
  PRIMARY KEY (`atr_main_id`),
  KEY `FK_atr_small_vessel_value_idx` (`atr_small_vessel_value`),
  KEY `FK_atr_big_vessel_value_idx` (`atr_big_vessel_value`),
  KEY `FK_atr_main_product_id_idx` (`atr_main_product_id`),
  CONSTRAINT `FK_atr_big_vessel_value` FOREIGN KEY (`atr_big_vessel_value`) REFERENCES `atr_big_vessel_table` (`atr_big_vessel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_atr_main_product_id` FOREIGN KEY (`atr_main_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_atr_small_vessel_value` FOREIGN KEY (`atr_small_vessel_value`) REFERENCES `atr_small_vessel_table` (`atr_small_vessel_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atr_small_vessel_table`
--

DROP TABLE IF EXISTS `atr_small_vessel_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atr_small_vessel_table` (
  `atr_small_vessel_id` int(11) NOT NULL AUTO_INCREMENT,
  `atr_small_vessel_product_id` int(11) NOT NULL,
  `atr_small_vessel_day` varchar(15) NOT NULL,
  `atr_small_vessel_date` int(11) NOT NULL,
  `atr_small_vessel_month` varchar(15) NOT NULL,
  `atr_small_vessel_year` int(11) NOT NULL,
  `atr_small_vessel_value` double NOT NULL,
  `atr_small_vessel_days_delayed` int(11) NOT NULL,
  `atr_small_vessel_delayed_cost` double NOT NULL,
  `atr_small_vessel_demurrage_value` double NOT NULL,
  `atr_small_vessel_volume` double NOT NULL,
  PRIMARY KEY (`atr_small_vessel_id`),
  KEY `FK_atr_small_vessel_product_id_idx` (`atr_small_vessel_product_id`),
  CONSTRAINT `FK_atr_small_vessel_product_id` FOREIGN KEY (`atr_small_vessel_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atr_vessel_cost_table`
--

DROP TABLE IF EXISTS `atr_vessel_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atr_vessel_cost_table` (
  `atr_vessel_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `atr_vessel_cost_product_id` int(11) NOT NULL,
  `atr_vessel_cost_day` varchar(15) NOT NULL,
  `atr_vessel_cost_date` int(11) NOT NULL,
  `atr_vessel_cost_month` varchar(15) NOT NULL,
  `atr_vessel_cost_year` int(11) NOT NULL,
  `atr_vessel_type` varchar(15) DEFAULT NULL,
  `atr_vessel_cost_value` double NOT NULL,
  PRIMARY KEY (`atr_vessel_cost_id`),
  KEY `FK_atr_vessel_cost_product_id_idx` (`atr_vessel_cost_product_id`),
  CONSTRAINT `FK_atr_vessel_cost_product_id` FOREIGN KEY (`atr_vessel_cost_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `charges_payableto_local_agencies_table`
--

DROP TABLE IF EXISTS `charges_payableto_local_agencies_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `charges_payableto_local_agencies_table` (
  `charges_payableto_local_agencies_id` int(11) NOT NULL AUTO_INCREMENT,
  `charges_payableto_local_agencies_product_id` int(11) NOT NULL,
  `charges_payableto_local_agencies_day` varchar(15) DEFAULT NULL,
  `charges_payableto_local_agencies_date` int(11) DEFAULT NULL,
  `charges_payableto_local_agencies_month` varchar(15) DEFAULT NULL,
  `charges_payableto_local_agencies_year` int(11) DEFAULT NULL,
  `charges_payableto_local_agencies_value` double DEFAULT NULL,
  PRIMARY KEY (`charges_payableto_local_agencies_id`),
  KEY `charges_payableto_local_agencies_product_id_idx` (`charges_payableto_local_agencies_product_id`),
  CONSTRAINT `charges_payableto_local_agencies_product_id` FOREIGN KEY (`charges_payableto_local_agencies_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cif_cost_dsm_table`
--

DROP TABLE IF EXISTS `cif_cost_dsm_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cif_cost_dsm_table` (
  `cif_cost_dsm_id` int(11) NOT NULL AUTO_INCREMENT,
  `cif_cost_dsm_product_id` int(11) NOT NULL,
  `cif_cost_dsm_day` varchar(15) NOT NULL,
  `cif_cost_dsm_date` int(11) NOT NULL,
  `cif_cost_dsm_month` varchar(15) NOT NULL,
  `cif_cost_dsm_year` int(11) NOT NULL,
  `cif_cost_dsm_value` double NOT NULL,
  `cif_cost_dsm_weighted_average_plat_fop` int(11) NOT NULL,
  `cif_cost_dsm_wa_premium_quatation` int(11) NOT NULL,
  PRIMARY KEY (`cif_cost_dsm_id`),
  KEY `FK_cif_cost_dsm_product_id_idx` (`cif_cost_dsm_product_id`),
  KEY `FK_cif_cost_dsm_wa_premium_quatation_idx` (`cif_cost_dsm_wa_premium_quatation`),
  KEY `FK_cif_cost_dsm_weighted_average_plat_fop_idx` (`cif_cost_dsm_weighted_average_plat_fop`),
  CONSTRAINT `FK_cif_cost_dsm_product_id` FOREIGN KEY (`cif_cost_dsm_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_cif_cost_dsm_wa_premium_quatation` FOREIGN KEY (`cif_cost_dsm_wa_premium_quatation`) REFERENCES `weighted_average_premium_quatation_table` (`weighted_average_premium_quatation_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_cif_cost_dsm_weighted_average_plat_fop` FOREIGN KEY (`cif_cost_dsm_weighted_average_plat_fop`) REFERENCES `weighted_average_platt_fob_table` (`weighted_average_platt_fob_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `computed_exchangerate_table`
--

DROP TABLE IF EXISTS `computed_exchangerate_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computed_exchangerate_table` (
  `com_exchangerate_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_exchangerate_day` varchar(15) NOT NULL,
  `com_exchangerate_date` int(11) NOT NULL,
  `com_exchangerate_month` varchar(15) NOT NULL,
  `com_exchangerate_year` int(11) NOT NULL,
  `com_exchangerate_value` double NOT NULL,
  PRIMARY KEY (`com_exchangerate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `custom_processing_fee_table`
--

DROP TABLE IF EXISTS `custom_processing_fee_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custom_processing_fee_table` (
  `custom_processing_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_processing_fee_product_id` int(11) NOT NULL,
  `custom_processing_fee_day` varchar(15) DEFAULT NULL,
  `custom_processing_fee_date` int(11) DEFAULT NULL,
  `custom_processing_fee_month` varchar(15) DEFAULT NULL,
  `custom_processing_fee_year` int(11) DEFAULT NULL,
  `custom_processing_fee_value` double DEFAULT NULL,
  PRIMARY KEY (`custom_processing_fee_id`),
  KEY `custom_processing_fee_product_id_idx` (`custom_processing_fee_product_id`),
  CONSTRAINT `custom_processing_fee_product_id` FOREIGN KEY (`custom_processing_fee_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `deliverly_charger_region_table`
--

DROP TABLE IF EXISTS `deliverly_charger_region_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverly_charger_region_table` (
  `deliverly_charger_region_id` int(11) NOT NULL AUTO_INCREMENT,
  `deliverly_charger_region` int(11) NOT NULL,
  `deliverly_charger_region_day` varchar(15) NOT NULL,
  `deliverly_charger_region_date` int(11) NOT NULL,
  `deliverly_charger_region_month` varchar(15) NOT NULL,
  `deliverly_charger_region_year` int(11) NOT NULL,
  `deliverly_charger_region_value` double NOT NULL,
  PRIMARY KEY (`deliverly_charger_region_id`),
  KEY `FK_deliverly_charger_region_id_idx` (`deliverly_charger_region`),
  CONSTRAINT `FK_deliverly_charger_region_id` FOREIGN KEY (`deliverly_charger_region`) REFERENCES `distance_dsm_to_region_table` (`distance_dsm_to_region_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `df_big_vessel_table`
--

DROP TABLE IF EXISTS `df_big_vessel_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `df_big_vessel_table` (
  `df_big_vessel_id` int(11) NOT NULL AUTO_INCREMENT,
  `df_big_vessel_product_id` int(11) NOT NULL,
  `df_big_vessel_day` varchar(15) NOT NULL,
  `df_big_vessel_date` int(11) NOT NULL,
  `df_big_vessel_month` varchar(15) NOT NULL,
  `df_big_vessel_year` int(11) NOT NULL,
  `df_big_vessel_value` double NOT NULL,
  `df_big_vessel_days_delayed` int(11) NOT NULL,
  `df_big_vessel_delayed_cost` double NOT NULL,
  `df_big_vessel_demurrage_value` double NOT NULL,
  `df_big_vessel_volume` varchar(15) NOT NULL,
  PRIMARY KEY (`df_big_vessel_id`),
  KEY `FK_df_big_vessel_product_id_idx` (`df_big_vessel_product_id`),
  CONSTRAINT `FK_df_big_vessel_product_id` FOREIGN KEY (`df_big_vessel_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `df_main_table`
--

DROP TABLE IF EXISTS `df_main_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `df_main_table` (
  `df_main_id` int(11) NOT NULL AUTO_INCREMENT,
  `df_main_product_id` int(11) NOT NULL,
  `df_main_day` varchar(15) NOT NULL,
  `df_main_date` int(11) NOT NULL,
  `df_main_month` varchar(15) NOT NULL,
  `df_main_year` int(11) NOT NULL,
  `df_main_value` double NOT NULL,
  `df_small_vessel_value` int(11) NOT NULL,
  `df_big_vessel_value` int(11) NOT NULL,
  PRIMARY KEY (`df_main_id`),
  KEY `FK_df_small_vessel_value_idx` (`df_small_vessel_value`),
  KEY `FK_df_big_vessel_value_idx` (`df_big_vessel_value`),
  KEY `FK_df_main_product_id_idx` (`df_main_product_id`),
  CONSTRAINT `FK_df_big_vessel_value` FOREIGN KEY (`df_big_vessel_value`) REFERENCES `df_big_vessel_table` (`df_big_vessel_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_df_main_product_id` FOREIGN KEY (`df_main_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_df_small_vessel_value` FOREIGN KEY (`df_small_vessel_value`) REFERENCES `df_small_vessel_table` (`df_small_vessel_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `df_small_vessel_table`
--

DROP TABLE IF EXISTS `df_small_vessel_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `df_small_vessel_table` (
  `df_small_vessel_id` int(11) NOT NULL AUTO_INCREMENT,
  `df_small_vessel_product_id` int(11) NOT NULL,
  `df_small_vessel_day` varchar(15) NOT NULL,
  `df_small_vessel_date` int(11) NOT NULL,
  `df_small_vessel_month` varchar(15) NOT NULL,
  `df_small_vessel_year` int(11) NOT NULL,
  `df_small_vessel_value` double NOT NULL,
  `df_small_vessel_days_delayed` int(11) NOT NULL,
  `df_small_vessel_delayed_cost` double NOT NULL,
  `df_small_vessel_demurrage_value` double NOT NULL,
  `df_small_vessel_volume` varchar(15) NOT NULL,
  PRIMARY KEY (`df_small_vessel_id`),
  KEY `FK_df_small_vessel_product_id_idx` (`df_small_vessel_product_id`),
  CONSTRAINT `FK_df_small_vessel_product_id` FOREIGN KEY (`df_small_vessel_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `df_vessel_cost_table`
--

DROP TABLE IF EXISTS `df_vessel_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `df_vessel_cost_table` (
  `df_vessel_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `df_vessel_cost_product_id` int(11) NOT NULL,
  `df_vessel_cost_day` varchar(15) NOT NULL,
  `df_vessel_cost_date` int(11) NOT NULL,
  `df_vessel_cost_month` varchar(15) NOT NULL,
  `df_vessel_cost_year` int(11) NOT NULL,
  `df_vessel_type` varchar(15) DEFAULT NULL,
  `df_vessel_cost_value` double NOT NULL,
  PRIMARY KEY (`df_vessel_cost_id`),
  KEY `FK_df_vessel_cost_product_id_idx` (`df_vessel_cost_product_id`),
  CONSTRAINT `FK_df_vessel_cost_product_id` FOREIGN KEY (`df_vessel_cost_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `distance_dsm_to_region_table`
--

DROP TABLE IF EXISTS `distance_dsm_to_region_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distance_dsm_to_region_table` (
  `distance_dsm_to_region_id` int(11) NOT NULL,
  `distance_dsm_to_region_name` varchar(45) NOT NULL,
  `distance_dsm_to_region_value` double NOT NULL,
  `distance_dsm_to_region_rate_say` double NOT NULL,
  `distance_dsm_to_region_region_pump_price_cap` double NOT NULL,
  PRIMARY KEY (`distance_dsm_to_region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `evaporation_losses_table`
--

DROP TABLE IF EXISTS `evaporation_losses_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaporation_losses_table` (
  `evaporation_losses_id` int(11) NOT NULL AUTO_INCREMENT,
  `evaporation_losses_product_id` int(11) NOT NULL,
  `evaporation_losses_day` varchar(15) DEFAULT NULL,
  `evaporation_losses_date` int(11) DEFAULT NULL,
  `evaporation_losses_month` varchar(15) DEFAULT NULL,
  `evaporation_losses_year` int(11) DEFAULT NULL,
  `evaporation_losses_value` double DEFAULT NULL,
  PRIMARY KEY (`evaporation_losses_id`),
  KEY `evaporation_losses_product_id_idx` (`evaporation_losses_product_id`),
  CONSTRAINT `evaporation_losses_product_id` FOREIGN KEY (`evaporation_losses_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exchangerate_table`
--

DROP TABLE IF EXISTS `exchangerate_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchangerate_table` (
  `exchangerate_id` int(11) NOT NULL AUTO_INCREMENT,
  `exchangerate_day` varchar(15) NOT NULL,
  `exchangerate_date` int(11) NOT NULL,
  `exchangerate_month` varchar(15) NOT NULL,
  `exchangerate_year` int(11) NOT NULL,
  `exchangerate_value` double NOT NULL,
  PRIMARY KEY (`exchangerate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exrcise_duty_table`
--

DROP TABLE IF EXISTS `exrcise_duty_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exrcise_duty_table` (
  `exrcise_duty_id` int(11) NOT NULL AUTO_INCREMENT,
  `exrcise_duty_product_id` int(11) NOT NULL,
  `exrcise_duty_day` varchar(15) DEFAULT NULL,
  `exrcise_duty_date` int(11) DEFAULT NULL,
  `exrcise_duty_month` varchar(15) DEFAULT NULL,
  `exrcise_duty_year` int(11) DEFAULT NULL,
  `exrcise_duty_value` double DEFAULT NULL,
  PRIMARY KEY (`exrcise_duty_id`),
  KEY `exrcise_duty_product_id_idx` (`exrcise_duty_product_id`),
  CONSTRAINT `exrcise_duty_product_id` FOREIGN KEY (`exrcise_duty_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `financing_cost_table`
--

DROP TABLE IF EXISTS `financing_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financing_cost_table` (
  `financing_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `financing_cost_product_id` int(11) NOT NULL,
  `financing_cost_day` varchar(15) DEFAULT NULL,
  `financing_cost_date` int(11) DEFAULT NULL,
  `financing_cost_month` varchar(15) DEFAULT NULL,
  `financing_cost_year` int(11) DEFAULT NULL,
  `financing_cost_value` double DEFAULT NULL,
  PRIMARY KEY (`financing_cost_id`),
  KEY `financing_cost_product_id_idx` (`financing_cost_product_id`),
  CONSTRAINT `financing_cost_product_id` FOREIGN KEY (`financing_cost_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fip_table`
--

DROP TABLE IF EXISTS `fip_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fip_table` (
  `fip_id` int(11) NOT NULL AUTO_INCREMENT,
  `fip_product_id` int(11) NOT NULL,
  `fip_day` varchar(15) NOT NULL,
  `fip_date` int(11) NOT NULL,
  `fip_month` varchar(15) NOT NULL,
  `fip_year` int(11) NOT NULL,
  `fip_value` double NOT NULL,
  PRIMARY KEY (`fip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fob_table`
--

DROP TABLE IF EXISTS `fob_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fob_table` (
  `fob_id` int(11) NOT NULL AUTO_INCREMENT,
  `fob_product_id` int(11) NOT NULL,
  `fob_day` varchar(15) NOT NULL,
  `fob_date` int(11) NOT NULL,
  `fob_month` varchar(15) NOT NULL,
  `fob_year` int(11) NOT NULL,
  `fob_value` double NOT NULL,
  PRIMARY KEY (`fob_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fuel_levy_table`
--

DROP TABLE IF EXISTS `fuel_levy_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuel_levy_table` (
  `fuel_levy_id` int(11) NOT NULL AUTO_INCREMENT,
  `fuel_levy_product_id` int(11) NOT NULL,
  `fuel_levy_day` varchar(15) DEFAULT NULL,
  `fuel_levy_date` int(11) DEFAULT NULL,
  `fuel_levy_month` varchar(15) DEFAULT NULL,
  `fuel_levy_year` int(11) DEFAULT NULL,
  `fuel_levy_value` double DEFAULT NULL,
  PRIMARY KEY (`fuel_levy_id`),
  KEY `fuel_levy_product_id_idx` (`fuel_levy_product_id`),
  CONSTRAINT `fuel_levy_product_id` FOREIGN KEY (`fuel_levy_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `government_taxes_table`
--

DROP TABLE IF EXISTS `government_taxes_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `government_taxes_table` (
  `government_taxes_id` int(11) NOT NULL AUTO_INCREMENT,
  `government_taxes_product_id` int(11) NOT NULL,
  `government_taxes_day` varchar(15) NOT NULL,
  `government_taxes_date` int(11) NOT NULL,
  `government_taxes_month` varchar(15) NOT NULL,
  `government_taxes_year` int(11) NOT NULL,
  `government_taxes_value` double NOT NULL,
  PRIMARY KEY (`government_taxes_id`),
  KEY `FK_government_taxes_product_id_idx` (`government_taxes_product_id`),
  CONSTRAINT `FK_government_taxes_product_id` FOREIGN KEY (`government_taxes_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `local_cost_computed_table`
--

DROP TABLE IF EXISTS `local_cost_computed_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local_cost_computed_table` (
  `local_cost_computed_id` int(11) NOT NULL AUTO_INCREMENT,
  `local_cost_computed_product_id` int(11) NOT NULL,
  `local_cost_computed_day` varchar(15) NOT NULL,
  `local_cost_computed_date` int(11) NOT NULL,
  `local_cost_computed_month` varchar(15) NOT NULL,
  `local_cost_computed_year` int(11) NOT NULL,
  `local_cost_computed_value` double NOT NULL,
  PRIMARY KEY (`local_cost_computed_id`),
  KEY `FK_local_cost_computed_product_id_idx` (`local_cost_computed_product_id`),
  CONSTRAINT `FK_local_cost_computed_product_id` FOREIGN KEY (`local_cost_computed_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `monthly_setting_table`
--

DROP TABLE IF EXISTS `monthly_setting_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthly_setting_table` (
  `monthly_setting_id` int(11) NOT NULL AUTO_INCREMENT,
  `monthly_setting_product_id` int(11) NOT NULL,
  `monthly_setting_day` varchar(15) NOT NULL,
  `monthly_setting_date` varchar(15) NOT NULL,
  `monthly_setting_month` varchar(15) NOT NULL,
  `monthly_setting_year` int(11) NOT NULL,
  `monthly_setting_fob` double NOT NULL,
  `monthly_setting_fip` double NOT NULL,
  `monthly_setting_cif` double NOT NULL,
  `monthly_setting_df` double NOT NULL,
  `monthly_setting_static_transport_charge_local` double NOT NULL,
  `monthly_setting_static_retailers_margin` double NOT NULL,
  `monthly_setting_static_overheads_margins` double NOT NULL,
  `monthly_setting_static_payable_local_autho_exc_agency` double NOT NULL,
  `monthly_setting_fuel_levy` double NOT NULL,
  `monthly_setting_exercise_duty` double NOT NULL,
  `monthly_setting_petroleum_fee` double NOT NULL,
  `monthly_setting_evaporation_loss_percentage` double NOT NULL,
  `monthly_setting_regulatory` double NOT NULL,
  `monthly_setting_cif_cost_percentage` double NOT NULL,
  `monthly_setting_tiper_fee_vat` double NOT NULL,
  `monthly_setting_tbs_charge` double NOT NULL,
  `monthly_setting_weight_measures_fee` double NOT NULL,
  `monthly_setting_custom_processing` double NOT NULL,
  PRIMARY KEY (`monthly_setting_id`),
  KEY `FK_monthly_setting_product_id_idx` (`monthly_setting_product_id`),
  CONSTRAINT `FK_monthly_setting_product_id` FOREIGN KEY (`monthly_setting_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `omc_overheads_margins_table`
--

DROP TABLE IF EXISTS `omc_overheads_margins_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `omc_overheads_margins_table` (
  `omc_overheads_margins_id` int(11) NOT NULL AUTO_INCREMENT,
  `omc_overheads_margins_product_id` int(11) NOT NULL,
  `omc_overheads_margins_day` varchar(15) DEFAULT NULL,
  `omc_overheads_margins_date` int(11) DEFAULT NULL,
  `omc_overheads_margins_month` varchar(15) DEFAULT NULL,
  `omc_overheads_margins_year` int(11) DEFAULT NULL,
  `omc_overheads_margins_value` double DEFAULT NULL,
  PRIMARY KEY (`omc_overheads_margins_id`),
  KEY `omc_overheads_margins_product_id_idx` (`omc_overheads_margins_product_id`),
  CONSTRAINT `omc_overheads_margins_product_id` FOREIGN KEY (`omc_overheads_margins_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `petroleum_fee_table`
--

DROP TABLE IF EXISTS `petroleum_fee_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petroleum_fee_table` (
  `petroleum_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `petroleum_fee_product_id` int(11) NOT NULL,
  `petroleum_fee_day` varchar(15) DEFAULT NULL,
  `petroleum_fee_date` int(11) DEFAULT NULL,
  `petroleum_fee_month` varchar(15) DEFAULT NULL,
  `petroleum_fee_year` int(11) DEFAULT NULL,
  `petroleum_fee_value` double DEFAULT NULL,
  PRIMARY KEY (`petroleum_fee_id`),
  KEY `petroleum_fee_product_id_idx` (`petroleum_fee_product_id`),
  CONSTRAINT `petroleum_fee_product_id` FOREIGN KEY (`petroleum_fee_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `petroleum_marking_cost_table`
--

DROP TABLE IF EXISTS `petroleum_marking_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `petroleum_marking_cost_table` (
  `petroleum_marking_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `petroleum_marking_cost_day` varchar(15) NOT NULL,
  `petroleum_marking_cost_date` int(11) NOT NULL,
  `petroleum_marking_cost_month` varchar(15) NOT NULL,
  `petroleum_marking_cost_year` int(11) NOT NULL,
  `petroleum_marking_cost_value` double NOT NULL,
  `petroleum_marking_cost_exchangerate` int(11) NOT NULL,
  PRIMARY KEY (`petroleum_marking_cost_id`),
  KEY `FK_petroleum_marking_cost_exchangerate_idx` (`petroleum_marking_cost_exchangerate`),
  CONSTRAINT `FK_petroleum_marking_cost_exchangerate` FOREIGN KEY (`petroleum_marking_cost_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_table`
--

DROP TABLE IF EXISTS `product_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_table` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pump_price_cap_dsm_table`
--

DROP TABLE IF EXISTS `pump_price_cap_dsm_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pump_price_cap_dsm_table` (
  `pump_price_cap_dsm_id` int(11) NOT NULL AUTO_INCREMENT,
  `pump_price_cap_dsm_product_id` int(11) NOT NULL,
  `pump_price_cap_dsm_day` varchar(15) NOT NULL,
  `pump_price_cap_dsm_date` int(11) NOT NULL,
  `pump_price_cap_dsm_month` varchar(15) NOT NULL,
  `pump_price_cap_dsm_year` int(11) NOT NULL,
  `pump_price_cap_dsm_value` double NOT NULL,
  PRIMARY KEY (`pump_price_cap_dsm_id`),
  KEY `FK_pump_price_cap_dsm_product_id_idx` (`pump_price_cap_dsm_product_id`),
  CONSTRAINT `FK_pump_price_cap_dsm_product_id` FOREIGN KEY (`pump_price_cap_dsm_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `regulatory_levy_table`
--

DROP TABLE IF EXISTS `regulatory_levy_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regulatory_levy_table` (
  `regulatory_levy_id` int(11) NOT NULL AUTO_INCREMENT,
  `regulatory_levy_product_id` int(11) NOT NULL,
  `regulatory_levy_day` varchar(15) DEFAULT NULL,
  `regulatory_levy_date` int(11) DEFAULT NULL,
  `regulatory_levy_month` varchar(15) DEFAULT NULL,
  `regulatory_levy_year` int(11) DEFAULT NULL,
  `regulatory_levy_value` double DEFAULT NULL,
  PRIMARY KEY (`regulatory_levy_id`),
  KEY `regulatory_levy_product_id_idx` (`regulatory_levy_product_id`),
  CONSTRAINT `regulatory_levy_product_id` FOREIGN KEY (`regulatory_levy_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `retailers_margin_table`
--

DROP TABLE IF EXISTS `retailers_margin_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retailers_margin_table` (
  `retailers_margin_id` int(11) NOT NULL AUTO_INCREMENT,
  `retailers_margin_product_id` int(11) NOT NULL,
  `retailers_margin_day` varchar(15) DEFAULT NULL,
  `retailers_margin_date` int(11) DEFAULT NULL,
  `retailers_margin_month` varchar(15) DEFAULT NULL,
  `retailers_margin_year` int(11) DEFAULT NULL,
  `retailers_margin_value` double DEFAULT NULL,
  PRIMARY KEY (`retailers_margin_id`),
  KEY `retailers_margin_product_id_idx` (`retailers_margin_product_id`),
  CONSTRAINT `retailers_margin_product_id` FOREIGN KEY (`retailers_margin_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `surveyors_cost_table`
--

DROP TABLE IF EXISTS `surveyors_cost_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surveyors_cost_table` (
  `surveyors_cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `surveyors_cost_product_id` int(11) NOT NULL,
  `surveyors_cost_day` varchar(15) NOT NULL,
  `surveyors_cost_date` int(11) NOT NULL,
  `surveyors_cost_month` varchar(15) NOT NULL,
  `surveyors_cost_year` int(11) NOT NULL,
  `surveyors_cost_value` double NOT NULL,
  `surveyors_cost_exchangerate` int(11) NOT NULL,
  `surveyors_cost_waa_conversion_factor` int(11) NOT NULL,
  `surveyors_cost_atr_small` int(11) NOT NULL,
  `surveyors_cost_atr_big` int(11) NOT NULL,
  PRIMARY KEY (`surveyors_cost_id`),
  KEY `FK_surveyors_cost_product_id_idx` (`surveyors_cost_product_id`),
  KEY `FK_surveyors_cost_exchangerate_idx` (`surveyors_cost_exchangerate`),
  KEY `FK_surveyors_cost_waa_conversion_factor_idx` (`surveyors_cost_waa_conversion_factor`),
  KEY `FK_surveyors_cost_atr_small_idx` (`surveyors_cost_atr_small`),
  KEY `FK_surveyors_cost_big_small_idx` (`surveyors_cost_atr_big`,`surveyors_cost_atr_small`),
  CONSTRAINT `FK_surveyors_cost_atr_big` FOREIGN KEY (`surveyors_cost_atr_big`) REFERENCES `atr_vessel_cost_table` (`atr_vessel_cost_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_surveyors_cost_atr_small` FOREIGN KEY (`surveyors_cost_atr_small`) REFERENCES `atr_vessel_cost_table` (`atr_vessel_cost_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_surveyors_cost_exchangerate` FOREIGN KEY (`surveyors_cost_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_surveyors_cost_product_id` FOREIGN KEY (`surveyors_cost_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_surveyors_cost_waa_conversion_factor` FOREIGN KEY (`surveyors_cost_waa_conversion_factor`) REFERENCES `waa_conversion_factor_table` (`waa_conversion_factor_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbs_charge_table`
--

DROP TABLE IF EXISTS `tbs_charge_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbs_charge_table` (
  `tbs_charge_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbs_charge_product_id` int(11) NOT NULL,
  `tbs_charge_day` varchar(15) DEFAULT NULL,
  `tbs_charge_date` int(11) DEFAULT NULL,
  `tbs_charge_month` varchar(15) DEFAULT NULL,
  `tbs_charge_year` int(11) DEFAULT NULL,
  `tbs_charge_value` double DEFAULT NULL,
  PRIMARY KEY (`tbs_charge_id`),
  KEY `tbs_charge_product_id_idx` (`tbs_charge_product_id`),
  CONSTRAINT `tbs_charge_product_id` FOREIGN KEY (`tbs_charge_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tiper_fee_table`
--

DROP TABLE IF EXISTS `tiper_fee_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiper_fee_table` (
  `tiper_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `tiper_fee_product_id` int(11) NOT NULL,
  `tiper_fee_day` varchar(15) DEFAULT NULL,
  `tiper_fee_date` int(11) DEFAULT NULL,
  `tiper_fee_month` varchar(15) DEFAULT NULL,
  `tiper_fee_year` int(11) DEFAULT NULL,
  `tiper_fee_value` double DEFAULT NULL,
  PRIMARY KEY (`tiper_fee_id`),
  KEY `tiper_fee_product_id_idx` (`tiper_fee_product_id`),
  CONSTRAINT `tiper_fee_product_id` FOREIGN KEY (`tiper_fee_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transport_charges_table`
--

DROP TABLE IF EXISTS `transport_charges_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_charges_table` (
  `transport_charges_id` int(11) NOT NULL AUTO_INCREMENT,
  `transport_charges_product_id` int(11) NOT NULL,
  `transport_charges_day` varchar(15) DEFAULT NULL,
  `transport_charges_date` int(11) DEFAULT NULL,
  `transport_charges_month` varchar(15) DEFAULT NULL,
  `transport_charges_year` int(11) DEFAULT NULL,
  `transport_charges_value` double DEFAULT NULL,
  PRIMARY KEY (`transport_charges_id`),
  KEY `transport_charges_product_id_idx` (`transport_charges_product_id`),
  CONSTRAINT `transport_charges_product_id` FOREIGN KEY (`transport_charges_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `waa_conversion_factor_table`
--

DROP TABLE IF EXISTS `waa_conversion_factor_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waa_conversion_factor_table` (
  `waa_conversion_factor_id` int(11) NOT NULL AUTO_INCREMENT,
  `waa_conversion_factor_product_id` int(11) NOT NULL,
  `waa_conversion_factor_day` varchar(15) NOT NULL,
  `waa_conversion_factor_date` int(11) NOT NULL,
  `waa_conversion_factor_month` varchar(15) NOT NULL,
  `waa_conversion_factor_year` int(11) NOT NULL,
  `waa_conversion_factor_value` double NOT NULL,
  PRIMARY KEY (`waa_conversion_factor_id`),
  KEY `waa_conversion_factor_product_id_idx` (`waa_conversion_factor_product_id`),
  CONSTRAINT `FK_waa_conversion_factor_product_id` FOREIGN KEY (`waa_conversion_factor_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weight_measures_fee_table`
--

DROP TABLE IF EXISTS `weight_measures_fee_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weight_measures_fee_table` (
  `weight_measures_fee_id` int(11) NOT NULL AUTO_INCREMENT,
  `weight_measures_fee_product_id` int(11) NOT NULL,
  `weight_measures_fee_day` varchar(15) DEFAULT NULL,
  `weight_measures_fee_date` int(11) DEFAULT NULL,
  `weight_measures_fee_month` varchar(15) DEFAULT NULL,
  `weight_measures_fee_year` int(11) DEFAULT NULL,
  `weight_measures_fee_value` double DEFAULT NULL,
  PRIMARY KEY (`weight_measures_fee_id`),
  KEY `weight_measures_fee_product_id_idx` (`weight_measures_fee_product_id`),
  CONSTRAINT `weight_measures_fee_product_id` FOREIGN KEY (`weight_measures_fee_product_id`) REFERENCES `product_table` (`product_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weighted_average_platt_fob_table`
--

DROP TABLE IF EXISTS `weighted_average_platt_fob_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weighted_average_platt_fob_table` (
  `weighted_average_platt_fob_id` int(11) NOT NULL AUTO_INCREMENT,
  `weighted_average_platt_fob_product_id` int(11) NOT NULL,
  `weighted_average_platt_fob_day` varchar(15) NOT NULL,
  `weighted_average_platt_fob_date` int(11) NOT NULL,
  `weighted_average_platt_fob_month` varchar(15) NOT NULL,
  `weighted_average_platt_fob_year` int(11) NOT NULL,
  `weighted_average_platt_fob_value` double NOT NULL,
  `weighted_average_platt_fob_exchangerate` int(11) NOT NULL,
  `weighted_average_platt_fob_waa_conversion_factor` int(11) NOT NULL,
  `weighted_average_platt_fob_current_fob` int(11) NOT NULL,
  PRIMARY KEY (`weighted_average_platt_fob_id`),
  KEY `FK_weighted_average_platt_fob_product_id_idx` (`weighted_average_platt_fob_product_id`),
  KEY `FK_weighted_average_platt_fob_exchangerate_idx` (`weighted_average_platt_fob_exchangerate`),
  KEY `FK_weighted_average_platt_fob_waa_conversion_factor_idx` (`weighted_average_platt_fob_waa_conversion_factor`),
  KEY `FK_weighted_average_platt_fob_current_fob_idx` (`weighted_average_platt_fob_current_fob`),
  CONSTRAINT `FK_weighted_average_platt_fob_current_fob` FOREIGN KEY (`weighted_average_platt_fob_current_fob`) REFERENCES `fob_table` (`fob_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_platt_fob_exchangerate` FOREIGN KEY (`weighted_average_platt_fob_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_platt_fob_product_id` FOREIGN KEY (`weighted_average_platt_fob_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_platt_fob_waa_conversion_factor` FOREIGN KEY (`weighted_average_platt_fob_waa_conversion_factor`) REFERENCES `waa_conversion_factor_table` (`waa_conversion_factor_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `weighted_average_premium_quatation_table`
--

DROP TABLE IF EXISTS `weighted_average_premium_quatation_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weighted_average_premium_quatation_table` (
  `weighted_average_premium_quatation_id` int(11) NOT NULL AUTO_INCREMENT,
  `weighted_average_premium_quatation_product_id` int(11) NOT NULL,
  `weighted_average_premium_quatation_day` varchar(15) NOT NULL,
  `weighted_average_premium_quatation_date` int(11) NOT NULL,
  `weighted_average_premium_quatation_month` varchar(15) NOT NULL,
  `weighted_average_premium_quatation_year` int(11) NOT NULL,
  `weighted_average_premium_quatation_value` double NOT NULL,
  `weighted_average_premium_quatation_waa_conversion_factor` int(11) NOT NULL,
  `weighted_average_premium_quatation_exchangerate` int(11) NOT NULL,
  `weighted_average_premium_quatation_current_fip` int(11) NOT NULL,
  PRIMARY KEY (`weighted_average_premium_quatation_id`),
  KEY `FK_weighted_average_premium_quatation_product_id_idx` (`weighted_average_premium_quatation_product_id`),
  KEY `FK_weighted_average_premium_quatation_waa_conversion_factor_idx` (`weighted_average_premium_quatation_waa_conversion_factor`),
  KEY `FK_weighted_average_premium_quatation_exchangerate_idx` (`weighted_average_premium_quatation_exchangerate`),
  KEY `FK_weighted_average_premium_quatation_current_fip_idx` (`weighted_average_premium_quatation_current_fip`),
  CONSTRAINT `FK_weighted_average_premium_quatation_current_fip` FOREIGN KEY (`weighted_average_premium_quatation_current_fip`) REFERENCES `fip_table` (`fip_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_premium_quatation_exchangerate` FOREIGN KEY (`weighted_average_premium_quatation_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_premium_quatation_product_id` FOREIGN KEY (`weighted_average_premium_quatation_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_weighted_average_premium_quatation_waa_conversion_factor` FOREIGN KEY (`weighted_average_premium_quatation_waa_conversion_factor`) REFERENCES `waa_conversion_factor_table` (`waa_conversion_factor_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wharfage_vat_table`
--

DROP TABLE IF EXISTS `wharfage_vat_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wharfage_vat_table` (
  `wharfage_vat_id` int(11) NOT NULL AUTO_INCREMENT,
  `wharfage_vat_product_id` int(11) NOT NULL,
  `wharfage_vat_day` varchar(15) NOT NULL,
  `wharfage_vat_date` int(11) NOT NULL,
  `wharfage_vat_month` varchar(15) NOT NULL,
  `wharfage_vat_year` int(11) NOT NULL,
  `wharfage_vat_value` double NOT NULL,
  `wharfage_vat_exchangerate` int(11) NOT NULL,
  `wharfage_vat_waa_conversion_factor` int(11) NOT NULL,
  PRIMARY KEY (`wharfage_vat_id`),
  KEY `FK_wharfage_vat_product_id_idx` (`wharfage_vat_product_id`),
  KEY `FK_wharfage_vat_exchangerate_idx` (`wharfage_vat_exchangerate`),
  KEY `FK_wharfage_vat_waa_conversion_factor_idx` (`wharfage_vat_waa_conversion_factor`),
  CONSTRAINT `FK_wharfage_vat_exchangerate` FOREIGN KEY (`wharfage_vat_exchangerate`) REFERENCES `computed_exchangerate_table` (`com_exchangerate_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_wharfage_vat_product_id` FOREIGN KEY (`wharfage_vat_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_wharfage_vat_waa_conversion_factor` FOREIGN KEY (`wharfage_vat_waa_conversion_factor`) REFERENCES `waa_conversion_factor_table` (`waa_conversion_factor_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wholesales_price_table`
--

DROP TABLE IF EXISTS `wholesales_price_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wholesales_price_table` (
  `wholesales_price_id` int(11) NOT NULL AUTO_INCREMENT,
  `wholesales_price_product_id` int(11) NOT NULL,
  `wholesales_price_day` varchar(15) NOT NULL,
  `wholesales_price_date` int(11) NOT NULL,
  `wholesales_price_month` varchar(15) NOT NULL,
  `wholesales_price_year` int(11) NOT NULL,
  `wholesales_price_value` double NOT NULL,
  PRIMARY KEY (`wholesales_price_id`),
  KEY `FK_wholesales_price_product_id_idx` (`wholesales_price_product_id`),
  CONSTRAINT `FK_wholesales_price_product_id` FOREIGN KEY (`wholesales_price_product_id`) REFERENCES `product_table` (`product_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-05 16:43:25
