package dao;


import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDvd(String dvdTitle, DVD dvd)
            throws DVDLibraryDaoException {
        loadRoster();
        DVD newDvd = dvds.put(dvdTitle, dvd);
        writeRoster();
        return newDvd;
    }


    @Override
    public List<DVD> getAllDvds()
            throws DVDLibraryDaoException {
        loadRoster();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDvd(String dvdTitle)
            throws DVDLibraryDaoException {
        loadRoster();
        return dvds.get(dvdTitle);
    }
    @Override
    public DVD removeDvd(String dvdTitle)
            throws DVDLibraryDaoException {
        loadRoster();
        DVD removedDvd = dvds.remove(dvdTitle);
        writeRoster();
        return removedDvd;
    }

    @Override
    public DVD editDvd(String dvdTitle)
            throws DVDLibraryDaoException {
        loadRoster();
        DVD removedDvd = dvds.remove(dvdTitle);
        writeRoster();
        return removedDvd;
    }

    private DVD unmarshallDvd(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String dvdTitle = dvdTokens[0];

        DVD dvdFromFile = new DVD(dvdTitle);

        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMpaaRating(dvdTokens[2]);

        dvdFromFile.setDirectorName(dvdTokens[3]);

        dvdFromFile.setStudio(dvdTokens[4]);

        dvdFromFile.setUserNote(dvdTokens[5]);


        // We have now created a student! Return it!
        return dvdFromFile;
    }

    private void loadRoster() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent student unmarshalled
        DVD currentDvd;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentDvd into the map using student id as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDvd(DVD aDvd){


        String dvdAsText = aDvd.getTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserNote();


        // We have now turned a student to text! Return it!
        return dvdAsText;
    }

    private void writeRoster() throws DVDLibraryDaoException{
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String dvdAsText;
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {
            // turn a Student into a String
            dvdAsText = marshallDvd(currentDvd);
            // write the Student object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }





}
