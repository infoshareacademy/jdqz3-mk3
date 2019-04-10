import categories.CartCategory;
import categories.CatalogueCategory;
import categories.PurchaseCategory;
import categories.UserCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        CartCategory.class,
        CatalogueCategory.class,
        PurchaseCategory.class,
        UserCategory.class
})
@Suite.SuiteClasses({
        CartUpdating.class,
        CatalogueTests.class,
        RegisteredUserTests.class,
        NotRegisteredUserTests.class,
        PurchaseTests.class
})

public class AllTestSuite {
}