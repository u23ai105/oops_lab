#include<bits/stdc++.h>
using namespace std;
class Complex{
    private:
    double real;
    double img;
    public:
    Complex(double r=0.0,double i=0.0) : real(r),img(i) {}
    inline void multiply(const Complex& other){
        Complex result;
        result.real=this->real*other.real - this->img*other.img;
        result.img=this->real*other.img + this->img*other.real;
        result.display();
    }
    void display(){
        if(img>=0) cout<<"The complex number is "<<real<<" + "<<img<<"i"<<endl;
        else cout<<"The complex number is "<<real<<" - "<<-1*img<<"i"<<endl;
    }
};
int main(){
    Complex c1(2.0,3.0);
    Complex c2(2.0,-3.0);
    Complex c3(-2.0,3.0);
    Complex c4(-2.0,-3.0);
    c1.multiply(c2);
    c1.multiply(c3);
    c1.multiply(c4);
    c2.multiply(c3);
    c2.multiply(c4);
    c3.multiply(c4);
return 0;
}