import categories.PurchaseCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.PurchaseTests;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        PurchaseCategory.class
})
@Suite.SuiteClasses({
        PurchaseTests.class
})

public class PurchaseTestSuite {
}
