#include<bits/stdc++.h>
using namespace std;
class Individual{
    private:
    string name;
    double income;
    double tax=0;
    public:
    Individual(string name,double income){
        this->name=name;
        this->income=income;
        tax=0;
    }
    void compute(){
        if(income<=100000) tax=0;
        else if(income>=100001 && income<=150000){
            tax=0.1*(income-100000);
        }
        else if(income>150000 && income<=200000){
            tax=0.2*(income-150000);
        }
        else{
            tax=0.2*(income-200000);
        }
    }
    void output(){
        compute();
        cout<<"Name : "<<name<<endl;
        cout<<"Tax to be paid is : "<<tax<<endl;
    }
};
int main(){
    Individual I1("A",50000);
    I1.output();
    Individual I2("B",150000);
    I2.output();
    Individual I3("C",200000);
    I3.output();
    Individual I4("D",500000);
    I4.output();
    Individual I5("E",1000000);
    I5.output();
return 0;
}