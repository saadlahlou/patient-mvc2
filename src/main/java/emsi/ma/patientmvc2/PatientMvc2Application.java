package emsi.ma.patientmvc2;

import emsi.ma.patientmvc2.entities.Patient;
import emsi.ma.patientmvc2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientMvc2Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(PatientMvc2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(
                new Patient(null,"Hassane", new Date(),false,300));
        patientRepository.save(
                new Patient(null,"Mohamed", new Date(),false,300));
        patientRepository.save(
                new Patient(null,"Imane", new Date(),false,300));
        patientRepository.save(
                new Patient(null,"saad", new Date(),false,300));
        List<Patient> patients = patientRepository.findAll();

        patients.forEach(p-> {
            System.out.println("========");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());


        });
        // UTILISATEUR SACHAN sans id
        System.out.println("*******");
        Patient patient=patientRepository.findById(1L).orElse(null);
        if(patient!=null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(860);
        // OPERATION DE MIS A JOUR
        patientRepository.save(patient);
        patientRepository.deleteById(1L);







    }
}
