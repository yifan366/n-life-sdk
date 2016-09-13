package com.b_noble.n_life.utils;

/**
 * rgb转hls
 * @author Administrator
 *
 */
public class RgbToHlsUtils {

	
	
	public static void rgbToHls(int rColor,int gColor,int bColor){
		
		float h=0, s=0, l=0;    
	    // normalizes red-green-blue values    
	    float r = rColor/255.f;    
	    float g = gColor/255.f;   
	    float b = bColor/255.f;   
	  /*  float maxVal = max3v(r, g, b);    
	    float minVal = min3v(r, g, b); */
	    
	    float maxVal = (r > g && r > b) ? r : (g > b) ? g : b;
	    float minVal = (r < g && r < b) ? r : (g < b) ? g : b;
	   
	    ///////////////////////////// hue//////////////// 
	    if(maxVal == minVal)      
	    {      
	        h = 0; // undefined      
	    } 
	    else if(maxVal==r && g>=b)      
	    {      
	        h = 60.0f*(g-b)/(maxVal-minVal);      
	    } 
	    else if(maxVal==r && g<b)      
	    {      
	        h = 60.0f*(g-b)/(maxVal-minVal) + 360.0f;    
	    } 
	    else if(maxVal==g)      
	    {      
	        h = 60.0f*(b-r)/(maxVal-minVal) + 120.0f;      
	    }    
	    else if(maxVal==b)      
	    {      
	        h = 60.0f*(r-g)/(maxVal-minVal) + 240.0f;      
	    }    
	   
	    ////////////////////// luminance ////////////////// 
	    l = (maxVal+minVal)/2.0f;  
	 
	    ///////////////////////// saturation //////////////// 
	    if(l == 0 || maxVal == minVal)    
	    {      
	        s = 0;      
	    }  
	    else if(0<l && l<=0.5f)    
	    {      
	        s = (maxVal-minVal)/(maxVal+minVal);      
	    }    
	    else if(l>0.5f)      
	    {      
	        s = (maxVal-minVal)/(2 - (maxVal+minVal)); //(maxVal-minVal > 0)?      
	    }    
	    float hue = (h>360)? 360 : ((h<0)?0:h);       
	    float saturation = ((s>1)? 1 : ((s<0)?0:s))*100;      
	    float luminance = ((l>1)? 1 : ((l<0)?0:l))*100;  
	 
	    System.out.println("hue:"+hue+" saturation:"+saturation+" luminance:"+luminance);
	    
	  /*  float m_Hue = 240 * hue / 360.f;      
	    float m_Saturation = 240 * saturation / 100.f;      
	    float m_Light = 240 * luminance / 100.f; 
	    
	    System.out.println("m_Hue:"+m_Hue+" m_Saturation:"+m_Saturation+" m_Light:"+m_Light);*/
		
	}
	
	public static void main(String[] args) {
		
		RgbToHlsUtils.rgbToHls(206, 0, 255);
		
	}
	
}
