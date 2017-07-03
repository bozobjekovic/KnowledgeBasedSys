set foreign_key_checks = 0;

drop table action_event;
drop table category_actions;
drop table consumption_limit;
drop table customer_category;
drop table general_discount;
drop table invoice;
drop table invoice_item;
drop table item_discount;
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