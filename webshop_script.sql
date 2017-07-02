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

INSERT INTO user VALUES ('1', 'Bozo', 'Bjekovic', '123', '2017-01-01', 'bbozo', null);
INSERT INTO user VALUES ('2', 'Miso', 'Milic', '123', '2017-02-02', 'miso', null);