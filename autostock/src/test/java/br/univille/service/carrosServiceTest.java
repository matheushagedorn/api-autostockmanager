package br.univille.service;

import br.univille.model.carros;
import br.univille.repository.carrosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class carrosServiceTest {

    @Autowired
    private carroService carroservice;

    @MockBean
    private carrosRepository carrosRepository;

    @Test
    public void testSalvarcarros() {
        carros carros = new carros();
        carros.setmodelo("c3");
        when(carrosRepository.save(any(carros.class))).thenReturn(carros);

        carros savedcarros = carroservice.salvarcarros(carros);
        assertEquals("c3", savedcarros.getmodelo());
    }

    @Test
    public void testBuscarPorId() {
        carros carros = new carros();
        carros.setId(1L);
        when(carrosRepository.findById(1L)).thenReturn(Optional.of(carros));

        Optional<carros> foundcarros = carroservice.buscarPorId(1L);
        assertEquals(true, foundcarros.isPresent());
        assertEquals(1L, foundcarros.get().getId());
    }
}

