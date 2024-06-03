package br.com.claudio.servicex.categoria.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO{
    private Integer idCategoria;
    private String nomeCategoria;
    private String mensagem;

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria) {
        idCategoria = categoria.getIdCategoria();
        nomeCategoria = categoria.getNomeCategoria();
    }

}