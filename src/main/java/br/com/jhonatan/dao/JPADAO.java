package br.com.jhonatan.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.Categoria;

@Repository
public interface JPADAO extends JpaRepository<Categoria, Long> {

	@Query(value="select c from Categoria c where ativo = :ativa and (descricao like concat('%', :descricao, '%') or :descricao is null)")
	Page<Categoria> pesquisarCategorias(@Param("descricao")String descricao, @Param("ativa")boolean ativa, Pageable pageable);

	
}
