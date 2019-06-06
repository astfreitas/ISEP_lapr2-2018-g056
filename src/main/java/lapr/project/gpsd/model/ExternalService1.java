/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lapr.project.gpsd.controller.ApplicationGPSD;

/**
 * External Service classe is responsible to obtain all locations from a
 * external file with postalCodes and coordinates
 *
 * @author astfr
 */
public class ExternalService1 implements IExternalService {

    private String filePath = ApplicationGPSD.getInstance().getCompany().getProps().getProperty("FilePostalCodes");

    /**
     * Returns a List of Locations within the given radius for the Geographic
     * Area.
     *
     * @param mainPCode Main (center) Postal Code of the Geographic Area
     * @param radius radius for the area of activity of the Geographic Area
     * @return List of Locations within the given radius for the Geographic Area
     * 
     */
    @Override
    public List<Location> getActsOnLocationList(PostalCode mainPCode, double radius){
        List<Location> newLocationL = new ArrayList<>();
        ArrayList<String[]> readCpFile;
        readCpFile = readFile(filePath);

        String sCP = mainPCode.getPostalCode();
        //Splits the Postal Code parts to search the file structure
        String[] sMainCp = sCP.split("-");
        //Removes leading zeros from the second part of the postalCode
        sMainCp[1] = sMainCp[1].replaceFirst("^0+(?!$)", "");
        double dLatitudeMainCP = 0;
        double dLongitudeMainCP = 0;
        // finds the postal code matching the given main postal code for the Geographic Area
        // and saves the the latitude and longitude
        for (String[] sReadCP : readCpFile) {
            if (sMainCp[0].equals(sReadCP[0]) && sMainCp[1].equals(sReadCP[1])/*equals(sReadCP[0]*/) {
                dLatitudeMainCP = Double.valueOf(sReadCP[2]);
                dLongitudeMainCP = Double.valueOf(sReadCP[3]);
                break;
            }
        }
        /*For each postal code calculates the distance to the main PostalCode 
        coordinates. If the distance is bellow the given radius creates a 
        new Location and adds to the LocationList*/
        for (String[] sReadCP : readCpFile) {
            double dLatitudeCP = Double.valueOf(sReadCP[2]);
            double dLongitudeCP = Double.valueOf(sReadCP[3]);
            Double distance = calculatesDistance(dLatitudeMainCP, dLongitudeMainCP, dLatitudeCP, dLongitudeCP);

            if (distance < radius) {
                String newCP = "";
                if (sReadCP[1].length() == 1) {
                    newCP = sReadCP[0] + "-00" + sReadCP[1];
                } else if (sReadCP[1].length() == 2) {
                    newCP = sReadCP[0] + "-0" + sReadCP[1];
                }
                Location newLocation = new Location(newCP, distance);
                newLocationL.add(newLocation);
            }
        }

        return newLocationL;
    }

    /**
     * Checks if the given postal code (string) exists in the PostalCode File
     *
     * @param cp postal code as string
     * @return True if and only if an equal postal code is found and false
     * otherwise.
     */
    @Override
    public boolean checkPostalCodeExist(String cp) {
        //Arraylist String to read lines from file
        ArrayList<String[]> readStrings = new ArrayList<>();
        //splits the received postalcode in two parts for for compatibility with
        //source file
        String[] cpfull = cp.split("-");
        //Removes leading zeros from the second part of the postalCode
        cpfull[1] = cpfull[1].replaceFirst("^0+(?!$)", "");

        File file = new File(filePath);
        Scanner scan = new Scanner(filePath);
        //Reads first line to ignore column title
        scan.nextLine();
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().trim().split(";");
            readStrings.add(line);
            if (line[0].equals(cpfull[0]) && line[1].equals(cpfull[1])) {
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns an List of Strings with the file contents. Each array is a line
     * read from the file.
     *
     * @param filepath file path to read
     * @return List of Strings with the file contents
     * @throws FileNotFoundException
     */
    private ArrayList<String[]> readFile(String filepath) {
        ArrayList<String[]> read = new ArrayList<>();
        try {
            File file = new File(filepath);
            Scanner scan = new Scanner(filepath);
            //Reads first line to ignore column title
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] linha = scan.nextLine().trim().split(";");
                read.add(linha);
                return read;
            }
        } catch (Exception e) {

        }
        return read;
    }

    /**
     * Calculates the distance between 2 points given the coordenates Method
     * given in the PPROG IT3 Project statement.
     *
     * @param lat1 Latitude of point 1
     * @param lon1 Longitude of point 1
     * @param lat2 Latitude of point 2
     * @param lon2 Longitude of point 2
     * @return Distance between the two given points
     */
    public static double calculatesDistance(double lat1, double lon1, double lat2, double lon2) {
        // shortest distance over the earth's surface
        // https://www.movable-type.co.uk/scripts/latlong.html
        final double R = 6371e3;
        double theta1 = Math.toRadians(lat1);
        double theta2 = Math.toRadians(lat2);
        double deltaTheta = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);
        double a = Math.sin(deltaTheta / 2) * Math.sin(deltaTheta / 2) + Math.cos(theta1) * Math.cos(theta2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // distância em metros
        return d;
    }

}
