package br.com.zuco.repository;

import br.com.zuco.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

    public List<Titulo> findByDescricaoContaining(String descricao);
}
