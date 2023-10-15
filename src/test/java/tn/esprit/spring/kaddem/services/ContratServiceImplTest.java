package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.util.Date;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContratServiceImplTest {

    @Mock
    ContratRepository contratRepository;
    @InjectMocks
    ContratServiceImpl contratService;

    @Test
    @Order(1)
    public void testRetrieveAllContrats() {

        Specialite IA = Specialite.IA;
        Contrat contrat = new Contrat(new Date(), new Date(), IA, false, 1);

        contrat.setIdContrat(1);

        when(contratRepository.findById(1)).thenReturn(Optional.of(contrat));

        contratService.retrieveContrat(1);
        Assertions.assertNotNull(contrat);
    }
    @Test
    @Order(2)
    public void testAddContrat() {
        Specialite IA = Specialite.IA;
        Contrat contratToAdd = new Contrat(new Date(), new Date(), IA, false, 1);
        when(contratRepository.save(contratToAdd)).thenReturn(contratToAdd);
        Contrat addedContrat = contratService.addContrat(contratToAdd);
        verify(contratRepository, times(1)).save(contratToAdd);
        assertNotNull(addedContrat);
        assertEquals(contratToAdd, addedContrat);
    }

}