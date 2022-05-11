package com.sportyshoes.controller;

import com.sportyshoes.entity.UserEntity;
import com.sportyshoes.model.UserRole;
import com.sportyshoes.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    //    @RolesAllowed({"ROLE-USER, ROLE_ADMIN"})
    @GetMapping("all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findAll(Model model) {

        model.addAttribute("users", userService.findAll());
        return "all-users";
    }

    @GetMapping("edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editUser(@PathVariable Integer id, Model model) {

        final UserEntity userEntity = userService.findById(id).get();

        model.addAttribute("user", userEntity);
        return "update-user";
    }

    @PostMapping("update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateUser(@Valid @ModelAttribute("user") UserEntity userEntity, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "update-user";

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userService.save(userEntity);
        return "redirect:/user/all?update-user=true";
    }

    @GetMapping("view/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String viewUser(@PathVariable Integer id, Model model) {

        final UserEntity userEntity = userService.findById(id).get();

        model.addAttribute("user", userEntity);
        return "user-details";
    }

    @GetMapping("sign-up")
    public String signUp(UserEntity userEntity) {

        return "sign-up";
    }

    @PostMapping("sign-up")
    public String signUp(@Valid UserEntity userEntity, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "sign-up";

        if (userEntity.getEmail().equals("prakashnaidupn7@gmail.com")) {
            userEntity.setUserRole(UserRole.ROLE_ADMIN);
            userEntity.setIsAccountNonExpired(true);
            userEntity.setIsAccountNonLocked(true);
            userEntity.setIsCredentialsNonExpired(true);
            userEntity.setIsEnabled(true);
        }
        else
            userEntity.setUserRole(UserRole.ROLE_USER);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userService.save(userEntity);
        return "redirect:/?sign-up=true";
    }
}
