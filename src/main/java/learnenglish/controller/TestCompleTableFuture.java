package learnenglish.controller;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCompleTableFuture {
	@GetMapping("hello-compleFuture")
	public void testCompleFuture(HttpServletResponse response ) throws InterruptedException, ExecutionException, IOException {
		System.out.println("Start test ComleFuture!");
		
		CompletableFuture.runAsync(()->{
			System.out.println("Start completable Future");
			System.out.println("Running .......");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Running done");
		});
//		comple.get();
		System.out.println("Return result from ComplerTableFuture");
//		"Return";
		response.sendRedirect("save-word");
	}
}
