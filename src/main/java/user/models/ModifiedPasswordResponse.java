package user.models;

public class ModifiedPasswordResponse {

    private String email;

    private String newPassword;

    final String eventName = "ModifiedPassword";

    public ModifiedPasswordResponse(){}

    public ModifiedPasswordResponse(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
