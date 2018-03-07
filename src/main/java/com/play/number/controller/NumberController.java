package com.play.number.controller;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.play.number.model.EqualityCheckerInterface;
import com.play.number.model.RandomNumberBean;

@Controller
public class NumberController {

	//private AtomicInteger count = new AtomicInteger(1);
	RandomNumberBean randomNumberBean = new RandomNumberBean();
	//int randomNumber = generateRandomNum();
	int attempt =randomNumberBean.getAttempt();
	 
	@RequestMapping("/")
	public String index() {
		randomNumberBean.setRandomNumber(generateRandomNum());
		randomNumberBean.setAttempt(resetAttempt());
		System.out.println("Random Number ::"+randomNumberBean.getRandomNumber());
		randomNumberBean.setMessage("");
	  return "index";
   }

   @RequestMapping(value="/guess", method=RequestMethod.POST)
   public String checkRandomNumber(
		   @RequestParam("number") int number, 
		   ModelMap model) {
	   
	   attempt+=1;
	   // attempt = count.getAndIncrement();
	   randomNumberBean.setAttempt(attempt);
	   randomNumberBean.setUserGuess(number);
	   randomNumberBean.setMessage(checkRandomNumber(randomNumberBean));
	   model.addAttribute("message", randomNumberBean.getMessage());
	   return "index";
   }
	// generate a random random number
	
   public String checkRandomNumber(RandomNumberBean number){
		int numberDifference = 0;
		try{
			// Just to show that we can use Lamda syntax for such cases
			EqualityCheckerInterface eqChecker = ((n1,n2) -> {
				return (n1==n2) ? n1-n2: ((n1>n2)?n1-n2:n2-n1);
			});
			//System.out.println("number.getAttempt()"+number.getAttempt());
			numberDifference = eqChecker.checkEquality(number.getRandomNumber(), number.getUserGuess());
			
			if(number.getMessage().contains("Right")){
				number.setMessage("You have already guessed Right Answer: "+number.getRandomNumber());
			}
			else if(numberDifference == 0 && number.getAttempt()<=3){
				number.setMessage("Right Answer ! Your Guess is:"+number.getUserGuess());
			}	
			else if(number.getAttempt()<=3){					
				switch(numberDifference){
					case 1:
						number.setMessage("Your Guess is:"+number.getUserGuess()+"(hot)");
						break;
					case 2: 
						number.setMessage("Your Guess is:"+number.getUserGuess()+"(warm)");
						break;
					default:
						number.setMessage("Your Guess is:"+number.getUserGuess()+"(cold)");
				}
			}
			else
			{
				number.setMessage("You have exceeded 3 times");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			return number.getMessage();
	}

	public int generateRandomNum() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10) + 1;
		return randomNum;
	}
	
	// reset attempt
	public int resetAttempt() {
		attempt = 0;
		return attempt;
	}
}