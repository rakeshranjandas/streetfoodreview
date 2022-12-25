ALTER TABLE `review` CHANGE `rating` `rating` ENUM('0','1','2','3','4','5') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '0';
