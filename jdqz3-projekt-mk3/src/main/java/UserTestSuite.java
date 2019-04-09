import categories.UserCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        UserCategory.class
})
@Suite.SuiteClasses({
        RegisteredUserTests.class,
        NotRegisteredUserTests.class,
        TestPurchase.class
})

public class UserTestSuite {
}
