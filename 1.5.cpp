#include<bits/stdc++.h>
using namespace std;
struct Arthimetic{
    int num1;
    int num2;
    void input(){
        cout<<"enter num1 "<<endl;
        cin>>num1;
        cout<<"enter num2 "<<endl;
        cin>>num2;
    }
    void add(){
       cout<<"addition of two numbers "<<num1+num2<<endl;
    }
    void sub(){
       cout<<"subraction of two numbers "<<num1-num2<<endl;
    }
    void multi(){
        cout<<"multiplication of two numbers "<<num1*num2<<endl;
    }
    void div(){
        cout<<"division of two numbers "<<num1/num2<<endl;
    }
};
int main(){
    struct Arthimetic object1;
    object1.input();
    object1.add();
    object1.sub();
    object1.multi();
    object1.div();
return 0;
}