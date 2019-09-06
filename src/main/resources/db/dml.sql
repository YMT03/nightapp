INSERT INTO ubicaciones VALUES(DEFAULT,'Don Anselmo Aieta 1083, 1103 CABA', -34.6205001,-58.369814);
INSERT INTO ubicaciones VALUES(DEFAULT,'Gral. Güemes 567, B1870 Crucecita, Buenos Aires', -34.672983,-58.3620329);

INSERT INTO establecimientos VALUES(DEFAULT,'Birra Bar', NULL,1);
INSERT INTO establecimientos VALUES(DEFAULT,'Parrilla El Tano', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin id magna sapien. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec commodo convallis iaculis. Proin porta metus id lacinia convallis. Mauris scelerisque neque et dapibus facilisis. Etiam eros dui, tristique nec faucibus quis, imperdiet rutrum dui. Phasellus ultricies metus eros, id volutpat mi sagittis finibus. Ut quis nunc vitae sem rutrum auctor. Phasellus sollicitudin ultrices tincidunt. Donec maximus nulla id tortor luctus, in efficitur velit ultrices. Donec ultricies turpis libero, quis interdum erat pulvinar in. Etiam metus justo, efficitur vel ornare at, vulputate nec lacus. Praesent vel fringilla mauris, ac mattis arcu. Mauris eu mattis nisi. Mauris risus velit, venenatis fermentum massa ac, ornare ullamcorper nibh. Aenean feugiat iaculis tincidunt.',2);


INSERT INTO roles VALUES(DEFAULT, 'ADMIN');
INSERT INTO roles VALUES(DEFAULT, 'USER');

INSERT INTO usuarios VALUES(DEFAULT, 1, 'admin', 'admin','Juan','Perez','j.perez@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user1', 'user1','user1','user1','usr1@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user2', 'user2','user2','user2','usr2@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user3', 'user3','user3','user3','usr3@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user4', 'user4','user4','user4','usr4@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user5', 'user5','user5','user5','usr5@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user6', 'user6','user6','user6','usr6@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user7', 'user7','user7','user7','usr7@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user8', 'user8','user8','user8','usr8@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user9', 'user9','user9','user9','usr9@gmail.com');
INSERT INTO usuarios VALUES(DEFAULT, 2, 'user10', 'user10','user10','user10','user10@noreply.com');

INSERT INTO comentarios VALUES(DEFAULT, 1, 1, 'El mejor lugar para un viernes a la noche', 'La verdad una locura. Nada mejor que este lugar, totalmente recomendable. +100');
INSERT INTO comentarios VALUES(DEFAULT, 1, 2, 'Gran lugar', 'Buen lugar para ir con amigos');
INSERT INTO comentarios VALUES(DEFAULT, 1, 3, 'La cajera una maleducada', 'No volveria');
INSERT INTO comentarios VALUES(DEFAULT, 1, 4, NULL, 'Bien');
INSERT INTO comentarios VALUES(DEFAULT, 1, 5, 'Mejor que McDonalds', 'Si vas una vez no volves nunca mas a McDonalds');
INSERT INTO comentarios VALUES(DEFAULT, 1, 6, 'OKOK', 'OKOK BIEN SESESESE');
INSERT INTO comentarios VALUES(DEFAULT, 1, 7, 'Lugarrrr unicooooo', 'Re va.. una LOCURAAAAAA');
INSERT INTO comentarios VALUES(DEFAULT, 1, 8, 'No volveria', 'Tardaron y el ambiente deja bastante que desear. La hamburguesa fria, aunque era rica');
INSERT INTO comentarios VALUES(DEFAULT, 1, 9, 'El mejor lugar para un paty', 'La verdad una locura. Nada mejor que este lugar, totalmente recomendable. +100');
INSERT INTO comentarios VALUES(DEFAULT, 1, 1, 'Gran lugar', 'Buen lugar para ir con amigos');
INSERT INTO comentarios VALUES(DEFAULT, 1, 1, 'La cajera una maleducada', 'No volveria');