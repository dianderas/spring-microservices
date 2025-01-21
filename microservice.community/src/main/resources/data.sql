-- Insertar un registro de comunidad con información básica
INSERT INTO communities (name, image, description, owner)
VALUES ('Comunidad A', 'imageA.jpg', 'Descripción de la comunidad A', 1);

-- Insertar otro registro de comunidad con información diferente
INSERT INTO communities (name, image, description, owner)
VALUES ('Comunidad B', 'imageB.jpg', 'Descripción de la comunidad B', 2);

-- Insertar una comunidad con una imagen distinta y descripción más larga
INSERT INTO communities (name, image, description, owner)
VALUES ('Comunidad C', 'imageC.jpg', 'Una comunidad dedicada al desarrollo de software y tecnologías emergentes.', 3);

-- Insertar un último registro de comunidad con un nombre y descripción corta
INSERT INTO communities (name, image, description, owner)
VALUES ('Comunidad D', 'imageD.jpg', 'Comunidad para amantes de los deportes.', 4);
