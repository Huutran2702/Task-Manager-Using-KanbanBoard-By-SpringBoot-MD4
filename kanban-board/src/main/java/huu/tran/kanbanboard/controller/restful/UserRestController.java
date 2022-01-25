package huu.tran.kanbanboard.controller.restful;

import huu.tran.kanbanboard.model.Role;
import huu.tran.kanbanboard.model.Status;
import huu.tran.kanbanboard.model.User;
import huu.tran.kanbanboard.model.dto.UserDTO;
import huu.tran.kanbanboard.model.dto.WorkspaceDTO;
import huu.tran.kanbanboard.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        User findUser = userService.findUserByEmail(user.getEmail());
        if (!(findUser == null)) {
            System.out.println(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        } else if (bindingResult.hasFieldErrors()) {
            System.out.println(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
        }

        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVATE);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/all/{id}")
    public List<UserDTO> getAllUserByWorkspaceId(@PathVariable Long id) {
        return userService.getAllUserByWorkspaceId(id).stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
