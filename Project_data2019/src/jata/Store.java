package project_data2019;

public class Store {
    
    /* STORE CLASS FUNCTIONS AND DATA FIELDS SHOULD BE HERE */
    
    Queue<Order> newOrders=new Queue<>();
     Queue<Order> processedOrders=new Queue<>();
      Queue<Order> removedOrders=new Queue<>();
        DLL<Item>items=new DLL<Item>();
      
    /* AFTER COMPLETING THE REQUIREMENTS ALL ERRORS SHOULD BE RESOLVED */
        
        public void addItem(Item t){
        items.addLast(t);
    }
    //print removed order in reverse
        public void printremoved_reverse(){
            Stack<Order> st=new Stack<>();
            Queue<Order> q=new Queue<>();
            while(!removedOrders.isEmpty()){
                Order o=removedOrders.dequeue();
                st.push(o);
                q.enqueue(o);
            }
            while(!st.isEmpty())
               st.pop().printOrder();
            while(!q.isEmpty())
                removedOrders.enqueue(q.dequeue());
               
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
        p.getNext().setPrev(p.getPrev());
        p.getPrev().setNext(p.getNext());
         return (Item)(p.getItem());
        
    }
      
        
        /////////

    public Store() {
    }
    public void resetOrders(){
       newOrders=new Queue<>();
       processedOrders=new Queue<>();
       removedOrders=new Queue<>();
    }
    public void addorder_ckeck_items(Order o){
      
        Node p=o.getitems().getHead();
        while(p!=null){
        if( ! items.ISEXIST(((Item)(p.getItem())).getNumber()))
            o.removeItem(((Item)(p.getItem())).getNumber());
            p=p.getNext();
        }
        newOrders.enqueue(o);
    }
    //التاكد من ان كل المنتجات موجوده في المخزن
     public void processedorder_ckeck_items(){
         Queue <Order>q=new Queue<>();
      while(!processedOrders.isEmpty()){
          Order o=processedOrders.dequeue();
        Node p=o.getitems().getHead();
        while(p!=null){
        if( ! items.ISEXIST(((Item)(p.getItem())).getNumber()))
            o.removeItem(((Item)(p.getItem())).getNumber());
            p=p.getNext();
        }
        q.enqueue(o);
        
      }
      while(!q.isEmpty())
          processedOrders.enqueue(q.dequeue());
      
    }
    
    
    public void addNewOrder(Order o){
        newOrders.enqueue(o);
    }
    public void processOrder(){
        if(!newOrders.isEmpty()){
       // Order o=newOrders.dequeue();
        processedOrders.enqueue(newOrders.dequeue());
        }else{
            System.out.println("No NEW ORDER");
        }
    }
    public void removeOrder(int num){
        Queue<Order> qOrder=new Queue<>();
        while(!newOrders.isEmpty()){
            Order o=newOrders.dequeue();
            if(o.getOrderNumber()==num)
                removedOrders.enqueue(o);
            else
            qOrder.enqueue(o);
        }
        while(!qOrder.isEmpty())
            newOrders.enqueue(qOrder.dequeue());
    }
    public void printAllOrders(Queue<Order> q){
      Queue<Order> qOrder=new Queue<>();
        while(!q.isEmpty()){ 
            Order o=q.dequeue();
            o.printOrder();
            qOrder.enqueue(o);
        }
        while(!qOrder.isEmpty())
            q.enqueue(qOrder.dequeue());
    }
    
    ///////حساب السعر بالعربي
     public double calculateSales(Queue<Order>q){
      Queue<Order> qOrder=new Queue<>();
      double sum=0;
        while(!q.isEmpty()){ 
        Order o=q.dequeue();
           sum+=o.calculateorderPrice();
            qOrder.enqueue(o);
        }
        while(!qOrder.isEmpty())
            q.enqueue(qOrder.dequeue());
        return sum;
 } 
    
    public double calculateSales(){
      Queue<Order> qOrder=new Queue<>();
      double sum=0;
        while(!processedOrders.isEmpty()){ 
        Order o=processedOrders.dequeue();
           sum+=o.calculateorderPrice();
            qOrder.enqueue(o);
        }
        while(!qOrder.isEmpty())
            processedOrders.enqueue(qOrder.dequeue());
        return sum;
 } 
 BinarysearchTree bst=new BinarysearchTree();
    public void generateItemsTree(){
        
        bst.build_by_doublelinkedlist(items);
    }
  public void binarysearch(Item k){
      int s=items.getSize();
      Item x[]=new Item[s];
      Node p=items.getHead();
      int i=0;
      while(p!=null){
            x[i]=(Item)p.getItem();
           p=p.getNext(); i++;
        }
      Sort(x);
      binarysearch(x, k);
  }
  public   static void Sort(Item[] arr){
     
      for(int i=0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;i++){
              if(arr[i].getNumber()>arr[j].getNumber()){
                  Item t=arr[i];
                  arr[i]=arr[j];
                  arr[j]=t;
              }
          }
      }
        
    }
  public  void binarysearch(Item x[],Item k){
int f=0,l=x.length-1;
int med;
while(f<=l){
med=(f+l)/2;
if(x[med].getNumber()==k.getNumber()) 
{System.out.println("x["+med+"]"+x[med].toString());return;}

    if(x[med].getNumber()>k.getNumber())
        l=med-1;
else
    f=med+1;

//System.out.println("x["+med+"]"+x[med].toString());
}
    }
 
    

    public static void main(String[] args) {
        Store store = new Store();
        Order o4 = new Order(4);
        o4.addItem(new Item(111,"iPhone X",3750));
        o4.addItem(new Item(133,"Bose Headphone",1099));
        o4.searchBYNAme_("iPh");
        store.addNewOrder(o4);
        Order o5 = new Order(5);
        o5.addItem(new Item(111,"iPhone X Max",5550));
        store.addNewOrder(o5);
        Order o1 = new Order(1);
        o1.addItem(new Item(111,"iPhone X",3750));
        o1.addItem(new Item(122,"iPhone X Max",5550));
        o1.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        o1.searchBYNAme_("Sam");
        store.addNewOrder(o1);
        Order o2 = new Order(2);
        o2.addItem(new Item(122,"iPhone X Max",5550));
        o2.addItem(new Item(131,"Apple AirPods",599));
        store.addNewOrder(o2);
        Order o3 = new Order(3);
        o3.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o3);
        
        store.removeOrder(5);
        store.processOrder();
        System.out.println("New:");
        store.printAllOrders(store.newOrders);
        System.out.println("Processed:");
        store.printAllOrders(store.processedOrders);
        System.out.println("Removed:");
        store.printAllOrders(store.removedOrders);
        
        
        
        //
        
       
        store.addItem(new Item(111,"iPhone X",3750));
        store.addItem(new Item(133,"Bose Headphone",1099));
        store.addItem(new Item(111,"iPhone X",3750));
        store.addItem(new Item(123,"iPhone X 11",5550));
       store.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
         store.addItem(new Item(122,"iPhone X Max",5550));
        store.addItem(new Item(131,"Apple AirPods",599));
              store.addItem(new Item(1212,"iPhone Xx Max",5550));
        store.addItem(new Item(1131,"Apple xx AirPods",599));
        Order test=new Order(1245);
        test.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        test.printOrder();
        store.addorder_ckeck_items(test);
       test.printOrder();
         System.out.println("New:");
        store.printAllOrders(store.newOrders);
        store.generateItemsTree();
        store.bst.inorder();
        System.out.println("");
        store.bst.preorder();
    }
    
}
