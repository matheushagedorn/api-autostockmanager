package br.univille.service;

import br.univille.model.carros;
import br.univille.repository.carrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class carroService {

    @Autowired
    private carrosRepository carrosRepository;

    public List<carros> listarTodos() {
        return carrosRepository.findAll();
    }

    public Optional<carros> buscarPorId(Long id) {
        return carrosRepository.findById(id);
    }

    public carros salvarcarros(carros carros) {
        return carrosRepository.save(carros);
    }

    public void deletarcarros(Long id) {
        carrosRepository.deleteById(id);
    }

    public carros atualizarcarros(Long id, carros carrosAtualizado) {
        return carrosRepository.findById(id).map(carros -> {
            carros.setmodelo(carrosAtualizado.getmodelo());
            carros.setano(carrosAtualizado.getano());
            carros.setcor(carrosAtualizado.getcor());
            carros.setquilometragem(carrosAtualizado.getquilometragem());
            carros.setvalor(carrosAtualizado.getvalor());
            carros.setstatus(carrosAtualizado.getstatus());
            return carrosRepository.save(carros);
        }).orElseGet(() -> {
            carrosAtualizado.setId(id);
            return carrosRepository.save(carrosAtualizado);
        });
    }
}
