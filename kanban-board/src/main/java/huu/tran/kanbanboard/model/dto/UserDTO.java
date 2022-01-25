package huu.tran.kanbanboard.model.dto;

import huu.tran.kanbanboard.model.Role;
import huu.tran.kanbanboard.model.Status;
import huu.tran.kanbanboard.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private long id;
    private String fullName;
    @NotBlank(message = "* Email không được để trống ")
    @Pattern(regexp = "^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$",message = "* Email không đúng định dạng")
    @Size(min = 10,max = 30)
    private String email;
    private String phone;
    private String address;

    @NotBlank(message = "* Mật khẩu không được để trống")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$",message = "* Mật khẩu không đúng định dạng")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
    
}
