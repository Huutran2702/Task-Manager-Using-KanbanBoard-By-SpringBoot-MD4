package huu.tran.kanbanboard.repository;

import huu.tran.kanbanboard.model.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWorkListRepository extends JpaRepository<WorkList,Long> {

    @Query("SELECT wl FROM WorkList wl WHERE wl.workspace.id = :id")
    List<WorkList> getAllWorkListByWorkspaceId(@Param("id") Long id);
}
