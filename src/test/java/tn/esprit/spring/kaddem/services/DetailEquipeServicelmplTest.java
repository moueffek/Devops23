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
    DetailEquipeRepository detailEquipeRepository ;
    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    DetailEquipeServicelmpl DetailEquipeService;

    @Test
    @Order(1)
    public void testRetrieveAllDetailEquipe() {

         DetailEquipe detailEquipe = new DetailEquipe( 1,  "exp");

        detailEquipe.setIdDetailEquipe(1);

        when(detailEquipeRepository.findById(1)).thenReturn(Optional.of(detailEquipe));

        DetailEquipeService.retrieveDetailEquipe(1);
        assertNotNull(detailEquipe);
    }

    @Test
    @Order(2)
    public void testAddDetailEquipe() {
        DetailEquipe detailEquipeAdd = new DetailEquipe( 1,  "exp");
        when(detailEquipeRepository.save(detailEquipeAdd)).thenReturn(detailEquipeAdd);
        DetailEquipe addedDetailEquipe = DetailEquipeService.addDetailEquipe(detailEquipeAdd);
        verify(detailEquipeRepository, times(1)).save(addedDetailEquipe);
        assertNotNull(addedDetailEquipe);
        assertEquals(detailEquipeAdd, addedDetailEquipe);
    }

    @Test
    @Order(3)
    public void testRetrieveContrat() {
        DetailEquipe expectedDetailEquipe = new DetailEquipe( 1,  "exp");

        expectedDetailEquipe.setIdDetailEquipe(1);

        when(detailEquipeRepository.findById(1)).thenReturn(Optional.of(expectedDetailEquipe));
        DetailEquipe retrieveDetailEquipe = DetailEquipeService.retrieveDetailEquipe(1);

        verify(detailEquipeRepository, times(1)).findById(1);

        assertNotNull(retrieveDetailEquipe);
        assertEquals(expectedDetailEquipe, retrieveDetailEquipe);
    }


























}
