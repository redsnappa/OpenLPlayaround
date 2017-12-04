package info.danthomson;

import com.example.beans.IFreeviewGenre;
import com.example.beans.openl.FreeviewGenre;
import org.openl.rules.project.instantiation.SimpleProjectEngineFactory;
import org.openl.rules.project.instantiation.SimpleProjectEngineFactory.SimpleProjectEngineFactoryBuilder;

/**
 * This class shows how to execute OpenL Tablets methods using Java interface.
 * Looks really simple...
 */
public class Main {

    public static void main(String[] args) throws Exception {
        if (System.getProperty("openl-cmd") != null) {
            run("openl");
        } else {
            run("src/main/openl");
        }
    }

    public static void run(String pathToOpenL) throws Exception {
        // Service - is generated interface from TemplateRules.xls using maven openl:generate goal.
        SimpleProjectEngineFactoryBuilder<FreeviewGenreMappingService> factoryBuilder = new SimpleProjectEngineFactoryBuilder<FreeviewGenreMappingService>();
        SimpleProjectEngineFactory<FreeviewGenreMappingService> factory = factoryBuilder.setProject(pathToOpenL)
                .setInterfaceClass(FreeviewGenreMappingService.class)
                .build();

        FreeviewGenreMappingService instance = factory.newInstance();
        String[] genres = {"One. ", "Two"};
        String[] formats = {"PT007"};
        FreeviewGenre freeviewGenre = instance.mapToFreeviewGenre(genres, formats);
        System.out.println("The freeview genre is: " + freeviewGenre.toString());
    }
}
