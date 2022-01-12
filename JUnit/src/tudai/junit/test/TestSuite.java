package tudai.junit.test;

/****************************TestSuite.java ************************/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	ProgramacionTest.class,
	ProgramaTest.class
})

public class TestSuite {

}
