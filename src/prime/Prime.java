package prime;
import java.math.BigInteger;

public class Prime {
	public int numDigits = 0;//大素数的长度
	public BigInteger results=BigInteger.ONE ;//大素数初始化为1
	private  StringBuffer[] digits = { new StringBuffer("0"), new StringBuffer("1"), new StringBuffer("2"), new StringBuffer("3"), new StringBuffer("4"), new StringBuffer("5"), 
	        new StringBuffer("6"), new StringBuffer("7"), new StringBuffer("8"), new StringBuffer("9") }; 
	//用一个动态数组保存要生成的每一位
	private   BigInteger ZERO = BigInteger.ZERO; 
    private   BigInteger ONE = BigInteger.ONE; 
    private   BigInteger TWO = new BigInteger("2");
    private   int ERR_VAL = 100; //用于确定错误率
    

public void generate(){
	BigInteger start = bigRandom(numDigits);
	start = nextPrime(start);
	results = start;
}

private BigInteger nextPrime(BigInteger start) {
	// 产生一个比给定大整数 start 大的素数，错误率低于 1/2 的 ERR_VAL 次方 
    if (isEven(start)) 
        start = start.add(ONE); 
    else 
        start = start.add(TWO); 
    if (start.isProbablePrime(ERR_VAL)) //调用java的库函数实现
        return (start); 
    else  
        return (nextPrime(start));  //递归寻找 时间耗费主要在这里，下一个素数具有随机性，大整数长度越长，时间越慢。
}
private boolean isEven(BigInteger n) {//判断是否是偶数
    return (n.mod(TWO).equals(ZERO)); 
}

//随机产生一个首位不为 0 的大整数
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
    // 产生一个随机的数字（字符串形式的），isZeroOK 决定这个数字是否可以为 0 
    int index; 
    if (isZeroOK) 
        index = (int) Math.floor(Math.random() * 10);   //math.random 0.0-1.0之间
    else 
        index = 1 + (int) Math.floor(Math.random() * 9); 
    return (digits[index]); 
} 

}
