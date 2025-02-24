package Base_Class;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class Data_Generator {

	 private static Faker faker = new Faker();

	    public static String generateRandomUsername() 
	    {
	    	   String name = faker.name().firstName().replaceAll("\\s", "");
	    	    return (name + "xxxxxxxxxx").substring(0, 10); // Ensure 10 chars, padding if needed
	    }

	    public static String generateRandomPassword() 
	    {
	        return RandomStringUtils.random(1, "ABCDEFGHIJKLMNOPQRSTUVWXYZ") +  // 1 Uppercase
	               RandomStringUtils.random(1, "abcdefghijklmnopqrstuvwxyz") +  // 1 Lowercase
	               RandomStringUtils.random(1, "0123456789") +                  // 1 Number
	               RandomStringUtils.random(1, "!@#$%^&*") + // 1 Special Char
	               RandomStringUtils.random(4, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()"); // Remaining characters
	    }
	
}
