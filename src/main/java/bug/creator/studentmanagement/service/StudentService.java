package bug.creator.studentmanagement.service;

import bug.creator.studentmanagement.base.BaseResponse;
import bug.creator.studentmanagement.entity.Student;
import bug.creator.studentmanagement.helper.StudentStatus;
import bug.creator.studentmanagement.repository.StudentRepository;
import bug.creator.studentmanagement.service.dataTransferObject.StudentDTO;
import bug.creator.studentmanagement.service.dataTransferObject.StudentUpdateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;


    public BaseResponse<Student> addStudent(StudentDTO student) {

        BaseResponse<Student> resp = new BaseResponse<>("00", "Success", null);

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

        resp.setData(response);
        return resp;
    }

    public BaseResponse<Student> getStudentByEmail(String email) {
        log.info("Fetching student by email: {}", email);

        BaseResponse<Student> resp = new BaseResponse<>("00", "Success", null);

        try {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                log.info("Fetched student: {}", objectMapper.writeValueAsString(student));
                resp.setData(student);
            } else {
                resp.setCode("404");
                resp.setMessage("Student not found");

            }


            return resp;
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Student getStudentByid(Integer idsv) {
        log.info("Fetching student by id: {}", idsv);
        try {
            Optional<Student> student = studentRepository.findById(idsv);
            log.info("Fetched student (id): {}", objectMapper.writeValueAsString(student));
            return student.orElse(null);
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON: {} (id)", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Student getStudentByPhoneNumber(String phoneNumber) {
        log.info("Fetching student by phone number: {}", phoneNumber);
        try {
            Optional<Student> optionalStudent = studentRepository.findByPhoneNumber(phoneNumber);
            if (optionalStudent.isPresent()) {
                log.info("Fetched student (id): {}", objectMapper.writeValueAsString(optionalStudent.get()));
                return optionalStudent.get();
            } else {
                log.info("notFound student (id): {}", phoneNumber);
                Student student = new Student();
                student.setCode("404");
                student.setMessage("Student not found");
                return student;
            }
        } catch (JsonProcessingException e) {
            log.error("Error processing JSON: {} (phone)", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentDynamic(String phone) {
        List<Student> students = studentRepository.findAll();

        List<Student> response = new ArrayList<>();
        for (Student student : students) {
            if (student.getPhoneNumber().contains(phone)) {
                response.add(student);
            }
        }

        return response;

    }

    public Student updateStudentById(Integer idsv, StudentUpdateDTO update) {
        Optional<Student> studentOptional = studentRepository.findById(idsv);
        if (studentOptional.isPresent()) {

            Student student = studentOptional.get();
            log.info("Updating student (id): {}", idsv);
            if (Objects.nonNull(update.getPhoneNumber())) {
                student.setPhoneNumber(update.getPhoneNumber());
            }

            if (Objects.nonNull(update.getStatus())) {
                student.setStatus(update.getStatus());
            }

            studentRepository.save(student);

            student.setCode("00");
            student.setMessage("Student updated");
            return student;

        }

        Student student = new Student();
        student.setCode("404");
        student.setMessage("Student not found");
        return student;
    }

    public Student deleteStudentById(Integer idsv) {
        if (studentRepository.existsById(idsv)) {
            log.info("Deleting student (id): {}", idsv);
            studentRepository.deleteById(idsv);
            Student student = new Student();
            student.setCode("00");
            student.setMessage("Student deleted");
            return student;
        }
        Student student = new Student();
        student.setCode("404");
        student.setMessage("Student not found");
        return student;
    }
}
