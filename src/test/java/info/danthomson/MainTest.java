package info.danthomson;

import static org.junit.Assert.assertEquals;

import com.example.beans.openl.FreeviewGenre;
import org.junit.Test;
import org.openl.rules.project.instantiation.SimpleProjectEngineFactory;
import org.openl.rules.project.instantiation.SimpleProjectEngineFactory.SimpleProjectEngineFactoryBuilder;

public class MainTest {

    @Test
    public void test() throws Exception {

        SimpleProjectEngineFactoryBuilder<FreeviewGenreMappingService> factoryBuilder = new SimpleProjectEngineFactoryBuilder<>();
        SimpleProjectEngineFactory<FreeviewGenreMappingService> factory = factoryBuilder.setProject("src/main/openl")
                .setInterfaceClass(FreeviewGenreMappingService.class)
                .build();

        FreeviewGenreMappingService instance = factory.newInstance();
        String[] genres = {"One. ", "Two"};
        String[] formats = {"PT007"};
        FreeviewGenre freeviewGenre = instance.mapToFreeviewGenre(genres, formats);
        assertEquals("5", freeviewGenre.getCode());
        assertEquals("Childrens", freeviewGenre.getName());
    }
}
