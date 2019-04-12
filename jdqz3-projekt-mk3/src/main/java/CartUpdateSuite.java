import categories.CartCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        CartCategory.class
})
@Suite.SuiteClasses({
        CartUpdating.class,
        CatalogueTests.class,
        RegisteredUserTests.class,
        NotRegisteredUserTests.class,
        PurchaseTests.class
})

public class CartUpdateSuite {
}
