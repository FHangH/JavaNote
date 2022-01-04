package project4;

import java.util.Arrays;

public class Demo1
{
    int x,y,z;
    int[] flagNo=new int[]{0,0,0, 0,0,0, 0,0,0};
    public static void main(String[] args)
    {
        Demo1 abc=new Demo1();
        abc.findRes();
    }

    public void stau(int i)
    {
        for (int j = 0; j <3 ; j++)
        {
            if (i%10!=0)
                flagNo[i%10-1]=1;
            i=i/10;
        }
    }

    public boolean isRepeat()
    {
        boolean tmp=true;
        for (int j:flagNo)
        {
            if (j == 0)
            {
                tmp = false;
                break;
            }
        }
        return tmp;
    }

    public void findRes()
    {
        int counter=0;
        for (x=123;x<=987;x++)
            for (y=x+1;y<987;y++)
            {
                Arrays.fill(flagNo, 0);

                z=x+y;
                if (z>123&&z<=987)
                {
                    if (isRepeatXYZ())
                    {
                        counter++;
                        System.out.println(x+"+"+y+"="+z+"【"+counter+"】");
                    }
                }
            }

    }

    public boolean isRepeatXYZ()
    {
        boolean tmp;
        stau(x);
        stau(y);
        stau(z);
        tmp=isRepeat();
        return tmp;
    }
}
