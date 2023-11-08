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
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
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


  /*  @Test
    @Order(1)
    public void testAddUniversite() {
        //Specialite IA = Specialite.IA;
        Universite contratToAdd = new Universite(nomUniv, new Date(), IA, false, 1);
        when(universiteRepository.save(contratToAdd)).thenReturn(contratToAdd);
        Universite addedContrat = universiteService.addUniversite(contratToAdd);
        verify(universiteRepository, times(1)).save(contratToAdd);
        assertNotNull(addedContrat);
        assertEquals(contratToAdd, addedContrat);
    }*/

  //  @Test
  //  @Order(1)


   /* public void testRetrieveUniversiteTest() {

       Universite universite = new Universite(1, "Université1");
        universite.setIdUniv(1);
       // when(universiteRepository.findById(1)).thenReturn(Optional.of(universite));

        universiteService.retrieveUniversite(1);
        assertNotNull(universite);

        System.out.println(universite);
        System.out.println("University Retrieve processed succefully...!!");

    }*/

    @Order(1)
    @Test
    public void testAddUniversite() {
        Universite universiteToAdd = new Universite("esprit1");
        when(universiteRepository.save(universiteToAdd)).thenReturn(universiteToAdd);

        Universite addedUniversite = universiteService.addUniversite(universiteToAdd);

        verify(universiteRepository).save(universiteToAdd);
        assertNotNull(addedUniversite);
        assertEquals(universiteToAdd, addedUniversite);

        System.out.println(universiteToAdd);
        System.out.println("University added succefully...!!");
    }


    @Order(3)
    @Test
    public void testRetrieveAllUniversiteTest()
    {
        List<Universite> Universitelist = new ArrayList<Universite>() {

            {
                add(new Universite(2, "Université2"));
                add(new Universite(3, "Université3"));
                add(new Universite(4, "Université4"));
                add(new Universite(5, "Université5"));

            }};
        when(universiteService.retrieveAllUniversites()).thenReturn(Universitelist);
        List<Universite> universitelist = universiteService.retrieveAllUniversites();
        assertEquals(4, universitelist.size());
        System.out.println("All Universities Retrieve processed succefully...!!");
    }

    @Test
    @Order(4)
    public void testUpdateUniversite() {

        Universite universiteToUpdate = new Universite(1, "central"); // Remplacez par les valeurs appropriées

        when(universiteRepository.save(universiteToUpdate)).thenReturn(universiteToUpdate);

        Universite updatedUniversite = universiteService.updateUniversite(universiteToUpdate);

        verify(universiteRepository, times(1)).save(universiteToUpdate);

        assertEquals(universiteToUpdate, updatedUniversite);

        System.out.println(universiteToUpdate);
        System.out.println("University updated succefully...!!");
    }



}
