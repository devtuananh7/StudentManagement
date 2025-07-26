package bug.creator.studentmanagement.helper;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum StudentStatus {
    PENDING_ACTIVE("0", "Pending Active"),
    ACTIVE("1", "Active"),
    INACTIVE("2", "Inactive"),
    GRADUATED("3", "Graduated"),
    SUSPENDED("4", "Suspended"),;

    @Getter
    private final String code;
    @Getter
    private final String description;

    StudentStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StudentStatus fromCode(String code) {
        for (StudentStatus status : StudentStatus.values()) {
            if (Objects.equals(status.getCode(), code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
