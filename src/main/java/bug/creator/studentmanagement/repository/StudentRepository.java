package bug.creator.studentmanagement.repository;

import bug.creator.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findByPhoneNumber(String phoneNumber);

//    @Modifying
//    @Query("update Student s set s.phoneNumber = '1' where s.idSv = ?1 and s.phoneNumber = ?2")
//    Student updateStudentByIdSv(Integer idsv, String phoneNumber);

}



