#include<bits/stdc++.h>
using namespace std;
class Bill{
    private:
    string name;
    int call_count;
    double cost=0;
    public:
    Bill(string name,int call_count){
        this->name=name;
        this->call_count=call_count;
    }
    void compute(){
        if(call_count>0 && call_count<=100) cost+=200;
        else if(call_count>100 && call_count<=150) cost+=200+0.6*(call_count-100);
        else if(call_count>150 && call_count<=200) cost+=200+0.6*50+0.5*(call_count-150);
        else if(call_count>200) cost+=200+0.6*50+0.5*50+0.4*(call_count-200);
    }
    void output(){
        compute();
        cout<<"Name : "<<name<<endl;
        cout<<"cost to be paid is : "<<cost<<endl;
    }
};
int main(){
    Bill b1("A",0);
    b1.output();
    Bill b2("B",100);
    b2.output();
    Bill b3("C",150);
    b3.output();
    Bill b4("D",200);
    b4.output();
    Bill b5("E",1000);
    b5.output();
return 0;
}