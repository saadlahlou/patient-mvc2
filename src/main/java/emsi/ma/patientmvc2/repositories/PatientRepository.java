package emsi.ma.patientmvc2.repositories;

import emsi.ma.patientmvc2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
