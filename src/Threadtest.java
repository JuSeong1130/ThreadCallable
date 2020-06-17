
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Threadtest {

	private static  int value=10;
	
	synchronized public void setValue(int value)
	{
		Threadtest.value=value;
		System.out.println(Threadtest.value);
	}
	
	public static void main(String[] args) throws Exception  {

	
		Callable<Integer> task1= () -> {
			int value=13;
			return value;
			
		};
		Callable<Integer> task2= () -> {
			int value=16;
			return value;
			
		};
		Callable<Integer> task3= () -> {
			int value=17;
			return value;
			
		};
	ExecutorService exr= Executors.newCachedThreadPool();
	Future<Integer> fur;
	Threadtest tt= new Threadtest();
	fur=exr.submit(task1);
	tt.setValue(fur.get());
	fur=exr.submit(task2);
	tt.setValue(fur.get());
	fur=exr.submit(task3);
	tt.setValue(fur.get());
	exr.shutdown();
	
	}
}
