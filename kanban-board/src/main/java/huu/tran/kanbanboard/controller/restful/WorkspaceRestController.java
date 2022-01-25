package huu.tran.kanbanboard.controller.restful;

import huu.tran.kanbanboard.model.User;
import huu.tran.kanbanboard.model.Workspace;
import huu.tran.kanbanboard.model.dto.UserDTO;
import huu.tran.kanbanboard.model.dto.WorkspaceDTO;
import huu.tran.kanbanboard.service.IUserService;
import huu.tran.kanbanboard.service.IWorkspaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workspace")
public class WorkspaceRestController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IWorkspaceService workspaceService;
    @Autowired
    private IUserService userService;

    @GetMapping("/all/{id}")
    public List<WorkspaceDTO> getAllWorkspaceByUserId(@PathVariable Long id) {

        return workspaceService.getAllWorkspaceByUserId(id).stream().map(workspace -> modelMapper.map(workspace, WorkspaceDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> getWorkspaceById(@PathVariable Long id) {
        Workspace workspace = workspaceService.findById(id).get();
        WorkspaceDTO workspaceDTO = modelMapper.map(workspace,WorkspaceDTO.class);
        return new ResponseEntity<>(workspaceDTO,HttpStatus.OK);
    }

    @PostMapping("/{userId}/create")
    public ResponseEntity<WorkspaceDTO> createWorkspace(@RequestBody WorkspaceDTO workspaceDTO, @PathVariable Long userId) {
        Workspace workspaceRequest = modelMapper.map(workspaceDTO, Workspace.class);
        User createBy = userService.findById(userId).get();
        List<User> users = new ArrayList<>();
        users.add(createBy);
        workspaceRequest.setUsers(users);
        workspaceRequest.setCreatedBy(createBy);
        Workspace workspace = workspaceService.save(workspaceRequest);
        if (createBy.getWorkspaces().size() == 0) {
            List<Workspace> workspaces = new ArrayList<>();
            workspaces.add(workspace);
            createBy.setWorkspaces(workspaces);
        } else {
            createBy.getWorkspaces().add(workspace);
        }
        User save = userService.save(createBy);
        WorkspaceDTO workspaceDTOResponse = modelMapper.map(workspace, WorkspaceDTO.class);
        return new ResponseEntity<>(workspaceDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<WorkspaceDTO> updatePost(@PathVariable long id, @RequestBody WorkspaceDTO workspaceDTO) {
        System.out.println(workspaceDTO.getFilePath());
        Workspace workspace = workspaceService.findById(id).get();
        workspace.setName(workspaceDTO.getName());
        if (workspaceDTO.getFilePath()!=null) {
            workspace.setFilePath(workspaceDTO.getFilePath());
        }
        // convert DTO to Entity

        Workspace workspaceUpdate = workspaceService.save(workspace);

        // entity to DTO
        WorkspaceDTO workspaceDTOResponse = modelMapper.map(workspaceUpdate, WorkspaceDTO.class);

        return ResponseEntity.ok().body(workspaceDTOResponse);
    }

    @DeleteMapping("/delete/{userId}/{id}")
    public ResponseEntity<WorkspaceDTO> deletePost(@PathVariable(name = "userId") Long userId, @PathVariable(name = "id") Long id) {
        Workspace workspace = workspaceService.findById(id).get();
        WorkspaceDTO workspaceDTO = modelMapper.map(workspace, WorkspaceDTO.class);
        User user = userService.findById(userId).get();
        user.getWorkspaces().removeIf(workspace1 -> workspace1.getId().equals(id));
        userService.save(user);
        if (workspace.getCreatedBy().getId().equals(userId)) {
            workspaceService.remove(id);
            return new ResponseEntity<>(workspaceDTO, HttpStatus.OK);
        } else {
            workspace.getUsers().removeIf(user1 -> user.getId().equals(userId));
            workspaceService.save(workspace);
            return new ResponseEntity<>(workspaceDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/invite/{wspId}/{email}")
    public ResponseEntity<WorkspaceDTO> invite(@PathVariable Long wspId, @PathVariable String email) {
        Workspace workspace = workspaceService.findById(wspId).get();
        User user = userService.findUserByEmail(email);
        if (user==null) {
            return new ResponseEntity<>(modelMapper.map(workspace,WorkspaceDTO.class),HttpStatus.NOT_FOUND);
        } else {
            boolean exist = false;
            for (User u: workspace.getUsers()
                 ) {
                if (u.getEmail().equals(user.getEmail())) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println(workspace.getUsers().contains(user));
                workspace.getUsers().add(user);
                workspaceService.save(workspace);
                user.getWorkspaces().add(workspace);
                userService.save(user);
                return new ResponseEntity<>(modelMapper.map(workspace,WorkspaceDTO.class),HttpStatus.OK);
            } else {
                System.out.println("error");
                return new ResponseEntity<>(modelMapper.map(workspace,WorkspaceDTO.class),HttpStatus.BAD_REQUEST);
            }

        }

    }

}
