/**
 * 
 */
package calculator;

import java.util.Scanner;

/**
 * @author Draven
 *
 */
public class PolynomialsInformation {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String replaceoldstrto0(int indexof0mulbackadd,int indexof0mulforwardadd,String oldstr)
{
int frontindex = indexof0mulforwardadd + 1;
String endstr;
if(indexof0mulbackadd == -1)
{
endstr = "";
}
else
{
endstr = oldstr.substring(indexof0mulbackadd);
}
String begin = oldstr.substring(0, frontindex);
String result = "";
result = result + begin + "0" + endstr;
return result;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String quchu0and1(String str)
{

return str;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String replaceoldchartonewchar(int index,String newchar,String oldstr)
{
if(oldstr.length() == 1)
{
return newchar;
}
else
{
String begin = oldstr.substring(0,index);
String end = oldstr.substring(index+1,oldstr.length());
return begin + newchar+ end;
}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int havacharinstr(String str,char cha)
{
int num = 0;
for(int i=0;i<str.length();i++)
{
if(str.charAt(i) == cha)
{
num += 1;
}
}
return num;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int havavary(String strin)//判断式子中是否有变量 1是有变量 0是没有变量
{
for(int i=0;i<strin.length();i++)
{
if(strin.charAt(i)>62)
{
return 1;
}
}
return 0;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String PolynomialsAssignment(String[] chuliarray,String DuoXiangShi)//处理表达式，形成自定义数据结构
{
if(chuliarray.length == 1)
{
return DuoXiangShi;
}
else
{
for(int i=1;i<chuliarray.length;i++)
{
String avary = chuliarray[i].split("\\=")[0];
String num1 	= chuliarray[i].split("\\=")[1];
DuoXiangShi=DuoXiangShi.replaceAll(avary, num1);
}
String resultofthis = PolynomialsSimplify(DuoXiangShi);
return resultofthis;
}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String PolynomialsSimplify(String duoxiangshiqian)//求值，简化
{
String ResultOfThis = null;
int haveshutimes = 0;
String[] quchujiafa = duoxiangshiqian.split("\\+");
String[] resultarray = new String[20];
String[] zimuji = new String[20];
int[] huavaryhere = new int[20];

if(quchujiafa.length > 0)
{
for(int i=0;i<quchujiafa.length;i++)//就剩乘法了
{
String[] quchujiacheng = null;
int[] quchujiachengmark = new int[20];
quchujiacheng = quchujiafa[i].split("\\*");//就剩字母和数字了



for(int j=0;j<quchujiacheng.length;j++)
{

if(quchujiacheng[j].charAt(0)>47 && quchujiacheng[j].charAt(0)<58)
{
quchujiachengmark[j]=1;//数字标志
}
else
{
quchujiachengmark[j]=2;//变量标志
}
}
int shuziji=1;
for(int k=0;k<quchujiacheng.length;k++)//把数字都乘在一起
{
if(quchujiachengmark[k]==1)
{
shuziji = shuziji * Integer.parseInt(quchujiacheng[k]);
}
}

resultarray[i] = String.valueOf(shuziji);

for (int p=0;p<quchujiacheng.length;p++)
{
int m=0;
if (quchujiachengmark[p]==2)
{
if (resultarray[i].compareTo("0")==0)
{
break;
}
zimuji[m]=quchujiacheng[p];

resultarray[i] = resultarray[i] + "*" + zimuji[m];
if (zimuji[m].length()>=2) //判断双字母变量
{
System.out.println("Error");
System.exit(0);
}
m=m+1;
}
}  //wtf





}
}

for(int p=0;p<quchujiafa.length;p++)
{
huavaryhere[p] = havavary(resultarray[p]);
}
for(int q=0;q<quchujiafa.length;q++)
{
if(huavaryhere[q]==0)
{
haveshutimes += 1;
}
}
if(haveshutimes>=2)
{
int temp_num = 0;
for(int r=0;r<quchujiafa.length;r++)
{
if(huavaryhere[r]==0)
{
temp_num += Integer.parseInt(resultarray[r]);
}
}
ResultOfThis = String.valueOf(temp_num);

for(int u=0;u<quchujiafa.length;u++)
{
if(huavaryhere[u]==1)
{
if (resultarray[u].compareTo("0")!=0)
{

ResultOfThis = ResultOfThis + "+" + resultarray[u];
}
}
}
}
else
{
int w=1;
ResultOfThis = resultarray[0];
if(resultarray[0].compareTo("0")==0)
{
ResultOfThis = null;
}

if(quchujiafa.length>=2)
{
for(w=1;w<quchujiafa.length;w++)
{
if (resultarray[w].compareTo("0")!=0)
{
ResultOfThis = ResultOfThis + "+" + resultarray[w];
}
}
}

}
ResultOfThis = quchu0and1(ResultOfThis);
return ResultOfThis;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String PolynomialsDerivation(char qiudaovary,String DuoXiangShi)//求导
{
String[] zhishengchengfa = DuoXiangShi.split("\\+");
String[] zhishengchengfachulihou = new String[20]; 
for(int i=0;i<zhishengchengfa.length;i++)
{
int numofchar = havacharinstr(zhishengchengfa[i],qiudaovary);
if(numofchar == 0)
{
zhishengchengfachulihou[i] = "0";
}
else
{
int varyindex = zhishengchengfa[i].indexOf(String.valueOf(qiudaovary));
zhishengchengfachulihou[i] = replaceoldchartonewchar(varyindex,String.valueOf(numofchar),zhishengchengfa[i]);
}
}
String zhenghe =  zhishengchengfachulihou[0];
if(zhishengchengfa.length >= 2)
{
for(int k=1;k<zhishengchengfa.length;k++)
{
zhenghe = zhenghe + "+" +zhishengchengfachulihou[k];
}
}
return PolynomialsSimplify(zhenghe);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void main(String[] args)
{

Scanner s = new Scanner(System.in);
PolynomialsInformation polynomials = new PolynomialsInformation();
String linestr=s.nextLine();

String DuoXiangShi = polynomials.PolynomialsSimplify(linestr);


System.out.println(DuoXiangShi);
while(true)
{	
String ChuLi=s.nextLine();
String[] cmd=ChuLi.split(" ");
if (ChuLi.charAt(0)=='!')
{
if(ChuLi.charAt(1)=='d')//求导
{
char qiudaovary = ChuLi.charAt(4);
int qiudaoindex = DuoXiangShi.indexOf(String.valueOf(qiudaovary));
if(qiudaoindex == -1)
{
System.out.println("Error,no variable");
continue;
}
else
{
String qiudaoresult= polynomials.PolynomialsDerivation(qiudaovary,DuoXiangShi);
System.out.println(qiudaoresult);

}
}
else if (cmd[0].compareTo("!quit")==0)
{
System.exit(0);
}

else if(cmd[0].compareTo("!simplify")==0)//给值替换
{
String[] chuliarray = ChuLi.split(" ");

System.out.println(polynomials.PolynomialsAssignment(chuliarray,DuoXiangShi));
}
else
{
System.out.println("Error ");
System.exit(0);
}


continue;



}
else
{
DuoXiangShi = ChuLi;
System.out.println(ChuLi);
}

}
}
}
