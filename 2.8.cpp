#include<bits/stdc++.h>
using namespace std;
class Bank{
    private:
    string name;
    int accno;
    double balance;
    public:
    Bank(){
        cout<<" A zero parameter constructer is used "<<endl;
        name=" ";
        accno=0;
        balance=0;
    }
    Bank(string name,int accno,double balance){
        cout<<" A parameter constructer is used "<<endl;
        this->name=name;
        this->accno=accno;
        this->balance=balance;
    }
    Bank(Bank &B){
        cout<<" A copy constructer is used "<<endl;
        this->name=B.name;
        this->accno=B.accno;
        this->balance=B.balance;
    }
    void Balance(){
        cout<<"Your current balance is "<<balance<<endl;
    }
    void deposit(double amount){
        balance+=amount;
        cout<<"Your current balance is "<<balance<<endl;
    }
    void withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            cout<<"Your current balance is "<<balance<<endl;
        }
        else{
            cout<<"insufficient balance"<<endl;
        }
    }
    void print(){
        cout<<"name of the account holder is "<<name<<endl;
        cout<<"account number of the account holder is "<<accno<<endl;
        cout<<"balance of the account holder is "<<balance<<endl;
    }
};
int main(){
    Bank customer1;
    Bank customer2("Rahul",123456,1000);
    customer2.deposit(500);
    customer2.withdraw(200);
    // customer2.Balance();
return 0;
}