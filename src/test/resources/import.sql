--Dados iniciais
insert into metodo_pagamento values(1, 'metodo1', true);
insert into categoria values(1, 'categoria1', true);
insert into metodo_pagamento values(2, 'metodo2', true);
insert into categoria values(2, 'categoria2', true);
insert into usuario values (1, true, 'admin', 'admin', 'ROLE_ADMIN', md5('123'));
-- fim dados iniciais

-- id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa
insert into despesa values (1, now(), 'teste', 1, 120.00, 1, 1, 1, false);
insert into despesa values (2, now(), 'teste2', 1, 120.00, 1, 1, 1, false);
insert into despesa values (3, now(), 'teste3', 1, 120.00, 1, 1, 1, true);

insert into despesa values (4, now(), 'Teste parcelada 10x', 10, 1500.00, 1, 1, 1, true);
insert into despesa values (5, now(), 'Teste Parcelada 5x', 5, 550.00, 1, 1, 1, true);
insert into despesa values (6, now(), 'Teste Parcelada 5x Ultima Paga', 5, 600.00, 1, 1, 1, true);


-- id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga

insert into parcela_despesa values (1, now(), 1, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '1 month', 2, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '2 month', 3, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '3 month', 4, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '4 month', 5, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '5 month', 6, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '6 month', 7, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '7 month', 8, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '8 month', 9, 4, 150.00, false);
insert into parcela_despesa values (1, now() + interval '9 month', 10, 4, 150.00, false);


insert into parcela_despesa values (1, now(), 1, 5, 110.00, false);
insert into parcela_despesa values (1, now() + interval '1 month', 2, 5, 110.00, false);
insert into parcela_despesa values (1, now() + interval '2 month', 3, 5, 110.00, false);
insert into parcela_despesa values (1, now() + interval '3 month', 4, 5, 110.00, false);
insert into parcela_despesa values (1, now() + interval '4 month', 5, 5, 110.00, false);

insert into parcela_despesa values (1, now(), 1, 6, 150.00, false);
insert into parcela_despesa values (1, now() + interval '1 month', 2, 6, 120.00, false);
insert into parcela_despesa values (1, now() + interval '2 month', 3, 6, 120.00, false);
insert into parcela_despesa values (1, now() + interval '3 month', 4, 6, 120.00, false);
insert into parcela_despesa values (1, now() + interval '4 month', 5, 6, 120.00, true);