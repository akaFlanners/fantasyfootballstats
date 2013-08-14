package uk.co.kaboom.projects.fantasyfootball.stats.tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * This class suffixed with "Tests" rather than "Test" - prevents SureFire from running everything twice.
 *  Alternative would be to change naming conventions NOT to use Test in each individual Test.
 *  or to exclude them in surefire config.
 *
 *  For further details see:
 *  http://maven.apache.org/surefire/maven-surefire-plugin/examples/inclusion-exclusion.html
 *
 * @author Mark Flanagan
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
     TestScrapingController.class,
     TestPlayerData.class,
     TestPersistence.class,
     TestHTMLElement.class
})
public class AllTests {

}

