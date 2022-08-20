package org.example;

class Math {
    public static int fibbonachi(int n) {
        if(n<0){
            return -1;
        }
        else if(n==0 || n==1){
            return n;
        }
        int fib_0=0;
        int fib_1=1;
        for(int i=2; i<=n; ++i){
            int fib_curr=fib_0+fib_1;
            fib_0=fib_1;
            fib_1=fib_curr;
        }
        return fib_1;
    };

    public static int factorial(int n)  {
        if(n<0){
            return -1;
        }
       int fact=1;
        for(int i=2;i<=n;++i){
            fact*=i;
        }
        return fact;
    };
}