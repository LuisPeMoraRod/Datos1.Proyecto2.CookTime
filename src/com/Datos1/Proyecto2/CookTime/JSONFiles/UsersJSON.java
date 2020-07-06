package com.Datos1.Proyecto2.CookTime.JSONFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import com.Datos1.Proyecto2.CookTime.Trees.BinaryTree;
import com.Datos1.Proyecto2.CookTime.UsersManagement.User;

public class UsersJSON {
	private User user;
	private JSONArray usersArray;
	private JSONParser jsonParser;
	private BinaryTree<User> BT ;
	

	private static UsersJSON usersJson = null;

	private UsersJSON() {
		BT = BinaryTree.getInstance();
	}
	
	public BinaryTree<User> getBT() {
		return BT;
	}

	public void setBT(BinaryTree<User> bT) {
		BT = bT;
	}

	/**
	 * Singleton pattern design instantiation method 
	 * @return usersJson : UsersJSON
	 */
	public static synchronized UsersJSON getInstance() {
		if (usersJson == null) {
			usersJson = new UsersJSON();
		}
		return usersJson;
	}

	
	
	/**
	 * Public method. Loads to the binary tree all the users objects from the JSONArray 
	 */
	@SuppressWarnings("unchecked")
	public void addUsersToBT(JSONArray usersList) {
			// Iterate over users array
			usersList.forEach(userObj -> parseUser((JSONObject) userObj));
	}

	private void parseUser(JSONObject userObj) {

		// Get user's attributes
		String email = (String) userObj.get("email");
		String name = (String) userObj.get("name");
		String password = (String) userObj.get("password");
		int age = Integer.parseInt((String) userObj.get("age"));
		
		this.user = User.builder().withEmail(email).withName(name).withPassword(password).withAge(age).build();
		this.BT.insert(user);
		
	}
	
	public static void main(String[] args) {
		UsersJSON usersJson = UsersJSON.getInstance();
		JSONParser parser = new JSONParser();
		JSONArray usersArray = null;
		try {
			usersArray = (JSONArray) parser
					.parse(new FileReader("src/com/Datos1/Proyecto2/CookTime/Admin/users.json"));
			
			usersJson.addUsersToBT(usersArray);
			System.out.println(usersJson.getBT().inOrder().toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
