package huu.tran.kanbanboard.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "users_workspaces",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "workspace_id")}
    )
    private List<Workspace> workspaces = new ArrayList<>();



}
