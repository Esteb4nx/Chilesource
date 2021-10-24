USE chilesourcedb;

INSERT INTO super_category (scategory_id, scategory_name)
VALUES (NULL, 'programming'), (NULL, 'hardware');

INSERT INTO category (category_id, category_name, description, super_category_id, icon_path)
VALUES (NULL, 'Java', 'Java Web, Java Server, Deskptop Dev, Game Dev', 1, '/media/icons/java.png'),
       (NULL, 'Python', 'Python 3.9, Matplotlib, Ciencia de datos, Machine learning, discusiones varias de Python, módulos', 1, '/media/icons/python.png'),
       (NULL, 'C/C++', 'Desarrollo en C, embedding, Game Dev, todo lo relacionado a estos lenguajes', 1, '/media/icons/c-logo.png');