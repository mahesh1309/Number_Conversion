import java.util.*;

class Conversion{
    int dec;
    int fromBinary(String s){
        int slen=s.length();
        int bin=Integer.parseInt(s);
        int sum=0;
        int count=0;
        while(count<slen){
            if(bin%10>1){
                return -1;
            }
            sum+=(bin%10)*(int)Math.pow(2, count);
            count++;
            bin=bin/10;
        }
        return sum;
    }
    int fromOctal(String s){
        int slen=s.length();
        int oct=Integer.parseInt(s);
        int sum=0;
        int count=0;
        while(count<slen){
            if(oct%10>7){
                return -1;
            }
            sum+=(oct%10)*(int)Math.pow(8, count);
            count++;
            oct=oct/10;
        }
        return sum;
    }
    int fromHex(String s){
        int slen=s.length();
        int sum=0;
        int count=0;
        while(count<slen){
            int val=0;
            char ch=s.charAt(slen-count-1);
            if(ch>'F' || ch=='f'){
                return -1;
            }
            else if(ch=='A' || ch=='a'){
                val=10;
            }
            else if(ch=='B' || ch=='b'){
                val=11;
            }
            else if(ch=='C'|| ch=='c'){
                val=12;
            }
            else if(ch=='D'|| ch=='d'){
                val=13;
            }
            else if(ch=='E'|| ch=='e'){
                val=14;
            }
            else if(ch=='F'|| ch=='f'){
                val=15;
            }
            else{
                val=Integer.parseInt(String.valueOf(ch)) ;
            }
            sum+=val*(int)Math.pow(16, count);
            count++;
        }
        return sum;
    }
    String tobinary(int n){
        String s=Integer.toBinaryString(n);
        return s;
    }
    String toOctal(int n){
        return Integer.toOctalString(n);
    }
    String toHex(int n){
        return Integer.toHexString(n);
    }
}
public class Number_converter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n1.From Decimal 2.From Binary 3.From Octal 4.From Hexadecimal");
        System.out.print("Select an option:");
        int op=sc.nextInt();

        System.out.println("\n1.To Decimal 2.To Binary 3.To Octal 4.To Hexadecimal");
        System.out.print("Select an option:");
        int ops=sc.nextInt();

        System.out.print("Enter the value:");
        String inp=sc.next();
        int decs=0;
        Conversion c=new Conversion();
        do{
            switch(op){
                case 1:decs=Integer.parseInt(inp);
                        break;
                case 2:decs=c.fromBinary(inp);
                        break;
                case 3:decs=c.fromOctal(inp);
                        break;
                case 4:decs=c.fromHex(inp);
                        break;
                default: System.out.print("Select proper option");
            }
        }while(op>4);
        
        do{
            switch(ops){
                case 1:System.out.print(decs);
                        break;
                case 2:System.out.print(c.tobinary(decs));
                        break;
                case 3:System.out.print(c.toOctal(decs));
                        break;
                case 4:System.out.print(c.toHex(decs));
                        break;
                default: System.out.print("Select proper option");
            }
        }while(op>4);
        
        sc.close();
    }
}
