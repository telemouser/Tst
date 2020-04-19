public class Journal implements Publication {//
	String name;			// назва журналу  
	int pageCount; 			// кількість сторінок
	int pageMark; 			// остання прочитана сторінка (закладка)
	boolean isPaper; 		// ознака наявності паперової версії
	boolean isDocFile; 		// ознака наявності текстового файлу
	Journal (String name, int pageCount, boolean isPaper){
		this.name = name; this.pageCount = pageCount;
		this.isPaper = isPaper; this.isDocFile = !isPaper;
	}
	public int read(int count) {
		System.out.printf("read method sets +%d pages book %s\n", count, this.name);
		if(this.pageMark + count > this.pageCount) 
			count = this.pageCount - this.pageMark;
		this.pageMark += count;
		return count;
	}
	public int getReadMark() {
		return this.pageMark;
	}
	public void setReadMark(int page) {
		System.out.printf("setReadMark method sets %d pages book %s\n", page, this.name);
		if(page < this.pageCount) this.pageMark = page;
		else this.pageMark = this.pageCount;	
	}
	public void print() {
		if (this.isDocFile)
			System.out.printf("Printing Journal %s Pages %d\n", this.name, this.pageCount);
		else
			System.out.printf("File of journal %s is not available\n", this.name);
	}
	public void info() {
		System.out.printf("Journal %s ", this.name);
		if(this.isPaper)System.out.printf("Paper");
		else System.out.printf("DocFile");
		System.out.printf("Pages %d Pages read %d\n", this.pageCount, this.pageMark);
	}
}
