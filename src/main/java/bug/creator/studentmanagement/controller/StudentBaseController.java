package bug.creator.studentmanagement.controller;

import bug.creator.studentmanagement.base.BaseResponse;
import bug.creator.studentmanagement.entity.Student;
import bug.creator.studentmanagement.service.StudentService;
import bug.creator.studentmanagement.service.dataTransferObject.StudentDTO;
import bug.creator.studentmanagement.service.dataTransferObject.StudentUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentBaseController {
    private final StudentService studentService;


    /**
     * Create a new student with name gender email phoneNumber
     * @param student
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Student> addStudent(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }


    @GetMapping("/get/emails/{email}")
    public BaseResponse<Student> getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    // Get by id
    @GetMapping("/get/ids/{idsv}")
    public Student getStudentById(@PathVariable Integer idsv) {
        return studentService.getStudentByid(idsv) ;
    }

    // Get by phone
    @GetMapping("/get/phones/{phoneNumber}")
    public Student getStudentByPhoneNumber(@PathVariable String phoneNumber) {
        return studentService.getStudentByPhoneNumber(phoneNumber);
    }

    @GetMapping("/get/phones-dynamic/{phone}")
    public List<Student> getStudentByPhoneNumberDynamic(@PathVariable String phone) {
        return studentService.getStudentDynamic(phone);
    }

    // Delete by id
    @DeleteMapping("/delete/ids/{idsv}")
    public Student deleteStudentById(@PathVariable Integer idsv) {
        return studentService.deleteStudentById(idsv);
    }

    // Update by id
    @PutMapping("/update/ids/{idsv}")
    public Student updateStudentById(@PathVariable Integer idsv, @RequestBody StudentUpdateDTO student) {
        return studentService.updateStudentById(idsv, student);
    }
    // Delete by email

    @PutMapping("/update/emails/{email}")
    public BaseResponse<StudentUpdateDTO> updateStudentByEmail(@PathVariable String email, @RequestBody StudentUpdateDTO student) {

    }
}
