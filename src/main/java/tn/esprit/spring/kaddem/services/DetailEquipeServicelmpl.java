package tn.esprit.spring.kaddem.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service


public class DetailEquipeServicelmpl implements IDetailEquipeService {
@Autowired
DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipes() {
        return  (List<DetailEquipe>) detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe e) {
        return (detailEquipeRepository.save(e));
    }

    @Override
    public void deleteDetailEquipe(Integer idDetailEquipe) {
        DetailEquipe e=retrieveDetailEquipe(idDetailEquipe);
        detailEquipeRepository.delete(e);

    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe e) {
        return (	detailEquipeRepository.save(e));    }

    @Override
    public DetailEquipe retrieveDetailEquipe(Integer equipeId) {
        return detailEquipeRepository.findById(equipeId).get();
    }
}
