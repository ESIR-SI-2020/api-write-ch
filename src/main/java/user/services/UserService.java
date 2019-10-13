package user.services;

import user.models.User;

public interface UserService {
    void sendModifiedPasswordEvent(String eventName, Long userId, String newPassword);
}
