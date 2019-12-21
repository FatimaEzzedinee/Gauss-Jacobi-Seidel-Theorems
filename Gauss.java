import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Gauss {
	static int nb_ligne=0;
	static int nb_colone=0;
	
	public static  float[][] lire_fichier_get_matrix()
	{
		Scanner in;
		int i=0;
		int l=0;
		try {
			in = new Scanner(new File("DataSet.txt"));
			
			String one=in.nextLine();
			i++;
			String t3[]=one.split("\t");
			l=t3.length;
			
			while(in.hasNext())
			{
				one=in.nextLine();
				//System.out.prfloatln(one);
				i++;
			}
			//System.out.prfloatln(i);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		nb_ligne=i;
		
		float numbers[][]=new float[i][l];
		int k=0;
		try {
			Scanner in2 = new Scanner(new File("DataSet.txt"));
			
			String one2=in2.nextLine();
			String t2[]=one2.split("\t");
			
			for(int j=0;j<t2.length;j++)
			{
				
				float f=(float)Float.parseFloat(t2[j]);
				numbers[k][j]=f;
			}
			k++;
			
			while(in2.hasNext())
			{
				one2=in2.nextLine();
				String t[]=one2.split("\t");
				
				for(int j=0;j<t.length;j++)
				{
					numbers[k][j]=(float) Double.parseDouble(t[j]);
				}
				nb_colone=t.length;
				k++;
			}
			
			in2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numbers;	
	}
	
	public static void print_Matrix(float[][] m,int l,int c)
	{
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<c;j++)
				System.out.print(m[i][j]+"\t");
			
			System.out.print("\n");
		}
	}
	
	public static boolean matrice_diagonale(float matrice[][],int l,int c)
	{
		int i=0,k;
		for(i=1;i<l;i++)
		{
			for( k=0;k<i;k++)
			{
				if(matrice[i][k]!=0)
					break;
			}
			if(k!=i)
				break;
		}
		if(i==l)
		{
			System.out.println("Matrice diagonalise ");
			return true;
		}
		System.out.println("Matrice non diagonalise");
		return false;
	}
	
	
	
	public static float[][] Matrice_solution(float matrice[][],int l,int c)
	{
		float fin[][]=new float[l][c];
		for(int i=0;i<l;i++)
			for(int j=0;j<c;j++)
				fin[i][j]=matrice[i][j];
		
		if(!matrice_diagonale(matrice,l,c))
		{
		for(int k=0;k<l-1;k++)
		{
			if (fin[k][k]==0) {
				int j;
				for (j=k; j<l ;j++) {
					if (fin[j][k]!=0) {
						for (int d=0; d<c; d++) {
							float tmp = fin[k][d];
							fin[k][d]=fin[j][d];
							fin[j][d]= tmp;
						}
					break;
					}
				}
				if (j==l) System.out.println("impossible");
			}
			
			for(int i=k+1;i<l;i++)
			{
				float Mik=fin[i][k];
				float Mkk=fin[k][k];
				float kk[] = new float[c],ll[] = new float[c];
				for(int u=0;u<c;u++)
				{
					kk[u]=fin[k][u];
					ll[u]=fin[i][u];
					fin[i][u]=ll[u]-(Mik/Mkk)*kk[u];
				}
			}
		}
		return fin;
		}
		else {
			return matrice;
		}
		
	}

}
