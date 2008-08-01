/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.test;

import junit.framework.TestCase;

import org.openmrs.Privilege;
import org.openmrs.Role;
import org.openmrs.util.OpenmrsConstants;

/**
 * This class tests all methods that are not getter or setters 
 * in the Role java object
 * 
 * TODO: finish this test class for Role
 * 
 * @see Role
 */
public class RoleTest extends TestCase {

	/**
	 * Test the adding and removing of privileges to a role
	 * 
	 * @throws Exception
	 */
	public void testAddRemovePrivilege() throws Exception {
		Role role = new Role();
		
		// test the null parameter cases
		role.addPrivilege(null);
		role.removePrivilege(null);
		
		Privilege priv1 = new Privilege("priv1");
		role.addPrivilege(priv1);
		assertTrue("The role should have 1 privilege but instead has " + role.getPrivileges().size(), role.getPrivileges().size() == 1);
		
		// adding the same privilege should not be allowed
		role.addPrivilege(priv1);
		assertTrue("The role should have 1 privilege but instead has " + role.getPrivileges().size(), role.getPrivileges().size() == 1);
		
		// adding a different privilege with the same name should not be allowed
		Privilege priv2 = new Privilege(priv1.getPrivilege());
		role.addPrivilege(priv2);
		assertTrue("The role should have 1 privilege but instead has " + role.getPrivileges().size(), role.getPrivileges().size() == 1);
		
		Privilege priv3 = new Privilege("priv3");
		
		// removing a fake privilege shouldn't do anything
		role.removePrivilege(priv3);
		assertTrue("The role should have 1 privilege but instead has " + role.getPrivileges().size(), role.getPrivileges().size() == 1);
		
		// removing the first privilege
		role.removePrivilege(priv1);
		assertTrue("The role should have 0 privileges but instead has " + role.getPrivileges().size(), role.getPrivileges().size() == 0);
	}
	
	/**
	 * Simple test to check the hasPrivilege method
	 * 
	 * @throws Exception
	 */
	public void testHasPrivilege() throws Exception {
		Role role = new Role();
		
		// test the null cases
		role.hasPrivilege("some privilege");
		role.hasPrivilege(null);
		
		// very basic privilege adding and checking
		Privilege p1 = new Privilege("priv1");
		role.addPrivilege(p1);
		assertTrue("This roles should have the privilege", role.hasPrivilege("priv1"));
		assertFalse("This roles should not have the privilege", role.hasPrivilege("some other privilege name"));
		
		
		// check super user "super" status
		role = new Role(OpenmrsConstants.SUPERUSER_ROLE);
		
		assertTrue("Super users are super special and should have all privileges", role.hasPrivilege("Some weird privilege name that shouldn't be there"));
	}
	
	/**
	 * Tests how roles inherit other roles
	 * 
	 * @throws Exception
	 */
	public void testInheritingRoles() throws Exception {
		
		// TODO finish test method
		
		// test the isInheriting method
		
		// test the getting of parent roles
		
		// test the recursing over parent roles
		
		// test the possible infinite loop condition of recursing over parent roles
	}
	
}