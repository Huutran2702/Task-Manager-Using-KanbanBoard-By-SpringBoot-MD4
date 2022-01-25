package huu.tran.kanbanboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "worklists")
public class WorkList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private int priority;

    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "workspace_id",nullable = false)
    private Workspace workspace;


    @OneToMany(
            mappedBy = "workList"
    )
    private List<Work> works;



}