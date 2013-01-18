package org.zetta1985.addressbook.api.command.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.zetta1985.addressbook.api.command.CreateContactCommand;

import com.google.inject.Inject;

/**
 * @author t_hara
 */
@RunWith(ValidationTestRunner.class)
public class CreateContactCommandValidaitonTest {

	@Inject
	Validator validator;
	
	CreateContactCommand target;
	
	@Before
	public void setup() {
		target = new CreateContactCommand();
	}
	
	@Test
	public void errorWhenNewContactNameIsNull() {
		target.setNewContactName(null);
		Set<ConstraintViolation<CreateContactCommand>> results = validator.validate(target);
		assertFalse(results.isEmpty());
		assertEquals(1, results.size());
		System.out.println(results.iterator().next().getMessage());
		
	}
}
