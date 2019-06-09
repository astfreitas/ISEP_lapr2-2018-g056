package lapr.project.gpsd.model;

import java.util.Objects;

public class Category
{
    private String code;
    private String description;
            
    /**
     * 
     * Creates an instance of Category
     * 
     * @param code Category unique code
     * @param description Category description
     */
    public Category(String code, String description){
        if ( (code == null) || (description == null) ||
                (code.isEmpty())|| (description.isEmpty()))
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        
        this.code = code;
        this.description = description;
    }
    
    /**
     * 
     * Checks if the Category has a determined ID
     * 
     * @param id ID to check
     * @return True/false if the Category has/hasn't the ID
     */
    public boolean hasId(String id)
    {
        return this.code.equalsIgnoreCase(id);
    }
    
    /**
     * 
     * Gets the Category unique ID
     * 
     * @return Category unique ID
     */
    public String getCode(){
        return this.code;
    }

    /**
     * 
     * Gets the Category description
     * 
     * @return Category description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * Sets the Category unique code
     * 
     * @param code Category unique code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * Sets the Category description
     * 
     * @param description Category description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * 
     * Compares two instances of Category and returns true/false if they are
     * equals or possess the same atributes
     * 
     * @param otherCategory Category to compare
     * @return True/false if they are
     * equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherCategory) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == otherCategory)
            return true;
        // null check
        if (otherCategory == null)
            return false;
        // type check and cast
        if (getClass() != otherCategory.getClass())
            return false;
        // field comparison
        Category obj = (Category) otherCategory;
        return (Objects.equals(code, obj.code));
    }
    
     /**
     * 
     * Returns the info of the Category in a String
     * 
     * @return Info of the instance
     */
    @Override
    public String toString()
    {
        return String.format("Category code: %s\nDescription: %s ", this.code, this.description);
    }

}
