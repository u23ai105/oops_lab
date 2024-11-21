#include<bits/stdc++.h>
using namespace std;
class employ{
    private:
    string name;
    double earning;
    double bonus=0;
    public:
    employ(string name,double earning){
        this->name=name;
        this->earning=earning;
    }
    void compute(){
        if(earning>=2000){
            bonus=0.1*earning;
        }
    }
    void info(){
        compute();
        cout<<"Name : "<<name<<endl;
        cout<<"Bonus : "<<bonus<<endl;
    }
};
int main(){
    employ e1("A",1000);
    e1.info();
    employ e2("B",2000);
    e2.info();
    employ e3("C",10000);
    e3.info();
    employ e4("D",100000);
    e4.info();
    employ e5("E",1000000);
    e5.info();
return 0;
}