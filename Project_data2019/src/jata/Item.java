package project_data2019;

public class Item {
    /* COMPLETE ITEM CLASS */
    private int Number;
    private String Name;
    private double Price;
private double cost;
    public Item(int Number, String Name, double Price) {
        this.Number = Number;
        this.Name = Name.toUpperCase();
        this.Price = Price;
        cost=0;
    }

    @Override
    public String toString() {
        return "Item{" + "Number=" + Number + ", Name=" + Name + ", Price=" + Price + '}';
    }

    /**
     * @return the Number
     */
    public int getNumber() {
        return Number;
    }

    /**
     * @param Number the Number to set
     */
    public void setNumber(int Number) {
        this.Number = Number;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
}
