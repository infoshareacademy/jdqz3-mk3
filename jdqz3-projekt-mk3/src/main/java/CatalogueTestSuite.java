import categories.CatalogueCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.CatalogueTests;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        CatalogueCategory.class
})
@Suite.SuiteClasses({
        CatalogueTests.class,
})

public class CatalogueTestSuite {
}
