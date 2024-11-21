#include<bits/stdc++.h>
using namespace std;
int n;
class Matrix{
    private:
    int **m1;
    int **m2;
    public:
    Matrix(){
        cout<<"enter the size of the matrix"<<endl;
        cin>>n;
        m1=new int*[n];
        m2=new int*[n];
        for(int i=0;i<n;i++){
            m1[i]=new int[n];
            m2[i]=new int[n];
        }
        cout<<"enter the matrix 1 values"<<endl;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>m1[i][j];
            }
        }
        cout<<"enter the matrix 2 values"<<endl;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>m2[i][j];
            }
        }
    }
    ~Matrix(){
        cout<<"The memory is freed up"<<endl;
    }
    void add(){
        int m3[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m3[i][j]=m1[i][j]+m2[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cout<<m3[i][j]<<" ";
            }
            cout<<endl;
        }
    }
};
int main(){
    Matrix M;
    M.add();
return 0;
}