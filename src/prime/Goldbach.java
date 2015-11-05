package prime;
import java.math.BigInteger;
import java.util.ArrayList;

public class Goldbach {
	RabinMiller ob = new RabinMiller();
	public   ArrayList<String> results= new ArrayList<String>();
	
	private  ArrayList<Integer> primes= new ArrayList<Integer>();
	
	public  void verify() {//��֤10000���ڵĸ�°ͺղ���

		for(int num=6;num<=10000;num+=2)   //������һ���Ż� maxIndex��������õ�������������±�
		{
			int maxIndex=0;
			while(primes.get(maxIndex)<9973)  //9973��10000���ڵ���������
			{ maxIndex++;
			}
	
			boolean flag = false;
			for(int i=0;i<=maxIndex;i++)//����ѭ���ж�Ѱ�����п��ܵ����
			{
				for(int j=maxIndex;j>=0;j--)
					if(primes.get(i)+primes.get(j)==num){
						String s =  num+"="+primes.get(i)+"+"+primes.get(j)+"\n";  //��ÿ�α���Ľ���浽�ַ�����
						results.add(s);
						flag=true;
						break;
					}
				if(flag) break;	
			}	
		}	
	}
	 public  void generatePrimes() {
		// primes�����ʼ�� ���10000���ڵ�����
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
	
	 

