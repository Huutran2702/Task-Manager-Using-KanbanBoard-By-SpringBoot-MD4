package huu.tran.kanbanboard.repository;

import huu.tran.kanbanboard.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWorkspaceRepository extends JpaRepository<Workspace,Long> {

    @Query("SELECT w " +
            "from Workspace w " +
            "JOIN w.users u " +
            "where u.id = :id")
    List<Workspace> getAllWorkspaceByUserId(@Param("id") Long id);
}
