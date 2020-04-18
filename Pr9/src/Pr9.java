interface Printable {
	void print();
}
interface Readable {
	int read(int pageCount);
	int getReadMark();
	void setReadMark(int page);
}	
interface Publication extends Printable, Readable {
	void info();
}
interface Listenable {
	int listen(int minute);
	int getListenMark();
	void setListenMark(int minute);
}	

public class Pr9 {
	 public static void main(String[] args) {
		 Publication P[] = new Publication[5];
		 P[0] = new Book("Kuuevo", "Kukin", 300, true, false);
		 P[1] = new Journal("Kuuevo Tech.",  70, false);
		 P[2] = new Book("Kuuevo 2", "Kukin Jr", 320, false, false);
		 P[3] = new Journal("Kuuevo Art", 120, true);
		 P[4] = new Book("Kuuevo. Comeback", "Kukin Jr2", 220, false, true);
		 SetReadMarkPublication(P);
		 SetListenMarkPublication(P);
		 ReadPublication(P);
		 ListenPublication(P);
		 PrintPublication(P);
	 }
	 static void SetReadMarkPublication(Publication P[]) {
		 System.out.printf("\n-< setReadMark method >-\n");
		 for(int i = 0; i < 5; i++) {
			 P[i].setReadMark(RandIntRange(0, 500));
			 P[i].info();
		 }
	 }
	 static void SetListenMarkPublication(Publication P[]) {
		 System.out.printf("\n-< setListenMark method >-\n");
		 for(int i = 0; i < 5; i++) {
			 if (P[i] instanceof Listenable)((Listenable)P[i]).setListenMark(RandIntRange(0, 500));
			 P[i].info();
		 }
	 }
	 static void ReadPublication(Publication P[]) {
		 System.out.printf("\n-< read method >-\n");
		 for(int i = 0; i < 5; i++) {
			 P[i].read(RandIntRange(0, 500));
			 P[i].info();
		 }
	 }
	 static void ListenPublication(Publication P[]) {
		 System.out.printf("\n-< listen method >-\n");
		 for(int i = 0; i < 5; i++) {
			 if(P[i] instanceof Listenable)((Listenable) P[i]).listen(RandIntRange(0, 500));
			 P[i].info();
		 }
	 }
	 static void PrintPublication(Publication P[]) {
		 System.out.printf("\n-< print method >-\n");
		 for(int i = 0; i < 5; i++)  P[i].print();
	 }
	 static int RandIntRange(int lowValue, int upperValue) {
		return lowValue + (int)(Math.random()*((upperValue - lowValue) + 1));
	 }

}
