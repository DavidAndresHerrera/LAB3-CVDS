package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Andres Rocha",1000076035,25,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
	@Test
    public void invalidAgeRegistryResult() {

        Person person = new Person("David Moya",1000075402,200,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	@Test
    public void underAgeRegistryResult() {

        Person person = new Person("Sofia Castellanos",1014268473,17,Gender.FEMALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
 
	@Test
    public void duplicatedRegistryResult() {

        Person person = new Person("Manuel Herrera",1000076035,25,Gender.MALE,true);
		Person person2 = new Person("Andres Salamanca",1000076035,40,Gender.MALE,true);
		
		RegisterResult result1 = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
	
	@Test
    public void deadRegistryResult() {

        Person person = new Person("Manuel ,Mendez",100456201,55,Gender.MALE,false);
		
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    // TODO Complete with more test cases
}