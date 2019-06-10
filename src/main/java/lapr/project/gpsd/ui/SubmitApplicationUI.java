package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.SubmitApplicationController;

public class SubmitApplicationUI {

    private Main mainApp;
    private SubmitApplicationController controller;

    public SubmitApplicationUI(Main mainApp) {
        this.mainApp = mainApp;
        this.controller = new SubmitApplicationController();
    }

    public Main getMainApp() {
        return this.mainApp;
    }

    public SubmitApplicationController getController() {
        return this.controller;
    }

    public void toSubmitApplicationScene1() {
        try {
            SubmitApplicationUI1 submitApplicationScene1UI = (SubmitApplicationUI1) this.mainApp.replaceSceneContent("/fxml/SubmitApplication1.fxml");
            submitApplicationScene1UI.setSubmitApplicationUI(this);
            submitApplicationScene1UI.getNameTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toSubmitApplicationScene2() {
        try {
            SubmitApplicationUI2 submitApplicationScene2UI = (SubmitApplicationUI2) this.mainApp.replaceSceneContent("/fxml/SubmitApplication2.fxml");
            submitApplicationScene2UI.setSubmitApplicationUI(this);
            submitApplicationScene2UI.getAddressTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toSubmitApplicationScene3() {
        try {
            SubmitApplicationUI3 submitApplicationSceneUI3 = (SubmitApplicationUI3) this.mainApp.replaceSceneContent("/fxml/SubmitApplication3.fxml");
            submitApplicationSceneUI3.setSubmitApplicationUI(this);
            submitApplicationSceneUI3.getCourseTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toSubmitApplicationScene4() {
        try {
            SubmitApplicationUI4 submitApplicationSceneUI4 = (SubmitApplicationUI4) this.mainApp.replaceSceneContent("/fxml/SubmitApplication4.fxml");
            submitApplicationSceneUI4.setSubmitApplicationUI(this);
            submitApplicationSceneUI4.getDescriptionTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toSubmitApplicationScene5() {
        try {
            SubmitApplicationUI5 submitApplicationSceneUI5 = (SubmitApplicationUI5) this.mainApp.replaceSceneContent("/fxml/SubmitApplication5.fxml");
            submitApplicationSceneUI5.setSubmitApplicationUI(this);
        } catch (Exception ex) {
        }
    }

    public void toSubmitApplicationScene6() {
        try {
            SubmitApplicationUI6 submitApplicationSceneUI6 = (SubmitApplicationUI6) this.mainApp.replaceSceneContent("/fxml/SubmitApplication6.fxml");
            submitApplicationSceneUI6.setSubmitApplicationUI(this);
        } catch (Exception ex) {
        }
    }

}
