package br.com.healthhelper.customer.app.controller;

import br.com.healthhelper.customer.app.dto.response.UserResponse;
import br.com.healthhelper.customer.app.mapper.UserAppMapper;
import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.domain.exception.UserNotFoundException;
import br.com.healthhelper.customer.domain.usecase.DeleteUserByIdUseCase;
import br.com.healthhelper.customer.domain.usecase.FindUserByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserAppMapper userAppMapper;
    private FindUserByIdUseCase findUserByIdUseCase;
    private DeleteUserByIdUseCase deleteUserByIdUseCase;

    @GetMapping
    public @ResponseBody ResponseEntity<UserResponse> findById(@RequestAttribute("userId") final String uuid) throws UserNotFoundException {
        User user = findUserByIdUseCase.execute(UUID.fromString(uuid));
        return new ResponseEntity<>(userAppMapper.domainToResponse(user), HttpStatus.OK);
    }

    @DeleteMapping
    public @ResponseBody ResponseEntity<Void> delete(@RequestAttribute("userId") final String uuid) {
        deleteUserByIdUseCase.execute(UUID.fromString(uuid));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
