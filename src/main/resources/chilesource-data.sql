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
