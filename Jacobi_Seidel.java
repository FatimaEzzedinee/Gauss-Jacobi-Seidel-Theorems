import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Jacobi_Seidel {
	
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
		
		
		public static float[] Jacobi(float matrice[][],int l,int c)
		{
			float xi[]=new float[c];
			float xip1[]=new float[c];
			int iteration=100;
			
			for(int k=0;k<iteration;k++)
			{
				for(int i=0;i<l;i++)
				{
				float s=0;
				for(int j=0;j<c-1;j++)
				{
					if(j!=i)
					s+=matrice[i][j]*xi[j];
				}
				//xi[i]=xip1[i];    //solution xi
				xip1[i]=(1/matrice[i][i])*(matrice[i][c-1]-s); // x0 xi+1
				}
				//calcule de difference entre xi et xi+1 pour detecter si erreur negligable
				int u=0;
				for(u=0;u<c-1;u++)
				{
					float moy=0;
					moy=Math.abs((xip1[u]-xi[u])/xi[u])*100;
					if(moy>=0.05)
						break;
				}
				if(u==l)
				{
					System.out.println("Iteration d'arret de nb "+k);
					break;
				}
				for (int b=0;b<xi.length;b++)
					xi[b]=xip1[b]; 
			}
			return xip1;
		}
		
		public static float[] Seidel(float matrice[][],int l,int c)
		{
			float xi[]=new float[c];
			float xip1[]=new float[c];
			int iteration=100;
			
			for(int k=0;k<iteration;k++)
			{
				for(int i=0;i<l;i++)
				{
				float s=0;
				for(int j=0;j<c-1;j++)
				{
					if(j!=i)
					s+=matrice[i][j]*xip1[j];
				}
				xi[i]=xip1[i];    //solution xi
				xip1[i]=(1/matrice[i][i])*(matrice[i][c-1]-s); // x0 xi+1
				}
				//calcule de difference entre xi et xi+1 pour detecter si erreur negligable
				int u=0;
				for(u=0;u<c-1;u++)
				{
					float moy=0;
					moy=Math.abs((xip1[u]-xi[u])/xi[u])*100;
					if(moy>=0.05)
						break;
				}
				if(u==l)
				{
					System.out.println("Iteration d'arret de nb "+k);
					break;
				} 
			}
			return xip1;
		}
		
	}
	

