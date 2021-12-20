//@Fuente: GeekforGeeks
import java.util.*;

public class FWarshall {

	public static void main(String[] args) {
	
	 VerificacionCaminos a = new VerificacionCaminos();
	 
	 						/* 		 A,    B,      C,	   D,	 E,	   F,	 G,	   H,    I,    J,	  K,     L,    M,	  N,   O , 	   P,    Q,     R,    S,    T,	  U,   V*/	
     int AQPCenter[][] = { /*A*/{    0,  399, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,	595,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*B*/{  399,	   0, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,	1050,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,	1100,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*C*/{a.INF,a.INF, 	  0,a.INF, 1550,a.INF,a.INF,  357,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF,  1260,a.INF,a.INF,a.INF,a.INF},
    		 			   /*D*/{a.INF,a.INF, a.INF,	0,a.INF,a.INF,a.INF,a.INF,  324,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF,   722,a.INF,a.INF,a.INF,a.INF},	                     
    		 			   /*E*/{a.INF,a.INF,  1550,a.INF,	  0,a.INF,  884,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,  574,a.INF,a.INF ,a.INF,   869,a.INF,a.INF,a.INF,a.INF},
    		 			   /*F*/{a.INF,a.INF, a.INF,a.INF,a.INF,	0,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF, 1890,  989,a.INF,   596,a.INF, a.INF,a.INF,a.INF,a.INF,  992},
    		 			   /*G*/{a.INF,a.INF, a.INF,a.INF,  884,a.INF,	  0,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,a.INF,a.INF,a.INF,  526},
    		 			   /*H*/{a.INF,a.INF,   357,a.INF,a.INF,a.INF,a.INF,	0,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,  989,a.INF,a.INF,a.INF},
    		 			   /*I*/{a.INF, 1050, a.INF,  324,a.INF,a.INF,a.INF,a.INF,    0,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,a.INF,a.INF, 1170, 1010},
    		 			   /*J*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,	0, a.INF,a.INF,a.INF,a.INF,  345,   319,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*K*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, 	   0,a.INF,  450,a.INF, 2420,a.INF ,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*L*/{  595,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,	 0,a.INF,a.INF,a.INF,a.INF , 2300, a.INF,a.INF,a.INF,  716,a.INF},
    		 			   /*M*/{a.INF,a.INF, a.INF,a.INF,a.INF, 1890,a.INF,a.INF,a.INF,a.INF,   450,a.INF,    0, 1840,a.INF,a.INF ,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*N*/{a.INF,a.INF, a.INF,a.INF,  574,  989,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF, 1840,	 0,a.INF,a.INF ,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*O*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,  345, 2420,a.INF,a.INF,a.INF,	   0,a.INF ,   87, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*P*/{a.INF, 1100, a.INF,a.INF,a.INF, 596,a.INF,a.INF, a.INF,  319, a.INF,a.INF,a.INF,a.INF,a.INF,	 0 ,a.INF, a.INF,a.INF,a.INF,  798,a.INF},
    		 			   /*Q*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF, 2300,a.INF,a.INF,  87,a.INF ,		0, a.INF,a.INF,a.INF,a.INF,a.INF},
    		 			   /*R*/{a.INF,a.INF,  1260,  722,  869,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, 	   0,a.INF,a.INF,a.INF,a.INF},
    		 			   /*S*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,  989,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,	 0,  239,a.INF,a.INF},
    		 			   /*T*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,  239,	   0,  811,a.INF},
    		 			   /*U*/{a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, 1170,a.INF, a.INF,  716,a.INF,a.INF,a.INF,a.INF ,a.INF, a.INF,a.INF,  811,	 0,a.INF},
    		 			   /*V*/{a.INF,a.INF, a.INF,a.INF,a.INF,  992,  526,a.INF, 1010,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,   798,a.INF, a.INF,a.INF,a.INF,a.INF,	   0}
	                     };

     int ASAlegre[][] = { 		
    		 				{	0, 1600, a.INF,a.INF,a.INF,a.INF,a.INF, 1740,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF}, 	
							{ 1600,	  0, a.INF, 1470,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, 2460,a.INF,a.INF, a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, 	 0,a.INF,a.INF,a.INF, 1890,a.INF,a.INF,a.INF, a.INF, 689,a.INF, a.INF,a.INF,a.INF},
					 	    {a.INF, 1470, a.INF,   0,a.INF, 1420,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,  1750,a.INF,a.INF},             
					 	    {a.INF,a.INF, a.INF,a.INF,	 0,  964,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,  330, 1240,a.INF},
					 	    {a.INF,a.INF, a.INF, 1420,  964,   0,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF, 1830,a.INF,  516,a.INF},
					 	    {a.INF,a.INF,  1890,a.INF,a.INF,a.INF,	 0, 3070,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF, 1050},
					 	    { 1740,a.INF, a.INF,a.INF,a.INF,a.INF, 3070,   0,  265,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,  265,   0,  218, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,  218,   0,   177,a.INF,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF, 2460, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,    0,a.INF, 1270,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF,   689,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,   0,  974,a.INF,a.INF,  723},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF, 1830,a.INF,a.INF,a.INF,a.INF,  1270,  974,   0,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF, 1750,  330,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,   0,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF, 1240,  516,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,   0, 1880},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF, 1050,a.INF,a.INF,a.INF, a.INF, 723,a.INF,a.INF,  1880,   0}
			           	};

     int Paucarpata[][] = { 	
							{    0,a.INF, a.INF, 4130,a.INF,a.INF,a.INF, 1190,a.INF, 1570, a.INF, 1840,a.INF,a.INF,a.INF,a.INF}, 	
							{a.INF,    0,   732,a.INF,a.INF,a.INF, 1990,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,  484,a.INF,a.INF},
					 	    {a.INF,  732, 	  0,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,  565},
					 	    { 4130,a.INF, a.INF,	0,a.INF,a.INF,a.INF,a.INF, 3950,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF},             
					 	    {a.INF,a.INF, a.INF,a.INF,	  0, 1110,a.INF, 2330,a.INF,a.INF, a.INF,  490,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF, 1110,	0,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,  749},
					 	    {a.INF, 1990, a.INF,a.INF,a.INF,a.INF,	  0, 2750,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF, 1650,a.INF},
					 	    { 1190,a.INF, a.INF,a.INF, 2330,a.INF, 2750,	0,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF, 2580,a.INF},
					 	    {a.INF,a.INF, a.INF, 3950,a.INF,a.INF,a.INF,a.INF,	  0,  117,   667,a.INF,a.INF,a.INF,a.INF,a.INF},
					 	    { 1570,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,  117,	0, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,  667,a.INF, 	   0,   94, 1440,a.INF,a.INF,a.INF},
					 	    { 1840,a.INF, a.INF,a.INF,  490,a.INF,a.INF,a.INF,a.INF,a.INF,    94,	 0,a.INF,a.INF,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,  1440,a.INF,	   0, 1220,a.INF,a.INF},
					 	    {a.INF,  484, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF, 1220,	 0,a.INF,a.INF},
					 	    {a.INF,a.INF, a.INF,a.INF,a.INF,a.INF, 1650, 2580,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,	   0,  502},
					 	    {a.INF,a.INF,   565,a.INF,a.INF,  749,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF,a.INF,a.INF,  502,	 0}
				          };
     int JHunter[][] = { 
    		 			 {    0,  3320,a.INF, 1325,a.INF, 2010,a.INF,a.INF,a.INF, a.INF,a.INF}, 	
						 { 3420,     0,a.INF, 1530,a.INF,a.INF,  556,a.INF,a.INF, a.INF,a.INF},	
						 {a.INF, a.INF,    0, 1540,  479,  666,a.INF,a.INF,a.INF, a.INF,a.INF}, 	
						 { 1200,  1650, 1640,    0,a.INF,a.INF,a.INF,a.INF,a.INF, a.INF,a.INF},                 
						 {a.INF, a.INF,  520,a.INF,    0,a.INF,a.INF,  680,a.INF, a.INF,a.INF},
						 { 1800, a.INF,  750,a.INF,a.INF,    0,a.INF,a.INF,a.INF,  2300,a.INF}, 	
						 {a.INF,   625,a.INF,a.INF,a.INF,a.INF,    0, 1400,a.INF, a.INF,  775}, 	
						 {a.INF, a.INF,a.INF,a.INF,  840,a.INF, 1230,    0,a.INF,   721,  881},
						 {a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,a.INF,    0,   345,  461}, 
						 {a.INF, a.INF,a.INF,a.INF,a.INF, 2120,a.INF,  845,  321,     0,a.INF}, 
						 {a.INF, a.INF,a.INF,a.INF,a.INF,a.INF,  645,  971,  525, a.INF,    0} 
			           	};
     a.floydWarshall(AQPCenter);
	}

}
