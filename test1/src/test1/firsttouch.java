package test1;

import java.util.Scanner;


public class firsttouch
{
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
/*////////////////////////////去除0*
	/*int indexof0mul;
	do
	{
	indexof0mul = str.indexOf("0*");
	if(str.indexOf("0*") >= 0)
	{
	indexof0mul = str.indexOf("0*");
	int indexof0mulbackadd = str.indexOf("+", indexof0mul+1);
	int indexof0mulforwardadd = str.substring(0,indexof0mul).lastIndexOf("+");////////////here////////////////
	str = replaceoldstrto0(indexof0mulbackadd,indexof0mulforwardadd,str);
	
	}
	}while(indexof0mul >= 0);

	/////////////////////////去除*0
	int indexofmul0;
	do
	{
	indexofmul0 = str.indexOf("*0");
	if(str.indexOf("*0") >= 0)
	{
	indexofmul0 = str.indexOf("*0");
	int indexof0mulbackadd = str.indexOf("+", indexofmul0+1);
	int indexof0mulforwardadd = str.substring(0,indexofmul0).lastIndexOf("+");////////////here////////////////
	str = replaceoldstrto0(indexof0mulbackadd,indexof0mulforwardadd,str);
	
	}
	}while(indexofmul0 >= 0);
//////////////////////////去除1*

int indexof1mul;
do
{
indexof1mul = str.indexOf("1*");
if(str.indexOf("1*") >= 0)
{
indexof1mul = str.indexOf("1*");
String begin = str.substring(0,indexof1mul);
String end = str.substring(indexof1mul+2,str.length());
str = "" + begin + end;
}
}while(indexof1mul >= 0);
//////////////////////////去除*1
int indexofmul1;
do
{
indexofmul1 = str.indexOf("*1");
if(str.indexOf("*1") >= 0)
{
indexofmul1 = str.indexOf("*1");
String begin = str.substring(0,indexofmul1);
String end = str.substring(indexofmul1+2,str.length());
str = "" + begin + end;
}
}while(indexofmul1 >= 0);

//////////////////////////////////////去除0+
int indexof0add;
do
{
indexof0add = str.indexOf("0+");
if(str.indexOf("0+") >= 0)
{
indexof0add = str.indexOf("0+");
String begin = str.substring(0,indexof0add);
String end = str.substring(indexof0add+2,str.length());
str = "" + begin + end;
}		
}while(indexof0add >= 0);
/////////////////////////////////////去除+0
int indexofadd0;
do
{
indexofadd0 = str.indexOf("+0");
if(str.indexOf("+0") >= 0)
{
indexofadd0 = str.indexOf("+0");
String begin = str.substring(0,indexofadd0);
String end = str.substring(indexofadd0+2,str.length());
str = "" + begin + end;
}		
}while(indexofadd0 >= 0);
*/
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
	String expression(String[] chuliarray,String DuoXiangShi)//处理表达式，形成自定义数据结构
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
			String resultofthis = simplify(DuoXiangShi);
			return resultofthis;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	String simplify(String duoxiangshiqian)//求值，简化
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
					/*if(quchujiacheng[j].length()>=2)
					{
						System.out.println("Error");
						System.exit(0);
					}*/
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

				
				
				/*
				for(int f=0;f<quchujiacheng.length;f++)
				{
					if(quchujiachengmark[f]==2)
					{
						resultarray[i] = resultarray[i] + "*" + zimuji[i];//quchujiacheng[i]有问题！！！！
					}
				}*/
				
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
			//for(int u=0;u<resultarray.length;u++)
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
	String derivative(char qiudaovary,String DuoXiangShi)//求导
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
		return simplify(zhenghe);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		firsttouch firsttouch1 = new firsttouch();
		String linestr=s.nextLine();
		/////////////////////////////////////////
		//System.out.println(linestr);
		/////////////////////////////////////////
		String DuoXiangShi = firsttouch1.simplify(linestr);
		//String DuoXiangShi = Input;
		
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
						String qiudaoresult= firsttouch1.derivative(qiudaovary,DuoXiangShi);
						System.out.println(qiudaoresult);
						//DuoXiangShi = qiudaoresult;
						//System.out.println(DuoXiangShi);
					}
				}
				else if (cmd[0].compareTo("!quit")==0)
				{
					System.exit(0);
				}
				
				else if(cmd[0].compareTo("!simplify")==0)//给值替换
				{
					String[] chuliarray = ChuLi.split(" ");
					//DuoXiangShi = firsttouch1.expression(chuliarray,DuoXiangShi);
					System.out.println(firsttouch1.expression(chuliarray,DuoXiangShi));
				}
				else
				{
					System.out.println("Error");
					System.exit(0);
				}
				
				//System.out.println(DuoXiangShi);
				continue;
				
				
				
			}
			else
			{
				DuoXiangShi = ChuLi;
				System.out.println(ChuLi);
			}
			//DuoXiangShi = firsttouch1.simplify(ChuLi);
			//System.out.println(DuoXiangShi);
			
		}
	}
}
