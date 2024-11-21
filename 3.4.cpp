#include<bits/stdc++.h>
using namespace std;
class Member{
    private:
    string name;
    string account_number;
    string type;
    double balance;
    public:
    Member(string name,string type="savings",double balance=0){
        this->name=name;
        account_number=to_string((rand() % (999999999999 - 100000000000 + 1))+100000000000);
        this->type=type;
        this->balance=balance;
    }
    void details(){
        cout<<"Name : "<<name<<endl;
        cout<<"Account Number : "<<account_number<<endl;
        cout<<"Type : "<<type<<endl;
    }
    void Balance(){
        cout<<"Balance amount is : "<<balance<<endl;
    }
    void deposit(double amount){
        balance+=amount;
        details();
        cout<<amount<<" RUPEES has been credited"<<endl;
        Balance();
    }
    void withdraw(double amount){
        if(amount>balance){
            details();
            cout<<"You have insufficient balance in your account"<<endl;
        }
        else{
            balance-=amount;
            details();
            cout<<amount<<" RUPEES has been debited"<<endl;
            Balance();
        }
    }
};
int main(){
    Member one("A","savings",10000);
    one.deposit(10000);
    one.withdraw(15000);
    Member two("A","savings",100000);
    two.deposit(200000);
    two.withdraw(1000000);
    Member three("A","savings",500); 
    three.deposit(1000);
    three.withdraw(1500);
return 0;
}