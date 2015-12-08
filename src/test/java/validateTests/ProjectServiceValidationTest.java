package validateTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.validation.ProjectServiceValidation;

public class ProjectServiceValidationTest {

	ProjectServiceValidation target;
	
	@Before
	public void setup(){
		target = new ProjectServiceValidation();
	}
	@Test
	public void testProjectNameWithValidName() throws Exception{
		Project project = new Project();
		project.setProjectName("project");
		assertTrue(target.projectName(project));
	}

	@Test
	public void testProjectNameWithNameThatIsWhiteSpaces() throws Exception{
		Project project = new Project();
		project.setProjectName("     ");
		assertFalse(target.projectName(project));
	}
	
	@Test(expected=Exception.class)
	public void testProjectNameWithNameThatIsNull() throws Exception{
		Project project = new Project();
		project.setProjectName(null);
		assertTrue(target.projectName(project));
	}
}
