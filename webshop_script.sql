set foreign_key_checks = 0;

drop table action_event;
drop table category_actions;
drop table consumption_limit;
drop table customer_category;
drop table customer_category_consumption_limit;
drop table general_discount;
drop table invoice;
drop table invoice_item;
drop table item_discount;
drop table invoice_invoice_item;
drop table product;
drop table product_category;
drop table role;
drop table user;
drop table user_profile;

set foreign_key_checks = 1;

select * from user;
select * from user_profile;
select * from product;
select * from product_category;
select * from invoice;
select * from invoice_item;
select * from invoice_invoice_item;
select * from customer_category;
select * from consumption_limit;
select * from customer_category_consumption_limit;
select * from action_event;
select * from category_actions;

insert into user_profile values ('1', 'Despota Stefana 7a', '50', null);
insert into user_profile values ('2', 'Gagarinova 84', '33', null);

INSERT INTO user VALUES ('1', 'Bozo', 'Bjekovic', '123', '2017-01-01', 'bbozo', null, '1');
INSERT INTO user VALUES ('2', 'Miso', 'Milic', '123', '2017-02-02', 'miso', null, '2');

INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('1', '0', 'School', null);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('2', '0', 'Electronics', null);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('3', '0', 'Clothes', null);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('4', '0', 'Furniture', null);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('5', '0', 'Books', null);

INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('6', '0', 'Bags', 1);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('7', '0', 'Glue', 1);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('8', '0', 'Pencils', 1);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('9', '0', 'Books', 1);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('10', '0', 'Cameras', 2);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('11', '0', 'Computers, Tablets & laptop', 2);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('12', '0', 'Mobile phones', 2);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('13', '0', 'Audio', 2);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('14', '0', 'BedroomWomen\'s Clothing', 3);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('15', '0', 'Women\'s Shoes', 3);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('16', '0', 'Men\'s Clothings', 3);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('17', '0', 'Men\'s Shoes', 3);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('18', '0', 'Bedroom', 4);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('19', '0', 'Bathrooom', 4);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('20', '0', 'Living room', 4);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('21', '0', 'Science fiction', 5);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('22', '0', 'Drama', 5);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('23', '0', 'Mystery', 5);
INSERT INTO product_category (`id`, `max_discount`, `name`, `supercategory_id`) VALUES ('24', '0', 'Romance', 5);

INSERT INTO product  VALUES ('1', true, '34252', '2017-06-06', false, 'image', '4', 'Bag 1', '1070.67', '34', '6');
INSERT INTO product  VALUES ('2', true, '32456', '2017-06-06', false, 'image', '4', 'Bag 2', '1170.67', '15', '6');
INSERT INTO product  VALUES ('3', true, '35785678', '2017-06-06', false, 'image', '4', 'Bag 3', '2070.67', '37', '6');
INSERT INTO product  VALUES ('4', true, '45373567', '2017-06-06', false, 'image', '4', 'Bag 4', '3070.67', '20', '6');
INSERT INTO product  VALUES ('5', true, '346233', '2017-06-06', false, 'image', '4', 'Bag 5', '4070.67', '19', '6');
INSERT INTO product  VALUES ('6', true, '653884', '2017-06-06', false, 'image', '4', 'Bag 6', '5070.67', '22', '6');
INSERT INTO product  VALUES ('7', true, '4234423', '2017-06-06', false, 'image', '4', 'Re glued', '55.67', '144', '7');
INSERT INTO product  VALUES ('8', true, '342423', '2017-06-06', false, 'image', '4', 'Blue glue', '68.67', '32', '7');
INSERT INTO product  VALUES ('9', true, '887688', '2017-06-06', false, 'image', '4', 'Pencils pack', '100.30', '5', '8');
INSERT INTO product  VALUES ('10', true, '098868', '2017-06-06', false, 'image', '4', 'Good pencil', '80.67', '88', '8');
INSERT INTO product  VALUES ('11', true, '43664', '2017-06-06', false, 'image', '4', 'Pencil 4', '20.66', '32', '8');
INSERT INTO product  VALUES ('12', true, '97789', '2017-06-06', false, 'image', '4', 'Math', '1000.43', '34', '9');
INSERT INTO product  VALUES ('13', true, '6454654', '2017-06-06', false, 'image', '4', 'English', '2000.67', '6', '9');
INSERT INTO product  VALUES ('14', true, '65655', '2017-06-06', false, 'image', '4', 'History', '700.89', '31', '9');
INSERT INTO product  VALUES ('15', true, '5463456', '2017-06-06', false, 'image', '4', 'Camera 1', '5070.67', '34', '10');
INSERT INTO product  VALUES ('16', true, '14562352', '2017-06-06', false, 'image', '4', 'Camera 2', '6005.67', '14', '10');
INSERT INTO product  VALUES ('17', true, '213332', '2017-06-06', false, 'image', '4', 'Asus 3425', '725.78', '4', '11');
INSERT INTO product  VALUES ('18', true, '23442', '2017-06-06', false, 'image', '4', 'MacBook PRO', '2225.78', '4','11');
INSERT INTO product  VALUES ('19', true, '64574', '2017-06-06', false, 'image', '4', 'MacAir', '1625.43', '4', '11');
INSERT INTO product  VALUES ('20', true, '4647', '2017-06-06', false, 'image', '4', 'Dell 32141', '625.78', '4', '11');
INSERT INTO product  VALUES ('21', true, '86790', '2017-06-06', false, 'image', '4', 'HP Spectre', '2225.78', '4', '11');
INSERT INTO product  VALUES ('22', true, '123241', '2017-06-06', false, 'image', '4', 'Iphone 7', '855.67', '4', '12');
INSERT INTO product  VALUES ('23', true, '746453', '2017-06-06', false, 'image', '4', 'LG G3', '255.67', '14', '12');
INSERT INTO product  VALUES ('24', true, '97864', '2017-06-06', false, 'image', '4', 'Iphone 6', '545.54', '6', '12');
INSERT INTO product  VALUES ('25', true, '356785', '2017-06-06', false, 'image', '4', 'Nokia 3310', '15.37', '4', '12');
INSERT INTO product  VALUES ('26', true, '979777', '2017-06-06', false, 'image', '4', 'Samsung S8', '985.78', '15', '12');
INSERT INTO product  VALUES ('27', true, '234234', '2017-06-06', false, 'image', '4', 'Drama book', '1000.43', '34', '22');
INSERT INTO product  VALUES ('28', true, '345345', '2017-06-06', false, 'image', '4', 'Mistery book', '3000.67', '6', '23');
INSERT INTO product  VALUES ('29', true, '56894', '2017-06-06', false, 'image', '4', 'Romance book', '700.89', '31', '24');

INSERT INTO customer_category values ('1', 'Regular');
INSERT INTO customer_category values ('2', 'Silver');
INSERT INTO customer_category values ('3', 'Gold');