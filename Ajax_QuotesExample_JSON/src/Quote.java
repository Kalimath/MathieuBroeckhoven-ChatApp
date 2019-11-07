import com.fasterxml.jackson.annotation.JsonIgnore;

public class Quote {
	
	private String author;
	private String quote;
	@JsonIgnore
	private int year;
	
	public Quote(String author, String quote, int year) {
		super();
		setAuthor(author);
		setQuote(quote);
		setYear(year);
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
}
