package huu.tran.kanbanboard.repository;

import huu.tran.kanbanboard.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkRepository extends JpaRepository<Work,Long> {
}
