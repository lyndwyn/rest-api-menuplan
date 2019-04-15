/*
 * Create Users
 * */

INSERT INTO public.users(account_expiration_date, credentials_expiration_date, email, enabled, first_name, last_name, living_goup, locked, password) VALUES (
			'2020-01-01',
			'2020-01-01', 
			'ivy@test.ch', 
			1, 
			'Ivy',  
			'Minoretti', 
			0, /* living_goup */
			0, 
			'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy' /* heinz */
	);

INSERT INTO public.users(account_expiration_date, credentials_expiration_date, email, enabled, first_name, last_name, living_goup, locked, password) VALUES (
		'2020-01-01',
		'2020-01-01', 
		'vivienne@test.ch', 
		1, 
		'Vivienne',  
		'Oberholzer', 
		0, /* living_goup */
		0, 
		'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy' /* heinz */
	);
	
INSERT INTO public.users(account_expiration_date, credentials_expiration_date, email, enabled, first_name, last_name, living_goup, locked, password) VALUES (
		'2020-01-01',
		'2020-01-01', 
		'wgeins@test.ch', 
		1, 
		'Wohngruppe Eins',  
		'Eins', 
		1, /* living_goup */
		0, 
		'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy' /* heinz */
	);

INSERT INTO public.users(account_expiration_date, credentials_expiration_date, email, enabled, first_name, last_name, living_goup, locked, password) VALUES (
		'2020-01-01',
		'2020-01-01', 
		'pascal@test.ch', 
		1, 
		'Pascal',  
		'Meier', 
		0, /* living_goup */
		0, 
		'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy' /* heinz */
	);
			
/*
 * Create Authorities
 * */			
INSERT INTO public.authority(name) VALUES (
				'WRITE'
			);
INSERT INTO public.authority(name) VALUES (
				'READ'
			);
INSERT INTO public.authority(name) VALUES (
				'EDIT'
			);
INSERT INTO public.authority(name) VALUES (
				'MASTER'
			);
			
/*
 * Create Roles
 */			
INSERT INTO public.role(name)	VALUES (
			'ADMIN'
		);
INSERT INTO public.role(name)	VALUES (
			'USER'
		);
		
INSERT INTO public.role(name)	VALUES (
			'KOCH'
		);

/*
 * Create Menus - Normal 
 */		
INSERT INTO public.menu(description, name, type) VALUES (
		'Enthaltet Milchprodukte', 
		'Schweinsgeschnetzeltes mit Reis und Blumenkohl, Blattsalat', 
		0
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'Teigwaren enthalten Ei und Getreide', 
		'Schweins Cordon Bleu mit Wintergem�se und Teigwaren, Blattsalat', 
		0
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Dillquarkdipp enth�lt Michlprodukte', 
		'Schinkensandwich, Dillquarkdipp, Blattsalat', 
		0
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Pommes mit Schnitzel, Blattsalat', 
		0
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Schweinsvoressen mit Reis, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Toast Hawaii, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Flammkuchen, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Fr�hlingsrollen mit Schwein, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Pizza Prosciutto, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Die Suppe enth�llt ein Rollschinken (Schwein).', 
		'B�ndner Gerstensuppe, Blattsalat', 
		0
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Regionale Kartoffeln.', 
		'Schweinspl�tzchen mit Bratkartoffeln, Blattsalat', 
		0
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'Nudeln enthalten Getreide und Eier.', 
		'Nudeln mit Rahmsauce und Schwein, Blattsalat', 
		0
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milch und Eier.', 
		'Omeletten mit Speck, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milchprodukte und Eier.', 
		'Burger mit Speck und Pommes, Blattsalat', 
		0
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milchprodukte und Eier.', 
		'Kalte Platte mit Schwein (W�rste, Trockenfleisch usw.), Brot, Blattsalat', 
		0
	);
	
/*
 * Create Menu - Kein Schwein
 */
INSERT INTO public.menu(description, name, type) VALUES (
		'Enthaltet Milchprodukte', 
		'Poulet Brust an einer Senfrahmsauce mit Reis und Blumenkohl, Blattsalat', 
		1
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'Teigwaren enthalten Ei und Getreide', 
		'Hackbraten mit Wintergem�se und Teigwaren, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Dillquarkdipp enth�lt Michlprodukte', 
		'Quiche mit Lachs und Brokkoli, Dillquarkdipp, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Pommes mit Chicken Nuggets, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Rindsvoressen mit Reis, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Lachstoast, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Gyros mit Zucchini und Brot, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Fr�hlingsrollen mit Crevetten, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Pizza Margaritha, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Die Suppe enth�llt ein Suppenhuhn.', 
		'Gem�se-H�hnersuppe, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Regionale Kartoffeln.', 
		'Rindspl�tzchen mit Bratkartoffeln, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Nudeln enthalten Getreide und Eier.', 
		'Chicor�e Huhn mit Nudeln, Blattsalat', 
		1
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Omeletten mit Rinderschinken, Blattsalat', 
		1
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milch und Eier.', 
		'Rinds-Burger und Pommes, Blattsalat', 
		1
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milchprodukte und Eier.', 
		'Kalte Platte mit Rind (W�rste, Trockenfleisch usw.), Brot, Blattsalat', 
		1
	);	

/*
 * Create Menu - Vegetarisch
 */
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Gem�se Pfanne mit Reis und Blumenkohl, Blattsalat', 
		2
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'Teigwaren enthalten Ei und Getreide', 
		'Wintergem�se Pfanne mit Teigwaren, Blattsalat', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Dillquarkdipp enth�lt Michlprodukte', 
		'Gem�sequiche, Dillquarkdipp, Blattsalat', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Pommes mit Gem�se-Frikadellen', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Regionales Gem�se.', 
		'Gem�seeintopf, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enzh�lt: Getreide, Michl und Eier.', 
		'Toast mit Frischk�se, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Nudelpfanne mit Champignosauce, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'', 
		'Fr�hlingsrollen, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Kann Getreide, Milch und Eier enthalten.', 
		'Vegetarische Pizza, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Die Suppe enth�llt kein Fleisch.', 
		'Gem�sesuppe, Blattsalat', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Regionale Kartoffeln', 
		'Brokkoli mit Bratkartoffeln, Blattsalat', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Nudeln enthalten Getreide und Eier.', 
		'Pilzrahmsauce mit Nudeln, Blattsalat', 
		2
	);

INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milch und Eier.', 
		'Omeletten mit K�se, Blattsalat', 
		2
	);
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milch und Eier.', 
		'Vegi-Burger mit Pommes, Blattsalat', 
		2
	);	
	
INSERT INTO public.menu(description, name, type) VALUES (
		'Enth�lt: Getreide, Milchprodukte und Eier.', 
		'Gem�se, K�seplatte, Brot, Blattsalat', 
		2
	);	
	
	
/*
 * Create Menuplan
 */	
INSERT INTO public.menuplan(calendar_week) VALUES (
		1
	);
	
INSERT INTO public.menuplan(calendar_week) VALUES (
		2
	);

INSERT INTO public.menuplan(calendar_week) VALUES (
		3
	);
	
INSERT INTO public.menuplan(calendar_week) VALUES (
		4
	);
	
INSERT INTO public.menuplan(calendar_week) VALUES (
		5
	);
	
/*
 * Create Order
 */
INSERT INTO public.orders(amount_nopork, amount_normal, amount_vegi, notice) VALUES (
		0, 
		0, 
		4, 
		'Am Mittwoch esse ich nicht in der Kantine.'
	);
	
INSERT INTO public.orders(amount_nopork, amount_normal, amount_vegi, notice) VALUES (
		0, 
		5, 
		0, 
		''
	);	
	
INSERT INTO public.orders(amount_nopork, amount_normal, amount_vegi, notice) VALUES (
		3, 
		0, 
		0, 
		'Donnerstags und Freitags bin ich nicht da.'
	);	
	
INSERT INTO public.orders(amount_nopork, amount_normal, amount_vegi, notice) VALUES (
		5, 
		10, 
		5, 
		'Drei Kinder und ein Betreuer. F�r Xy bitte die Vegi-Mahlzeiten p�rieren.'
	);		
	
INSERT INTO public.orders(amount_nopork, amount_normal, amount_vegi, notice) VALUES (
		0, 
		8, 
		0, 
		'Ein Kind und ein Betreuer. Am Freitag sind wir nicht vorort.'
	);	
	
	
	
/* * * * * * Set Relationship for Authority (authority - role), Role (role - users) * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */	
/*
 * Link Authorities to Admin (write, read, edit & master)
 * */		
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			1, 
			1
		);
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			1, 
			2
		);
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			1, 
			3
		);
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			1, 
			4
		);
		
/*
 * Link Authorities to User (read)
 * */
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			2, 
			2
		);

/*
 * Link Authorities to Koch (write, read & edit)
 * */
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			3, 
			1
		);
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			3, 
			2
		);
INSERT INTO public.authority_role(role_id, authority_id) VALUES (
			3, 
			3
		);
		
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Link Roles to Users: Admin
 * */
INSERT INTO public.users_role(users_id, role_id) VALUES (
			1, 
			1
		);	
/* 
 * Link Roles to Users: Koch
 * */
INSERT INTO public.users_role(users_id, role_id) VALUES (
			2, 
			3
		);	
/* 
 * Link Roles to Users (wg): User
 * */
INSERT INTO public.users_role(users_id, role_id) VALUES (
			3, 
			2
		);	
/* 
 * Link Roles to Users(Personal): User
 * */
INSERT INTO public.users_role(users_id, role_id) VALUES (
			4, 
			2
		);	

/* * * * * * Set Relationship for Menu (menu - menuplan), Menuplan (menuplan - orders), Orders (orders - users) * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/*
 * Link Menu to Menuplan-Menu
 * 
 * menuplans: 1-5
 * 
 * 15 Menus per Week
 * normal: 1-15
 * noPork: 16-30
 * vegi:   31-45
 */	
		
/* Menuplan KW 1 **********************************************
 * normal */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		1
	);

INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		3
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		5
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		7
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		9
	);
	
/* noPork */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		16
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		18
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		20
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		22
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		24
	);
	
/* vegi */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		31
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		33
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		35
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		37
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		1, 
		39
	);
	
/* Menuplan KW 2 **********************************************
 * normal */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		2
	);

INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		4
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		6
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		8
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		10
	);
	
/* noPork */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		17
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		19
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		21
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		23
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		25
	);
	
/* vegi */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		32
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		34
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		36
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		38
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		2, 
		40
	);
	
/* Menuplan KW 3 **********************************************
 * normal */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		15
	);

INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		9
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		2
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		5
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		13
	);
	
/* noPork */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		29
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		17
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		24
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		21
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		27
	);
	
/* vegi */
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		33
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3,  
		42
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		39
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		45
	);
	
INSERT INTO public.menuplan_menu(menuplan_id, menu_id) VALUES (
		3, 
		34
	);
	
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/*
 * Link Menuplan to Menuplan-Orders
 * 
 * 3 fully defined menuplans
 * 5 Orders
 */	
/* Menuplan 1 - two orders */
INSERT INTO public.menuplan_orders(menuplan_id, orders_id) VALUES (
		1, 
		5
	);

INSERT INTO public.menuplan_orders(menuplan_id, orders_id) VALUES (
		1, 
		2
	);	

/* Menuplan 2 - three orders */
INSERT INTO public.menuplan_orders(menuplan_id, orders_id) VALUES (
		2, 
		1
	);	

/* Menuplan 3 - five orders*/
	
INSERT INTO public.menuplan_orders(menuplan_id, orders_id) VALUES (
		3, 
		3
	);	
	
INSERT INTO public.menuplan_orders(menuplan_id, orders_id) VALUES (
		3, 
		4
	);
	
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/*
 * Link Orders to Users-Orders
 * 
 * Insgesamt 10 orders
 * Mp 1: 2
 * Mp 2: 3
 * Mp 3: 5
 * 
 * Insgesamt 4 users 
 * personal: 1, 
 * wohngruppe: 1, 
 * koch: 1, 
 * admin: 1)
 */	
/* Menuplan 1 - two orders */
INSERT INTO public.users_orders(user_id, orders_id)	VALUES (
		1, 
		2
	);
	
INSERT INTO public.users_orders(user_id, orders_id)	VALUES (
		2, 
		1
	);
	
/* Menuplan 2 - three orders */
INSERT INTO public.users_orders(user_id, orders_id)	VALUES (
		4, 
		3
	);
	
INSERT INTO public.users_orders(user_id, orders_id)	VALUES (
		3, 
		4
	);
	
INSERT INTO public.users_orders(user_id, orders_id)	VALUES (
		3, 
		5
	);

	