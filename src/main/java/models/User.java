package models;

import java.util.List;

public class User {
	String username;
	String password;
	String email;
	String photoUrl;
	String bio;
	Address address;
	List<String> friendsId;
}
