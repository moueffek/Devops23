package tn.esprit.spring.kaddem.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import static org.mockito.Mockito.when;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)

public class UniversiteServiceImplTest {
    @Mock
    UniversiteRepository universiteRepository;
    @InjectMocks
    private UniversiteServiceImpl universiteService;
    @Test
    @Order(1)


    public void testRetrieveUniversiteTest() {

       Universite universite = new Universite(1, "Université1");

        universite.setIdUniv(1);

        when(universiteRepository.findById(1)).thenReturn(Optional.of(universite));

        universiteService.retrieveUniversite(1);
        Assertions.assertNotNull(universite);

        System.out.println(universite);
        System.out.println(" University Retrieve processed succefully...!!");

    }


}
