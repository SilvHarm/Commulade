INSERT INTO user_table (
	username, password
) VALUES
	('SilvHarm', 'SilvHarm'),
	('Niroune', 'Niroune'),
	('Ostrax', 'Ostrax'),
	('Cloquanfage', 'Cloquanfage'),
	('Solomur', 'Solomur'),
	('Arbriteau', 'Arbriteau'),
	('Doudolax', 'Doudolax'),
	('Sefiran', 'Sefiran'),
	('Zatrofi', 'Zatrofi'),
	('Xuvopole', 'Xuvopole'),
	('Nuritra', 'Nuritra');
	
INSERT INTO message (
	receiver_id, sender_id, previous_message_id, date_time,
	message_read, subject, content
) VALUES
	(1, null, null, '2018-01-03 06:47:24',
	true, 'Test in the Box', 'Vivamus feugiat justo eu dui hendrerit finibus. Nulla interdum fringilla ligula, a auctor nulla. Aliquam tempor venenatis cursus. Sed dapibus orci ut posuere posuere. Integer egestas at nibh eget imperdiet. Pellentesque consectetur dui quis arcu congue, in euismod lectus convallis. Curabitur eleifend iaculis diam vitae consectetur. Donec euismod sollicitudin suscipit. Quisque rhoncus imperdiet egestas. Sed ultricies imperdiet nisl quis vestibulum. Mauris eros libero, semper eget commodo eget, vehicula ut mauris. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse eleifend aliquet dui a venenatis. Fusce lacinia velit et sapien sollicitudin fringilla.'|| chr(10) ||'Praesent finibus felis eget ultrices laoreet. Aenean sit amet diam magna. Vivamus posuere risus urna, vel volutpat tellus convallis eu. Integer euismod massa nec scelerisque sollicitudin. Integer posuere mattis mauris, ut malesuada nisi aliquet nec. Mauris fringilla ipsum sed dapibus metus. '),
	(3, 1, null, '2018-01-05 08:57:34',
	true, 'Pâtes ?', '???'),
	(1, 3, 2, '2018-01-05 09:21:19',
	true, 'Pâtes ? Carbo'' !', '!'),
	(3, 1, 3, '2018-01-05 12:47:24',
	true, 'Pâtes ? Carbo'' !', 'Carbo imperdiet nisl quis vestibulum.'),
	(1, 3, 4, '2018-01-05 18:31:17',
	false, 'Pâtes ? Carbo'' !', 'Sed rutrum, ante a auctor tempus, tellus lectus pulvinar lorem, et volutpat massa libero eget nisl. Suspendisse facilisis suscipit commodo. Suspendisse eget nunc lacus. Mauris a rhoncus nisi. Morbi vel elementum tellus. Aliquam et risus ac amet.'),
	(1, 5, null, '2018-01-11 02:22:22',
	false, 'No One in the sky', 'Vivamus libero dui, tincidunt id ante quis, lacinia faucibus massa. Curabitur consectetur mi a justo ornare vestibulum. Praesent a nisi faucibus, ullamcorper dolor ut, varius eros. Curabitur condimentum lacus vel lacinia tincidunt. Donec fringilla sed dui sit amet consectetur. Pellentesque mi mauris, congue at arcu quis, scelerisque vehicula augue. Duis nunc felis, vulputate feugiat pharetra eu, gravida nec lorem. Phasellus non metus odio. Vestibulum pulvinar lacus interdum dignissim bibendum. Curabitur id elit magna. Nunc finibus varius sed.');


/*=====================================
		Topo
=======================================*/
INSERT INTO topo (
	name, edition_date, description
) VALUES
	('El Potito', '2017-02-17', null),
	('Salraisin', '2015-01-01', 'Décris les sites de la région de Champigna'),
	('Zoparana', '2014-06-01', null);
	
INSERT INTO topo_ownedby_user (
	owner_id, topo_id
) VALUES
	(1, 1),
	(3, 1),
	(4, 1),
	(11, 1),
	(11, 2),
	(11, 2);

INSERT INTO lending_topo (
	topo_owned_id, borrower_id, lending_start, lending_end
) VALUES
	(1, 5, '2017-02-03', '2017-02-07'),
	(1, 7, '2017-02-21', '2017-02-23'),
	(3, 9, '2017-03-05', '2017-03-17'),
	(2, 8, '2017-03-07', '2017-03-12'),
	(5, 2, '2017-03-21', '2017-03-28');
	
	
/*=====================================
		Escalade
=======================================*/
INSERT INTO site (
	name, date, photo_name, place, path_indication
) VALUES
	('Charmignière', '2017-02-01', null, 'Lorem', 'Ipsum esto de la quota'),
	('Camichoux', '2015-01-01', 'camichoux-5124.jpg', 'Lotrem', 'Ipsum esto de la quota'),
	('Torlodoudou', '2014-09-24', null, 'Logrum', 'Ipsum esto de la quota'),
	('Impoquina', '2016-03-24', 'impoquina_521.jpg', 'Lorpan', 'Ipsum esto de la quota'),
	('Estrazone', '2014-06-01', 'estroll.jpg', 'Lormom', 'Ipsum esto de la quota'),
	('Silacrate', '2014-06-01', null, 'Lorcem', 'Ipsum esto de la quota');
	
INSERT INTO site_topo (
	topo_id, site_id
) VALUES
	(1, 1),
	(2, 2),
	(2, 3),
	(3, 4),
	(3, 5),
	(3, 6);

INSERT INTO secteur (
	name, site_id, photo_name
) VALUES
	('Monzoulou', 1, null),
	('Harbanicha', 1, 'harbanicha56.jpg'),
	('Portinia', 2, null),
	('Mensouli', 2, null),
	('Kiklota', 2, 'kiklota.jpg'),
	('Silofra', 3, null),
	('Histany', 3, null),
	('Kibafqi', 4, null),
	('Isolab', 4, null),
	('Cifoltra', 5, null),
	('Zaqora', 6, 'zaquora_10.jpg'),
	('Galocha', 6, null),
	('Urtiquo', 6, 'utiquo.jpg');

INSERT INTO voie (
	name, secteur_id
) VALUES
	('Boom del Balza', 1),
	('Tom de Richpauvre', 1),
	('Salade de noix', 1),
	('null', 1),
	('Quinoa', 1),
	('Labangère', 2),
	('Hortimar', 2),
	('Brandisquo', 2),
	('Matmoissa', 3),
	('Sotron', 3),
	('Lamie', 3),
	('Zoulzabou', 3),
	('Fortn', 4),
	('Ight', 4),
	('Dezas', 5),
	('Duinbre', 5),
	('Xiolarou', 5),
	('Salamine', 6),
	('Tromb', 6),
	('Atour', 6),
	('Tourlari', 7),
	('Fouldavri', 7),
	('Quentonri', 7),
	('Mang Ton', 7),
	('Riz au Curry', 8),
	('Wololo', 8),
	('Potrolo', 8),
	('Salelolo', 9),
	('Tenabouri', 9),
	('Soulmari', 10),
	('Voilabouch', 10),
	('Danse la Vallée', 11),
	('Petrimor', 11),
	('Voltu', 11),
	('Céqui', 12),
	('Lapéro', 12),
	('Vod kaor Ange', 13),
	('Rotrinmar', 13);

INSERT INTO longueur (
	voie_id, previous_longueur_id, height, nombre_points, cotation
) VALUES
	(1, null, 34, 14, '8a'),
	(2, null, 34, 18, '7a'),
	(3, null, 34, 12, '3a'),
	(4, null, 34, 16, '6a'),
	(5, null, 34, 23, '7a'),
	(6, null, 34, 24, '4a'),
	(7, null, 34, 21, '9a'),
	(8, null, 34, 9, '3a'),
	(9, null, 34, 17, '3a'),
	(10, null, 34, 8, '8a'),
	(11, null, 34, 11, '3a'),
	(12, null, 34, 14, '6a'),
	(13, null, 34, 13, '7a'),
	(14, null, 34, 22, '6a'),
	(15, null, 34, 20, '3a'),
	(16, null, 34, 7, '4a'),
	(17, null, 34, 6, '5a'),
	(18, null, 34, 12, '3a'),
	(19, null, 34, 15, '9a'),
	(20, null, 34, 22, '6a'),
	(21, null, 34, 24, '8a'),
	(22, null, 34, 18, '7a'),
	(23, null, 34, 17, '3a'),
	(24, null, 34, 14, '4a'),
	(25, null, 34, 12, '3a'),
	(26, null, 34, 11, '5a'),
	(27, null, 34, 10, '9a'),
	(28, null, 34, 9, '3a'),
	(29, null, 34, 9, '7a'),
	(30, null, 34, 8, '3a'),
	(31, null, 34, 8, '6a'),
	(32, null, 34, 9, '4a'),
	(33, null, 34, 13, '5a'),
	(34, null, 34, 12, '3a'),
	(35, null, 34, 14, '9a'),
	(36, null, 34, 16, '3a'),
	(37, null, 34, 9, '3a'),
	(38, null, 34, 7, '5a');
	
	INSERT INTO longueur (
	voie_id, previous_longueur_id, height, nombre_points, cotation
) VALUES
	(2, 2, 34, 14, '8c'),
	(4, 4, 34, 18, '7b'),
	(5, 5, 34, 12, '4a'),
	(9, 9, 34, 16, '6b'),
	(12, 12, 34, 23, '7c'),
	(16, 16, 34, 24, '3c'),
	(17, 17, 34, 21, '9a'),
	(22, 22, 34, 9, '3c'),
	(29, 29, 34, 17, '3b'),
	(31, 31, 34, 8, '7c');


/*================================
		Commentaire
==================================*/
INSERT INTO comment (
	user_id, post_type, post_id,
	date_time, comment
) VALUES
	(null, 1, 1,
	'2018-01-03 06:47:24', 'Donec cursus, mauris sed venenatis hendrerit, eros purus accumsan nisi, sed ullamcorper ante orci sed tellus. Donec sem posuere.'),
	(null, 1, 3,
	'2018-01-09 22:36:57', 'In ut posuere tortor, in tempor massa. Aliquam et vulputate orci cras amet.'),
	(3, 2, 1,
	'2018-01-18 11:25:36', 'Nunc turpis est, congue et velit in, pulvinar lobortis erat. Nam at sapien at nunc tincidunt vulputate eu id neque. Integer ullamcorper maximus sed.'),
	(2, 2, 1,
	'2018-01-18 11:28:32', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum turpis eu massa nunc.'),
	(3, 2, 1,
	'2018-01-18 18:15:22', 'Olo dec lo quara do Sebara.'),
	(5, 2, 1,
	'2018-01-19 06:58:42', 'Proin eget lobortis tellus. Nulla facilisi. Morbi molestie arcu fermentum enim vehicula posuere.'),
	(2, 3, 2,
	'2018-01-21 04:05:06', 'Aliquam eget condimentum diam. Cras sit amet enim vitae velit nullam.'),
	(3, 4, 4,
	'2018-02-22 14:05:06', 'Maecenas consequat sollicitudin nisl amet.');
	