package huu.tran.kanbanboard.model.dto;

import huu.tran.kanbanboard.model.Favorite;
import huu.tran.kanbanboard.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WorkspaceDTO {
    private long id;
    @NotBlank(message = "Tên không gian làm việc không được để trống")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Favorite favorite;

    private Date createdAt;

    private String filePath;
}
