package huu.tran.kanbanboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Date startTime;
    private Date finishTime;

    private Date createAt;

    private String description;

    @ManyToOne
    @JoinColumn(name = "worklist_id",referencedColumnName = "id")
    private WorkList workList;


}