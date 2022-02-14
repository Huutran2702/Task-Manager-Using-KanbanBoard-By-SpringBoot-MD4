package huu.tran.kanbanboard.controller;

import huu.tran.kanbanboard.model.Role;
import huu.tran.kanbanboard.model.Status;
import huu.tran.kanbanboard.model.User;
import huu.tran.kanbanboard.model.dto.UserDTO;
import huu.tran.kanbanboard.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller

public class LoginController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String loginForm() {
        return "/login/index";
    }

    @PostMapping("/dashboard")
    public ModelAndView submit(@Valid @ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/login/index");
      User findUser =  userService.findUserByEmail(user.getEmail());
        UserDTO userDTO = null;
      if (findUser!=null) {
         userDTO = modelMapper.map(findUser,UserDTO.class);
      }


        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("messages", "Thông tin đăng nhập không hợp lệ!");
        } else if (findUser==null){
            modelAndView.addObject("messages","Email không tồn tại");
        } else if (findUser.getStatus().equals(Status.DEACTIVATE)) {
            modelAndView.addObject("messages","Tài khoản hiện tại đã bị khóa");
        } else if (!user.getPassword().equals(findUser.getPassword())) {
            modelAndView.addObject("messages","Mật khẩu đăng nhập không chính xác");
        } else if (findUser.getRole().equals(Role.USER)) {
            HttpSession account = request.getSession();
            account.setAttribute("user",userDTO);
            modelAndView.setViewName("/kanban/dashboard");
            modelAndView.addObject("user",userDTO);

            return modelAndView;
        } else {
            modelAndView.setViewName("/admin/index");
            return modelAndView;
        }
        return modelAndView;
    }

}
