/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class SPCategoryList {
    
    private List<Category> categorylist;

    public SPCategoryList() {
        this.categorylist = new ArrayList<>();
    }

    public List<Category> getCategorylist() {
        return categorylist;
    }
    
    
}
