#include<bits/stdc++.h>
using namespace std;
int n;
class students{
    private:
    vector<string>name;
    vector<int>marks;
    public:
    students(){
        cout<<"enter total number of students"<<endl;
        cin>>n;
        name.resize(n);
        marks.resize(n);
        for(int i=0;i<n;i++){
            cout<<"enter the name of the "<<i+1<<" student along with ist his marks"<<endl;
            cin>>name[i];
            cin>>marks[i];
        }
    }
    void topper(){
        int index=0;
        int maxi=marks[0];
        for(int i=1;i<n;i++){
            if(maxi<marks[i]){
                maxi=marks[i];
                index=i;
            }
        }
        cout<<"the topper of the calss is : "<<name[index]<<" and marks are : "<<marks[index]<<endl;
    }
};
int main(){
    students A;
    A.topper();
return 0;
}