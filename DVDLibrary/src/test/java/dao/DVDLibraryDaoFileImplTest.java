package dao;

import dto.DVD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DVDLibraryDaoFileImplTest {

    DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest() {

    }

    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        // Arrange
        String title = "Inception";
        DVD dvd = new DVD(title);
        dvd.setReleaseDate(LocalDate.parse("2020-04-20"));
        dvd.setMpaaRating("PG-13");
        dvd.setDirectorName("Christopher Nolan");
        dvd.setStudio("Warner Bros");
        dvd.setUserNote("Great film");

        // Act
        testDao.addDvd(title, dvd);
        DVD retrievedDVD = testDao.getDvd(title);

        // Assert
        assertNotNull(retrievedDVD, "DVD should not be null");

        assertEquals(dvd.getTitle(),
                retrievedDVD.getTitle(),
                "Checking title.");

        assertEquals(dvd.getReleaseDate(),
                retrievedDVD.getReleaseDate(),
                "Checking release date.");

        assertEquals(dvd.getMpaaRating(),
                retrievedDVD.getMpaaRating(),
                "Checking MPAA rating.");

        assertEquals(dvd.getDirectorName(),
                retrievedDVD.getDirectorName(),
                "Checking director name.");

        assertEquals(dvd.getStudio(),
                retrievedDVD.getStudio(),
                "Checking studio.");

        assertEquals(dvd.getUserNote(),
                retrievedDVD.getUserNote(),
                "Checking user note.");
    }

    @Test
    public void testAddGetAllDVDs() throws Exception {
        // Arrange - first DVD
        DVD firstDVD = new DVD("Inception");
        firstDVD.setReleaseDate(LocalDate.parse("2020-04-20"));
        firstDVD.setMpaaRating("PG-13");
        firstDVD.setDirectorName("Christopher Nolan");
        firstDVD.setStudio("Warner Bros");
        firstDVD.setUserNote("Great film");

        // Arrange - second DVD
        DVD secondDVD = new DVD("Interstellar");
        secondDVD.setReleaseDate(LocalDate.parse("2020-04-20"));
        secondDVD.setMpaaRating("PG-13");
        secondDVD.setDirectorName("Christopher Nolan");
        secondDVD.setStudio("Paramount");
        secondDVD.setUserNote("Amazing visuals");

        // Act - add both DVDs
        testDao.addDvd(firstDVD.getTitle(), firstDVD);
        testDao.addDvd(secondDVD.getTitle(), secondDVD);

        // Retrieve all DVDs
        List<DVD> allDVDs = testDao.getAllDvds();

        // Assert - general checks
        assertNotNull(allDVDs, "The list of DVDs must not be null");
        assertEquals(2, allDVDs.size(), "List should have 2 DVDs.");

        // Assert - specific contents
        assertTrue(allDVDs.contains(firstDVD), "Should contain Inception");
        assertTrue(allDVDs.contains(secondDVD), "Should contain Interstellar");
    }

    @Test
    public void testRemoveDVD() throws Exception {
        // Arrange - first DVD
        DVD firstDVD = new DVD("Inception");
        firstDVD.setReleaseDate(LocalDate.parse("2020-04-20"));
        firstDVD.setMpaaRating("PG-13");
        firstDVD.setDirectorName("Christopher Nolan");
        firstDVD.setStudio("Warner Bros");
        firstDVD.setUserNote("Great film");

        // Arrange - second DVD
        DVD secondDVD = new DVD("Interstellar");
        secondDVD.setReleaseDate(LocalDate.parse("2020-04-20"));
        secondDVD.setMpaaRating("PG-13");
        secondDVD.setDirectorName("Christopher Nolan");
        secondDVD.setStudio("Paramount");
        secondDVD.setUserNote("Amazing visuals");

        // Act - add both DVDs
        testDao.addDvd(firstDVD.getTitle(), firstDVD);
        testDao.addDvd(secondDVD.getTitle(), secondDVD);

        // Remove first DVD
        DVD removedDVD = testDao.removeDvd(firstDVD.getTitle());

        // Assert removed correctly
        assertEquals(removedDVD, firstDVD, "The removed DVD should be Inception.");

        // Get all DVDs
        List<DVD> allDVDs = testDao.getAllDvds();

        // Check list state
        assertNotNull(allDVDs, "DVD list should not be null.");
        assertEquals(1, allDVDs.size(), "Only one DVD should remain.");

        assertFalse(allDVDs.contains(firstDVD), "List should NOT contain Inception.");
        assertTrue(allDVDs.contains(secondDVD), "List should contain Interstellar.");

        // Remove second DVD
        removedDVD = testDao.removeDvd(secondDVD.getTitle());

        // Assert removed correctly
        assertEquals(removedDVD, secondDVD, "The removed DVD should be Interstellar.");

        // Final check - empty list
        allDVDs = testDao.getAllDvds();
        assertTrue(allDVDs.isEmpty(), "DVD list should be empty.");

        // Verify both are gone
        DVD retrievedDVD = testDao.getDvd(firstDVD.getTitle());
        assertNull(retrievedDVD, "Inception should be null after removal.");

        retrievedDVD = testDao.getDvd(secondDVD.getTitle());
        assertNull(retrievedDVD, "Interstellar should be null after removal.");
    }



}