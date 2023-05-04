package com.example.userservice.controller;


import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.UpdateUserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) throws Exception {
        return ResponseEntity.ok(userService.createUser(createUserRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser( @RequestBody UpdateUserRequestDto updateUserRequestDto) throws Exception{
        return ResponseEntity.ok(userService.updateUser(updateUserRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserResponseDtoById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public  void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(Pageable pageable){
        return  ResponseEntity.ok(userService.getAllUsers(pageable));
    }
//
//    @GetMapping("/expense")
//    public ResponseEntity<List<ExpenseResponseDto>> getUserExpense(Long id){
//        return  ResponseEntity.ok(userService.getUserExpense(id));
//    }
//
//    @GetMapping("/leave")
//    public ResponseEntity<List<LeaveResponseDto>> getUserLeave(Long id){
//        return ResponseEntity.ok(userService.getUserLeave(id));
//    }
//
//    @GetMapping("/advance")
//    public ResponseEntity<List<AdvanceResponseDto>> getUserAdvance(Long id){
//        return ResponseEntity.ok(userService.getUserAdvance(id));
//    }
//
//    @GetMapping("/overtimeWork")
//    public ResponseEntity<List<OvertimeWorkResponseDto>> getUserOvertimeWork(Long id){
//        return ResponseEntity.ok(userService.getUserOvertimeWork(id));
//    }
//
//    @GetMapping("/getEmployeesBirthday")
//    public ResponseEntity<List<UserResponseDto>> getEmployeesBirthday() {
//        return ResponseEntity.ok(userService.getEmployeesBirthday());
//    }

}
