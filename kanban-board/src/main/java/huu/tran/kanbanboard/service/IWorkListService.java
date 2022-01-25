package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.WorkList;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorkListService extends IGeneralService<WorkList> {
    List<WorkList> getAllWorkListByWorkspaceId( Long id);
}
