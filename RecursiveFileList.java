
package lab6;
 
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
 
public class RecursiveFileList {
 
	public static final  String dirToRecurse = "D:";
	public static final  String dirToRecurse1 = "D:\\zainab";
	 public static final    RecursiveFileList rfl = new RecursiveFileList();
    
	   public static final    Vector<lab> obj1=new Vector<lab>();
    public static void main(String[] args) throws InterruptedException {
    	
    	
    	 Thread t =new Thread(RecursiveFileList.run(dirToRecurse));
    	 Thread t2 =new Thread(RecursiveFileList.run(dirToRecurse1));
       
    	 
         t.start();
         t2.start();
         t.join();
         t2.join();
        
        
       
     
       search(obj1);
        
        
    }
    
    public static Runnable run (String path){
    	
    	rfl.fileList(new File(path),obj1 );
    	
    	return null;
    	}
    
    
	
    
    public static void search (Vector <lab> obj1 )
    {
    	
    	Scanner in = new Scanner(System.in);
    	 
        System.out.println("Enter file name");
       String s = in.nextLine();
       int k=0;
       
       for(int j=0;j<obj1.size();j++)
	   {
		   if(s.equals(obj1.elementAt(j).name))
		   {
			   k=1;
			   for(int y=0;y<obj1.elementAt(j).myVector.size();y++)
	        	{
	        		System.out.println(obj1.elementAt(j).myVector.get(y));
	        		
	        	}
			   
		   }
		   
	   }
       
       if(k==0)
       {
    	   System.out.println("The result is  not found ");
    	   
       }
       
    	
    	
    }
    
    private void fileList(File dir, Vector <lab> obj1 ){
        //Get list of all files and folders in directory
        File[] files = dir.listFiles();
        
        //For all files and folders in directory
try{
        for(int i=0; i<files.length; i++){
            //Check if directory
            if(files[i].isDirectory())
                //Recursively call file list function on the new directory
                fileList(files[i] ,obj1);
            else{
            	
            	String dum = null;
            	StringTokenizer defaultTokenizer = new StringTokenizer(files[i].toString(), "\\");
            	
            	while (defaultTokenizer.hasMoreTokens())
            	{
            	   dum= defaultTokenizer.nextToken();
            	}
               if(obj1.size()==0)
               {
            	   lab obj2 =new lab ();
            	   obj2.name=dum;
            	   obj2.myVector.addElement(files[i].toString());
            	   obj1.addElement(obj2);
            	   
               }
            	
               else
               {
            	   int k=0;
            	   for(int j=0;j<obj1.size();j++)
            	   {
            		   if(dum.equals(obj1.elementAt(j).name))
            		   {
            			   obj1.elementAt(j).myVector.addElement(files[i].toString());
            			   k=1;
            		   }
            		   
            	   }
            	   
            	   if(k==0)
                   {
                	   lab obj2 =new lab ();
                	   obj2.name=dum;
                	   obj2.myVector.addElement(files[i].toString());
                	   obj1.addElement(obj2);
                	   
                   }
            	   
               }
                
                
            }
        }
    } catch(NullPointerException npe){
		
	}
    }
}