package iasi.CP2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import iasi.CP2.model.Brinquedo;

@Repository
public class JdbcBrinquedoRepositorio implements BrinquedoRepositorio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Brinquedo brinquedo) {
        return jdbcTemplate.update("INSERT INTO TDS_TB_Brinquedos (nome, tipo, classificacao, tamanho, preco) VALUES(?,?,?,?,?)",
                new Object[] { brinquedo.getNome(), brinquedo.getTipo(), brinquedo.getClassificacao(), brinquedo.getTamanho(), brinquedo.getPreco() });
    }

    @Override
    public int update(Brinquedo brinquedo) {
        return jdbcTemplate.update("UPDATE TDS_TB_Brinquedos SET nome=?, tipo=?, classificacao=?, tamanho=?, preco=? WHERE id=?",
                new Object[] { brinquedo.getNome(), brinquedo.getTipo(), brinquedo.getClassificacao(), brinquedo.getTamanho(), brinquedo.getPreco(), brinquedo.getId() });
    }

    @Override
    public Brinquedo findById(Long id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM TDS_TB_Brinquedos WHERE ID=?",
                    new Object[]{id},
                    (rs, rowNum) -> {
                        Brinquedo brinquedo = new Brinquedo();
                        brinquedo.setId(rs.getLong("id"));
                        brinquedo.setNome(rs.getString("nome"));
                        brinquedo.setTipo(rs.getString("tipo"));
                        brinquedo.setClassificacao(rs.getString("classificacao"));
                        brinquedo.setTamanho(rs.getString("tamanho"));
                        brinquedo.setPreco(rs.getDouble("preco"));
                        return brinquedo;
                    }
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM TDS_TB_Brinquedos WHERE id=?", id);
    }

    @Override
    public List<Brinquedo> findAll() {
        return jdbcTemplate.query("SELECT * FROM TDS_TB_Brinquedos", (rs, rowNum) -> {
            Brinquedo brinquedo = new Brinquedo();
            brinquedo.setId(rs.getLong("ID"));
            brinquedo.setNome(rs.getString("nome"));
            brinquedo.setTipo(rs.getString("tipo"));
            brinquedo.setClassificacao(rs.getString("classificacao"));
            brinquedo.setTamanho(rs.getString("tamanho"));
            brinquedo.setPreco(rs.getDouble("preco"));
            return brinquedo;
        });
    }

    @Override
    public List<Brinquedo> findByNameContaining(String nome) {
        String q = "SELECT * from TDS_TB_Brinquedos WHERE nome LIKE '%" + nome + "%' collate binary_ci";

        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Brinquedo.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from TDS_TB_Brinquedos");
    }
}
