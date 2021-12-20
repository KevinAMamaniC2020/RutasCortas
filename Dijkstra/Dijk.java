import java.util.*;
public class Dijk {
	public static void dijkstra(int[][] graph, int sourceVertex){
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; 
        for (int i = 0; i < vertexCount; i++){
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;
            for (int v =0 ; v < vertexCount; v++){
                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++){
            System.out.println(String.format("Distancia del vertice origen %s al vertice %s es %s", sourceVertex, i, distance[i]));
        }

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            //the vertex should not be visited and the distance should be the minimum.
            //this is similar to finding the min element of an array
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
    	//24nodos
    	int Cayma[][] = new int[][] { 	/*   A,   B,   C,   D,   E,   F,   G,   H,   I,   J,   K,   L,   M,   N,   O,   P,   Q,   R,   S,   T,   U,   V,   W,   X*/
			  						/*A*/{   0, 353,   0,   0,   0,   0,   0,   0,   0,   0,   0,1050,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*B*/{ 353,   0,   0,   0,   0,   0,   0,   0,   0,   0, 997,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*C*/{   0,   0,   0, 468,   0,   0,   0,   0,   0,   0,   0,   0, 980,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*D*/{   0,   0, 468,   0,   0,   0,   0,   0,   0,   0,   0,   0, 723,   0, 375,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*E*/{   0,   0,   0,   0,   0, 548,   0,   0,   0,   0,   0,   0,   0,   0,1350,   0,   0,1230, 686,   0,   0,   0,   0,   0},
									/*F*/{   0,   0,   0,   0, 548,   0,   0,   0,   0,   0,1100,   0,   0, 750,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*G*/{   0,   0,   0,   0,   0,   0,   0, 797,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 835, 386,   0,   0,   0,   0},
			  						/*H*/{   0,   0,   0,   0,   0,   0, 797,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1830,1200},
			  						/*I*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1740,   0, 807,   0},
			  						/*J*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 870, 478},
			  						/*K*/{   0, 997,   0,   0,   0,   0,   0,   0,3880,   0,   0, 269,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1320},
			  						/*L*/{1050,   0,   0,   0,   0,   0,   0,   0,   0,   0, 269,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2180},
			  						/*M*/{   0,   0, 980, 723,   0,   0,   0,   0,   0,   0,   0,   0,   0,1020, 737,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*N*/{   0,   0,   0,   0,   0, 750,   0,   0,   0,   0,   0,   0,1020,   0,   0,1460,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*O*/{   0,   0,   0, 375,1350,   0,   0,   0,   0,   0,   0,   0, 737,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*P*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1460,   0,   0, 319, 579,   0,   0,   0,   0,   0,   0},
			  						/*Q*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 319,   0,   0,   0,   0, 464,   0,   0,   0},
			  						/*R*/{   0,   0,   0,   0,1230,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 579,   0,   0,   0,   0, 492, 470,   0,   0},
			  						/*S*/{   0,   0,   0,   0, 686,   0, 835,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 798,   0,   0},
			  						/*T*/{   0,   0,   0,   0,   0,   0, 386,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 363,   0,   0},
			  						/*U*/{   0,   0,   0,   0,   0,   0,   0,   0,1740,   0,   0,   0,   0,   0,   0,   0, 464, 492,   0,   0,   0,   0,   0,   0},
			  						/*V*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 470, 798, 363,   0,    0,   0,   0},
			  						/*W*/{   0,   0,   0,   0,   0,   0,   0,1830, 807, 870,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
			  						/*X*/{   0,   0,   0,   0,   0,   0,   0,1200,   0, 478,1320,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
    								};

    	
    	//16 nodos
    	int JLBYRivero [][] = new int[][] { 	/*   A,   B,   C,   D,   E,   F,   G,   H,   I,   J,   K,   L,   M,   N,   O,   P*/
											/*A*/{   0,   0,   0,   0,   0,   0,1670,   0,   0,   0,   0,   0,   0,   0, 414, 654},
											/*B*/{   0,   0,1100,   0,   0,   0,   0, 606,   0,   0,   0,   0,   0,   0,   0,   0},
											/*C*/{   0,1100,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2360,1010,1120,   0},
											/*D*/{   0,   0,   0,   0,   0,   0,   0,   0,   0,1090,   0,   0,   0,   0,   0, 670},
											/*E*/{   0,   0,   0,   0,   0,   0,   0,   0,1010,   0,   0,   0,1760,   0,   0,   0},
											/*F*/{   0,   0,   0,   0,   0,   0,   0,   0,   0, 764,   0, 652,   0,1060,   0,   0},
											/*G*/{1670,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 524,   0},
											/*H*/{   0, 606,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0, 194,   0,   0},
											/*I*/{   0,   0,   0,   0,1010,   0,   0,   0,   0,   0,1130,   0,   0,   0,   0,   0},
											/*J*/{   0,   0,   0,   0,   0, 764,   0,   0,   0,   0, 398,   0,   0,   0,   0,   0},
											/*K*/{   0,   0,   0,   0,   0,   0,   0,   0,1130, 398,   0,   0,   0,   0,   0,   0},
											/*L*/{   0,   0,   0,   0,   0, 652,   0,   0,   0,   0,   0,   0, 401, 722,   0,   0},
											/*M*/{   0,   0,2360,   0,1760,   0,   0,   0,   0,   0,   0, 401,   0,   0,   0,   0},
											/*N*/{   0,   0,1010,   0,   0,1060,   0, 194,   0,   0,   0, 722,   0,   0,1780, 549},
											/*O*/{   0,   0,1120,   0,   0,   0, 524,   0,   0,   0,   0,   0,   0,1780,   0,   0},
											/*P*/{ 654,   0,   0, 670,   0,   0,   0,   0,   0,   0,   0,   0,   0, 549,   0,   0},
						
										};
		//7 nodos
    	int sabandia[][] = new int[][] { 	/*   A,   B,   C,   D,   E,   F,   G*/
										/*A*/{   0,3160,   0,5120,   0,4060,   0},
										/*B*/{3160,   0,   0,   0,   0,2920,   0},
										/*C*/{   0,   0,   0,2000,2280,   0, 520},
										/*D*/{5120,   0,2000,   0, 649,   0,   0},
										/*E*/{   0,   0,2280, 649,   0,   0,   0},
										/*F*/{4060,2920,   0,   0,   0,   0, 355},
										/*G*/{   0,   0, 520,   0,   0, 355,   0}
        							};
        
        dijkstra(Cayma, 19);
    }
}