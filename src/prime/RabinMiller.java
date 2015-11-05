package prime;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
 
public class RabinMiller{
	    public  int Times = 10;
	    
	    public  BigInteger quick_mod(BigInteger a,BigInteger b,BigInteger m){
	    	// Montgomery�㷨���ټ��㣨x^y��%z
	    		BigInteger ans = BigInteger.ONE;
	    		a = a.mod(m);//a=a%m
	    		while(!(b.equals(BigInteger.ZERO))){//b��Ϊ0ʱ
	    				if((b.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)){//���bΪ����
	    						ans = (ans.multiply(a)).mod(m);//ans = ans*a ��mod m��
	    						b = b.subtract(BigInteger.ONE);//b = b-1
	    				}
	    				b = b.divide(BigInteger.valueOf(2)); //bΪb����2֮�������
	    				a = (a.multiply(a)).mod(m); //aΪa*a mod��m��
	    		}
	    		return ans;
	    }
	    
	 	public boolean IsPrime(BigInteger n){ //RabinMiller�㷨
	 			if(n.equals(BigInteger.valueOf(2))) return true;
	 			if(n.equals(BigInteger.ONE)) return false;
	 			if((n.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)) return false;
	 			//RabinMiller
	 			BigInteger m = n.subtract(BigInteger.ONE);  //n-1
	 			BigInteger y = BigInteger.ZERO;
	 			int k = 0;   // k��ָ��
	 			while((m.mod(BigInteger.valueOf(2))).equals(BigInteger.ZERO)){
	 					k++;
	 					m = m.divide(BigInteger.valueOf(2));
	 			}// N-1 = m*2^k
	 			Random d = new Random();
	 			for(int i=0;i<Times;i++){
	 				    int t = 0;
	 				    if(n.compareTo(BigInteger.valueOf(10000)) == 1){
	 				    		t = 10000;  //n>10000 t=10000
	 				    }else{
	 				    	    t = n.intValue() - 1;  //n-1
	 				    }
	 					int a = d.nextInt(t) + 1; // ���Ȳ��� ����� 1<=a<=t
	 					BigInteger x = quick_mod(BigInteger.valueOf(a),m,n);//x =a^m (mod n)
	 				 						
	 					for(int j=0;j<k;j++)
	 					{
	 						  	y = (x.multiply(x)).mod(n);  //y = x^2 (mod n)
	 							if(y.equals(BigInteger.ONE) 
	 									&& !(x.equals(BigInteger.ONE)) 
	 									&& !(x.equals(n.subtract(BigInteger.ONE)))) return false;
	 							//y=1 x��=1 x��=n-1  �� ����
	 							x = y;
	 					}
	 					if(!(y.equals(BigInteger.ONE))) return false;  //y ������1 �Ǻ���
	 			}
	 			return true;
	 	}
}

 