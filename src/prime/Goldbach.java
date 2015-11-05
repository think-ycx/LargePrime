package prime;
import java.math.BigInteger;
import java.util.ArrayList;

public class Goldbach {
	RabinMiller ob = new RabinMiller();
	public   ArrayList<String> results= new ArrayList<String>();
	
	private  ArrayList<Integer> primes= new ArrayList<Integer>();
	
	public  void verify() {//验证10000以内的哥德巴赫猜想

		for(int num=6;num<=10000;num+=2)   //首先做一个优化 maxIndex代表可能用到的最大素数的下标
		{
			int maxIndex=0;
			while(primes.get(maxIndex)<9973)  //9973是10000以内的最大的素数
			{ maxIndex++;
			}
	
			boolean flag = false;
			for(int i=0;i<=maxIndex;i++)//二重循环判断寻找所有可能的情况
			{
				for(int j=maxIndex;j>=0;j--)
					if(primes.get(i)+primes.get(j)==num){
						String s =  num+"="+primes.get(i)+"+"+primes.get(j)+"\n";  //把每次保存的结果存到字符串里
						results.add(s);
						flag=true;
						break;
					}
				if(flag) break;	
			}	
		}	
	}
	 public  void generatePrimes() {
		// primes数组初始化 存放10000以内的素数
		for(int i=0;i<=10000;i+=1){
			if(ob.IsPrime(BigInteger.valueOf(i))){
				primes.add(i);
			}
		}
	}
/*	 public static void main(String[] args) {
			Goldbach g = new Goldbach();
			g.generatePrimes();
			g.verify();
			g.showPrimes();
			
		}*/
}	 
	
	 

