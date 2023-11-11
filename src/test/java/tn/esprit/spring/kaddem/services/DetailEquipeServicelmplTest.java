package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DetailEquipeServicelmplTest {

    @Mock
    DetailEquipeRepository detailEquipeRepository;

    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    DetailEquipeServicelmpl detailEquipeService;

    @Test
    @Order(1)
    public void testRetrieveDetailEquipe() {
        // Given
        DetailEquipe detailEquipe = new DetailEquipe(1, "exp");
        detailEquipe.setIdDetailEquipe(1);

        when(detailEquipeRepository.findById(1)).thenReturn(Optional.of(detailEquipe));

        // When
        DetailEquipe retrievedDetailEquipe = detailEquipeService.retrieveDetailEquipe(1);

        // Then
        assertNotNull(retrievedDetailEquipe);
        assertEquals(detailEquipe, retrievedDetailEquipe);
    }

    @Test
    @Order(2)
    public void testAddDetailEquipe() {
        // Given
        DetailEquipe detailEquipeToAdd = new DetailEquipe(1, "exp");

        when(detailEquipeRepository.save(detailEquipeToAdd)).thenReturn(detailEquipeToAdd);

        // When
        DetailEquipe addedDetailEquipe = detailEquipeService.addDetailEquipe(detailEquipeToAdd);

        // Then
        verify(detailEquipeRepository, times(1)).save(detailEquipeToAdd);
        assertNotNull(addedDetailEquipe);
        assertEquals(detailEquipeToAdd, addedDetailEquipe);
    }


    @Test
    @Order(3)
    public void testRetrieveContrat() {
        // Given
        DetailEquipe expectedDetailEquipe = new DetailEquipe(1, "exp");
        expectedDetailEquipe.setIdDetailEquipe(1);

        when(detailEquipeRepository.findById(1)).thenReturn(Optional.of(expectedDetailEquipe));

        // When
        DetailEquipe retrieveDetailEquipe = detailEquipeService.retrieveDetailEquipe(1);

        // Then
        verify(detailEquipeRepository, times(1)).findById(1);
        assertNotNull(retrieveDetailEquipe);
        assertEquals(expectedDetailEquipe, retrieveDetailEquipe);
    }

}
