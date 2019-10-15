package java.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import user.controllers.UserController;
import user.json.ModifyPasswordWrapper;

import static org.mockito.Mockito.*;


public class TestUserController {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeAll
    public void init(){
    }

    @Test
    public void modifyPassword_ShouldReturnOK_OK(){
        Mockito.doNothing().when(userService).sendModifiedPasswordEvent(isA(String.class), isA(String.class));
        ResponseEntity response = userController.modifyPassword("test@gmail.com",new ModifyPasswordWrapper("oldpassword","Newpassword01&"));
        Assertions.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }
}
