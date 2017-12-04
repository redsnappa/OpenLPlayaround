package info.danthomson;


import com.example.beans.openl.FreeviewGenre;

public interface FreeviewGenreMappingService {

    FreeviewGenre mapToFreeviewGenre(String[] genres, String[] formats);

}
