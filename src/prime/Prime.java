package prime;
import java.math.BigInteger;

public class Prime {
	public int numDigits = 0;//�������ĳ���
	public BigInteger results=BigInteger.ONE ;//��������ʼ��Ϊ1
	private  StringBuffer[] digits = { new StringBuffer("0"), new StringBuffer("1"), new StringBuffer("2"), new StringBuffer("3"), new StringBuffer("4"), new StringBuffer("5"), 
	        new StringBuffer("6"), new StringBuffer("7"), new StringBuffer("8"), new StringBuffer("9") }; 
	//��һ����̬���鱣��Ҫ���ɵ�ÿһλ
	private   BigInteger ZERO = BigInteger.ZERO; 
    private   BigInteger ONE = BigInteger.ONE; 
    private   BigInteger TWO = new BigInteger("2");
    private   int ERR_VAL = 100; //����ȷ��������
    

public void generate(){
	BigInteger start = bigRandom(numDigits);
	start = nextPrime(start);
	results = start;
}

private BigInteger nextPrime(BigInteger start) {
	// ����һ���ȸ��������� start ��������������ʵ��� 1/2 �� ERR_VAL �η� 
    if (isEven(start)) 
        start = start.add(ONE); 
    else 
        start = start.add(TWO); 
    if (start.isProbablePrime(ERR_VAL)) //����java�Ŀ⺯��ʵ��
        return (start); 
    else  
        return (nextPrime(start));  //�ݹ�Ѱ�� ʱ��ķ���Ҫ�������һ��������������ԣ�����������Խ����ʱ��Խ����
}
private boolean isEven(BigInteger n) {//�ж��Ƿ���ż��
    return (n.mod(TWO).equals(ZERO)); 
}

//�������һ����λ��Ϊ 0 �Ĵ�����
private BigInteger bigRandom(int numDigits) {
	StringBuffer s = new StringBuffer(""); 
    for (int i = 0; i < numDigits; i++) 
        if (i == 0) 
            s.append(randomDigit(false)); 
        else 
            s.append(randomDigit(true)); 
    return (new BigInteger(s.toString())); 
}
private  StringBuffer randomDigit(boolean isZeroOK) { 
    // ����һ����������֣��ַ�����ʽ�ģ���isZeroOK ������������Ƿ����Ϊ 0 
    int index; 
    if (isZeroOK) 
        index = (int) Math.floor(Math.random() * 10);   //math.random 0.0-1.0֮��
    else 
        index = 1 + (int) Math.floor(Math.random() * 9); 
    return (digits[index]); 
} 

}
