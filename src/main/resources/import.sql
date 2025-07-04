INSERT INTO tb_tipo(descricao) VALUES ('Tipo A');
INSERT INTO tb_tipo(descricao) VALUES ('Tipo B');

INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 1', 100.00, 10, 1);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 2', 200.00, 20, 1);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 3', 300.00, 30, 2);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 4', 400.00, 40, 2);

INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Maria', 'maria', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL1');
INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Pedro', 'pedro', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL2');
INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Laura', 'laura', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL3');

INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 300.00, 2);
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (300.00, 3, 1, 1);

INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 500.00, 2);
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (200, 2, 2, 1);
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (300, 1, 2, 3);

INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 3200, 3);
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (600.00, 2, 3, 3);
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (400.00, 1, 3, 4);

