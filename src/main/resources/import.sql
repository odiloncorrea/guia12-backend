-- Inserções para a tabela 'tb_tipo' (não dependem de outras tabelas)
INSERT INTO tb_tipo(descricao) VALUES ('Tipo A');
INSERT INTO tb_tipo(descricao) VALUES ('Tipo B');

-- Inserções para a tabela 'tb_usuario' (não dependem de outras tabelas)
INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Maria', 'maria', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL1');
INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Pedro', 'pedro', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL2');
INSERT INTO tb_usuario(nome, login, senha, nivel_acesso) VALUES('Laura', 'laura', '$2a$10$ZQDZDXqV/LKQTq13NKJ2aeUmrxV787/U1BSEfXS.pGPu0Sd9CgYX6', 'NIVEL3');

-- Inserções para a tabela 'tb_produto' (dependem de 'tb_tipo')
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 1', 100.00, 10, 1);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 2', 200.00, 20, 1);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 3', 300.00, 30, 2);
INSERT INTO tb_produto(descricao, valor, estoque, tipo_id) VALUES ('Produto 4', 400.00, 40, 2);

-- Inserções para a tabela 'tb_pedido' (dependem de 'tb_usuario')
INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 300.00, 2); -- Este será o Pedido ID 1
INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 500.00, 2); -- Este será o Pedido ID 2
INSERT INTO tb_pedido(data, valor, usuario_id) VALUES ('2000-01-01', 3200, 3);   -- Este será o Pedido ID 3

-- Inserções para a tabela 'tb_item' (dependem de 'tb_pedido' e 'tb_produto')
-- Usar IDs de Pedido e Produto que já existem.
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (300.00, 3, 1, 1); -- Item para Pedido 1, Produto 1
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (200, 2, 2, 1);     -- Item para Pedido 2, Produto 1
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (300, 1, 2, 3);     -- Item para Pedido 2, Produto 3
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (600.00, 2, 3, 3); -- Item para Pedido 3, Produto 3
INSERT INTO tb_item(valor, quantidade, pedido_id, produto_id) VALUES (400.00, 1, 3, 4); -- Item para Pedido 3, Produto 4