import java.io.*;
import java.util.*;
import java.net.*;
public class WebpageTCP {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the hostname:");
        String hostname=sc.nextLine();
        System.out.println("Enter the portnumber");
        int portnumber=sc.nextInt();
        Socket s= new Socket(hostname,portnumber);
        DataOutputStream out= new DataOutputStream(s.getOutputStream());
        DataInputStream in= new DataInputStream(s.getInputStream());
        out.writeUTF("GET / HTTP /1.1\nHost:" +hostname+  "\n\n ");
        File f1= new File(hostname + ".html");
        FileWriter fw=new FileWriter(f1);
        String line;
        while((line=in.readLine())!=null)
        {
            fw.write(line + "\n");
        }
        System.out.println("Downloaded!");
        fw.close();
        sc.close();
        s.close(); 
    }
    
    
}
