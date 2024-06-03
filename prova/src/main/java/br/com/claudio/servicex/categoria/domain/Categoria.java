package br.com.claudio.servicex.categoria.domain;


import br.com.claudio.servicex.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIAS")
public class Categoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;
    @Column(name = "NOME_CATEGORIA")
    private String nomeCategoria;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Servico> servicos;


    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }


}


