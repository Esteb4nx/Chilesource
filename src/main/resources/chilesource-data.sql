USE chilesourcedb;

INSERT INTO super_category (scategory_id, scategory_name)
VALUES (NULL, 'Programación'), (NULL, 'Hardware y Sistemas Operativos');

# Programming category
INSERT INTO category (category_id, category_name, description, super_category_id, icon_path)
VALUES (NULL, 'Java', 'Java Web, Java Server, Deskptop Dev, Game Dev', 1, '/media/icons/java.png'),
       (NULL, 'Python', 'Python 3.9, Matplotlib, Ciencia de datos, Machine learning, discusiones sobre Python', 1, '/media/icons/python.png'),
       (NULL, 'C/C++', 'Desarrollo en C, embedding, Game Dev, todo lo relacionado a estos lenguajes', 1, '/media/icons/c-logo.png'),
       (NULL, 'JavaScript', 'Desarrollo front y backend, frameworks js, módulos js, vue.js, angular, react, entre otras discusiones', 1, '/media/icons/javascript.png'),
       (NULL, 'Kotlin', NULL, 1, '/media/icons/kotlin.png');


# Hardware category
# Todo poblar con lo que solía estar en el json
INSERT INTO category (category_id, category_name, description, super_category_id, icon_path)
VALUES (NULL, 'PC', 'Debate y temáticas relacionadas al armado de computadores de escritorio', 2, '/media/icons/computer.png'),
       (NULL, 'GNU/Linux', 'Debate todo lo relacionado a SO''s basados en el kernel Linux', 2, '/media/icons/linux-logo.png'),
       (NULL, 'Windows', 'Windows NT, Windows server, Windows OS', 2, '/media/icons/windows-logo.png'),
       (NULL, 'Electrónica', 'Arduino, controladores, robótica, comparte tus temas favoritos sobre robótica', 2, '/media/icons/hardware.png'),
       (NULL, 'Hardware', NULL, 2, '/media/icons/hardware.png');


INSERT INTO role(role_name)
VALUES ('Invitado'),('Usuario'),('Administrador');

INSERT INTO user (user_id, user_name, user_password, user_email, profile_description, profile_picture, role_id)
VALUES (1, 'Esteban', '123', 'admin@example.com', 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Incidunt fugit at tenetur quia atque vero, expedita voluptatibus eveniet natus beatae nisi magnam voluptates? Minus excepturi eligendi necessitatibus suscipit et officiis?', '/media/img/profile-picture.jpg', 3),
       (2, 'Jorge', '123', 'admin@example.com', 'Lorem ipsum dolor sit amet, consectetur adip', 'https://bestprofilepictures.com/wp-content/uploads/2021/04/Cool-Profile-Picture.jpg', 3),
       (3, 'Administrador', '123', 'admin@example.com', 'Lorem ipsum dolor sit amet, consectetur adip', 'https://scontent.fzco1-1.fna.fbcdn.net/v/t31.18172-8/16825970_748869598613762_9006949948895762754_o.jpg?_nc_cat=100&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=PxqCs5YLgO8AX-dJovO&_nc_ht=scontent.fzco1-1.fna&oh=2a9ff0bb897953035dc6da10850f1219&oe=619AB6D6', 3);

# INSERT INTO post(post_title, post_body, post_date, post_category_id, author_id)
# VALUES ('Crear foro con Spring Boot','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tempus suscipit hendrerit. Integer pulvinar hendrerit odio vitae fermentum. Duis eget felis eget felis placerat ornare at nec ipsum. In eget venenatis risus, sit amet maximus lorem. Curabitur viverra consequat orci, eget ullamcorper ante finibus et. Proin at massa et dui rhoncus sagittis. Quisque eget laoreet lacus. Nullam a finibus lacus. Aliquam sit amet ex eget sem congue molestie nec ac odio. Curabitur blandit condimentum laoreet. Vestibulum porttitor arcu sit amet arcu cursus viverra. ', '2021-10-26',1,1),
#        ('QT Framework con C++','Sed eu pretium nunc. Fusce semper lorem sed odio fermentum finibus. Praesent fermentum congue mi, sit amet maximus nunc. Cras venenatis commodo nisl sit amet lacinia. Nulla et tellus id arcu lacinia mattis. Curabitur eu lorem sit amet ligula malesuada auctor. Proin congue fermentum efficitur. Praesent ultricies, mi non placerat dignissim, risus turpis interdum odio, quis dapibus arcu mi in mi. Morbi bibendum ac turpis at vulputate. Nunc quis ligula bibendum, vehicula leo gravida, posuere mi. Nunc volutpat a est ac finibus. In sed efficitur augue. ', '2021-10-26',3,2),
#        ('Express con Node.js','Nullam eget dui quis nulla pulvinar fringilla. Aliquam ac ullamcorper mi. Maecenas lacinia odio quis dui varius, nec euismod turpis porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas viverra id lacus eu fringilla. Donec sagittis elementum ligula sit amet luctus. Donec eget metus nec urna faucibus cursus. Sed eget eros sit amet mauris faucibus venenatis. ', '2021-10-26', 4, 3),
#        ('Como instalar Ubuntu Server','Aenean vehicula ipsum ac varius commodo. Pellentesque consequat in orci in fermentum. Sed tempor sit amet nisi in viverra. Vestibulum sit amet eleifend massa, quis sodales nisl. Phasellus a nisl a erat egestas elementum lobortis ac ex. Curabitur lacinia venenatis orci, vel pharetra quam semper hendrerit. Proin nec dapibus ex, a suscipit urna. Maecenas dapibus sodales ligula in accumsan. Nulla dictum metus dolor, ac dictum mauris placerat a. Sed sit amet gravida ante, non varius sapien. Quisque sit amet semper nisi, eu rhoncus lectus. Aenean pretium tortor nisi, quis pharetra nulla efficitur vel. Quisque et dui sit amet diam commodo convallis. Vivamus tempus ex ut sodales vestibulum. Curabitur ac turpis rhoncus, mattis ante ac, blandit eros. Curabitur blandit interdum neque, a congue lectus efficitur vel. ', '2021-10-26',7,1),
#        ('Descargar Windows 11','Nulla tellus odio, mollis a egestas at, sodales eu sapien. Ut euismod ex a rutrum imperdiet. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi vitae purus aliquam, consectetur turpis eget, ullamcorper mauris. Vivamus finibus viverra leo sit amet accumsan. Donec eget mauris eleifend magna sagittis congue et et sapien. Maecenas nisi lacus, accumsan ac condimentum ut, imperdiet sed dolor. In sit amet nulla porta, ornare sem quis, faucibus felis. Nam eu tortor lobortis, dictum metus ut, ullamcorper velit. Phasellus nec ex ipsum. Integer vulputate diam ut magna imperdiet faucibus. Fusce iaculis ligula ipsum, id ultrices ipsum consectetur vitae. Phasellus condimentum nulla est, eu tincidunt ligula scelerisque non. Duis dictum est id elit scelerisque scelerisque.', '2021-10-26',8,2),
#        ('MatplotLib tutorial', 'Mauris sit amet velit ex. Praesent egestas nunc in nisi rutrum, in egestas sapien finibus. Maecenas sed elementum ligula, nec vehicula purus. Nulla ultricies magna ac lectus commodo pharetra. Ut volutpat aliquet mollis. Vivamus ornare tincidunt sem, at lobortis augue gravida ut. Donec vulputate lorem id lacinia gravida. Aliquam at erat a neque facilisis condimentum. Nullam vitae mi eget lorem hendrerit ornare. Phasellus vitae tempus elit, non rhoncus odio.', '2021-12-25', 2, 3),
#        ('Programa tu propio robot con Arduino', 'Duis eu sapien vitae metus luctus elementum a et velit. Integer ac ligula cursus, cursus sapien id, venenatis dolor. Vivamus finibus tristique nunc, vel pretium turpis varius eu. Nulla sit amet lacus urna. Aliquam quam odio, imperdiet vel risus eu, mattis consectetur odio. Morbi id justo eget nulla ullamcorper volutpat et id lacus. Curabitur tincidunt, dolor eget rutrum mollis, diam turpis maximus lorem, et dapibus tellus ante at arcu.', '2018-4-23', 9, 1),
#        ('Mejores componentes Hardware 2021', 'Duis eu sapien vitae metus luctus elementum a et velit. Integer ac ligula cursus, cursus sapien id, venenatis dolor. Vivamus finibus tristique nunc, vel pretium turpis varius eu. Nulla sit amet lacus urna. Aliquam quam odio, imperdiet vel risus eu, mattis consectetur odio. Morbi id justo eget nulla ullamcorper volutpat et id lacus. Curabitur tincidunt, dolor eget rutrum mollis, diam turpis maximus lorem, et dapibus tellus ante at arcu.', '2019-2-10', 10, 2),
#        ('Como iniciar en Kotlin', 'Vestibulum quis neque quam. Sed sagittis scelerisque dui. Nam auctor purus nec tempus congue. Suspendisse aliquet scelerisque sem sit amet ultricies. Praesent vel dui vel dolor blandit aliquet nec posuere mauris. Integer ac libero quis diam vehicula convallis. Aenean cursus diam vitae nisi eleifend, vitae luctus ipsum molestie. Duis suscipit, leo et rutrum egestas, libero tortor egestas sem, eget pretium leo ex eu mi.', '2021-4-8', 5, 3),
#        ('Compra y venta de componentes', 'Maecenas auctor sapien nibh, non cursus erat rutrum tristique. Nullam auctor malesuada quam sit amet iaculis. Mauris nunc est, porta vulputate porttitor id, vulputate nec eros. Aenean ultricies molestie dui. Curabitur ante urna, sollicitudin bibendum felis vitae, cursus fringilla nibh. Donec vel tristique nunc, a aliquam nisl. In efficitur a magna ut euismod. Pellentesque convallis sapien vitae tincidunt finibus. Fusce id augue fringilla, tempor nibh ut, viverra nisl. Proin rhoncus nisi sit amet lorem varius posuere.', '2017-2-14', 6, 1);


# Poblar tabla post
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (1, 'Crear foro con Spring Boot', '<p>Donec imperdiet sapien mollis facilisis placerat. Ut at dui condimentum,
 suscipit nisi quis, facilisis enim. Maecenas ut risus at nisi efficitur
 imperdiet. Duis vel augue bibendum, consectetur mi vitae, mattis erat.
Vivamus vel dolor est. Curabitur ipsum ante, mollis nec ante non, <span style="background-color: rgb(0, 255, 255);">varius
 scelerisque est</span>. Vestibulum egestas massa at augue sodales
sollicitudin. Suspendisse ultrices arcu sit amet diam varius, sed
lacinia nisl tempus. Etiam a malesuada lectus. Sed est justo, viverra in
 mollis vitae, bibendum quis ligula. Nam tempus dapibus eleifend.
</p><p><br></p>', '2021-10-26 00:00:00', 1, 1);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (2, 'QT Framework con C++', 'Sed eu pretium nunc. Fusce semper lorem sed odio fermentum finibus. Praesent fermentum congue mi, sit amet maximus nunc. Cras venenatis commodo nisl sit amet lacinia. Nulla et tellus id arcu lacinia mattis. Curabitur eu lorem sit amet ligula malesuada auctor. Proin congue fermentum efficitur. Praesent ultricies, mi non placerat dignissim, risus turpis interdum odio, quis dapibus arcu mi in mi. Morbi bibendum ac turpis at vulputate. Nunc quis ligula bibendum, vehicula leo gravida, posuere mi. Nunc volutpat a est ac finibus. In sed efficitur augue. ', '2021-10-26 00:00:00', 3, 2);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (3, 'Express con Node.js', 'Nullam eget dui quis nulla pulvinar fringilla. Aliquam ac ullamcorper mi. Maecenas lacinia odio quis dui varius, nec euismod turpis porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas viverra id lacus eu fringilla. Donec sagittis elementum ligula sit amet luctus. Donec eget metus nec urna faucibus cursus. Sed eget eros sit amet mauris faucibus venenatis. ', '2021-10-26 00:00:00', 4, 3);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (4, 'Como instalar Ubuntu Server', 'Aenean vehicula ipsum ac varius commodo. Pellentesque consequat in orci in fermentum. Sed tempor sit amet nisi in viverra. Vestibulum sit amet eleifend massa, quis sodales nisl. Phasellus a nisl a erat egestas elementum lobortis ac ex. Curabitur lacinia venenatis orci, vel pharetra quam semper hendrerit. Proin nec dapibus ex, a suscipit urna. Maecenas dapibus sodales ligula in accumsan. Nulla dictum metus dolor, ac dictum mauris placerat a. Sed sit amet gravida ante, non varius sapien. Quisque sit amet semper nisi, eu rhoncus lectus. Aenean pretium tortor nisi, quis pharetra nulla efficitur vel. Quisque et dui sit amet diam commodo convallis. Vivamus tempus ex ut sodales vestibulum. Curabitur ac turpis rhoncus, mattis ante ac, blandit eros. Curabitur blandit interdum neque, a congue lectus efficitur vel. ', '2021-10-26 00:00:00', 7, 1);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (5, 'Descargar Windows 11', 'Nulla tellus odio, mollis a egestas at, sodales eu sapien. Ut euismod ex a rutrum imperdiet. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi vitae purus aliquam, consectetur turpis eget, ullamcorper mauris. Vivamus finibus viverra leo sit amet accumsan. Donec eget mauris eleifend magna sagittis congue et et sapien. Maecenas nisi lacus, accumsan ac condimentum ut, imperdiet sed dolor. In sit amet nulla porta, ornare sem quis, faucibus felis. Nam eu tortor lobortis, dictum metus ut, ullamcorper velit. Phasellus nec ex ipsum. Integer vulputate diam ut magna imperdiet faucibus. Fusce iaculis ligula ipsum, id ultrices ipsum consectetur vitae. Phasellus condimentum nulla est, eu tincidunt ligula scelerisque non. Duis dictum est id elit scelerisque scelerisque.', '2021-10-26 00:00:00', 8, 2);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (6, 'MatplotLib tutorial', '<p>Mauris sit amet velit ex. Praesent egestas nunc in nisi rutrum, in egestas sapien finibus. Maecenas sed elementum ligula, nec vehicula purus. Nulla ultricies magna ac lectus commodo pharetra. Ut volutpat aliquet mollis. Vivamus ornare tincidunt sem, at lobortis augue gravida ut. Donec vulputate lorem id lacinia gravida. Aliquam at erat a neque facilisis condimentum. Nullam vitae mi eget lorem hendrerit ornare. Phasellus vitae tempus elit, non rhoncus odio.</p><p><br></p><p><img style="width: 25%;" src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/2048px-Python.svg.png"><br></p>', '2021-12-25 00:00:00', 2, 3);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (7, 'Programa tu propio robot con Arduino', 'Duis eu sapien vitae metus luctus elementum a et velit. Integer ac ligula cursus, cursus sapien id, venenatis dolor. Vivamus finibus tristique nunc, vel pretium turpis varius eu. Nulla sit amet lacus urna. Aliquam quam odio, imperdiet vel risus eu, mattis consectetur odio. Morbi id justo eget nulla ullamcorper volutpat et id lacus. Curabitur tincidunt, dolor eget rutrum mollis, diam turpis maximus lorem, et dapibus tellus ante at arcu.', '2018-04-23 00:00:00', 9, 1);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (8, 'Mejores componentes Hardware 2021', 'Duis eu sapien vitae metus luctus elementum a et velit. Integer ac ligula cursus, cursus sapien id, venenatis dolor. Vivamus finibus tristique nunc, vel pretium turpis varius eu. Nulla sit amet lacus urna. Aliquam quam odio, imperdiet vel risus eu, mattis consectetur odio. Morbi id justo eget nulla ullamcorper volutpat et id lacus. Curabitur tincidunt, dolor eget rutrum mollis, diam turpis maximus lorem, et dapibus tellus ante at arcu.', '2019-02-10 00:00:00', 10, 2);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (9, 'Como iniciar en Kotlin', 'Vestibulum quis neque quam. Sed sagittis scelerisque dui. Nam auctor purus nec tempus congue. Suspendisse aliquet scelerisque sem sit amet ultricies. Praesent vel dui vel dolor blandit aliquet nec posuere mauris. Integer ac libero quis diam vehicula convallis. Aenean cursus diam vitae nisi eleifend, vitae luctus ipsum molestie. Duis suscipit, leo et rutrum egestas, libero tortor egestas sem, eget pretium leo ex eu mi.', '2021-04-08 00:00:00', 5, 3);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (10, 'Compra y venta de componentes', '<p>Maecenas auctor sapien nibh, non cursus erat rutrum tristique. Nullam auctor malesuada quam sit amet iaculis. Mauris nunc est, porta vulputate porttitor id, vulputate nec eros. <br><br><a href="https://www.solotodo.cl/" target="_blank">solotodo.cl</a><br><br>Aenean ultricies molestie dui. Curabitur ante urna, sollicitudin bibendum felis vitae, cursus fringilla nibh. Donec vel tristique nunc, a aliquam nisl. In efficitur a magna ut euismod. Pellentesque convallis sapien vitae tincidunt finibus. Fusce id augue fringilla, tempor nibh ut, viverra nisl. Proin rhoncus nisi sit amet lorem varius posuere.</p><p><br></p>', '2017-02-14 00:00:00', 6, 1);
insert into chilesourcedb.post (post_id, post_title, post_body, post_date, post_category_id, author_id) values (11, 'Programación orientada a Objetos recursos', '<p>P<b>roin aliquam, ex quis malesuada euismod, arcu lectus eleifend orci, eu
interdum tortor enim at libero</b>. Donec a placerat tellus, a efficitur ex.
 Donec ac tellus vel tortor elementum fringilla quis at leo. Vestibulum
sagittis odio sed fermentum placerat. Nullam eleifend risus ac est
vehicula, eu maximus purus gravida. Curabitur eu nisi ac qu<b>am rhoncus
luctus.</b> Cras non lacus tellus. Aliquam molestie erat ut turpis
vestibulum, vitae dignissim eros.
</p><p><br></p><p><img style="width: 437.352px; height: 185.033px;" src="https://pc-solucion.es/wp-content/uploads/2019/05/programacion-orientada-a-objetos.png"><br></p>', '2021-10-27 07:00:30', 1, 2);
