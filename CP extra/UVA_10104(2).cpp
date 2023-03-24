

#include<bits/stdc++.h>

using namespace std;
int x,y,g;

void extended_euclid(int a, int b)
{
    if(b==0)
    {
        x = 1;
        y = 0;
        g = a;

        return;
    }

    extended_euclid(b, a%b);

    int sx = y;
    int sy = x - ((a/b)*y);

    x = sx;

    y = sy;
}
int main()
{
    while(1)
    {
        int a, b;
        cin>>a>>b;

        extended_euclid(a, b);

        cout<<x<<" "<<y<<" "<<g<<endl;
    }

    return 0;
}
