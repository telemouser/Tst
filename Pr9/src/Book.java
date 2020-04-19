 public class Book implements Publication, Listenable { //
	static final int FAILURE = -1; //
	String name;				// назва книги 
	String author;  
	int pageCount;				// кількість сторінок
	int pageMark;			 	// остання прочитана сторінка (закладка)
	boolean isPaper;			// ознака наявності паперової версії
	boolean isDocFile; 			// ознака наявності текстового файлу
	boolean isAudioFile;  		// ознака наявності аудіофайлу
	int minuteCount; 			// кількість хвилин в аудіофайлу
	int listenMark; 			// остання прослухана хвилина (закладка)
	Book(String name, String author, int Count, boolean isPaper, boolean isAudioFile){
		this.name = name; this.author = author; 
		if(!isAudioFile) {
			this.isPaper = isPaper; this.isDocFile = !isPaper; 
			this.isAudioFile = false;
			this.pageCount = Count; this.pageMark = 0;
		}
		else {
			this.isPaper = this.isDocFile = false; 
			this.isAudioFile = true;
			this.minuteCount = Count; this.listenMark = 0;
		}
	}
	public int read(int count) {
		if(!this.isAudioFile) {
			System.out.printf("read method sets +%d pages book %s\n", count, this.name);
			if(this.pageMark + count > this.pageCount) 
				count = this.pageCount - this.pageMark;
			this.pageMark += count;
			return count;
		}
		else {
			System.out.printf("read method is not appliable for audiobook %s\n", this.name);
			return FAILURE;
		}
	}
	public int getReadMark() {
		if(!this.isAudioFile) return this.pageMark;
		else {
			System.out.printf("getReadMark method is not appliable for audiobook %s\n", this.name);
			return FAILURE; 
		}
	}
	public void setReadMark(int page) {
		if(!this.isAudioFile) {
			System.out.printf("setReadMark method sets %d pages book %s\n", page, this.name);
			if(page < this.pageCount) this.pageMark = page;
			else this.pageMark = this.pageCount;
		}	
		else System.out.printf("setReadMark method is not appliable for audiobook %s\n", this.name);
	}
	public void print() {
		if (this.isDocFile)
			System.out.printf("Printing Book %s Author %s Pages %d\n", this.name, this.author, this.pageCount);
		else
			System.out.printf("File of book %s is not available\n", this.name);
	}
	public void info() {
		System.out.printf("Book %s. Author %s. ", this.name, this.author);
		if(!this.isAudioFile) {
			if(this.isPaper)System.out.printf("This is paperBook. ");
			else System.out.printf("This is docFile. ");
			System.out.printf("Pages %d Pages read %d\n", this.pageCount, this.getReadMark());
		}
		else System.out.printf("AudioBook Minutes %d Minutes listen %d\n", this.minuteCount, this.getListenMark());
	}
	public int listen(int count) {
		if(this.isAudioFile) {
			if(this.listenMark + count > this.minuteCount) 
				count = this.minuteCount - this.listenMark;
			this.listenMark += count;
			return count;
		}
		else {
			System.out.printf("listen method is not appliable for paper or docfile book %s\n", this.name);
			return FAILURE;
		}
	}	
	public int getListenMark() {
		if(this.isAudioFile) return this.listenMark;
		else {
			System.out.printf("getlistenMark method is not appliable for paper or docfile book %s\n", this.name);
			return FAILURE; 
		}
	}
	public void setListenMark(int minute) {
		if(this.isAudioFile) {
			if(minute < this.minuteCount) this.listenMark = minute;
			else this.listenMark = this.minuteCount;
		}
		else System.out.printf("setlistenMark method is not appliable for paper or docfile book %s\n", this.name);
	}
}
