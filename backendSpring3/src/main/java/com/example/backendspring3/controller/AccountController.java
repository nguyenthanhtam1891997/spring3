package com.example.backendspring3.controller;

import com.example.backendspring3.dto.LoginForm;
import com.example.backendspring3.dto.SignUpForm;
import com.example.backendspring3.dto.Token;
import com.example.backendspring3.model.Role;
import com.example.backendspring3.model.RoleName;
import com.example.backendspring3.model.User;
import com.example.backendspring3.security.jwt.JwtProvider;
import com.example.backendspring3.security.jwt.JwtTokenFilter;
import com.example.backendspring3.security.userPrinciple.UserPrinciple;
import com.example.backendspring3.service.IRoleService;
import com.example.backendspring3.service.IUserService;
import com.example.backendspring3.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    private Map<String, String> mapError = new HashMap<>();
    private Map<String, String> mapSuccess = new HashMap<>();
    private static final String MESSAGE = "message";

    @PostMapping("/creatAccount")
    public ResponseEntity<Object> createAccount(@Valid @RequestBody SignUpForm signUpForm) {
        mapError.clear();
        mapSuccess.clear();
        if (userService.existsByUserName(signUpForm.getUsername())) {
            mapError.put(MESSAGE, "tên user bị trùng");
            return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
        } else if (userService.existsByEmail(signUpForm.getEmail())) {
            mapError.put(MESSAGE, "tên email bị trùng");
            return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
        } else {
            List<Role> roleList = new ArrayList<>();
            roleList.add(new Role(3L, RoleName.ROLE_USER));
            if (signUpForm.getUsername().equals("TamAdmin")) {
                roleList.add(new Role(2L, RoleName.ROLE_EMPLOYEE));
                roleList.add(new Role(1L, RoleName.ROLE_ADMIN));
            } else if (signUpForm.getUsername().contains("employee")) {
                roleList.add(new Role(2L, RoleName.ROLE_EMPLOYEE));
            }
            User user = new User(signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()), roleList);

            userService.save(user);
            mapSuccess.put(MESSAGE, "Thêm Tai Khoản Thành Công");
            return new ResponseEntity<>(mapSuccess, HttpStatus.OK);
        }
    }

    @PostMapping("/loginAccount")
    public ResponseEntity<Object> loginAccount(@Valid @RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Token token1 = new Token(userPrinciple.getUser().getUserName(), token);
        return new ResponseEntity<>(token1, HttpStatus.OK);
    }


    //    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delet")
    public ResponseEntity<?> getListBook() {

        System.out.println("12313213213");
        return new ResponseEntity<>("21313112", HttpStatus.OK);
    }
}
