package project_data2019;
 
public class Order {
    /* COMPLETE ORDER CLASS */
    private int orderNumber;
    private DLL<Item>items=new DLL<>();

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public double calculateorderPrice(){
         Node p=items.getHead();
         double sum=0;
        while(p!=null){
            sum+=((Item)(p.getItem())).getPrice();
           p=p.getNext(); 
        }
        return sum;
    }
    
    public void addItem(Item t){
        items.addLast(t);
    }
    
    //remove by number
    public Item removeItem(int number){
        Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getNumber()==number){
                break;
            }
            p=p.getNext();
        }
        if(p==null)
        { System.out.println("Not Found");
        return null;
        }
        if(p==items.getHead()){
            items.setHead(items.getHead().getNext());
            if(items.getHead()!=null)
            items.getHead().setPrev(null);
            if(items.getHead()==null)
                items.setTail(null);
            return (Item)(p.getItem());
             }
        if(p==items.getTail()){
            items.setTail(items.getTail().getPrev());
            
            items.getTail().setNext(null);
            return (Item)(p.getItem());
        }
        p.getNext().setPrev(p.getPrev());//p.next.prev=p.prev;
        
        p.getPrev().setNext(p.getNext());//p.prev.next=p.next;
         return (Item)(p.getItem());
        
    }
     //remove by name
    public Item removeItem(String name){
        Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getName().equals(name)){
                break;
            }
            p=p.getNext();
        }
        if(p==null)
        { System.out.println("Not Found");
        return null;
        }
        if(p==items.getHead()){
            items.setHead(items.getHead().getNext());
            items.getHead().setPrev(null);
            if(items.getHead()==null)
                items.setTail(null);
            return (Item)(p.getItem());
             }
        if(p==items.getTail()){
            items.setTail(items.getTail().getPrev());
            items.getTail().setNext(null);
            return (Item)(p.getItem());
        }
        p.getNext().setPrev(p.getPrev());
        p.getPrev().setNext(p.getNext());
         return (Item)(p.getItem());
        
    }
     //remove by price >5000
    public void removeall_item(double p){
        while(removeItem(p)!=null);
    }
    public Item removeItem(double price){
        Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getPrice()>price){
                break;
            }
            p=p.getNext();
        }
        if(p==null)
        { System.out.println("Not Found");
        return null;
        }
        if(p==items.getHead()){
            items.setHead(items.getHead().getNext());
            items.getHead().setPrev(null);
            if(items.getHead()==null)
                items.setTail(null);
            return (Item)(p.getItem());
             }
        if(p==items.getTail()){
            items.setTail(items.getTail().getPrev());
            items.getTail().setNext(null);
            return (Item)(p.getItem());
        }
        p.getNext().setPrev(p.getPrev());
        p.getPrev().setNext(p.getNext());
         return (Item)(p.getItem());
        
    }
    public Item searchBYNumber(int num){
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getNumber()==num){
                System.out.println(p.getItem().toString());
                return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         System.out.println("Not Found");
        return null;
         
    }
     public Item searchBYNAme(String name){
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getName().equals(name)){
                System.out.println(p.getItem().toString());
                return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         System.out.println("Not Found");
        return null;
         
    }
     // search by apart of the name
      public Item searchBYNAme_(String name){
          name=name.toUpperCase();
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getName().contains(name)){
                System.out.println(p.getItem().toString());
                return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         System.out.println("Not Found");
        return null;
         
    }
      public void searchBYNAme_all(String name){
          name=name.toUpperCase();
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getName().contains(name)){
                System.out.println(p.getItem().toString());
               // return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         System.out.println("Not Found");
       // return null;
         
    }
      
      
      
      
     public Item searchBYPrice(double price){
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getPrice()==price){
                System.out.println(p.getItem().toString());
                return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         System.out.println("Not Found");
        return null;
         
    }
     
     
     
     public void searchBYPrice_(double price){
     Node p=items.getHead();
        while(p!=null){
            if(((Item)(p.getItem())).getPrice()==price){
                System.out.println(p.getItem().toString());
                //return (Item)p.getItem();
            }
            p=p.getNext();
        }
       
         //System.out.println("Not Found");
      //  return null;
         
    }
     public void printOrder(){
         System.out.println( "orderNumber=" + getOrderNumber()); 
         items.print();
         }
     


    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the items
     */
    public DLL<Item> getitems() {
        return items;
    }
    
}
