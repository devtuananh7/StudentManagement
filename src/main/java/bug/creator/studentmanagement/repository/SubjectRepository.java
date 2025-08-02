package bug.creator.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
