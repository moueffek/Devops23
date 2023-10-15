package tn.esprit.spring.kaddem.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
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

       Universite universite = new Universite(1, "100");

        universite.setIdUniv(1);

        when(universiteRepository.findById(1)).thenReturn(Optional.of(universite));

        universiteService.retrieveUniversite(1);
        Assertions.assertNotNull(universite);

        System.out.println(universite);
        System.out.println(" University Retrieve processed succefully...!!");

    }


}
