import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ManageQuoteServlet")
public class ManageQuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuoteRepository quoteRepository;
		
	public ManageQuoteServlet() {
		super();
		quoteRepository = new QuoteRepository();
	}   	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteRepository.getRandomQuote(); //geeft willekeurige quote terug
		String quoteJSON = this.toJSON(quote); //zet quote om in JSON string
		response.setContentType("application/json"); //vul response header
		response.getWriter().write(quoteJSON); //commit response
	}  	
		
	public String toJSON (Quote quote) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); //create objectmapper instance
		return mapper.writeValueAsString(quote); //geeft quote inhoud als JSON string terug
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
