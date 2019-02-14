
import java.util.Scanner;
import java.util.Stack;



public class springerproblemet
{
    
    private static String FRI = "O", VEI = "X";
    private static int telle = 0;
    private static int n = 6;
    static Stack<String> Trekk = new Stack<String>();
    private static String L[][];

    public static boolean finnVei(int i, int j)
    {
    	//Markerer steget vi har kommet til
    	L[i][j] = VEI;
    	telle++;
	
    	// Sjekker om springeren har vaert paa hele brettet og returnerer true slik at veien kan bygges rekursivt.
	if (full())
	{
	    return true;
	}
	

	//HOYRE OPP. Sjekker om ruten er ledig.
	if (j < n-2 && i > 0 && L[i-1][j+2] == FRI)
	{	 
		// Sjekker vei videre.
	    if (finnVei(i-1,j+2))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i-1) + "," + (j+2) + ")");   
		L[i][j] = VEI;
		return true;
	    }
	}
	//HOYRE NED
	if (j < n-2 && i < n-1 && L[i+1][j+2] == FRI)
	{	    
		 
	    if (finnVei(i+1,j+2))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i+1) + "," + (j+2) + ")");
		L[i][j] = VEI;
		return true;
	    }
	}
	// NED VENSTRE
	if (i < n-2 && j > 0 && L[i+2][j-1] == FRI)
	{	
		 
	    if (finnVei(i+2,j-1))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i+2) + "," + (j-1) + ")");
		L[i][j] = VEI;
		return true;
	    }
	}
	// NED HOYRE
	if (i < n-2 && j < n-1 && L[i+2][j+1] == FRI)
	{	    
		 
	    if (finnVei(i+2,j+1))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i+2) + "," + (j+1) + ")");	 
		L[i][j] = VEI;
		return true;
	    }
	}

	// VENSTRE OPP
	if (j-1 > 0 && i > 0  && L[i-1][j-2] == FRI)
	{	    
		 
	    if (finnVei(i-1,j-2))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i-1) + "," + (j-2) + ")");	 
		L[i][j] = VEI;
		return true;
	    }
	}

	// VENSTRE NED
	if (j-1 > 0 && i < n-1 && L[i+1][j-2] == FRI)
	{	    
		 
	    if (finnVei(i+1,j-2))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i+1) + "," + (j-2) + ")");	 
		L[i][j] = VEI;
		return true;
	    }
	}
	// OPP HOYRE
	if (i-1 > 0 && j < n-1 && L[i-2][j+1] == FRI)
	{	     
	    if (finnVei(i-2,j+1))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i-2) + "," + (j+1) + ")");	 
		L[i][j] = VEI;
		return true;
	    }
	}
	// OPP VENSTRE
	if (i-1 > 0 && j > 0 && L[i-2][j-1] == FRI)
	{	    
		
	    if (finnVei(i-2,j-1))
	    {
	    Trekk.push("fra (" + (i) + "," + (j) + ") Til (" + (i-2) + "," + (j-1) + ")");	 
		L[i][j] = VEI;
		return true;
	    }

	}
    
	//Blindvei. Returnerer false og setter rute til aa vaere fri.
    	L[i][j] = FRI;
    
	return false;
    }

    private static boolean full() {
    	for (int i = 0; i < n; i++)	
        {
    		for (int j = 0; j < n; j++)
    		{
    			if (L[i][j] == "O")
	    		return false;
    		}
        }
    	return true;
	}

	public static void main(String args[])
    {
		Scanner in = new Scanner(System.in);
		System.out.println("Hvor stort skal brettet vaere? (n X n, n > 6 er dumt) Velg n:");
		n = Integer.parseInt(in.nextLine());
		System.out.println("Startposisjon X? (mellom 0 og " + n + ")");
		int x = Integer.parseInt(in.nextLine());
		System.out.println("Startposisjon Y? (mellom 0 og " + n + ")");
		int y = Integer.parseInt(in.nextLine());
		in.close();
	// Oppretter 2D-tabell som lagrer brettet
	L = new String[n][n];

	// Fyller brettet L med ubsoekte ruter.
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		    L[i][j] = FRI;


	boolean funnetVei = finnVei(x,y);
	while (!Trekk.isEmpty())
		System.out.println(Trekk.pop());
	
	/* Skriver ut brettet
	System.out.println();
	for (int i = 0; i < n; i++)	
        {
	    for (int j = 0; j < n; j++)
	    {
		    System.out.print(L[i][j] + " - ");
	    }
	    System.out.println("");
  	} */

	System.out.println("Antall forsøk på å finne vei: " + telle);
	if (!funnetVei)
	    System.out.println("Fant ikke rute for springeren gjennom hele brettet");

    }
}