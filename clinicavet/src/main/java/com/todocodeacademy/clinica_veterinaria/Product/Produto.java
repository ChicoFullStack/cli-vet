package com.todocodeacademy.clinica_veterinaria.Product;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigoSku;
    private Integer quantidade;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;

// Adicionar a relação com a tabela de categorias
// Adicionar a relação com a tabela de marca

    @ElementCollection
    @CollectionTable(name = "produto_cores", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "cor")
    private List<String> cores;

    @ElementCollection
    @CollectionTable(name = "produto_tamanhos", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tamanho")
    private List<String> tamanhos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}

