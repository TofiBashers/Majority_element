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

    static int searchMajorityElement(int arr[], int n) {
        int count = 0;
        int elem = 0;
        for(int i = 0; i < n; i++)
        {
            if(count == 0)
            {
                elem = arr[i];
                count++;
            }
            else
            {
                if(arr[i] == elem)
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
        }
        int control = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == elem)
            {
                control++;
                if(control > n/2)
                {
                    return elem;
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
            writer.write(Integer.toString(searchMajorityElement(arr, n)) + " ");
            writer.flush();
        }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
