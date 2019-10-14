package user.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import user.controllers.UserController;
import user.exceptions.ResourceException;
import user.json.ModifyPasswordWrapper;

public class UserControllerImpl implements UserController {
    /**
     * generated event name
     */
    public static final String EVENT_MODIFY_PASSWORD = "Password modification";
    /**
     * user service
     */
    @Autowired
    UserService userService;

    public ResponseEntity modifyPassword(Long userId, ModifyPasswordWrapper modifyPasswordWrapper) {
        try {
            //controle wrapper(new password)
            String oldPassword = modifyPasswordWrapper.getOldPassword();
            String newPassword = modifyPasswordWrapper.getNewPassword();
            if (oldPassword == null || newPassword == null) {
                throw new ResourceException(HttpStatus.BAD_REQUEST, "Bad request");
            }
            //controle userId/password
            checkCredential(userId, oldPassword);

            userService.sendModifiedPasswordEvent(EVENT_MODIFY_PASSWORD, userId, newPassword);

            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }
    }

    private boolean checkCredential(Long userId, String oldPassword) {
        if() {
            throw new ResourceException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
    }

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity handleException(ResourceException e) {
        // log exception
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
