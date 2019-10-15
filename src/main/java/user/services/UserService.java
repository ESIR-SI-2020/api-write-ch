package user.services;

import user.models.User;

public interface UserService {
    void sendModifiedPasswordEvent(String email, String newPassword);
}
