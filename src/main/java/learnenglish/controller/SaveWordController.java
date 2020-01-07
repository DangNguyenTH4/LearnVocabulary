package learnenglish.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learnenglish.model.ListWord;
import learnenglish.model.Message;
import learnenglish.model.Word;
import learnenglish.service.SaveWordService;

@RestController
public class SaveWordController {
	@Autowired
	private SaveWordService saveWordService;
//	private static Logger logger = LoggerFactory.getLogger(SaveWordController.class);
	@PostMapping("save-word")
	public ResponseEntity<String> saveWord(@RequestBody Word word) throws IOException {
		
		System.out.println(word);
		Message result = saveWordService.saveWord(word);
		return new ResponseEntity<String>(result.getMessage(),result.getStatus());
	}
	
	@GetMapping("read-word")
	public ListWord readWord() throws IOException {
		throw new RuntimeException("Read word ex");
//		ListWord lst = saveWordService.readWord();
//		return lst;
	}
	
	
//	@ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        System.out.println("Handle");
//        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//	
}
