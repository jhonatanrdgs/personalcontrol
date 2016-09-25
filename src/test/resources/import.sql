--Dados iniciais
--Rendimento id_rendimento, nome_pessoa, valor, dt_inicio, dt_fim
insert into rendimento(id_rendimento, nome_pessoa, valor, dt_inicio, dt_fim) values (1, 'Teste', 3000.00, '2016-08-20', '2018-08-20');
insert into rendimento(id_rendimento, nome_pessoa, valor, dt_inicio, dt_fim)  values (2, 'Teste2', 1000.00, '2016-08-20', '2018-08-20');
insert into rendimento(id_rendimento, nome_pessoa, valor, dt_inicio, dt_fim)  values (3, 'Teste3', 1000.00, '2015-08-20', '2015-10-20');
insert into rendimento(id_rendimento, nome_pessoa, valor, dt_inicio, dt_fim)  values (3, 'Teste3', 1000.00, '2017-08-20', '2017-10-20');

insert into metodo_pagamento (id_metodo_pagamento, descricao, ativo) values(1, 'metodo1', true);
insert into categoria (id_categoria, descricao, ativo) values(1, 'categoria1', true);
insert into metodo_pagamento (id_metodo_pagamento, descricao, ativo) values(2, 'metodo2', true);
insert into categoria (id_categoria, descricao, ativo) values(2, 'categoria2', true);
insert into usuario (id_usuario, ativo, login, nome_usuario, permissao, senha) values (1, true, 'admin', 'admin', 'ROLE_ADMIN', '123');
-- fim dados iniciais

-- id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa
insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (1, '2016-09-20', 'teste', 1, 120.00, 1, 1, 1, false);
insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (2, '2016-09-20', 'teste2', 1, 120.00, 1, 1, 1, false);
insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (3, '2016-09-20', 'teste3', 1, 120.00, 1, 1, 1, true);

insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (4, '2016-09-20', 'Teste parcelada 10x', 10, 1500.00, 1, 1, 1, false);
insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (5, '2016-09-20', 'Teste Parcelada 5x', 5, 550.00, 1, 1, 1, false);
insert into despesa (id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa) values (6, '2016-09-20', 'Teste Parcelada 5x Ultima Paga', 5, 600.00, 1, 1, 1, false);

-- id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga

insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (1, '2016-09-20', 1, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (2, '2016-10-20', 2, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (3, '2016-11-20', 3, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (4, '2016-12-20', 4, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (5, '2017-01-20', 5, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (6, '2017-02-20', 6, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (7, '2017-03-20', 7, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (8, '2017-04-20', 8, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (9, '2017-05-20', 9, 4, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (10, '2017-06-20', 10, 4, 150.00, false);


insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (11, '2016-09-20', 1, 5, 110.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (12, '2016-10-20', 2, 5, 110.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (13, '2016-11-20', 3, 5, 110.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (14, '2016-12-20', 4, 5, 110.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (15, '2017-01-20', 5, 5, 110.00, false);

insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (16, '2016-09-20', 1, 6, 150.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (17, '2016-10-20', 2, 6, 120.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (18, '2016-11-20', 3, 6, 120.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (19, '2016-12-20', 4, 6, 120.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (20, '2017-01-20', 5, 6, 120.00, true);


insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (21, '2016-09-20', 1, 1, 120.00, false);
insert into parcela_despesa (id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga) values (22, '2016-09-20', 1, 2, 120.00, false);