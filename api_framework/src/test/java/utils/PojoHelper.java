package utils;

import pojo.CreateRepositoryPojo;

public class PojoHelper {

	public static CreateRepositoryPojo getCreateGithubRepoPojo(String name, String description) {
		String jsonPayload = "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"description\": \""+description+"\"\r\n"				
				+ "}";
		
		CreateRepositoryPojo obj = new CreateRepositoryPojo();
		obj.setName(name);
		obj.setDescription(description);
		
		return obj;
	}
	
	
	
}
