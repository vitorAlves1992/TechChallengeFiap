INSERT INTO usuario (id) values (1);

INSERT INTO usuario (id) values (2);
INSERT INTO usuario (id) values (3);
INSERT INTO usuario (id) values (4);
INSERT INTO usuario (id) values (5);

INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (1, 'bairro a', 'cidade a', 'RS', '123', 'rua a', 1);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (2, 'bairro b', 'cidade b', 'RS', '456', 'rua b', 2);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (3, 'bairro c', 'cidade c', 'RS', '789', 'rua c', 3);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (4, 'bairro d', 'cidade d', 'RS', '987', 'rua d', 4);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (5, 'bairro e', 'cidade e', 'RS', '654', 'rua e', 5);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (6, 'bairro f', 'cidade f', 'RS', '156', 'rua f', 4);
INSERT INTO endereco (id, bairro, cidade, estado, numero, rua, usuario_id) VALUES  (7, 'bairro g', 'cidade g', 'RS', '832', 'rua g', 5);

INSERT INTO pessoa (data_nascimento, nome, sexo, endereco_id,  usuario_pessoa_id) VALUES ('2021-06-16', 'Daniel', 'masculino', 1, 1);
INSERT INTO pessoa (data_nascimento, nome, sexo, endereco_id,  usuario_pessoa_id) VALUES ('2021-06-16', 'Felipe', 'masculino', 2, 2);
INSERT INTO pessoa (data_nascimento, nome, sexo, endereco_id,  usuario_pessoa_id) VALUES ('2021-06-16', 'Kassi', 'feminino', 3, 3);
INSERT INTO pessoa (data_nascimento, nome, sexo, endereco_id,  usuario_pessoa_id) VALUES ('2021-06-16', 'Leandro', 'masculino', 4, 4);
INSERT INTO pessoa (data_nascimento, nome, sexo, endereco_id,  usuario_pessoa_id) VALUES ( '2021-06-16', 'Vitor', 'masculino', 5, 5);


INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (1, 'Modelo a', 'nome a', 200.00, 1, 1);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (2, 'Modelo b', 'nome b', 120.00, 2, 2);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (3, 'Modelo c', 'nome c', 180.00, 3, 3);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (4, 'Modelo d', 'nome d', 300.00, 4, 4);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (5, 'Modelo e', 'nome e', 550.00, 5, 5);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (6, 'Modelo f', 'nome f', 250.00, 4, 4);
INSERT INTO eletrodomestico (id, modelo, nome, potencia, endereco_id, usuario_id) VALUES  (7, 'Modelo g', 'nome g', 250.00, 5, 5);