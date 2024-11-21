#include<bits/stdc++.h>
using namespace std;
struct employee{
       string name;
       int calls;
       float cost;
       void getdata(){
        cout << "Enter name"<<endl;
        cin>>name;
        cout << "Enter number of calls"<<endl;
        cin>>calls;
       }
       void total(){
        if(calls<=100) cost=200;
        else if(calls<=150) cost=200+0.6*(calls-100);
        else if(calls<=200) cost=200+0.6*(50)+(calls-150)*0.5;
        else  cost=200+0.6*(50)+50*0.5+(calls-200)*0.4;
       }
       void print(){
        cout<<"Name "<<name<<endl;
        cout<<"number of calls "<<calls<<endl;
        cout<<"biit amount "<<cost<<endl; 
       }
};
int main(){
    struct employee x;
    x.getdata();
    x.total();
    x.print();
return 0;
}