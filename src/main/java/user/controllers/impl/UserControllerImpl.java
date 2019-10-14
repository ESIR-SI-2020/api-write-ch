package user.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import user.controllers.UserController;
import user.exceptions.ResourceException;
import user.json.ModifyPasswordWrapper;
import user.utils.Patterns;

import java.util.regex.Pattern;

public class UserControllerImpl implements UserController {
    /**
     * user service
     */
    @Autowired
    UserService userService;

    public ResponseEntity modifyPassword(String userId, ModifyPasswordWrapper modifyPasswordWrapper) {
        //controle wrapper(new password)
        String oldPassword = modifyPasswordWrapper.getOldPassword();
        String newPassword = modifyPasswordWrapper.getNewPassword();
        if (oldPassword == null || newPassword == null) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Given new password or old password are empty.");
        }
        if (Patterns.emailPattern.matcher(userId).matches()){
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : The given email is in the wrong format)");
        }
        if (Patterns.passwordPattern.matcher(newPassword).matches()){
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request : Your password must have : Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character");
        }
        //controle userId/password
        checkCredential(userId, oldPassword);

        userService.sendModifiedPasswordEvent(userId, newPassword);

        return ResponseEntity.status(HttpStatus.OK).body("Modify password request received");
    }

    private void checkCredential(String userId, String oldPassword) {
        // TODO check password
        if(false) {
            throw new ResourceException(HttpStatus.UNAUTHORIZED, "Unauthorized : bad user ID and password");
        }
    }
}
