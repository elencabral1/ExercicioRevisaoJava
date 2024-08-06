package iasi.CP2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TDS_TB_Brinquedos")
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "classificacao")
    private String classificacao;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "preco")
    private double preco;



    @Override
    public String toString() {
        return "Brinquedo [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", classificação=" + classificacao + ", tamanho=" + tamanho + ", preço=" + preco + "]";
    }
}
