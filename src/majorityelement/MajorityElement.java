/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package majorityelement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author TofixXx
 */

public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    static int SearchMajorityElement(int arr[], int N) {
        int count = 0;
        int Elem = 0;
        for(int i = 0; i < N; i++)
        {
            if(count == 0)
            {
                Elem = arr[i];
                count++;
            }
            else
            {
                if(arr[i] == Elem)
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
            //System.out.println(count+ " " + Elem + " " + arr[i]);
        }
        int control = 0;
        for(int i = 0; i < N; i++)
        {
            if(arr[i] == Elem)
            {
                control++;
                if(control > N/2)
                {
                    return Elem;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("rosalind_maj.txt"));
        FileWriter writer = new FileWriter(new File("output.txt")))
        {
            String inp[] = reader.readLine().split(" ");
        int k = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);
        while(reader.ready())
        {
            String Sarr[] = reader.readLine().split(" ");
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = Integer.parseInt(Sarr[i]);
            }
            writer.write(Integer.toString(SearchMajorityElement(arr, n)) + " ");
            writer.flush();
        }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
