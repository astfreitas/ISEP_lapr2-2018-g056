/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import lapr.project.authentication.AuthenticationFacade;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.AcademicCompetence;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Availability;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ClientRegistry;
import lapr.project.gpsd.utils.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ExtendableService;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.LimitedService;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.ProfessionalCompetence;
import lapr.project.gpsd.model.SPApplication;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;

/**
 *
 * @author paulomaio
 */
public class ApplicationGPSD {

    private final Company company;
    private final AuthenticationFacade authentication;
    private boolean flagBootstrap;

    public ApplicationGPSD() {
        Properties props = getProperties();
        this.company = new Company(props);
        this.authentication = this.company.getAuthenticationFacade();
        this.flagBootstrap = true;
    }

    public Company getCompany() {
        return this.company;
    }

    public UserSession getCurrentSession() {
        return this.authentication.getCurrentSession();
    }

    public boolean doLogin(String id, String pwd) {
        return this.authentication.doLogin(id, pwd) != null;
    }

    public void doLogout() {
        this.authentication.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_NIF, "Default NIF");

        // Lê as propriedades e valores definidas 
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
            props.load(in);
            in.close();
        } catch (Exception ex) {

        }
        return props;
    }

    public void bootstrap() {
        if(flagBootstrap){
        this.authentication.registerUserRole(Constants.ROLE_ADMINISTRATIVE);
        this.authentication.registerUserRole(Constants.ROLE_CLIENT);
        this.authentication.registerUserRole(Constants.ROLE_HRO);
        this.authentication.registerUserRole(Constants.ROLE_SERVICE_PROVIDER);

        this.authentication.registerUserWithRole("adm1", "adm1@isep.ipp.pt", "123", Constants.ROLE_ADMINISTRATIVE);
        this.authentication.registerUserWithRole("hro1", "hro1@isep.ipp.pt", "123", Constants.ROLE_HRO);

        //Clients
        ClientRegistry rc = this.company.getClientRegistry();
        Client regCli1 = rc.newClient("Maria Santos", "100542369", "936565651", "msantos@gmail.com");
        Address ca1 = Client.newAddress("Gondomar", "4420-001", "Rua D. João de França, nº 1");
        regCli1.addAddress(ca1);
        rc.registerClient(regCli1, "prosdbsts190");
        Client regCli2 = rc.newClient("António Lage", "200542669", "916535661", "aLage@gmail.com");
        Address ca2 = Client.newAddress("Pedroso", "4415-999", "R. Gonçalves de Castro, nº 8");
        regCli2.addAddress(ca2);
        rc.registerClient(regCli2, "aLage1234");
        Client regCli3 = rc.newClient("Ana Santos", "110542349", "966535661", "aSantos23@isep.ipp.pt");
        Address ca3 = Client.newAddress("Porto", "4250-100", "R. do Carvalhido, nº 9");
        regCli3.addAddress(ca3);
        rc.registerClient(regCli3, "aSantini456");
        Client regCli4 = rc.newClient("Joana Santos", "210975020", "966545644", "jSantos@isep.ipp.pt");
        Address ca4 = Client.newAddress("Maia", "4470-528", "R. Cegonheira, nº 3");
        regCli4.addAddress(ca4);
        rc.registerClient(regCli4, "jjSantos23");

        //Categories
        Category cat1 = new Category("1", "Plumber");
        Category cat2 = new Category("2", "Locksmith");
        Category cat3 = new Category("3", "Automotive Mechanic");
        Category cat4 = new Category("4", "Cook");
        Category cat5 = new Category("5", "Painter");
        this.company.getCategoryRegistry().registerCategory(cat1);
        this.company.getCategoryRegistry().registerCategory(cat2);
        this.company.getCategoryRegistry().registerCategory(cat3);
        this.company.getCategoryRegistry().registerCategory(cat4);
        this.company.getCategoryRegistry().registerCategory(cat5);

        //SP Application
        SPApplication spa1 = new SPApplication("António Patrão", "500324896", "968795236", "aPatrao@gmail.com");
        Address add1 = new Address("Crestuma", "4415-995", "R. Central");
        spa1.setAddress(add1);
        AcademicCompetence ac1 = new AcademicCompetence("Bachelor", "N/A", 0);
        spa1.addAcademicCompetence(ac1);
        ProfessionalCompetence pc1 = new ProfessionalCompetence("Professional Training Course of Automotive Mechanic of the Center for Professional Training of Automotive Repair");
        spa1.addProfessionalCompetence(pc1);
        ProfessionalCompetence pc2 = new ProfessionalCompetence("Professional license for light and heavy vehicles");
        spa1.addProfessionalCompetence(pc2);
        ProfessionalCompetence pc3 = new ProfessionalCompetence("Advanced Course in Automotive Mechanics");
        spa1.addProfessionalCompetence(pc3);
        spa1.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        spa1.addCategory(this.company.getCategoryRegistry().getCatById("3"));
        this.company.getSPApplicationRegistry().registerApplication(spa1);

        SPApplication spa2 = new SPApplication("Maria Silva", "510324896", "928735537", "mSilva@hotmail.com");
        Address add2 = new Address("N/A", "4420-002", "N/A");
        spa2.setAddress(add2);
        AcademicCompetence ac2 = new AcademicCompetence("Bachelor", "N/A", 0);
        AcademicCompetence ac3 = new AcademicCompetence("Masters", "N/A", 0);
        AcademicCompetence ac4 = new AcademicCompetence("PhD", "N/A", 0);
        spa2.addAcademicCompetence(ac2);
        spa2.addAcademicCompetence(ac3);
        spa2.addAcademicCompetence(ac4);
        ProfessionalCompetence pc4 = new ProfessionalCompetence("Advanced Course of plumbing and locksmithing");
        spa2.addProfessionalCompetence(pc4);
        ProfessionalCompetence pc5 = new ProfessionalCompetence("Professional license for light and heavy vehicles");
        spa2.addProfessionalCompetence(pc5);
        ProfessionalCompetence pc6 = new ProfessionalCompetence("Cooking Course");
        spa2.addProfessionalCompetence(pc6);
        spa2.addCategory(this.company.getCategoryRegistry().getCatById("5"));
        spa2.addCategory(this.company.getCategoryRegistry().getCatById("2"));
        spa2.addCategory(this.company.getCategoryRegistry().getCatById("4"));
        this.company.getSPApplicationRegistry().registerApplication(spa2);

        SPApplication spa3 = new SPApplication("Joaquina Dos Santos", "510324877", "934735567", "jaquina@hotmail");
        Address add3 = new Address("Maia", "4470-526", "Rua Altino Silva Gomes");
        spa3.setAddress(add3);
        AcademicCompetence ac5 = new AcademicCompetence("Bachelor", "N/A", 0);
        spa3.addAcademicCompetence(ac5);
        ProfessionalCompetence pc7 = new ProfessionalCompetence("Advanced Course of plumbing and locksmithing");
        spa3.addProfessionalCompetence(pc7);
        ProfessionalCompetence pc8 = new ProfessionalCompetence("Advanced Course in Automotive Mechanics");
        spa3.addProfessionalCompetence(pc8);
        spa3.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        spa3.addCategory(this.company.getCategoryRegistry().getCatById("2"));
        spa3.addCategory(this.company.getCategoryRegistry().getCatById("3"));
        this.company.getSPApplicationRegistry().registerApplication(spa3);

        SPApplication spa4 = new SPApplication("Serafim Santos", "230324822", "223654987", "sSantos@gmail.com");
        Address add4 = new Address("Vila Nova De Gaia", "4430-601", "R. Alberto Alves Tavares");
        spa4.setAddress(add4);
        AcademicCompetence ac6 = new AcademicCompetence("High School", "N/A", 0);
        spa4.addAcademicCompetence(ac6);
        ProfessionalCompetence pc9 = new ProfessionalCompetence("Painter course");
        spa4.addProfessionalCompetence(pc9);
        spa4.addCategory(this.company.getCategoryRegistry().getCatById("5"));
        spa4.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        this.company.getSPApplicationRegistry().registerApplication(spa4);

        //Services
        FixedService fs1 = new FixedService("1", "Light plumbing", "Install water tap", 100, this.company.getCategoryRegistry().getCatById("1"));
        fs1.setPredeterminedDuration(60);
        this.company.getServiceRegistry().registerService(fs1);
        LimitedService ls1 = new LimitedService("2", "Heavy plumbing", "Pipeline repair", 40, this.company.getCategoryRegistry().getCatById("1"));
        this.company.getServiceRegistry().registerService(ls1);
        LimitedService ls2 = new LimitedService("3", "Gate painting", "Gate painting", 60, this.company.getCategoryRegistry().getCatById("5"));
        this.company.getServiceRegistry().registerService(ls2);
        ExtendableService es1 = new ExtendableService("4", "Prepare dinner", "Prepare dinner and clean kitchen", 80, this.company.getCategoryRegistry().getCatById("4"));
        this.company.getServiceRegistry().registerService(es1);
        LimitedService ls3 = new LimitedService("5", "Vehicle repair", "Repair vehicle engine", 80, this.company.getCategoryRegistry().getCatById("3"));
        this.company.getServiceRegistry().registerService(ls3);
        FixedService fs2 = new FixedService("6", "Gate painting", "Gate painting", 90, this.company.getCategoryRegistry().getCatById("5"));
        fs2.setPredeterminedDuration(60);
        this.company.getServiceRegistry().registerService(fs2);

        //Geographic Areas
        this.company.getGeographicAreaRegistry().registerGeographicArea(this.company.getGeographicAreaRegistry().newGeographicArea("Gondomar-1", 50, "4420-002", 10000));
        this.company.getGeographicAreaRegistry().registerGeographicArea(this.company.getGeographicAreaRegistry().newGeographicArea("Gondomar-2", 10, "4420-570", 5000));
        this.company.getGeographicAreaRegistry().registerGeographicArea(this.company.getGeographicAreaRegistry().newGeographicArea("Gondomar-3", 20, "4435-685", 8000));
        this.company.getGeographicAreaRegistry().registerGeographicArea(this.company.getGeographicAreaRegistry().newGeographicArea("Porto-1", 30, "4250-108", 10000));
        this.company.getGeographicAreaRegistry().registerGeographicArea(this.company.getGeographicAreaRegistry().newGeographicArea("Maia-1", 40, "4470-526", 5000));

        //Service Providers
        Address add5 = new Address("N/A", "4415-995", "N/A");
        ServiceProvider sp1 = new ServiceProvider("António Padrão", "500324896", "aPadrao@gmail.com", "António Dos Santos Padrão");
        sp1.setNumber(10001);
        sp1.setSpAddress(add5);
        sp1.addCategory(this.company.getCategoryRegistry().getCatById("3"));
        sp1.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        sp1.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Gondomar-1"));
        sp1.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Gondomar-2"));
        this.company.getServiceProviderRegistry().registerServiceProvider(sp1);

        Address add6 = new Address("N/A", "4420-002", "N/A");
        ServiceProvider sp2 = new ServiceProvider("Maria Silva", "510324896", "mSilva@hotmail.com", "Maria Das Neves Silva");
        sp2.setNumber(10002);
        sp2.setSpAddress(add6);
        sp2.addCategory(this.company.getCategoryRegistry().getCatById("2"));
        sp2.addCategory(this.company.getCategoryRegistry().getCatById("4"));
        sp2.addCategory(this.company.getCategoryRegistry().getCatById("5"));
        sp2.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Porto-1"));
        this.company.getServiceProviderRegistry().registerServiceProvider(sp2);

        Address add7 = new Address("N/A", "4470-526", "N/A");
        ServiceProvider sp3 = new ServiceProvider("Joaquina Dos Santos", "510324877", "jaquina@hotmail", "Joaquina Dos Santos");
        sp3.setNumber(10003);
        sp3.setSpAddress(add7);
        sp3.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        sp3.addCategory(this.company.getCategoryRegistry().getCatById("2"));
        sp3.addCategory(this.company.getCategoryRegistry().getCatById("3"));
        sp3.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Maia-1"));
        this.company.getServiceProviderRegistry().registerServiceProvider(sp3);

        Address add8 = new Address("N/A", "4430-601", "N/A");
        ServiceProvider sp4 = new ServiceProvider("Serafim Santos", "230324822", "sSantos@gmail.com", "Serafim Santos");
        sp4.setNumber(10004);
        sp4.setSpAddress(add8);
        sp3.addCategory(this.company.getCategoryRegistry().getCatById("5"));
        sp3.addCategory(this.company.getCategoryRegistry().getCatById("1"));
        sp4.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Maia-1"));
        sp4.addGeoArea(this.company.getGeographicAreaRegistry().getGeoAreaByDesignation("Gondomar-2"));
        this.company.getServiceProviderRegistry().registerServiceProvider(sp4);

        //Availabilities
        LocalDate date1 = LocalDate.of(2019, 6, 3);
        LocalDate date2 = LocalDate.of(2019, 6, 4);
        LocalDate date3 = LocalDate.of(2019, 6, 5);
        LocalTime time1 = LocalTime.of(9, 0);
        LocalTime time2 = LocalTime.of(23, 0);
        Availability aval1 = new Availability(date1, time1, time2, "");
        Availability aval2 = new Availability(date2, time1, time2, "");
        Availability aval3 = new Availability(date3, time1, time2, "");
        LocalDate date5 = LocalDate.of(2019, 6, 24);
        LocalDate date6 = LocalDate.of(2019, 6, 25);
        LocalTime time3 = LocalTime.of(9, 0);
        LocalTime time4 = LocalTime.of(13, 0);
        Availability aval5 = new Availability(date5, time3, time4, "");
        Availability aval6 = new Availability(date6, time3, time4, "");
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001).getSpAvailabilityList().addAvailability(aval1);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001).getSpAvailabilityList().addAvailability(aval2);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001).getSpAvailabilityList().addAvailability(aval3);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001).getSpAvailabilityList().addAvailability(aval5);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001).getSpAvailabilityList().addAvailability(aval6);

        LocalDate date7 = LocalDate.of(2019, 6, 6);
        LocalDate date8 = LocalDate.of(2019, 6, 7);
        LocalTime time5 = LocalTime.of(9, 0);
        LocalTime time6 = LocalTime.of(23, 0);
        Availability aval7 = new Availability(date7, time5, time6, "");
        Availability aval8 = new Availability(date8, time5, time6, "");
        LocalDate date10 = LocalDate.of(2019, 6, 24);
        LocalDate date11 = LocalDate.of(2019, 6, 25);
        LocalTime time7 = LocalTime.of(9, 0);
        LocalTime time8 = LocalTime.of(22, 0);
        Availability aval10 = new Availability(date10, time7, time8, "");
        Availability aval11 = new Availability(date11, time7, time8, "");
        LocalDate date12 = LocalDate.of(2019, 6, 28);
        LocalDate date13 = LocalDate.of(2019, 6, 29);
        LocalTime time9 = LocalTime.of(20, 0);
        LocalTime time10 = LocalTime.of(23, 59);
        LocalTime time11 = LocalTime.of(6, 0);
        LocalTime time12 = LocalTime.of(18, 0);
        Availability aval12 = new Availability(date12, time9, time10, "");
        Availability aval13 = new Availability(date13, time11, time12, "");
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval7);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval8);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval10);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval11);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval12);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002).getSpAvailabilityList().addAvailability(aval13);

        LocalDate date15 = LocalDate.of(2019, 6, 7);
        LocalDate date16 = LocalDate.of(2019, 6, 8);
        LocalDate date180 = LocalDate.of(2019, 6, 10);
        LocalTime time13 = LocalTime.of(9, 0);
        LocalTime time14 = LocalTime.of(23, 0);
        Availability aval15 = new Availability(date15, time13, time14, "");
        Availability aval16 = new Availability(date16, time13, time14, "");
        Availability aval180 = new Availability(date180, time13, time14, "");
        LocalDate date18 = LocalDate.of(2019, 6, 28);
        LocalDate date19 = LocalDate.of(2019, 6, 29);
        LocalTime time15 = LocalTime.of(20, 0);
        LocalTime time16 = LocalTime.of(23, 59);
        LocalTime time17 = LocalTime.of(6, 0);
        LocalTime time18 = LocalTime.of(18, 0);
        Availability aval18 = new Availability(date18, time15, time16, "");
        Availability aval19 = new Availability(date19, time17, time18, "");
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003).getSpAvailabilityList().addAvailability(aval15);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003).getSpAvailabilityList().addAvailability(aval16);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003).getSpAvailabilityList().addAvailability(aval18);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003).getSpAvailabilityList().addAvailability(aval19);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003).getSpAvailabilityList().addAvailability(aval180);

        LocalDate date21 = LocalDate.of(2019, 6, 28);
        LocalDate date22 = LocalDate.of(2019, 6, 29);
        LocalTime time19 = LocalTime.of(20, 0);
        LocalTime time20 = LocalTime.of(23, 59);
        LocalTime time21 = LocalTime.of(6, 0);
        LocalTime time22 = LocalTime.of(18, 0);
        Availability aval21 = new Availability(date21, time19, time20, "");
        Availability aval22 = new Availability(date22, time21, time22, "");
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10004).getSpAvailabilityList().addAvailability(aval21);
        this.company.getServiceProviderRegistry().getServiceProviderByNumber(10004).getSpAvailabilityList().addAvailability(aval22);

        //Service Requests
        Client cli1 = this.company.getClientRegistry().getClientByNIF("100542369");
        PostalCode cp1 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4420-001");
        ServiceRequest sq1 = this.company.getServiceRequestRegistry().newServiceRequest(cli1, cli1.getAddress("Gondomar", cp1, "Rua D. João de França, nº 1"));
        FixedService fservice1 = (FixedService) this.company.getServiceRegistry().getServiceById("1");
        sq1.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("1"), "Close water tap", (int) fservice1.getPredeterminedDuration());
        sq1.addSchedulePreferenceString(LocalDate.of(2019, 6, 3), LocalTime.of(9, 0), "");
        sq1.addSchedulePreferenceString(LocalDate.of(2019, 6, 5), LocalTime.of(22, 0), "");
        sq1.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq1);

        Client cli2 = this.company.getClientRegistry().getClientByNIF("100542369");
        PostalCode cp2 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4420-001");
        ServiceRequest sq2 = this.company.getServiceRequestRegistry().newServiceRequest(cli2, cli2.getAddress("Gondomar", cp2, "Rua D. João de França, nº 1"));
        sq2.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("2"), "Pipeline repair", 60);
        sq2.addSchedulePreferenceString(LocalDate.of(2019, 6, 24), LocalTime.of(9, 0), "");
        sq2.addSchedulePreferenceString(LocalDate.of(2019, 6, 25), LocalTime.of(22, 0), "");
        sq2.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq2);

        Client cli3 = this.company.getClientRegistry().getClientByNIF("110542349");
        PostalCode cp3 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4250-100");
        ServiceRequest sq3 = this.company.getServiceRequestRegistry().newServiceRequest(cli3, cli3.getAddress("Porto", cp3, "R. do Carvalhido, nº 9"));
        sq3.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("3"), "Iron gate painting", 120);
        sq3.addSchedulePreferenceString(LocalDate.of(2019, 6, 24), LocalTime.of(10, 0), "");
        sq3.addSchedulePreferenceString(LocalDate.of(2019, 6, 25), LocalTime.of(14, 30), "");
        sq3.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq3);

        Client cli4 = this.company.getClientRegistry().getClientByNIF("110542349");
        PostalCode cp4 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4250-100");
        ServiceRequest sq4 = this.company.getServiceRequestRegistry().newServiceRequest(cli4, cli4.getAddress("Porto", cp4, "R. do Carvalhido, nº 9"));
        sq4.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("4"), "Prepare dinner and clean kitchen", 120);
        sq4.addSchedulePreferenceString(LocalDate.of(2019, 6, 6), LocalTime.of(19, 0), "");
        sq4.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq4);

        Client cli5 = this.company.getClientRegistry().getClientByNIF("210975020");
        PostalCode cp5 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4470-528");
        ServiceRequest sq5 = this.company.getServiceRequestRegistry().newServiceRequest(cli5, cli5.getAddress("Maia", cp5, "R. Cegonheira, nº 3"));
        FixedService fservice2 = (FixedService) this.company.getServiceRegistry().getServiceById("1");
        sq5.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("1"), "Water tap repair", (int) fservice2.getPredeterminedDuration());
        sq5.addSchedulePreferenceString(LocalDate.of(2019, 6, 7), LocalTime.of(19, 0), "");
        sq5.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq5);

        Client cli6 = this.company.getClientRegistry().getClientByNIF("210975020");
        PostalCode cp6 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4470-528");
        ServiceRequest sq6 = this.company.getServiceRequestRegistry().newServiceRequest(cli6, cli6.getAddress("Maia", cp6, "R. Cegonheira, nº 3"));
        sq6.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("5"), "Repair vehicle engine and change oil", 60);
        sq6.addSchedulePreferenceString(LocalDate.of(2019, 6, 8), LocalTime.of(9, 0), "");
        sq6.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq6);

        Client cli7 = this.company.getClientRegistry().getClientByNIF("210975020");
        PostalCode cp7 = this.company.getPostalCodeRegistry().getMatchingPostalCode("4470-528");
        ServiceRequest sq7 = this.company.getServiceRequestRegistry().newServiceRequest(cli7, cli7.getAddress("Maia", cp7, "R. Cegonheira, nº 3"));
        FixedService fservice3 = (FixedService) this.company.getServiceRegistry().getServiceById("6");
        sq7.addServiceRequestDescription(this.company.getServiceRegistry().getServiceById("6"), "Paint gate", (int) fservice3.getPredeterminedDuration());
        sq7.addSchedulePreferenceString(LocalDate.of(2019, 6, 29), LocalTime.of(20, 0), "");
        sq7.calculateCost();
        this.company.getServiceRequestRegistry().registerServiceRequest(sq7);

        //Service Orders
        //APadrao
        ServiceProvider apadrao = this.company.getServiceProviderRegistry().getServiceProviderByNumber(10001);
        ServiceRequest servReq1 = this.company.getServiceRequestRegistry().getServiceRequestByNumber(1);
        ServiceRequestDescription servRD1 = servReq1.getServiceRequestDescriptions().get(0);
        SchedulePreference schedPref1 = servReq1.getSchedulePreferences().get(1);
        ServiceAssignment sa1 = new ServiceAssignment(apadrao, servRD1, servReq1, schedPref1);
        this.company.getServiceAssignementRegistry().addServiceAssignment(sa1);
        this.company.getServiceOrderRegistry().registerServiceOrder(sa1);

        //MSilva
        ServiceProvider msilva = this.company.getServiceProviderRegistry().getServiceProviderByNumber(10002);
        ServiceRequest servReq3 = this.company.getServiceRequestRegistry().getServiceRequestByNumber(4);
        ServiceRequestDescription servRD3 = servReq3.getServiceRequestDescriptions().get(0);
        SchedulePreference schedPref3 = servReq3.getSchedulePreferences().get(0);
        ServiceAssignment sa3 = new ServiceAssignment(msilva, servRD3, servReq3, schedPref3);
        this.company.getServiceAssignementRegistry().addServiceAssignment(sa3);
        this.company.getServiceOrderRegistry().registerServiceOrder(sa3);

        //JSantos
        ServiceProvider jsantos = this.company.getServiceProviderRegistry().getServiceProviderByNumber(10003);
        ServiceRequest servReq2 = this.company.getServiceRequestRegistry().getServiceRequestByNumber(5);
        ServiceRequestDescription servRD2 = servReq2.getServiceRequestDescriptions().get(0);
        SchedulePreference schedPref2 = servReq2.getSchedulePreferences().get(0);
        ServiceAssignment sa2 = new ServiceAssignment(jsantos, servRD2, servReq2, schedPref2);
        this.company.getServiceAssignementRegistry().addServiceAssignment(sa2);
        this.company.getServiceOrderRegistry().registerServiceOrder(sa2);

        ServiceRequest servReq5 = this.company.getServiceRequestRegistry().getServiceRequestByNumber(6);
        ServiceRequestDescription servRD5 = servReq5.getServiceRequestDescriptions().get(0);
        SchedulePreference schedPref5 = servReq5.getSchedulePreferences().get(0);
        ServiceAssignment sa5 = new ServiceAssignment(jsantos, servRD5, servReq5, schedPref5);
        this.company.getServiceAssignementRegistry().addServiceAssignment(sa5);
        this.company.getServiceOrderRegistry().registerServiceOrder(sa5);

        //Complete Services
        ServiceOrder cso1 = this.company.getServiceOrderRegistry().getServiceOrderById(1);
        this.company.getServiceOrderRegistry().concludeServiceOrder(cso1);
        ServiceOrder cso2 = this.company.getServiceOrderRegistry().getServiceOrderById(2);
        this.company.getServiceOrderRegistry().concludeServiceOrder(cso2);
        ServiceOrder cso3 = this.company.getServiceOrderRegistry().getServiceOrderById(3);
        this.company.getServiceOrderRegistry().concludeServiceOrder(cso3);
        ServiceOrder cso4 = this.company.getServiceOrderRegistry().getServiceOrderById(4);
        this.company.getServiceOrderRegistry().concludeServiceOrderWithIssue(cso4, "Customer complained about delay. Work performed without the presence of the client.");

        //Rate Service Provider
        ServiceProvider rsp1 = cso1.getServiceProvider();
        //rsp1.registerEvaluation(4, cso1);
        ServiceProvider rsp2 = cso2.getServiceProvider();
        rsp2.registerEvaluation(5, cso2);
        ServiceProvider rsp3 = cso3.getServiceProvider();
        rsp3.registerEvaluation(2, cso3);
        ServiceProvider rsp4 = cso4.getServiceProvider();
        rsp4.registerEvaluation(2, cso4);
        this.flagBootstrap = false;
        }
    }

    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationGPSD singleton = null;

    public static ApplicationGPSD getInstance() {
        if (singleton == null) {
            synchronized (ApplicationGPSD.class) {
                singleton = new ApplicationGPSD();
            }
        }
        return singleton;
    }

}
