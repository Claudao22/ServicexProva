package br.com.claudio.servicex.categoria.repositories;


import br.com.claudio.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByServicos_IdServico(Integer idServico);
    boolean existsByNomeCategoria(String nome);

}
