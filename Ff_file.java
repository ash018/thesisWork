/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ff_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import sun.misc.IOUtils;

/**
 *
 * @author akash
 */
public class Ff_file {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         
        
        
        try 
		{
			
			
                       // Scanner in = new Scanner(new File("driverlog5.txt"));
                       for(int fileNumber = 23; fileNumber <= 24; fileNumber++){ 
                        String lne,lne2,depthline;
                        //List<String> lines = null;
                        LineNumberReader LNR = null;
                         
                        boolean ffFlag = false;
                        ArrayList<String> list = new ArrayList<String>();
                        ArrayList<String> depthList = new ArrayList<String>();
                        ArrayList<String> lineList = new ArrayList<String>();
                        String filePath = String.format("/home/akash/solver_output/depot_Numeric/%d.txt",fileNumber);
                        BufferedReader r = new BufferedReader(new FileReader(filePath));
                        BufferedReader br = new BufferedReader(new FileReader(filePath));
                        //FileInputStream target = new FileInputStream(new File("driverlog5.txt"));
                        Pattern p1 = Pattern.compile("g = ;(.*)");
                        String fString = String.format("/home/akash/solver_output/depot_Numeric/java/%d.txt",fileNumber);
                        File f = new File(fString);
                        FileOutputStream fos = new FileOutputStream(f);
                       // PrintWriter pw = new PrintWriter(fos);
                        FileWriter fw = new FileWriter(f,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        
                        
                       
         while((depthline = br.readLine()) != null){
                            Matcher m = p1.matcher(depthline);
                            if (m.find())
        //if(line.contains(";"))
            //a=Integer.parseInt(m.group(1));
            //System.out.print(a );
           // System.out.println(m.group(1) + '\n');
            //System.out.println(line.indexOf(";"));
                            depthList.add(m.group(1));
                        }
                         
                       
                        
                       
                        
                        while((lne = r.readLine()) != null){
                            if(ffFlag){
                                if(lne.isEmpty()){
                                   break;
                                  //  return;
                                 //System.out.println(lne);
                                }
                               
                             
                                 //System.out.println(lne);
                                 list.add(lne);
                                //list.add(r.readLine());
                                
                            }else{
                                if(lne.equals("ff: found legal plan as follows")){
                                    ffFlag = true;
                                   // list.add(r.readLine());
                                    //System.out.println(lne);
                                   // LNR = new LineNumberReader(new FileReader(match));
                                    //System.out.println("Line: "+LNR.getLineNumber());
                                }
                            }
                        }
                        
                        
                        System.out.println("\t\tDepth\t\t\t Action");
                        bw.write("\t\t\t\tDepth\t\t\t\t Action");
                        bw.newLine();
			String line = "";
			//String regex = "\\s*\\b[1]\\b\\s*";
                        int n,p=0,recur=0;
                        int startLine = 17;
			String name, edgeType,depthLine;
                       // name = Files.readAllLines(Paths.get("depot4.txt")).get(40);
                       // name = name.replaceAll("\\s+", "");
                       // n = Integer.parseInt(name);
                        n = list.size();
                        /*
                        while(startLine < (15+n) && p<50 ){
                            depthLine = Files.readAllLines(Paths.get("dr.txt")).get(startLine);
                          //  depthLine = depthLine.replaceAll(regex, "");
                            //String openBracket = "1";
                            int m = p + recur;
                            int countBracket = depthLine.length() - depthLine.replace("[","").length();
                            System.out.println(countBracket);
                            for(int ii= 0; ii<countBracket;ii++){
                            //System.out.println("\n" +countBracket);
                                
                                System.out.println("" +depthLine);
                                recur++;
                            }
                            startLine++;
                            p++;
                            
                            
                            
                        }
                        */
          // BufferedWriter file = new BufferedWriter(new FileWriter("test.txt"));             
           while(startLine < (17+n) && p<50 ){
               
                        //depthLine = Files.readAllLines(Paths.get("/home/akash/solver_output/zenoTravelNumeric/2.txt")).get(startLine);
                        depthLine = Files.readAllLines(Paths.get(filePath)).get(startLine);

                        lineList.add(depthLine);
                        startLine++;
           }            
                        for(int i=0;i<depthList.size();i++){
                            String element1 = depthList.get(i);
                            int a = 0;
                            //int loop;
                            int nextLine=0;
                            a = Integer.parseInt(element1);
                            System.out.println("\n");
                            bw.newLine();
                            if(i == 0){
                                int loop = a;
                                
                                for(int j = 0;j < loop;j++){
                                System.out.println(""+lineList.get(i)  +"    "+list.get(nextLine));
                                bw.write(""+lineList.get(i)  +"    "+list.get(nextLine));
                                bw.newLine();
                                nextLine++;
                                
                                //bw.write(lineList.get(i)+"    "+list.get(nextLine));
                                //bw.newLine();
                                //pw.flush();
                                //fos.close();
                               // pw.close();
                              // bw.close();
                                }
                                
                            }
                            
                            
                            else{
                                nextLine = Integer.parseInt(depthList.get(i-1));
                                int loop = a - Integer.parseInt(depthList.get(i-1));
                                for(int j = 0;j < loop;j++){
                                System.out.println(""+lineList.get(i)  +"    "+list.get(nextLine));
                                bw.write(""+lineList.get(i)  +"    "+list.get(nextLine));
                                bw.newLine();
                                nextLine++;
                                
                                //bw.write(lineList.get(i)+"    "+list.get(nextLine));
                                //bw.newLine();
                                //pw.flush();
                                
                                
                                }
                                
                                
                            }
                            
                            
                           
                        }
                        //fos.close();
                        bw.close();
                       
                       }      
                       
                
                }
        	catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       
        
       
    
        
        
    }
    
}
