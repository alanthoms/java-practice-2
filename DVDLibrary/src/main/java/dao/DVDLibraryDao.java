package dao;

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
    DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException;

    DVD removeDvd(String title) throws DVDLibraryDaoException;

    DVD getDvd(String title) throws DVDLibraryDaoException;

    List<DVD> getAllDvds() throws DVDLibraryDaoException;

    DVD editDvd(String title) throws DVDLibraryDaoException;

}
