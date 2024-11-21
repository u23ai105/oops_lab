#include<bits/stdc++.h>
using namespace std;
int n;
class Books{
    private:
    vector<string>name;
    vector<int>cost;
    public:
    Books(){
        cout<<"enter total number of Books"<<endl;
        cin>>n;
        name.resize(n);
        cost.resize(n);
        for(int i=0;i<n;i++){
            cout<<"enter the name of the "<<i+1<<" book along with ist his cost"<<endl;
            cin>>name[i];
            cin>>cost[i];
        }
    }
    void cheapest(){
        int index=0;
        int maxi=cost[0];
        for(int i=1;i<n;i++){
            if(maxi>cost[i]){
                maxi=cost[i];
                index=i;
            }
        }
        cout<<"the cheapest book is : "<<name[index]<<" and its cost is : "<<cost[index]<<endl;
    }
};
int main(){
    Books A;
    A.cheapest();
return 0;
}