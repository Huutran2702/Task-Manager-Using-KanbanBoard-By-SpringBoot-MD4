package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.WorkList;
import huu.tran.kanbanboard.repository.IWorkListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkListService implements IWorkListService{

    @Autowired
    private IWorkListRepository workListRepository;

    @Override
    public Iterable<WorkList> findAll() {
        return workListRepository.findAll();
    }

    @Override
    public Optional<WorkList> findById(Long id) {
        return workListRepository.findById(id);
    }

    @Override
    public WorkList save(WorkList workList) {
        return workListRepository.save(workList);
    }

    @Override
    public void remove(Long id) {
        workListRepository.deleteById(id);
    }

    @Override
    public List<WorkList> getAllWorkListByWorkspaceId(Long id) {
        return workListRepository.getAllWorkListByWorkspaceId(id);
    }
}
