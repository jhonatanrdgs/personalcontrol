

-- -----------------------------------------------------
-- Schema personal_control
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS personal_control;


-- -----------------------------------------------------
-- Table personal_control.categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.categoria (
  id_categoria BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_categoria));


-- -----------------------------------------------------
-- Table personal_control.metodo_pagamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.metodo_pagamento (
  id_metodo_pagamento BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_metodo_pagamento));


-- -----------------------------------------------------
-- Table personal_control.grupo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.grupo (
  id_grupo BIGSERIAL NOT NULL,
  PRIMARY KEY (id_grupo));


-- -----------------------------------------------------
-- Table personal_control.usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.usuario (
  id_usuario BIGSERIAL NOT NULL,
  nome_usuario VARCHAR(100) NOT NULL,
  login VARCHAR(100) NOT NULL,
  senha VARCHAR(500) NOT NULL,
  ativo BOOLEAN NOT NULL,
  permissao INT NOT NULL,
  PRIMARY KEY (id_usuario));


-- -----------------------------------------------------
-- Table personal_control.despesa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.despesa (
  id_despesa BIGSERIAL NOT NULL,
  parcelada BOOLEAN NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  numero_parcela INT NOT NULL,
  total_parcelas INT NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  data DATE NOT NULL,
  id_categoria INT NOT NULL,
  id_metodo_pagamento INT NOT NULL,
  id_grupo INT NOT NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_despesa),
  CONSTRAINT despesa_categoria
    FOREIGN KEY (id_categoria)
    REFERENCES personal_control.categoria (id_categoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT despesa_metodo_pagamento
    FOREIGN KEY (id_metodo_pagamento)
    REFERENCES personal_control.metodo_pagamento (id_metodo_pagamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT despesa_grupo
    FOREIGN KEY (id_grupo)
    REFERENCES personal_control.grupo (id_grupo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT despesa_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES personal_control.usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table personal_control.despesa_carro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.despesa_carro (
  id_despesa_carro BIGSERIAL NOT NULL,
  km VARCHAR(6) NOT NULL,
  id_despesa INT NOT NULL,
  PRIMARY KEY (id_despesa_carro),
  CONSTRAINT despesa_carro_despesa
    FOREIGN KEY (id_despesa)
    REFERENCES personal_control.despesa (id_despesa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table personal_control.item_despesa_carro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.item_despesa_carro (
  id_item_despesa_carro BIGSERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor_item DECIMAL(10,2) NOT NULL,
  id_despesa_carro INT NOT NULL,
  PRIMARY KEY (id_item_despesa_carro),
  CONSTRAINT item_despesa_carro_despesa_carro
    FOREIGN KEY (id_despesa_carro)
    REFERENCES personal_control.despesa_carro (id_despesa_carro)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table personal_control.rendimento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.rendimento (
  id_rendimento BIGSERIAL NOT NULL,
  valor DECIMAL(10,2) NULL,
  id_usuario INT NULL,
  PRIMARY KEY (id_rendimento),
  CONSTRAINT rendimento_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES personal_control.usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table personal_control.usuario_grupo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personal_control.usuario_grupo (
  id_usuario INT NOT NULL,
  id_grupo INT NOT NULL,
  PRIMARY KEY (id_usuario, id_grupo),
  CONSTRAINT usuario_grupo_grupo
    FOREIGN KEY (id_grupo)
    REFERENCES personal_control.grupo (id_grupo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT usuario_grupo_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES personal_control.usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

