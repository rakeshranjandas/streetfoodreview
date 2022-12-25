CREATE TABLE `streetfoodreview`.`review` ( `id` INT NOT NULL AUTO_INCREMENT , `description` MEDIUMTEXT NOT NULL , `rating` ENUM('0','1','2','3','4','5') NOT NULL , `user_id` INT NOT NULL , `shop_id` INT NOT NULL , PRIMARY KEY (`id`), INDEX (`user_id`), INDEX (`shop_id`)) ENGINE = InnoDB;