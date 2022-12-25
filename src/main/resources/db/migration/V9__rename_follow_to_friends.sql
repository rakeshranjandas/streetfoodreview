RENAME TABLE `streetfoodreview`.`follow` TO `streetfoodreview`.`friend`;

ALTER TABLE `friend` CHANGE `follower_user_id` `friend_user_id` INT(11) NOT NULL;