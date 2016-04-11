package poules;

import matrice.Matrice;

public class ChampionnatSimple {
	private PouleSimple pouleA,pouleB;
	private int equilibreDesPoule;
	private double distanceMoyenne;

	
	ChampionnatSimple (int a, int b, int c, int d, int e, int f, int g, int h, int i,int j,int k,int l,int m,int n,int o,int p,int q,int r, Matrice mat) {
		this.pouleA = new PouleSimple(new Equipe(a,mat),new Equipe(b,mat),new Equipe(b,mat),new Equipe(d,mat),new Equipe(e,mat),new Equipe(f,mat),new Equipe(h,mat),new Equipe(h,mat),new Equipe(i,mat));
		this.pouleB = new PouleSimple(new Equipe(j,mat),new Equipe(k,mat),new Equipe(l,mat),new Equipe(m,mat),new Equipe(n,mat),new Equipe(o,mat),new Equipe(p,mat),new Equipe(q,mat),new Equipe(r,mat));
		equilibreDesPoule = 0;
		int z;
		for ( z= 0; z < 9 ; z++) {
			equilibreDesPoule = equilibreDesPoule + Integer.max(pouleA.getEquipe(z).getClassement(), pouleB.getEquipe(z).getClassement()) - Integer.min(pouleA.getEquipe(z).getClassement(), pouleB.getEquipe(z).getClassement());
		}
		distanceMoyenne = (pouleA.getDistanceMoyenne() + pouleB.getDistanceMoyenne()) / 2 ;
	}
	
	ChampionnatSimple (int nbEqu,Matrice mat) {
		int [] t = FonctionsTransverse.tirage(nbEqu);
		this.pouleA = new PouleSimple(new Equipe(t[0],mat),new Equipe(t[1],mat),new Equipe(t[2],mat),new Equipe(t[3],mat),new Equipe(t[4],mat),new Equipe(t[5],mat),new Equipe(t[6],mat),new Equipe(t[7],mat),new Equipe(t[8],mat));
		this.pouleB = new PouleSimple(new Equipe(t[9],mat),new Equipe(t[10],mat),new Equipe(t[11],mat),new Equipe(t[12],mat),new Equipe(t[13],mat),new Equipe(t[14],mat),new Equipe(t[15],mat),new Equipe(t[16],mat),new Equipe(t[17],mat));
		equilibreDesPoule = 0;
		for (int i = 0; i < 9 ; i++) {
			equilibreDesPoule = equilibreDesPoule + Integer.max(pouleA.getEquipe(i).getClassement(), pouleB.getEquipe(i).getClassement()) - Integer.min(pouleA.getEquipe(i).getClassement(), pouleB.getEquipe(i).getClassement());
		}
		distanceMoyenne = (pouleA.getDistanceMoyenne() + pouleB.getDistanceMoyenne()) / 2 ;
	}

	public double getDistanceMoyenne() {
		return distanceMoyenne;
	}

	public double getEquilibreDesPoules() {
		return equilibreDesPoule;
	}
	
	public int getTaillePoule (){
		return 9;
	}
}
