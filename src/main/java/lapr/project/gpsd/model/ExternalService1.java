/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * External Service classe is responsible to obtain all locations from a
 * external file with postalCodes and coordinates
 *
 * @author astfr
 */
public class ExternalService1 implements IExternalService {

    private String filePath;

    public ExternalService1(String filepath) {
        this.filePath = filepath;
    }

    /**
     * Returns a List of Locations within the given radius for the Geographic
     * Area.
     *
     * @param mainPCode Main (center) Postal Code of the Geographic Area
     * @param radius radius for the area of activity of the Geographic Area
     * @param pcRegistry reference for the PostalCodeRegistry to obtain the
     * PostalCodeList
     * @return List of Locations within the given radius for the Geographic Area
     *
     */
    @Override
    public List<Location> getActsOnLocationList(PostalCode mainPCode, double radius,
            PostalCodeRegistry pcRegistry) {

        List<Location> newLocationL = new ArrayList<>();
        List<PostalCode> pcList = pcRegistry.getPostalCodeList();
        double mCPLatitude = mainPCode.getCpLatitude();
        double mCPLongitude = mainPCode.getCpLongitude();
        /* Scrolls through the postal code list and verifies that the calculated distance is less than the given radius */
        for (PostalCode pc : pcList) {
            double latitudeCP = pc.getCpLatitude();
            double longitudeCP = pc.getCpLongitude();
            double dDistance = calculatesDistance(mCPLatitude, mCPLongitude, latitudeCP, longitudeCP);
            if (dDistance < radius) {
                Location nL = new Location(pc, dDistance);
                newLocationL.add(nL);
            }
        }
        return newLocationL;
    }

    /**
     * Returns an List of Strings with the file contents. Each array is a line
     * read from the file.
     *
     * @param filepath file path to read
     * @return List of Strings with the file contents
     * @throws FileNotFoundException
     */
    private ArrayList<String[]> readFile(String filepath) throws IOException {
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            Scanner scan = new Scanner(is);
            ArrayList<String[]> read = new ArrayList<>();
            //Reads first line to ignore column title
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] linha = scan.nextLine().trim().split(";");
                read.add(linha);
            }
            return read;
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());
        }

        return null;
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
    private static double calculatesDistance(double lat1, double lon1, double lat2, double lon2) {
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

    /**
     * Returns a List of existing Postal Codes to the system
     *
     * @return Postal Code List
     */
    @Override
    public ArrayList<PostalCode> loadPostalCodeList() throws IOException {
        ArrayList<PostalCode> pCodeList = new ArrayList<>();
        ArrayList<String[]> readCpFile;
        readCpFile = readFile(filePath);
        String sNewPC = "";
        double cpLatitude = 0;
        double cpLongitude = 0;
        for (String[] line : readCpFile) {
            if (line[1].length() == 1) {
                sNewPC = line[0] + "-00" + line[1];
            } else if (line[1].length() == 2) {
                sNewPC = line[0] + "-0" + line[1];
            } else if (line[1].length() == 3) {
                sNewPC = line[0] + "-" + line[1];
            }
            cpLatitude = Double.valueOf(line[2]);
            cpLongitude = Double.valueOf(line[3]);
            PostalCode newCP = new PostalCode(sNewPC, cpLatitude, cpLongitude);
            pCodeList.add(newCP);
        }
        return pCodeList;
    }

    /**
     * Return the distance between two given Postal Codes. Distance value is not
     * checked in return.
     *
     * @param pc1 PostalCode instance
     * @param pc2 PostalCOde instance
     * @return the value of the distance between the two given Postal Code
     * Instances.
     */
    public double getDistanceBetCP(PostalCode pc1, PostalCode pc2) {
        return calculatesDistance(pc1.getCpLatitude(), pc1.getCpLongitude(), pc2.getCpLatitude(), pc2.getCpLongitude());

    }

}
