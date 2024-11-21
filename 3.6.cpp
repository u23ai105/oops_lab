#include<bits/stdc++.h>
using namespace std;
class B;
class A{
    private:
    double a;
    public:
    A(double a){
        this->a=a;
    }
    friend void mean(A,B);
};
class B{
    private:
    double b;
    public:
    B(double b){
        this->b=b;
    }
    friend void mean(A,B);
};
void mean(A a1,B b1){
        cout<<"mean of a and b is "<<(a1.a+b1.b)/2<<endl;
    }
int main(){
    A a1(10);
    B b1(20);
    mean(a1,b1);
return 0;
}