package dao;

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
    DVD addDvd(String title, DVD dvd);

    DVD removeDvd(String title);

    DVD getDvd(String title);

    List<DVD> getAllDvds();

    DVD editDvd(String title, DVD updatedDvd);

    void loadLibrary() throws Exception;

    void saveLibrary() throws Exception;
}
