package bug.creator.studentmanagement.controller;

import bug.creator.studentmanagement.entity.Student;
import bug.creator.studentmanagement.service.StudentService;
import bug.creator.studentmanagement.service.dataTransferObject.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Student addStudent(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }


    @GetMapping("/get/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    // Get by id
    // Get by phone
    // Delete by id
    // Update by id
    // Delete by email
}
