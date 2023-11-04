package com.spring.spring_h2_mysql;
import com.spring.spring_h2_mysql.entities.Patient;
import com.spring.spring_h2_mysql.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringH2MySqlApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringH2MySqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Ajout Manuel
        patientRepository.save(new Patient(null,"Nisrine",new Date(),false,100));
        patientRepository.save(new Patient(null,"Amal",new Date(),false,98));
        patientRepository.save(new Patient(null,"Nour",new Date(),false,80));
        //Ajout par Boucle
        for (int i=0;i<100;i++){
            patientRepository.save(
                    new Patient(null, "Aymen",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100))
            );
        }
//---------------------------------------Affichage par liste------------------------------------------
		/*
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(patient -> {
            System.out.println("*******************Patient:"+patient.getId()+"*******************");
			System.out.println(patient.getNom());
			System.out.println(patient.getScore());
			System.out.println(patient.getDateNaissance());
			System.out.println(patient.isMalade());
		});*/
        //---------------------------Affiche avec Pagination-----------------------------------------
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total pages : "+patients.getTotalPages());
        System.out.println("Total elements :"+patients.getTotalElements());
        System.out.println("Num Page: "+patients.getNumber());
        List<Patient> content = patients.getContent();
        System.out.println("Liste des patients sans Contraints :");
        content.forEach(patient -> {
            System.out.println("Patient:"+patient.getId()+" ");
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
        });


        //System.out.println("Liste des patients malade:");
        //List<Patient> patientsList = patientRepository.findByMalade(true);
        //System.out.println("Liste de 4 patients malade dans la page 0: ");
        //Page<Patient> patientsList = patientRepository.findByMalade(true,PageRequest.of(0,4));
        System.out.println("Liste des patients qui contient dans le nom 'o' et un score < 100:");
        List<Patient> patientsList=patientRepository.chercherPatients("%o%",100);
        patientsList.forEach(patient -> {
            System.out.println("Patient:"+patient.getId()+" ");
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
        });

        //-------------------------------Recherche un patient par Id------------------------------
        System.out.println("Recherche de patient par Id : ");
        Patient patient_recherche=patientRepository.findById(1L).orElse(null);
        if(patient_recherche!=null){
            System.out.println(patient_recherche.getNom());
            System.out.println(patient_recherche.getDateNaissance());
            System.out.println(patient_recherche.getScore());
            System.out.println(patient_recherche.isMalade());
        }
        else {
            System.out.println("Le Patient recherché n'existe pas");
        }

        //Mettre à Jour un Patient
        Patient patient_modifie = patientRepository.findById(2L).orElse(null);
        if(patient_modifie != null){
            patient_modifie.setMalade(true);
            patient_modifie.setScore(870);
            patientRepository.save(patient_modifie);
            System.out.println("Les infos du Patient n°"+patient_modifie.getId()+" ont été modifié avec succés");
            System.out.println("Nouveau score : " + patient_modifie.getScore());
            System.out.println("Etat de maladie :" + patient_modifie.isMalade());
        }
        else {
            System.out.println("Le Patient a modifier est introuvalbe");
        }

        //----------------------------------Suppression un patient-----------------------------------------
        patientRepository.deleteById(4L);
        System.out.println("Le Patient a été supprimé");
    }
}



