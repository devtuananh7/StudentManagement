package bug.creator.studentmanagement.service.dataTransferObject;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDTO {
    private String phoneNumber;
    private String status;
}
