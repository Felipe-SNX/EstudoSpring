insert into USUARIOS (id, username, password, role) values (100, 'ana@email.com', '$2a$12$irvQ7iuF7p4fIFl44nAU5.CIInlEZjw59uA0Q7RSjv9qbNXhGJbmW', 'ROLE_ADMIN');
insert into USUARIOS (id, username, password, role) values (101, 'bia@email.com', '$2a$12$irvQ7iuF7p4fIFl44nAU5.CIInlEZjw59uA0Q7RSjv9qbNXhGJbmW', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (102, 'bob@email.com', '$2a$12$irvQ7iuF7p4fIFl44nAU5.CIInlEZjw59uA0Q7RSjv9qbNXhGJbmW', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (103, 'mari@email.com', '$2a$12$irvQ7iuF7p4fIFl44nAU5.CIInlEZjw59uA0Q7RSjv9qbNXhGJbmW', 'ROLE_CLIENTE');

insert into CLIENTES (id, nome, cpf, id_usuario) values (10, 'Bianca Silva', '35483570081', 101);
insert into CLIENTES (id, nome, cpf, id_usuario) values (20, 'Roberto Gomes', '19104400003', 102);