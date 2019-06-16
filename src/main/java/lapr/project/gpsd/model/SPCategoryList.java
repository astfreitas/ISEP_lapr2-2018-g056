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

    /**
     * validates if category is already in registry
     *
     * @param cat
     * @return false if category is already in registry. true if it is not
     */
    public boolean validateCategory(Category cat) {
        if (categorylist.contains(cat) || cat == null) {
            return false;
        }
        return true;
    }

    public boolean addCategory(Category cat) {
        if (validateCategory(cat)) {
            return categorylist.add(cat);
        }
        return false;
    }

    /**
     * removes category from list
     *
     * @param catId
     */
    public void removeCategory(Category cat) {
        categorylist.remove(cat);
    }

    @Override
    public String toString() {
        String text = "";
        for (Category cat : categorylist) {
            text += cat.toString() + "\n";
        }
        return text;
    }

}
