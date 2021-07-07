/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_data2019;

/**
 *
 * @author Abo_mohamed
 */
public class BinarysearchTree {
    private TreeNode root;

    public BinarysearchTree() {
        root=null;
    }
    private TreeNode insert(Item x,TreeNode  t){
        
        if(t==null)
            t=new TreeNode(x);
        else if(x.getPrice()<=t.data.getPrice())
           t.left= insert(x, t.left);
        else
           t.right=insert(x,t.right);
        
        return t;
    }
    
    private TreeNode insert_by_Number(Item x,TreeNode  t){
        
        if(t==null)
            t=new TreeNode(x);
        else if(x.getNumber()<=t.data.getNumber())
           t.left= insert(x, t.left);
        else
           t.right=insert(x,t.right);
        
        return t;
    }
     public void insert_by_number(Item x){
       root= insert_by_Number(x, root);
    }
    public void insert(Item x){
       root= insert(x, root);
    }
    
    public Item getmax(TreeNode t)
    {
    if(t.right==null)
        return t.data;
    return getmax(t.right);
    }
    
    public TreeNode delete(Item x,TreeNode t)
    {
    
    if(t==null)
        return null;
    else if(x.getPrice()<t.data.getPrice())
       t.left= delete(x, t.left);
    else if(x.getPrice()>t.data.getPrice())
       t.right= delete(x, t.right);
    else if(t.left==null){
    TreeNode p=t;
    t=t.right;
    
    }else if(t.right==null)
    {
  
    t=t.left;
    }else{
        t.data=getmax(t.left);
      t.left=  delete(t.data, t.left);
    }
    
    return t;
    }
   
    public void delete(Item x)
    {
        root=delete(x, root);
    }
    /////
    public TreeNode delete_by_num(Item x,TreeNode t)
    {
    
    if(t==null)
        return null;
    else if(x.getNumber()<t.data.getNumber())
       t.left= delete(x, t.left);
    else if(x.getNumber()>t.data.getNumber())
       t.right= delete(x, t.right);
    else if(t.left==null){
    TreeNode p=t;
    t=t.right;
    
    }else if(t.right==null)
    {
  
    t=t.left;
    }else{
        t.data=getmax(t.left);
      t.left=  delete(t.data, t.left);
    }
    
    return t;
    }
   
    public void delete_by_number(Item x)
    {
        root=delete(x, root);
    }
   //delete by name
    public void delete__by_name(String name){
        root=delete_by_name(root,name);
    }
    public TreeNode delete_by_name(TreeNode t,String name){
        if(t==null)
        return null;
        if(t.data.getName().equals(name))
        {     delete(t.data);
        return t;
        }
       
         t.left=delete_by_name(t.left, name);
         t.right=delete_by_name(t.right, name);
         return t;
        
    }
    
    
    
    
    
    
    
    public void inorder(TreeNode t)
    {
        if(t==null)
            return;
        else{
            
            inorder(t.left);
            System.out.print(t.data.toString()+" , ");
            inorder(t.right);
        }
    }
     public void postorder(TreeNode t)
    {
        if(t==null)
            return;
        else{
            
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.data+" , ");
           
        }
    }
     
      public void preorder(TreeNode t)
    {
        if(t==null)
            return;
        else{
            
           
            System.out.print(t.data.toString()+" , ");
            preorder(t.left);
            preorder(t.right);
        }
    }
     public void inorder()
     {  inorder(root);}
     
     public void postorder(){
         postorder(root);
     }
     public void preorder(){
         preorder(root);
     }
     public void printbylevel(){
         Queue <TreeNode> q=new Queue<TreeNode>();
        TreeNode p=root;
         q.enqueue(root);
         while(!q.isEmpty()){
             TreeNode t=q.dequeue();
             System.out.print(t.data.toString()+" \n ");
             if(t.left!=null)
                 q.enqueue(t.left);
             if(t.right!=null)
                 q.enqueue(t.right);
         }
         
     }
     public int getmax(int a,int b){
         if(a>b)
             return a;
         return b;
     }
    public  int getheight(TreeNode t){
             if(t==null)
     return -1;
     return getmax(getheight(t.left),getheight(t.right))+1;
    }
  public  int getheight(){return getheight(root);}
    
   
      //اخذ لينكد لست وتعبئتها في  
      //bst
      public void build_by_doublelinkedlist(DLL<Item> dl){
          Node<Item> p=dl.getHead();
          while(p!=null){
              
                  insert(p.getItem());
              
              p=p.getNext();
          }
          
          
      }
       public boolean searchbyNumber(int num){
           return searchbynummber(root,num);
       }
      public boolean searchbynummber(TreeNode t,int num){
           if(t==null){
              System.out.println("Not found...");
          return false;
          }
         if(t.data.getNumber()==num){
             System.out.println(t.data.toString());    
         
             return true;
         }
         return searchbynummber(t.left, num)&&searchbynummber(t.right, num);
      }
      
      public boolean searchbyName(String name){
           return searchbyname(root,name);
       }
      public boolean searchbyname(TreeNode t,String name){
          if(t==null){
              System.out.println("Not found...");
          return false;
          }
         if(t.data.getName().equals(name))
             return true;
         return searchbyname(t.left, name)&&searchbyname(t.right, name);
      }
    
    
    
    
    

}

        

