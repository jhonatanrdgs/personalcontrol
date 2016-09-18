--Dados iniciais
insert into metodo_pagamento values(1, 'metodo1', true);
insert into categoria values(1, 'categoria1', true);
insert into metodo_pagamento values(2, 'metodo2', true);
insert into categoria values(2, 'categoria2', true);
insert into usuario values (1, true, 'admin', 'admin', 'ROLE_ADMIN', md5('123'));
-- fim dados iniciais

-- id_despesa, data, descricao, total_parcelas, valor_total, id_categoria, id_metodo_pagamento, id_usuario, fixa
insert into despesa values (1, now(), 'teste', 1, 120.00, 1, 1, 1, false);
insert into despesa values (1, now(), 'teste', 1, 120.00, 1, 1, 1, false);

-- id_parcela_despesa, data_parcela, numero_parcela, id_despesa, valor_parcela, paga

