#include<bits/stdc++.h>
using namespace std;
class A{
    private:
    int a;
    public:
    A(){
        cout<<"class A constructor"<<endl;
    }
    ~A(){
        cout<<"class A deconstructor"<<endl;
    }
    void input(int a){
        this->a=a;
    }
    void display(){
        cout<<a<<endl;
    }
};
int main(){
    int n;
    cout<<"enter the size of array"<<endl;
    cin>>n;
    A *arr=new A[n];
    for(int i=0;i<n;i++){
        int val;
        cin>>val;
        arr[i].input(val);
    }
    for(int i=0;i<n;i++){
        arr[i].display();
    }
    delete []arr;
return 0;
}