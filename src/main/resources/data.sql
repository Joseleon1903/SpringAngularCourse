/*
       Employee table insert
 */
insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (1, 'Carlos', 'carlosgEE@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (2, 'Julia', 'Julia@gmail.com','Analist', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUJHD04857');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (3, 'Maria', 'Maria@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888UJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (4, 'Sandra', 'Sandra@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUJHD0485OPL');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (5, 'Sergio', 'Sergio@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '93854757488PO8eUJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (6, 'Mister', 'Mister@gmail.com','UX', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUPOKLJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (7, 'Marta', 'Marta@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUJ896HD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (8, 'Carlos', 'carlosgEE@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '9385475747854888eUJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (9, 'Cintia', 'Cintia@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '9385475748oIOLKJ88eUJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (10, 'Carlos', 'carlosgEE@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '9385475ESVC74888eUJHD0485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (11, 'Rubia', 'Rubia@gmail.com','Developer', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '938547574888eUJHD896520485');

insert into Employee (employee_id,name, email, job_title, phone, image_url, employee_code )
VALUES (12, 'Elizabeth', 'Elizabeth@gmail.com','Quality', '809653214',
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSya5dwz7sppH6NGJVip5KpNHbO6feSmMVJoQ&usqp=CAU', '93854757LMNVCX4888eUJHD0485');

ALTER SEQUENCE employee_sequence RESTART WITH 13;
/*
       student table insert
 */

insert into Student (id, first_name, last_name, email, age ) VALUES (1, 'Mario', 'Carluchi','Carichi@gmail.com', 15);
insert into Student (id, first_name, last_name, email, age ) VALUES (2, 'Luigi', 'Catalano','Catalano@gmail.com', 25);
insert into Student (id, first_name, last_name, email, age ) VALUES (3, 'Sandra', 'Cavalier','CarCavalier_89@gmail.com', 16);
insert into Student (id, first_name, last_name, email, age ) VALUES (4, 'Jessica', 'Bisquite','JessicaRiga@gmail.com', 23);

/*
       category table insert
 */
insert into Category(id, name, code, status)values(1, 'Tecnology', 'TEC-00', true);
insert into Category(id, name, code, status)values(2, 'Antiques', 'ANT-01', true);
insert into Category(id, name, code, status)values(3, 'Art', 'ART-02', true);
insert into Category(id, name, code, status)values(4, 'Baby', 'BB-03', true);
insert into Category(id, name, code, status)values(5, 'Books', 'BK-04', true);
insert into Category(id, name, code, status)values(6, 'Industrial', 'IND-05', true);
insert into Category(id, name, code, status)values(7, 'Cameras', 'CAM-06', true);
insert into Category(id, name, code, status)values(8, 'Photo', 'PH-07', true);
insert into Category(id, name, code, status)values(9, 'Cell Phones', 'CELL-08', true);
insert into Category(id, name, code, status)values(10, 'Cars', 'CAR-09', true);

--  *************************************************
insert into Category(id, name, code, status)values(11, 'Clothing', 'CL-10', true);
insert into Category(id, name, code, status)values(12, 'Accessories', 'AC-01', true);
insert into Category(id, name, code, status)values(13, 'Collectibles', 'CC-02', true);
insert into Category(id, name, code, status)values(14, 'Computers/Tablets', 'CT=-03', true);
insert into Category(id, name, code, status)values(15, 'Networking', 'NET-04', true);
insert into Category(id, name, code, status)values(16,  'Movies', 'MOV-05', true);
insert into Category(id, name, code, status)values(17, 'Entertainment Memorabilia', 'ENT-06', true);
insert into Category(id, name, code, status)values(18, 'Gift Cards/Coupons', 'CARD-07', true);
insert into Category(id, name, code, status)values(19, 'Health Beauty', 'HEAL-08', true);
insert into Category(id, name, code, status)values(20, 'Home Garden', 'HOM-09', true);
--  *************************************************

insert into Category(id, name, code, status)values(21, 'Jewelry Watches', 'JEW-01', true);
insert into Category(id, name, code, status)values(22, 'Music', 'MUS-02', true);
insert into Category(id, name, code, status)values(23, 'Pet Supplies', 'PET-03', true);
insert into Category(id, name, code, status)values(24, 'Sporting', 'SPR-04', true);
insert into Category(id, name, code, status)values(25, 'Hobbies', 'HOB-05', true);
insert into Category(id, name, code, status)values(26, 'Travel', 'TRL-06', true);
insert into Category(id, name, code, status)values(27, 'Video Games Console', 'VID-07', true);
insert into Category(id, name, code, status)values(28, 'Unknow', 'UNK-00', true);
ALTER SEQUENCE category_sequence RESTART WITH 29;

/*
       destination table insert
 */
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(1, 'Mississipi City', '615  Marcus Street','Mississipi', 'Alabama','35816',  2.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(2, 'Florida Town', '05  Main Street','Florida', 'Florida','58623',  5.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(3, 'Kentucky City', '615  Saint Thomas Street','Kentucky', 'Kentucky','58876',  1.2);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(4, 'California City', '777  Galicia Street','California', 'California','37716',  2.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(5, 'Florida Country', '65  second Street','Florida', 'Florida','89631',  7.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(6, 'Ohio City', '014  Virginity Street','Ohio', 'Ohio','85631',  4.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(7, 'Nebraska City', '615  Marcus Street','Nebraska', 'Nebraska','35800',  12.10);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(8, 'Minnesota City', '705  cleveland boulevard Street','Minnesota', 'Minnesota','35847',  1.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(9, 'New York City', '890  boulevard Street','New York', 'New York','35875',  7.8);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(10, 'Illinois City', '541  Cartel Street','Illinois', 'Illinois','89632',  8.25);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(11, 'California Town', '256  Madison Street','California', 'California','00589',  12.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(12, 'Virginia City', '875  Square Street','Virginia', 'Virginia','10010',  15.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(13, 'Connecticut City', '555  Third Street','Connecticut', 'Connecticut','20020',  4.5);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(14, 'New Jersey City', '010  Saint Jule Street','New Jersey', 'New Jersey','69632',  5.20);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(15, 'Texas City', '002  june Street','Texas', 'Texas','35410',  9.99);
insert into Destination(destination_id, name, address, city, region, postal_code, charge)values(16, 'Chicago City', '639  Princess Street','Chicago', 'Chicago','87530',  3.5);
ALTER SEQUENCE destination_sequence RESTART WITH 17;

/*
       role table insert
 */
insert into Role(role_id, role_name, description, creation_date, permission)values(1, 'BASIC_USER', 'Simple user of the application',CURRENT_TIMESTAMP(), 'BASIC');
insert into Role(role_id, role_name, description, creation_date, permission)values(2, 'ADMIN_USER', 'Administrator user of the application',CURRENT_TIMESTAMP(), 'ADMIN');
insert into Role(role_id, role_name, description, creation_date, permission)values(3 , 'UNKNOW_USER', 'Unknow user of the application',CURRENT_TIMESTAMP(), 'NONE');
ALTER SEQUENCE role_sequence RESTART WITH 4;

/*
       default admin user table insert
 */
insert into Customer  (customer_id, customer_code,first_name, last_name, address, birthday ) VALUES (1, 'ADMIN_CODE', 'administrator', 'system administrator','NONE',CURRENT_TIMESTAMP() );
insert into Sys_User  (user_id, email,username, password, creation_day, last_update, status, role_id, customer_id) VALUES (1, 'SysAdmin@admin.com', 'admin', 'admin01',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), 'ACTIVE', 2 , 1 );

ALTER SEQUENCE user_sequence RESTART WITH 2;
ALTER SEQUENCE customer_sequence RESTART WITH 2;

/*
       product table insert
 */
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(1, 'Computer','Personal computer', 1, 'AHSGD-85', 85.50, 20, 'https://www.quietpc.com/images/products/intel-compute-stick-tv-large.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(2, 'HP Pavellion','Personal Laptop', 1, 'AH86GD-85', 120.50, 5, 'https://images-na.ssl-images-amazon.com/images/I/61Srnd0L8YL._AC_SX679_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(3, 'Samsumng Turbo','Personal laptop', 1, 'SAMG-00', 250.50, 20, 'https://fdn.gsmarena.com/imgroot/news/20/06/xiaomi-mi-notebook-15-pro-2020-announced/-1200/gsmarena_000.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(4, 'HP Chromebook 14','Personal computer', 1, 'N3350', 250.99, 15, 'https://media.wired.com/photos/59e95252c2c41472a6d3e474/master/w_2560%2Cc_limit/ChromebookTA.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(5, 'Acer Chromebook 11.6','Personal computer', 1, 'JUO85', 562.00, 20, 'https://images-na.ssl-images-amazon.com/images/I/71ibtUL6c2L._AC_SL1500_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(6, 'Dell 11.6" Chromebook Intel','Personal computer', 1, 'AGD85', 356.30, 0, 'https://images-na.ssl-images-amazon.com/images/I/61mdECoYszL._AC_SL1280_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(7, 'Lenovo 11.6 Thinkpad','Personal computer', 1, 'GG56', 585.50, 0, 'https://images-na.ssl-images-amazon.com/images/I/61oEkxwGEYL._AC_SX355_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(8, 'Lenovo Flex 6 2','Personal computer', 1, '522LX', 596.50, 0, 'https://brain-images-ssl.cdn.dixons.com/1/9/10207991/u_10207991.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(9, 'Gateway 11.6','Personal computer', 1, 'GAT11', 1200.50, 30, 'https://images-na.ssl-images-amazon.com/images/I/81tPc3YcDlL._AC_SY355_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(10, 'Samsung 4 15.6','Personal computer', 1, 'POP85', 1560.10, 0, 'https://img.global.news.samsung.com/pe/wp-content/uploads/2018/05/62-1024x683.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(11, 'HP Stream','Personal computer', 1, 'HP33', 85.50, 20, 'https://vombos.com/wp-content/uploads/2021/02/HP-STREAM-14-2.jpg' );
--
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(12, 'Hercules Bodybuilding','Book Train Without Weights "FREE SHIPPING" and "FREE GIFT"', 5, 'ISBN8965233205', 20.25, 12, 'https://static01.nyt.com/images/2019/11/21/books/best-books-2019/best-books-2019-mobileMasterAt3x.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(13, 'True Strength','My Journey from Hercules to Mere Mortal and How Nearly Dying Save', 5, 'ISBN8566322322', 45.10, 6, 'https://media.newyorker.com/photos/5fc53ea865b1e636a7ab47b7/master/w_1600%2Cc_limit/TNY-BestBooks2020-EPJones.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(14, 'Pillars of Hercules','A Grand Tour of the Mediterranean by Paul Theroux', 5, 'ISBN78563322235', 256, 13, 'https://i.pinimg.com/originals/75/14/35/751435e19c13f980313c7df3077de8e0.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(15, 'Zenmaster Coloring','Books-Adult Color Bk Of Chihuahuas T BOOK NEW', 5, 'ISBN786633214555', 10.30, 0, 'https://i.insider.com/5e873c73dcd88c2607758a74?width=1100&format=jpeg&auto=webp' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(16, 'Kate in Waiting','by Becky Albertalli SIGNED FIRST EDITION', 5, 'ISBN1256986563385', 56.50, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFyLWTQEkyKJDuiwM1XSMzy0qbLXjVd1xzEA&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(17, 'Stephen King Night Shift','GIFT EDITION SLIPCASED Cemetery Dance Beautiful book!', 5, 'ISBN46696632155', 63.10, 0, 'https://media.newyorker.com/photos/5fc53ead04d5eeb69d5bb23a/master/w_1600%2Cc_limit/TNY-BestBooks2020-Serpell.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(18, 'The Whys Of Cooking','Book Janet McKenzie Hill', 5, 'ISBN78556333214455', 33.50, 40, 'https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1612555832-41pxgSgxYL.jpg?crop=1xw:1xh;center,top' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(19, 'Black Book','by Rankin', 5, 'ISBN9780752883571 ', 22.50, 20, 'https://media1.popsugar-assets.com/files/thumbor/5FNrv-PHKmE1ONBomol5FellUSw/fit-in/728xorig/filters:format_auto-!!-:strip_icc-!!-/2020/04/10/871/n/1922283/47f422ff5e90cf198d85a7.39740782_/i/best-books-by-women-2020.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(20, 'A New History of England','by Jeremy Black (English) Paperback Book Free Shipping!', 5, 'ISBN7896632541', 23.11, 5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa5k6m2bgG4WB6DXK5O6AqCFBZ0_gwdhFtsw&usqp=CAU' );

insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(21, 'Women Clothes Casual Women''s','Clothing Funny Cute Cat Print Long Sleeve T-Shirts', 11, 'CLOS9685', 15.70, 5, 'https://i.shopstyle-cdn.com/i/af4b895e-7a2c-4db6-8e09-224772c538d9/258-258/aerosoles-womens-chlose-friend-sandal-MadiD.jpeg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(22, 'Aventura Clothing Casual Sleeveless Dress','Women''s Size XS, Print NWT', 11, 'IOPLN', 13.53, 9, 'https://belk.scene7.com/is/image/Belk?layer=0&src=2900798_TOOCHLOSE_A_001_T10L00&layer=comp&$DWP_PRODUCT_PDP_MOBILE_L$' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(23, 'Coveted Clothing Womens Coral','Sleeveless Lace Shift Dress Small', 11, '963PL85', 26.50, 0, 'https://i.pinimg.com/736x/9d/0b/7a/9d0b7a4982c3cf5bd23057757331a55d.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(24, 'Pregnant Women Summer','Nursing Dress Stripe Sleepwear Sleeveless Casual Clothing', 11, 'AHSGD89', 14.99, 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT68XLfhO-Hz5Y5w-4AL6ojmedAD42SwJFZmQ&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(25, 'Pregnant Women Nursing Vest','Dress Maternity Summer Casual Breastfeeding Clothing', 11, 'AA-99', 89.29, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-bPafdtqqGNriZEBzn6SuFvHXczq5i_5S5g&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(26, 'ONE CLOTHING Womens Navy Tie Dye','Short Sleeve Above The Knee Dress Size: S', 11, 'BB-896', 63.99, 25, 'https://i.ebayimg.com/thumbs/images/g/ZpkAAOSwne1fwq-g/s-l300.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(27, 'DKNY Women''s Sleeveless Scuba','Stretch Dress Sheath 8 Casual Work Clothes NWT', 11, 'CC-987', 11.99, 0, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWCQOjlyb9ryvj-LlMBxqq-gAy1VQOZcwMRg&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(28, 'Alligator Embroidered','Badge Iron On Sew On Clothes', 11, 'AA-256', 63.99, 0, 'https://img.joomcdn.net/5368d4c2a1ab4a46ffdbe2b04c46bc4d3041d65e_400_400.jpeg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(29, 'Children''S Clothing','Bulktops Skirt Dress Underpants', 11, 'II-85', 6.99, 3, 'https://www.picclickimg.com/d/l400/pict/264654389009_/Womens-Aerosoles-Chlose-Range-Nude-Beige-Flat-Toe.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(30, 'Pink Korean Children''S','Clothing Dot Tops', 11, 'PLO-96385', 30, 0, 'https://www.picclickimg.com/d/l400/pict/264681071692_/WOMENS-AEROSOLES-CHLOSE-TOGETHER-THONG-LEATHER-SANDAL-SHOES.jpg' );

insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(31, 'Frank Holme Signed Original Antique','WC Painting Arab Eastern Camel & Figures', 3, 'ART-85', 45.50, 0, 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/paiting-gurpreet-singh.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(32, 'Hand Painted impressionism','art-Portrait Canvas Oil Painting for Home Wall Art', 3, 'ART-8555', 11.99, 20, 'https://ae01.alicdn.com/kf/HTB1I4h_HpXXXXcxapXXq6xXFXXXJ/New-Painting-Yellow-Butterfly-Oil-Paiting-On-Canvas-Beautiful-Animal-Butterfly-Pictures-For-Study-Room-And.jpg_Q90.jpg_.webp' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(33, 'Russian Avant Garde','Suprematist Ivan Kliun, bears signature in Cyrillic', 3, 'ART-99', 85.50, 20, 'https://images.saatchiart.com/saatchi/1617725/art/7776925/6844933-XMXRVTWK-7.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(34, 'BLUE FLOWERS EXPRESSIONIST OIL PAINTING','BY ARTIST VIVEK MANDALIA FLORAL ARTWORK', 3, 'ARTT-78', 25.99, 11, 'https://ae01.alicdn.com/kf/HTB1iLfrKbuWBuNjSszgq6z8jVXaF/Fashion-Colors-Lion-Pop-Art-Oil-Painting-Wall-Art-Picture-Paiting-Canvas-Paints-Home-Decor-HD.jpg_q50.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(35, 'Painting Print Man Naked Nude Erotic Art','Nude Man Erotic Beautiful Art Print', 3, 'ART-125', 256.99, 20, 'https://st2.depositphotos.com/1000891/12034/i/950/depositphotos_120341568-stock-photo-woman-paiting-the-wall.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(36, 'Painting Print Man Naked Nude Erotic Art','Nude Man Erotic Beautiful Art Print', 3, 'ART-416', 13.99, 3, 'https://i.ebayimg.com/images/g/bwcAAOSwUjJergWK/s-l300.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(37, 'Man Nude Erotic Art','Print 20x30cm, Nude Man Erotic Art Print', 3, 'ART-741', 10.50, 5, 'https://i.pinimg.com/originals/c5/53/0e/c5530e657cd2bc770d1e106b2890eab6.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(38, 'Watercolour Painting','Original and signed', 3, 'ART-01', 12.50, 0, 'https://i.etsystatic.com/13709905/r/il/b5fdb7/1043926480/il_570xN.1043926480_lr92.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(39, 'Watercolour, Drawing Signed!!!','Carl Jürgen tohmfor', 3, 'ART-0285', 63.99, 7, 'https://ae01.alicdn.com/kf/HTB1vxJMkUUIL1JjSZFrq6z3xFXa8/Big-Sale-terrier-art-Oil-Painting-Wall-Art-Picture-Paiting-Canvas-Paints-Home-Decor-HD-Print.jpg_q50.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(40, 'Printing 20x30cm Man Naked Nude Erotic Art','Nude Man Erotic Beautiful Art Print', 3, 'ART-13', 56.99, 0, 'https://www.nguyenartgallery.com/wp-content/uploads/Portrait-11-Vietnam-Art-Paiting.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(41, 'Lone Star Tip Original ACEO','Pin Up Sexy Sketch Card by Jimbing', 3, 'ART-963', 99.99, 9, 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/2/haunted-house-acrylic-paiting-rick-berube.jpg' );

--
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(42, 'REFURBISHED STORM FIRE ROAD','FULLY PLUGGED, REVIVED, RESURFACED,15LBS', 24, 'SPORT-896', 33.50, 20, 'https://modern-gadget.com/wp-content/uploads/2019/03/Tangram-Smart-Rope.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(43, 'Vintage Nokona Pro Line','Kangaroo Leather Baseball Glove', 24, 'SPORT-85', 14.99, 0, 'https://lh3.googleusercontent.com/proxy/7BybK86HWa5qsnQJoav8-PZW4dZtZKVdLVYbZ83_nDCpVC3FCsTfg7kiK_sc0gkXK9R9AJ7Hfs-TsZBF3xDGDQ4wDkJx63KFOI_5vlvo7PEsgHmy4Oee6vXpjvM6GvfjWbZAmbXr2KY' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(44, 'Nike Tiempo Legend 8 Elite FG','Cleats Black Red Size 10.5 BRAND NEW Soocer Boots', 24, 'SPORT-8745', 78.99, 7, 'https://i.ebayimg.com/images/g/tGYAAOSw~b1d0Cma/s-l300.png' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(45, 'SHIRT ARSENAL 1982-1983','PETROVIC SERBIA JERSEY CRVENA ZVEZDA YUGOSLAVIA STANDARD', 24, 'SPORT-41', 785.99, 11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQis9rFtO32CXBOxZiWJm7McbmrZhCE9GfkoQ&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(46, 'Nike Men''s Tiempo Legend 7 Pro FG','White Blue Soccer Cleats Size 10 AH7241-107', 24, 'SPORT-789', 10.50, 0, 'https://cpshapes.com/wp-content/uploads/2020/06/527-4vxjbj-350x350.jpeg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(47, 'VAUGHN EPIC 8404 GOALIE','CHEST AND ARM PROTECTOR shoulder pads youth Small', 24, 'SPORT-2013', 5.50, 0, 'https://lh3.googleusercontent.com/proxy/kJMUJhZ9dxxEI735qrrAIy2HZjQ29ztAgD1oUVYJjIPrJ2nFQmayMylFl8nTh1-0DR8pz6YoYlPfBw_imBXPsPXDo8w-hHVHNPYCG6dGVssRy77NP6d8Nd14tF_2Xosw4Gy8DGdYog8' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(48, '2017 Demarini CF9 SPRITE -11 31/20','Composite Fastpitch Softball Bat', 24, 'SPORT-2020', 78.50, 6, 'https://m.media-amazon.com/images/I/71QGtFxIMQL.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(49, 'CORE Dark Blue SKATEBOARD TRUCKS','WHEELS, ABEC 5 BEARIN', 24, 'SPORT-7896', 24.99, 13, 'http://naijainfolab.com.ng/wp-content/uploads/2020/05/ski-mask-sport-gadget.-.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(50, 'Element Skateboards','Peanuts Snoopy Joe Cool Appleyard Skateboard Deck', 24, 'SPORT-14789', 230.99, 0, 'https://images-na.ssl-images-amazon.com/images/I/51KiVm3-02L._AC_SX425_.jpg' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(51, 'Tommy Sandoval ','Zero Rasta Burning Deck Skateboard 8.25', 24, 'SPORT-10147', 100, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdWloF1G2czK6VHW_b6TlX3zRZGyufJY56SA&usqp=CAU' );
insert into product (product_id,name, description, category_id, product_code, price,discount_percent, image_path) values(52, 'Skateboard 30" x 10"','No Fear long board Good Wheels and Deck Skateboarding', 24, 'SPORT-850', 450.50, 0, 'https://www.giftsicle.com/wp-content/uploads/2020/03/best-tech-gifts-2021-new-latest-electronic-gadgets-for-men-women.png' );

ALTER SEQUENCE product_sequence RESTART WITH 53;


/*
       order_status table insert
 */
insert into Order_status (order_status_id,name, description ) values(1, 'PENDING', 'Order is waiting to sending');
insert into Order_status (order_status_id,name, description ) values(2, 'CONFIRMED', 'Order is confirmed and send');
insert into Order_status (order_status_id,name, description ) values(3, 'CANCELED', 'Order was cancel by the customer');
insert into Order_status (order_status_id,name, description ) values(4, 'REFUSE', 'Something went wrong with the transaction');
insert into Order_status (order_status_id,name, description ) values(5, 'IN_PROGRESS', 'Order is in progress');

ALTER SEQUENCE order_status_sequence RESTART WITH 6;
