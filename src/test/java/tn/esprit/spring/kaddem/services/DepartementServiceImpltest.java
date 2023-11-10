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
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)

public class DepartementServiceImpltest {
    @Mock
    DepartementRepository departementRepository;
    @InjectMocks
    private DepartementServiceImpl departementService;

    @Test
    @Order(1)

    public void testRetrieveDepartement() {

        Departement departement = new Departement(1, "departement1");
        departement.setIdDepart(1);
        when(departementRepository.findById(1)).thenReturn(Optional.of(departement));

        departementService.retrieveDepartement(1);
        Assertions.assertNotNull(departement);

        System.out.println(departement);
        System.out.println("Departement Retrieve succefully...!!");

    }

    @Test
    @Order(2)
    public void testRetrieveAllDepartementTest() {
        List<Departement> Departementlist = new ArrayList<Departement>() {

            {
                add(new Departement(2, "departement2"));
                add(new Departement(3, "departement3"));
                add(new Departement(4, "departement4"));
                add(new Departement(5, "departement5"));

            }
        };
        when(departementService.retrieveAllDepartements()).thenReturn(Departementlist);
        List<Departement> departementlist = departementService.retrieveAllDepartements();
        assertEquals(4, departementlist.size());
        System.out.println("All departements Retrieved succefully...!!");
    }

    @Test
    @Order(3)

    public void testaddDepartement() {

        Departement departementadd = new Departement(1, "departement1");
        when(departementRepository.save(departementadd)).thenReturn(departementadd);
        Departement addeddepartement = departementService.addDepartement(departementadd);
        verify(departementRepository, times(1)).save(addeddepartement);
        assertNotNull(addeddepartement);
        assertEquals(departementadd, addeddepartement);
    }

}