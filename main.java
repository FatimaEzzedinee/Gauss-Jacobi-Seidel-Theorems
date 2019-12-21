import java.util.Date;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float matrice[][]=Gauss.lire_fichier_get_matrix();
		 long start=System.nanoTime();
		float fin[][]=Gauss.Matrice_solution(matrice,Gauss.nb_ligne,Gauss.nb_colone);
		System.out.println("Matrice initiale : ");
		Gauss.print_Matrix(matrice, Gauss.nb_ligne,Gauss.nb_colone );
		System.out.println("-------------------------------------------");
		System.out.println("Methode de Gauss Jordan ");
		//Gauss.print_Matrix(fin,Gauss.nb_ligne,Gauss.nb_colone);
		//System.out.println(" Fin ? Diagonale ? "+Gauss.matrice_diagonale(fin,Gauss.nb_ligne, Gauss.nb_colone) );
		float solution[]=new float[Gauss.nb_ligne];
		for(int i=Gauss.nb_ligne-1;i>=0;i--)
		{
			float l=0;
			for(int j=0;j<Gauss.nb_colone-1;j++)
			{
				l+=fin[i][j]*solution[j];
			}
			solution[i]=(fin[i][Gauss.nb_colone-1]-l)/fin[i][i];
			System.out.println(solution[i]);
		}
		for(int i=0;i<solution.length;i++)
		{
			System.out.println("x"+(i+1)+"="+solution[i]);
		}
		 long end=System.nanoTime();	 
		 System.out.println("Time in ms methode de Gauss-Jordan :"+(end-start)/1000);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Methode de Jacobi ");
		 long start1=System.nanoTime();
		float matrice2[][]=Jacobi_Seidel.lire_fichier_get_matrix();
		//Seidel.print_Matrix(matrice2, Seidel.nb_ligne, Seidel.nb_colone);
		float fin2[]=Jacobi_Seidel.Jacobi(matrice2,Jacobi_Seidel.nb_ligne,Jacobi_Seidel.nb_colone);
		for(int i=0;i<fin2.length;i++)
		{
			System.out.println("x"+i + " = "+fin2[i]);
		}
		long end1=System.nanoTime();
		System.out.println("Method de jacobi en ms: "+(end1-start1)/1000);
		System.out.println("-------------------------------------------");
		System.out.println("Methode de Seidel ");
		long start2=System.nanoTime();
		float fin3[]=Jacobi_Seidel.Seidel(matrice2,Jacobi_Seidel.nb_ligne,Jacobi_Seidel.nb_colone);
		for(int i=0;i<fin2.length;i++)
		{
			System.out.println("x"+i + " = "+fin3[i]);
		}
		long end2=System.nanoTime();
		System.out.println("Method de Seidel en ms :"+(end2-start2)/1000);
	}
	

}
