package tn.esprit.spring.kaddem.services;

import tn.esprit.spring.kaddem.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {

        public List<DetailEquipe> retrieveAllDetailEquipes();
        public DetailEquipe addDetailEquipe(DetailEquipe e);
        public  void deleteDetailEquipe(Integer idEquipe);
        public DetailEquipe updateDetailEquipe(DetailEquipe e);
        public DetailEquipe retrieveDetailEquipe(Integer equipeId);
 }
