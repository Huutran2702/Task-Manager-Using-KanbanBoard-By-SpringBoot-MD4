package huu.tran.kanbanboard;

import huu.tran.kanbanboard.model.User;
import huu.tran.kanbanboard.model.WorkList;
import huu.tran.kanbanboard.model.Workspace;
import huu.tran.kanbanboard.model.dto.UserDTO;
import huu.tran.kanbanboard.model.dto.WorkListDTO;
import huu.tran.kanbanboard.model.dto.WorkspaceDTO;
import huu.tran.kanbanboard.repository.IUserRepository;
import huu.tran.kanbanboard.repository.IWorkListRepository;
import huu.tran.kanbanboard.repository.IWorkspaceRepository;
import huu.tran.kanbanboard.service.IWorkspaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KanbanBoardApplication implements CommandLineRunner {

    @Autowired
    private IWorkspaceService workspaceService;

    @Autowired
    private IUserRepository userRepository;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(KanbanBoardApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
    }
}
