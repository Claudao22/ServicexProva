package br.com.claudio.servicex.servico.repositories;


import br.com.claudio.servicex.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
