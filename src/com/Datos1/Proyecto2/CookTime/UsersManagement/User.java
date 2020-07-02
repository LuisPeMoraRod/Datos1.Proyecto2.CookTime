package com.Datos1.Proyecto2.CookTime.UsersManagement;

import java.awt.image.BufferedImage;


public class User implements Comparable<User>{
	/**
	 * User objects class
	 * @author Luis Pedro Morales Rodriguez
	 * @version 1/7/2020
	 */
	
	private String email;
	private String name;
	private int age;
	private String password;
	private MyMenu myMenu;
	private BufferedImage profilePic;
	private User[] usersFollowing;
	private String[] followers;

	public User(String email, String name, int age, String password, MyMenu myMenu, BufferedImage profilePic, User[] usersFollowing, String[] followers) {
		super();
		this.email = email;
		this.name = name;
		this.age = age;
		this.password = password;
		this.myMenu = myMenu;
		this.profilePic = profilePic; 
		this.usersFollowing = usersFollowing;
		this.followers = followers;
	}
	
	public User (Builder builder) {
		this.email = builder.email;
		this.name = builder.name;
		this.age = builder.age;
		this.password = builder.password;
		this.myMenu = builder.myMenu;
		this.profilePic = builder.profilePic; 
		this.usersFollowing = builder.usersFollowing;
		this.followers = builder.followers;
	}

	// Getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public MyMenu getProfile() {
		return myMenu;
	}
	public void setProfile(MyMenu myMenu) {
		this.myMenu = myMenu;
	}
	public BufferedImage getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(BufferedImage profilePic) {
		this.profilePic = profilePic;
	}

	public User[] getUsersFollowing() {
		return usersFollowing;
	}

	public void setUsersFollowing(User[] usersFollowing) {
		this.usersFollowing = usersFollowing;
	}

	public String[] getFollowers() {
		return followers;
	}

	public void setFollowers(String[] followers) {
		this.followers = followers;
	}
	
	public static Builder builder() {
		return new Builder();
	} 
	
	public static class Builder{
		private String email;
		private String name;
		private int age;
		private String password;
		private MyMenu myMenu;
		private BufferedImage profilePic;
		private User[] usersFollowing;
		private String[] followers;
		
		public User build() {
			return new User(this);
		}
		
		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Builder withMyMenu (MyMenu myMenu) {
			this.myMenu = myMenu;
			return this;
		}
		
		public Builder withProfilePic(BufferedImage profilePic) {
			this.profilePic = profilePic;
			return this;
		}
		
		public Builder withUsersFollowing (User[] usersFollowing) {
			this.usersFollowing = usersFollowing;
			return this;
		}
		
		public Builder withFollowers (String [] followers) {
			this.followers = followers;
			return this;
		}
		
	}

	@Override
	public int compareTo(User o) {
		if (o == null) {
			return -1;
		}
		return this.email.compareTo(o.toString());
	}

	

}
