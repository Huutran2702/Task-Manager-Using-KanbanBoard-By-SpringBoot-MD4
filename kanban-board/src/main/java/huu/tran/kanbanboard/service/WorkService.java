package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.Work;
import huu.tran.kanbanboard.repository.IWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkService implements IWorkService{
    @Autowired
    private IWorkRepository workRepository;

    @Override
    public Iterable<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Optional<Work> findById(Long id) {
        return workRepository.findById(id);
    }

    @Override
    public Work save(Work work) {
        return workRepository.save(work);
    }

    @Override
    public void remove(Long id) {
        workRepository.deleteById(id);
    }
}
