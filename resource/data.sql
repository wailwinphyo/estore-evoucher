-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: estore
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
-- Dumping data for table `buyer_info`
--

LOCK TABLES `buyer_info` WRITE;
/*!40000 ALTER TABLE `buyer_info` DISABLE KEYS */;
INSERT INTO `buyer_info` VALUES (104,'2021-09-20 01:59:41.552000',105.6,'test','09777979965',10,'PAID',101,105,100),(116,'2021-09-20 02:00:27.807000',105.6,'test','09777979965',10,'PAID',103,117,100),(130,'2021-09-20 02:02:48.743000',1056,'test','09777979965',100,'PAID',103,131,100);
/*!40000 ALTER TABLE `buyer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `evoucher`
--

LOCK TABLES `evoucher` WRITE;
/*!40000 ALTER TABLE `evoucher` DISABLE KEYS */;
INSERT INTO `evoucher` VALUES (101,12,'2021-09-18 16:26:27.054000',8,'uploads/vouchers/3422169f-6038-40b0-86dd-c751a62aad23.png',12,12,490,'INACTIVE','testVoucher3',1),(102,12,'2021-09-18 16:26:27.054000',8,'uploads/vouchers/8b80b881-8d47-4677-b3e8-5374c5d6b34e.png',12,12,500,'ACTIVE','testVoucher2',1),(103,12,'2021-09-18 16:26:27.054000',8,'uploads/vouchers/86164800-5d99-49b5-885e-b6745ec9515e.png',12,12,390,'ACTIVE','Voucher1',1);
/*!40000 ALTER TABLE `evoucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
truncate `hibernate_sequence`;
INSERT INTO `hibernate_sequence` VALUES (232);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
INSERT INTO `paymentmethod` VALUES (1,'VISA','VISA','ACTIVE'),(2,'MASTERCARD','MasterCard','ACTIVE'),(3,'JCB','JCB','ACTIVE'),(4,'CHINA_UNION_PAY','China Union Pay','ACTIVE');
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `promo_code_voucher`
--

LOCK TABLES `promo_code_voucher` WRITE;
/*!40000 ALTER TABLE `promo_code_voucher` DISABLE KEYS */;
INSERT INTO `promo_code_voucher` VALUES (106,'801007mluWe','/QRpromocodes/5c63191d-ca45-4704-90c7-4728843ab9bc.png','UNUSE',NULL,104,100),(107,'629512wSmqS','/QRpromocodes/71d829b5-1b7a-4549-b0fe-fa40eada1efa.png','UNUSE',NULL,104,100),(108,'745646ZbsCo','/QRpromocodes/00da8c34-53c6-41bd-adf9-70012924e6de.png','UNUSE',NULL,104,100),(109,'008687wARIG','/QRpromocodes/c823c95e-e641-4804-9ff9-4e8a3c577127.png','UNUSE',NULL,104,100),(110,'027839daELt','/QRpromocodes/367a93ba-9542-4a27-8760-31371b33281b.png','UNUSE',NULL,104,100),(111,'418592KojXO','/QRpromocodes/eb13218b-f785-4b4c-95f9-c22c7eed6b21.png','UNUSE',NULL,104,100),(112,'698785KEjPy','/QRpromocodes/fe47e053-74a4-4899-902a-e35b9f93b420.png','UNUSE',NULL,104,100),(113,'696345pRMcN','/QRpromocodes/f4d39c9e-4f25-4f44-a627-ac2bcee71e1d.png','UNUSE',NULL,104,100),(114,'110831slghc','/QRpromocodes/09af588c-b7ff-4d00-9deb-75650c6fcb17.png','UNUSE',NULL,104,100),(115,'691238sjkUj','/QRpromocodes/2fba07c2-5b6a-4f74-a107-d57740316fba.png','UNUSE',NULL,104,100),(118,'469077reITE','/QRpromocodes/8c73a09f-ae6b-4f39-865b-3ef620ef9972.png','UNUSE',NULL,116,100),(119,'507317HHlWk','/QRpromocodes/60891a95-0192-4a70-9494-91bbb2f87581.png','UNUSE',NULL,116,100),(120,'798978eZrDq','/QRpromocodes/068c7779-1a39-4a55-8c23-d802d2e21afa.png','UNUSE',NULL,116,100),(121,'697781xIRev','/QRpromocodes/0630f4f8-fdb4-473d-96d3-d23a5f90fc77.png','UNUSE',NULL,116,100),(122,'194766VFgOP','/QRpromocodes/5bcebfe7-ade5-41cb-b6d7-00c53b4b4842.png','UNUSE',NULL,116,100),(123,'174206kXAzD','/QRpromocodes/55a614d8-838a-4a6c-9af3-95d04d02e422.png','UNUSE',NULL,116,100),(124,'933341AMxjC','/QRpromocodes/7f745dc0-f42b-420c-9bb2-69436c57d677.png','UNUSE',NULL,116,100),(125,'405587fSlRQ','/QRpromocodes/dc617de9-5e0f-4c2f-84a5-0c22822b5d07.png','UNUSE',NULL,116,100),(126,'318385VlNWw','/QRpromocodes/b8a38812-ac75-4fc2-881d-08227953a376.png','UNUSE',NULL,116,100),(127,'155146ShWUz','/QRpromocodes/e4226730-00e4-4aea-9994-4e779aff32b7.png','UNUSE',NULL,116,100),(132,'262519oGobr','/QRpromocodes/5aba41fd-b9f5-47d9-9329-7f9f9e2286d9.png','UNUSE',NULL,130,100),(133,'272115lvTBq','/QRpromocodes/86f92ef7-ecd6-4377-964a-cbb27611aee4.png','UNUSE',NULL,130,100),(134,'330521mlPXY','/QRpromocodes/2f3dc7dc-562b-4b55-ae76-4562c610bf77.png','UNUSE',NULL,130,100),(135,'891274ZtCEu','/QRpromocodes/53b18923-e289-4f7d-9a78-305bf31565db.png','UNUSE',NULL,130,100),(136,'338602RkydW','/QRpromocodes/33f4b0bb-2f2e-415b-9f84-4f2c8b0ecb1a.png','UNUSE',NULL,130,100),(137,'862840EFrRR','/QRpromocodes/bb8061b7-c51a-48b2-b72e-05fd708d5a5d.png','UNUSE',NULL,130,100),(138,'134052gOQAz','/QRpromocodes/0ae49c4f-8c07-4af3-a8b5-2e1c78e67578.png','UNUSE',NULL,130,100),(139,'314106LWLSe','/QRpromocodes/c9fc5f98-670b-4280-ac79-5c06f7d89c8a.png','UNUSE',NULL,130,100),(140,'615887HQMNB','/QRpromocodes/7e8bb890-0cfb-4bdf-8484-ff1cf61b17bb.png','UNUSE',NULL,130,100),(141,'621389bmAiF','/QRpromocodes/874d7721-96c5-49a9-91b3-45008679477c.png','UNUSE',NULL,130,100),(142,'502833eqVdW','/QRpromocodes/6b0ddd6b-31e7-4fc5-9148-4aa9b92b5353.png','UNUSE',NULL,130,100),(143,'987776qIKYW','/QRpromocodes/ecd1194f-fe2a-4782-b206-d204db236cc9.png','UNUSE',NULL,130,100),(144,'953690gfJon','/QRpromocodes/1d0a6602-6651-4cc2-839b-591aca7e3551.png','UNUSE',NULL,130,100),(145,'418460qhiPu','/QRpromocodes/af50e193-8c63-443e-8447-64bdeb02496e.png','UNUSE',NULL,130,100),(146,'170306zFqNq','/QRpromocodes/f844c5fd-ae9d-4747-b893-625901044e7c.png','UNUSE',NULL,130,100),(147,'127510uQTrX','/QRpromocodes/b695e206-eab7-4424-aa11-742a0e15fb71.png','UNUSE',NULL,130,100),(148,'285018WJImM','/QRpromocodes/b039b246-230b-4118-a8d3-a9fc9d621077.png','UNUSE',NULL,130,100),(149,'997089DmUdy','/QRpromocodes/0ebf29e1-0d23-48f8-978d-93e987119186.png','UNUSE',NULL,130,100),(150,'412763gQdty','/QRpromocodes/ff297fa7-f2a6-4f59-b385-ccc3f89e85ff.png','UNUSE',NULL,130,100),(151,'597256FWLMK','/QRpromocodes/374e7ac0-c960-431b-b2e1-c10246b660e0.png','UNUSE',NULL,130,100),(152,'738289misqn','/QRpromocodes/99f99fa0-e6ba-4a52-b0ba-4b4f0fab26af.png','UNUSE',NULL,130,100),(153,'116535LmKkF','/QRpromocodes/b6c79b6e-3ec9-480a-9911-4fc380d2213d.png','UNUSE',NULL,130,100),(154,'185083xLsJn','/QRpromocodes/70aa4a1a-b30b-4a1c-9f31-e70d01a37eb5.png','UNUSE',NULL,130,100),(155,'416916MTnfS','/QRpromocodes/c086ed64-b3f3-4b5f-b27c-dfcfed69481a.png','UNUSE',NULL,130,100),(156,'229417KZdps','/QRpromocodes/8345075f-81c9-4461-9cfc-2615add31daa.png','UNUSE',NULL,130,100),(157,'498440RTNvf','/QRpromocodes/09a5ad7c-3da0-4c76-ad94-a35ab9b60087.png','UNUSE',NULL,130,100),(158,'949100NEHSz','/QRpromocodes/2d2e06a6-242f-4839-8f17-5dd276da769c.png','UNUSE',NULL,130,100),(159,'935753EOrLQ','/QRpromocodes/ed2e95f0-d2d5-4375-b6d4-bbc400f34ed0.png','UNUSE',NULL,130,100),(160,'441448NBAwt','/QRpromocodes/eb4e5780-dc55-4ef8-92a9-bb68e49af6b5.png','UNUSE',NULL,130,100),(161,'483430suttF','/QRpromocodes/71871a36-16b6-4b18-9a14-de42586df0c0.png','UNUSE',NULL,130,100),(162,'014311QngdX','/QRpromocodes/8b956a1f-a429-4222-a547-681133cce255.png','UNUSE',NULL,130,100),(163,'320587NsIhn','/QRpromocodes/3d2e20ff-90a8-4a0c-bdea-9355a6ec17c2.png','UNUSE',NULL,130,100),(164,'891724sdYOZ','/QRpromocodes/bc4d7133-9e20-4c82-9388-247cadf6f95f.png','UNUSE',NULL,130,100),(165,'749482XIoro','/QRpromocodes/f375cf59-4ad9-456a-9b22-15863bd8ee6b.png','UNUSE',NULL,130,100),(166,'013177JGqcy','/QRpromocodes/d98149c1-50b8-4675-ae7a-4161a395d253.png','UNUSE',NULL,130,100),(167,'810552cTxVM','/QRpromocodes/88f14050-771d-4c8f-ba3c-6163e4e0bb3c.png','UNUSE',NULL,130,100),(168,'688947XUHCj','/QRpromocodes/747da82f-0315-43d5-b4b1-915bc4fb99b8.png','UNUSE',NULL,130,100),(169,'630553hBNDa','/QRpromocodes/799f564b-43b1-4891-88ad-d1093660b55e.png','UNUSE',NULL,130,100),(170,'813917znkjw','/QRpromocodes/f572b2ef-6241-42cc-b17a-683a71aa3515.png','UNUSE',NULL,130,100),(171,'302221CdMZX','/QRpromocodes/d3a99a64-c8f9-4518-8d40-1a078b7ff914.png','UNUSE',NULL,130,100),(172,'325374wTwkq','/QRpromocodes/f12c577d-fefc-459f-97ed-2f73a293f70d.png','UNUSE',NULL,130,100),(173,'047874NkLqE','/QRpromocodes/35ca849b-8e5b-42e9-b83f-94e26a61f237.png','UNUSE',NULL,130,100),(174,'675334yOvls','/QRpromocodes/c523b953-f11c-4d26-9000-d16da0e10bb0.png','UNUSE',NULL,130,100),(175,'707545xJffc','/QRpromocodes/c7d35439-7ca1-4837-85cb-3e0173219ccc.png','UNUSE',NULL,130,100),(176,'982036NsDos','/QRpromocodes/25f5fe8d-a1dd-49c4-9c00-8c198b2dbbb7.png','UNUSE',NULL,130,100),(177,'049469kwjDk','/QRpromocodes/07ba45ec-4e27-41eb-9411-9ad9988e8859.png','UNUSE',NULL,130,100),(178,'628047TFZaC','/QRpromocodes/34b1372c-2672-4b1c-88aa-d728a517566d.png','UNUSE',NULL,130,100),(179,'983005eOtwh','/QRpromocodes/572def8e-e5db-422c-9a3d-e732650b4063.png','UNUSE',NULL,130,100),(180,'676059kLQcn','/QRpromocodes/ac2075de-5ae4-4abd-af88-ec503670c256.png','UNUSE',NULL,130,100),(181,'961714hDtvO','/QRpromocodes/0b16c67d-f459-43b0-ba09-07f04dfb9a31.png','UNUSE',NULL,130,100),(182,'044550qfJHa','/QRpromocodes/ed84b8de-180d-4af7-9889-ac99b32e5da5.png','UNUSE',NULL,130,100),(183,'740606CGKnW','/QRpromocodes/17e6060c-b541-4e30-825e-1b3838ff8c56.png','UNUSE',NULL,130,100),(184,'338457hLPQR','/QRpromocodes/9d236fb9-2189-45ea-bccd-57e6e5ddc665.png','UNUSE',NULL,130,100),(185,'566693MEoGP','/QRpromocodes/4e2ec903-9b6e-4d5a-a1c8-165e6fd05d23.png','UNUSE',NULL,130,100),(186,'104717hOHTq','/QRpromocodes/a2004c9d-7faa-41ec-a6be-c29cc111cb18.png','UNUSE',NULL,130,100),(187,'244110QoyIu','/QRpromocodes/9c99cb65-1d19-4691-b697-cbc4797cdb97.png','UNUSE',NULL,130,100),(188,'446863oHOCB','/QRpromocodes/e9a6bf94-f526-465a-956c-6f59c3c2c12b.png','UNUSE',NULL,130,100),(189,'018161XlyVq','/QRpromocodes/4ea432cf-e7f2-4a07-8c59-009d9332be96.png','UNUSE',NULL,130,100),(190,'904726hsgey','/QRpromocodes/6e67334e-2ed5-4e22-8471-5f07fd5a1f8e.png','UNUSE',NULL,130,100),(191,'654924gXayB','/QRpromocodes/ecd6f4e0-e943-485e-9c54-39ace6bcf906.png','UNUSE',NULL,130,100),(192,'563196MqbPH','/QRpromocodes/3a11c196-95f4-4dae-93db-eb87798e441f.png','UNUSE',NULL,130,100),(193,'051845VNBtQ','/QRpromocodes/9f9d6777-511c-4def-b830-d772b1c101a6.png','UNUSE',NULL,130,100),(194,'865761bMZLR','/QRpromocodes/c05e7806-6c0a-49dc-adbc-dc71efee9824.png','UNUSE',NULL,130,100),(195,'087947ZApoN','/QRpromocodes/6f168e75-9985-416b-909c-770a7326dd3d.png','UNUSE',NULL,130,100),(196,'920387sOcYR','/QRpromocodes/d54809e5-83a6-4c4e-9a68-a4c617c25a48.png','UNUSE',NULL,130,100),(197,'214530riprn','/QRpromocodes/fc525d0c-7ad5-4c89-9e6d-12cff97a767d.png','UNUSE',NULL,130,100),(198,'518182FJuKl','/QRpromocodes/e9487628-ca55-4d6d-8ee8-98327a83077a.png','UNUSE',NULL,130,100),(199,'358034csZGj','/QRpromocodes/996b4279-fb9a-4c6b-9c4c-dc703c43de48.png','UNUSE',NULL,130,100),(200,'573930YOZOA','/QRpromocodes/e3859acb-7df1-4191-add0-b8f6acfc1e62.png','UNUSE',NULL,130,100),(201,'159365IBkXY','/QRpromocodes/4e37e68d-e3c6-4b9f-b6c0-a2c5f96dec8c.png','UNUSE',NULL,130,100),(202,'907510UFJKJ','/QRpromocodes/a3db53a8-6c09-4a5c-97eb-705d96ee5e94.png','UNUSE',NULL,130,100),(203,'215244QBjQY','/QRpromocodes/2299cee8-2054-4306-90c4-17ba9bc42157.png','UNUSE',NULL,130,100),(204,'839569gGVvL','/QRpromocodes/1ce4da11-9b44-4633-9b43-b5dd4f7c627c.png','UNUSE',NULL,130,100),(205,'082877GUkRP','/QRpromocodes/8f78af16-72bf-4b4c-b586-ce342c879bda.png','UNUSE',NULL,130,100),(206,'306421gEZhL','/QRpromocodes/fbde7e5d-f0f4-41a9-b3b1-f3ddb8f65a80.png','UNUSE',NULL,130,100),(207,'310436hTrpb','/QRpromocodes/9035dd9f-e647-4473-94db-72e8c1a8d489.png','UNUSE',NULL,130,100),(208,'414477nfHPz','/QRpromocodes/c5f8e077-8b3c-47e9-a2ac-9b299625d46d.png','UNUSE',NULL,130,100),(209,'023711QwVZa','/QRpromocodes/414e233d-0e92-4bbb-8417-394d5250d32c.png','UNUSE',NULL,130,100),(210,'634013vyShs','/QRpromocodes/ee2f6803-9d20-4568-ba05-545bf0765f93.png','UNUSE',NULL,130,100),(211,'143984nxXiz','/QRpromocodes/6f129b45-e479-4e69-91d1-a997093201db.png','UNUSE',NULL,130,100),(212,'876441mopMY','/QRpromocodes/645844cc-a249-4eae-a446-f53b4aa31bb1.png','UNUSE',NULL,130,100),(213,'526305BYvDt','/QRpromocodes/2565c026-3eb7-420c-b956-397be1e0bdae.png','UNUSE',NULL,130,100),(214,'073287pRiqg','/QRpromocodes/bdf6427b-586f-4ca8-8ae9-981b2f0d80a6.png','UNUSE',NULL,130,100),(215,'800514nkzsq','/QRpromocodes/3292348c-58ff-4079-b272-cec151696a8a.png','UNUSE',NULL,130,100),(216,'472280oBeme','/QRpromocodes/a03cdfee-e2b7-4fce-88fc-c27e8ed6e4f0.png','UNUSE',NULL,130,100),(217,'060331gheCB','/QRpromocodes/17aa1a6f-18f5-4371-a3f1-a9fde0a8209c.png','UNUSE',NULL,130,100),(218,'836002uLVXm','/QRpromocodes/a30ed225-b616-4b99-ae55-d1914616c19b.png','UNUSE',NULL,130,100),(219,'669478PuXHl','/QRpromocodes/d540197d-812a-4b61-907f-ff0f5fbcb809.png','UNUSE',NULL,130,100),(220,'083343qvGly','/QRpromocodes/0402bfb6-f70b-4917-9e11-395246f6c3f9.png','UNUSE',NULL,130,100),(221,'350888qEggB','/QRpromocodes/e8129e19-ed45-45e2-8bd5-78c81c21e4a9.png','UNUSE',NULL,130,100),(222,'466806szpRZ','/QRpromocodes/d656c6cb-f97f-4686-b764-cef68e7fccb2.png','UNUSE',NULL,130,100),(223,'319060aVWeS','/QRpromocodes/ad7810a0-bf2c-4e9c-88bf-f571ebc0417d.png','UNUSE',NULL,130,100),(224,'454569IhLQF','/QRpromocodes/ac4cbf7c-3216-48bb-9778-2beded2bda21.png','UNUSE',NULL,130,100),(225,'697369fCWih','/QRpromocodes/4de7453b-fe6e-4ac8-be58-e11a48c16b1f.png','UNUSE',NULL,130,100),(226,'301321LcZpX','/QRpromocodes/34ca95c2-89f9-4816-8159-2d3b181ef6f9.png','UNUSE',NULL,130,100),(227,'617812rMLta','/QRpromocodes/d0753cd0-ebb7-4613-9bc9-9768a2945d1d.png','UNUSE',NULL,130,100),(228,'043978UQWaP','/QRpromocodes/7b2ef74d-1c5d-4bc2-8165-29833bfcacc8.png','UNUSE',NULL,130,100),(229,'693262qELly','/QRpromocodes/ed90d826-e20c-4e7f-b5de-e9eefdff051b.png','UNUSE',NULL,130,100),(230,'341440GUZvA','/QRpromocodes/e2f5f37c-93d0-47b1-a6b1-d15061de3516.png','UNUSE',NULL,130,100),(231,'933265OavXY','/QRpromocodes/b7cf2a52-2cb4-487f-8204-13998d7b1fa9.png','UNUSE',NULL,130,100);
/*!40000 ALTER TABLE `promo_code_voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `refreshtoken`
--

LOCK TABLES `refreshtoken` WRITE;
/*!40000 ALTER TABLE `refreshtoken` DISABLE KEYS */;
INSERT INTO `refreshtoken` VALUES (100,'2021-09-27 01:57:43.257886','eb8977db-6e26-4a67-8865-75780e97d61f',102),(128,'2021-09-27 02:01:24.158005','67de69f0-c52c-4d01-b204-ee61aa776171',100),(129,'2021-09-27 02:02:05.683111','040318cd-50e0-4a1f-88fd-43e148847d67',100);
/*!40000 ALTER TABLE `refreshtoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_history`
--

LOCK TABLES `transaction_history` WRITE;
/*!40000 ALTER TABLE `transaction_history` DISABLE KEYS */;
INSERT INTO `transaction_history` VALUES (105,105.6,'2021-09-20 01:59:41.957000'),(117,105.6,'2021-09-20 02:00:28.069000'),(131,1056,'2021-09-20 02:02:49.096000');
/*!40000 ALTER TABLE `transaction_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (100,_binary '','jame','$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi','jame'),(101,_binary '','Charles','$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi','Charles'),(102,_binary '','Sam','$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi','Sam'),(103,_binary '','Michel','$2a$10$dGGZGOCVNtpkvBdwPNH3K.O0EMVbgRcPz0y/CPq0cW9jcXw7YR8Wi','Michel');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_authorities`
--

LOCK TABLES `user_authorities` WRITE;
/*!40000 ALTER TABLE `user_authorities` DISABLE KEYS */;
INSERT INTO `user_authorities` VALUES (100,1),(101,1),(102,1),(103,1),(102,2);
/*!40000 ALTER TABLE `user_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'estore'
--

--
-- Dumping routines for database 'estore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-20  2:10:24
