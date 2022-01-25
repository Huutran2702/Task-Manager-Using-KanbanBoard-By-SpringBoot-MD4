package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.Workspace;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorkspaceService extends IGeneralService<Workspace> {
    List<Workspace> getAllWorkspaceByUserId( Long id);
}
