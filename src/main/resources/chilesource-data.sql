USE chilesourcedb;

INSERT INTO super_category (scategory_id, scategory_name)
VALUES (NULL, 'Programación'), (NULL, 'Hardware y Sistemas Operativos');

# Programming category
INSERT INTO category (category_id, category_name, description, super_category_id, icon_path)
VALUES (
        NULL,
        'Java',
        'Java Web, Java Server, Deskptop Dev, Game Dev',
        1,
        '/media/icons/java.png'
        ),
       (
        NULL,
        'Python',
        'Python 3.9, Matplotlib, Ciencia de datos, Machine learning, discusiones sobre Python',
        1,
        '/media/icons/python.png'
        ),
       (
        NULL,
        'C/C++', 'Desarrollo en C, embedding, Game Dev, todo lo relacionado a estos lenguajes',
        1,
        '/media/icons/c-logo.png'
        ),
       (
        NULL,
        'JavaScript',
        'Desarrollo front y backend, frameworks js, módulos js, vue.js, angular, react, entre otras discusiones',
        1,
        '/media/icons/javascript.png'
        ),
       (
        NULL,
        'Kotlin',
        NULL,
        1,
        '/media/icons/kotlin.png'
        );

# Hardware category
# Todo poblar con lo que solía estar en el json
INSERT INTO category (category_id, category_name, description, super_category_id, icon_path)
VALUES (NULL, 'PC', 'Debate y temáticas relacionadas al armado de computadores de escritorio', 2, '/media/icons/computer.png'),
       (NULL, 'GNU/Linux', 'Debate todo lo relacionado a SO''s basados en el kernel Linux', 2, '/media/icons/linux-logo.png'),
       (NULL, 'Windows', 'Windows NT, Windows server, Windows OS', 2, '/media/icons/windows-logo.png');

INSERT INTO role(role_name)
VALUES ('Invitado'),('Usuario'),('Administrador');

INSERT INTO user (user_id, user_name, user_password, user_email, profile_description, user_gender, profile_picture, role_id) VALUES (1, 'Esteban', '123', 'admin@example.com', 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Incidunt fugit
                        at tenetur quia atque vero,
                        expedita voluptatibus eveniet natus beatae nisi magnam voluptates? Minus excepturi eligendi
                        necessitatibus
                        suscipit et officiis?', null, '/media/img/profile-picture.jpg', 3),
(2, 'Jorge', '123', 'admin@example.com', 'Lorem ipsum dolor sit amet, consectetur adip', null, 'https://bestprofilepictures.com/wp-content/uploads/2021/04/Cool-Profile-Picture.jpg', 3),
(3, 'Administrador', '123', 'admin@example.com', 'Lorem ipsum dolor sit amet, consectetur adip', null, 'https://scontent.fzco1-1.fna.fbcdn.net/v/t31.18172-8/16825970_748869598613762_9006949948895762754_o.jpg?_nc_cat=100&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=PxqCs5YLgO8AX-dJovO&_nc_ht=scontent.fzco1-1.fna&oh=2a9ff0bb897953035dc6da10850f1219&oe=619AB6D6', 3);