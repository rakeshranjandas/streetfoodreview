
INSERT INTO `user` (`id`, `name`, `email`) VALUES
(1, 'johncena', 'johncena@abc.com'),
(2, 'mirabelle', 'mirabelle@abc.com'),
(3, 'taylor', 'taylorswift@music.com'),
(4, 'adamlevine', 'adamlevine@maroon.com');


INSERT INTO `shop` (`id`, `name`, `location`) VALUES
(1, 'Sahu fast food, Jagamara', '1,1'),
(2, 'Munna Dahibara, Ravi Talkies', '2,2'),
(3, 'Bhaina Guguni, Garage Chhak', '3,3'),
(4, 'Mishra Chat, Khandagiri', '123,1423'),
(5, 'Mausa Gupchup, Old town', '423,324');


INSERT INTO `review` (`id`, `description`, `rating`, `user_id`, `shop_id`) VALUES
(1, 'Badhia', '4', 1, 2),
(2, 'Chaliba', '2', 1, 3),
(3, 'Thik thak', '3', 1, 4),
(4, 'Bobaal', '0', 1, 1),
(5, 'Faltu', '2', 2, 4);

INSERT INTO `follow` (`user_id`, `follower_user_id`) VALUES
(2, 1),
(3, 1),
(4, 1),
(3, 2),
(4, 2),
(3, 2),
(4, 1);



