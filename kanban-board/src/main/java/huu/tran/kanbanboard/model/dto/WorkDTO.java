package huu.tran.kanbanboard.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class WorkDTO {
    private long id;
    private String name;
    private Date startTime;
    private Date finishTime;

    private Date createAt;

    private String description;
}
