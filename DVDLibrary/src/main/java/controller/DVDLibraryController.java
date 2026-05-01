package controller;


import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.util.List;

public class DVDLibraryController {

    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();


                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        addDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }


            }
            exitMessage();

        } catch(
                DVDLibraryDaoException e)

        {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDvd() throws DVDLibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddSuccessBanner();
    }

    private void listDvds() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        String dvdChoice = view.getDVDChoice();
        DVD dvd = dao.getDvd(dvdChoice);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DVDLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdChoice = view.getDVDChoice();
        DVD removedDvd = dao.removeDvd(dvdChoice);
        view.displayRemoveResult(removedDvd);
    }

    private void editDvd() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        String dvdChoice = view.getDVDChoice();
        DVD newChoice = view.getNewDvdInfo();
        DVD editedDvd = dao.editDvd(dvdChoice, newChoice );
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }


}
