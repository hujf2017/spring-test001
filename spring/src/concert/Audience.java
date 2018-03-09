package concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class Audience {
	public Audience(){
		String a ="111";
	}	
	@Pointcut("execution (**.perform(..))")  //�����е���ʽ һ�θ���
	public void performance(){}
	

	@Before("Performance()")
	public void  TakeSeats(){
		System.out.print("Take you Seats");
	}
	
	@AfterReturning("Performance()")
	public void applause(){
		System.out.print("CLAP CLAP CLAP");
	}
	
}
