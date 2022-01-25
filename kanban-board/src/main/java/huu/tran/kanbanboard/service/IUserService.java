package huu.tran.kanbanboard.service;

import huu.tran.kanbanboard.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService extends IGeneralService<User> {
    User findUserByEmail(String email);
    List<User> getAllUserByWorkspaceId( Long id);
}
