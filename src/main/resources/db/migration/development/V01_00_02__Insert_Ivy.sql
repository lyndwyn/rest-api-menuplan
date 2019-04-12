/*
 * Create Users
 * */

INSERT INTO public.users(account_expiration_date, credentials_expiration_date, email, enabled, first_name, last_name, living_goup, locked, password) VALUES (
			'2020-01-01',
			'2020-01-01', 
			'ivy@test.ch', 
			1, 
			'Ivy',  
			'Musterfrau', 
			0, 
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
		1, 
		0, 
		'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy' /* heinz */
	);

			
/*
 * Insert Roles, Authorities and link them to each other
 * */			
INSERT INTO public.authority(name) VALUES (
				'WRITE'
			);
INSERT INTO public.authority(name) VALUES (
				'READ'
			);
			
			
INSERT INTO public.role(name)	VALUES (
			'ADMIN'
		);
INSERT INTO public.role(name)	VALUES (
			'USER'
		);
		
/*
 * Link Authorities to Role-Admin (read & write)
 * */		
INSERT INTO public.authority_role VALUES (
			1, 
			1
		);
INSERT INTO public.authority_role VALUES (
			1, 
			2
		);
		
/*
 * Link Authorities to Role-User (read)
 * */
INSERT INTO public.authority_role VALUES (
			2, 
			2
		);
		
		
/*
 * Link Roles to Users: Admin
 * */
INSERT INTO public.users_role VALUES (
			1, 
			1
		);	
INSERT INTO public.users_role VALUES (
			2, 
			2
		);	

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		