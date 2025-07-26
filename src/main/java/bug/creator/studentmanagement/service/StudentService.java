package bug.creator.studentmanagement.service;

import bug.creator.studentmanagement.entity.Student;
import bug.creator.studentmanagement.helper.StudentStatus;
import bug.creator.studentmanagement.repository.StudentRepository;
import bug.creator.studentmanagement.service.dataTransferObject.StudentDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;


    public Student addStudent(StudentDTO student) {
        Student response = new Student();

        try {
            log.info("Adding new student: {}", objectMapper.writeValueAsString(student));

            response.setName(student.getName());
            response.setGender(student.getGender());
            response.setEmail(student.getEmail());
            response.setPhoneNumber(student.getPhoneNumber());
            response.setStatus(StudentStatus.PENDING_ACTIVE.getCode());

            response = studentRepository.save(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public Student getStudentByEmail(String email) {
        log.info("Fetching student by email: {}", email);
        try {
            Student student = studentRepository.findByEmail(email);
            log.info("Fetched student: {}", objectMapper.writeValueAsString(student));
            return student;
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON: {}", e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
