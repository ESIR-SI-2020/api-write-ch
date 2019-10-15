package user.models;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ModifiedPasswordResponse implements Serializable {

    private String email;

    private String newPassword;

    public String getEventName(){return "ModifiedPassword";}
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
    public String toString() {
        StringBuffer sb =  new StringBuffer() ;
        return sb.append(getEventName()).append(" ").append(email).append(" ").append(newPassword).toString() ;
    }
}
