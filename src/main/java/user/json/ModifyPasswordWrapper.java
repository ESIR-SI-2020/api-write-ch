package user.json;

public class ModifyPasswordWrapper {
    private String oldPassword;
    private String newPassword;

    public ModifyPasswordWrapper(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
