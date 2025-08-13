package br.com.zuco.service;

import br.com.zuco.model.StatusTitulo;
import br.com.zuco.model.Titulo;
import br.com.zuco.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TituloService {

    @Autowired
    private TituloRepository tituloRepository;

    public List<Titulo> listarTodos() {
        List<Titulo> listar = tituloRepository.findAll();
        return listar;
    }

    public void salvar(Titulo titulo) {
        try {
            tituloRepository.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
    }

    public void deletar(Long codigo) {
        tituloRepository.deleteById(codigo);
    }

    public String receber(Long codigo) {
        Titulo titulo = tituloRepository.findById(codigo).orElseThrow(NoSuchElementException::new);
        titulo.setStatus(StatusTitulo.RECEBIDO);
        tituloRepository.save(titulo);
        return StatusTitulo.RECEBIDO.getDescricao();
    }
}
