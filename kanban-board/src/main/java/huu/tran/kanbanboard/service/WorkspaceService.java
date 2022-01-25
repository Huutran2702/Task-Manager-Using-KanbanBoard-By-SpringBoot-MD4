package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.Workspace;
import huu.tran.kanbanboard.repository.IWorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService implements IWorkspaceService{

    @Autowired
    private IWorkspaceRepository workspaceRepository;

    @Override
    public Iterable<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    @Override
    public Optional<Workspace> findById(Long id) {
        return workspaceRepository.findById(id);
    }

    @Override
    public Workspace save(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    @Override
    public void remove(Long id) {
        workspaceRepository.deleteById(id);
    }

    @Override
    public List<Workspace> getAllWorkspaceByUserId(Long id) {
        return workspaceRepository.getAllWorkspaceByUserId(id);
    }
}
