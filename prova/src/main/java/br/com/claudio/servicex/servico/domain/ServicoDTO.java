package br.com.claudio.servicex.servico.domain;

import br.com.claudio.servicex.categoria.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoDTO {

    private Integer idServico;
    private String nome;
    private Double valor;
    private Categoria categoria;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico servico) {
        idServico = servico.getIdServico();
        nome = servico.getNome();
        valor = servico.getValor();
        categoria = servico.getCategoria();
    }
}
