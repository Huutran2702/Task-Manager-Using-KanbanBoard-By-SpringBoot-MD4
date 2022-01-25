package huu.tran.kanbanboard.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Tên không gian làm việc không được để trống")
    private String name;

    @Enumerated(EnumType.ORDINAL)

    private Favorite favorite;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private String filePath;

    @OneToMany(mappedBy="workspace",fetch = FetchType.LAZY)
    private List<WorkList> workLists;

    @ManyToMany(mappedBy = "workspaces",cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<User> users;
}