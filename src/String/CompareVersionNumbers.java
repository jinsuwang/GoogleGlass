/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

/**
 *
 * @author Sam
 */
public class CompareVersionNumbers {
    
    public int compareVersion(String version1, String version2) {
        
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int lengthV1 = v1.length;
        int lengthV2 = v2.length;
        int len = Math.max(lengthV1, lengthV2);
        for(int i=0;i<len;i++){
            int nV1 = 0, nV2 = 0; 
            if (i<lengthV1) {
                nV1=Integer.parseInt(v1[i]);
            }
            if (i<lengthV2) {
                nV2=Integer.parseInt(v2[i]);
            }
            if (nV1>nV2) {
                return 1;
            }else if (nV1<nV2) {
                return -1;
            }
        }
        return 0;
    }
}
