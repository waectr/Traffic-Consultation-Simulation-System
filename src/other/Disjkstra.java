package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import person.DijkLine;

public class Disjkstra {

	private int[] mapping;//存图的结点
	private int[][] matrix;//存图的二维数组
	private int end;

	//初始化图的顶底
	public Disjkstra(int[][] a,int[] b) {  //在new这个类时就通过vertexes将所有的结点传了进来
		int len=b.length;
		mapping=new int[len];
		matrix=new int[len][len];
		for(int i=0;i<len;i++) {
			mapping[i]=b[i];
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				matrix[i][j]=a[i][j];
			}
		}
	}
	
	//diji算法实现最短路径
	public List<DijkLine> Dijkstra(int start,int endl) {
		end=endl;
		int length=mapping.length;
		int x=-1;
		for(int i=0;i<length;i++) {//此处在寻找起点
			if(mapping[i]==start) {
				x=i;
				break;
			}
		}
		if(x==-1) {
			throw new RuntimeException("路径起点错误");
		}
		
		int[] s=new int[length];//初始化为0
		int[][] distance=matrix;//存储两个坐标之间的最短距离
		int[] path=new int[length];//存储路径
		
		//初始化path数组
		for(int i=0;i<length;i++) {  //对存储的这个图的路径进行查找，如果该值为0就证明这两个点没有联系
			if(matrix[x][i]>0) {
				path[i]=x;//可达，赋值
			}else {
				path[i]=-1;//不可到达，前一个坐标为-1
			}
		}
		
		s[x]=1;//将起点加入s
		
		for(int i=0;i<length;i++)
		 {
			 int min=Integer.MAX_VALUE;//首先需要寻找start顶点到各顶点最短的路径
			 int v=0;  //记录x到各顶点最短的
			 for(int j=0;j<length;j++)
			 {
				  if(s[j]!=1&&x!=j&&distance[x][j]!=0&&distance[x][j]<min)//
				  {
					  min=distance[x][j];
					  v=j;
				  }
			 }
			  //v是目前x到各顶点最短的
			 s[v]=1;
			 //修正最短路径distance及最短距离path
			 for(int j=0;j<length;j++)
			 {
				 if(s[j]!=1&&distance[v][j]!=0&&(min+distance[v][j]<distance[x][j]||distance[x][j]==0))
				 {
					 //说明加入了中间顶点之后找到了更短的路径
					 distance[x][j]=min+distance[v][j];
					 path[j]=v;	 
				 }
			 }
		 }
		//此处借助堆来读取数据,创建一个int型的堆
		 List<DijkLine> list=new ArrayList<DijkLine>();
		 Stack <Integer>stack=new Stack<Integer>();
		 for(int i=0;i<length;i++)
		 {
			 if(distance[x][i]!=0)
			 {
				 System.out.println(mapping[x]+"-->"+mapping[i]+" "+distance[x][i]);
				 //path存储路径，可以逆序输出，可以借助栈实现正序输出
				 int index=i;
				 while(index!=-1&&mapping[i]==end)
				 {
					 stack.push(mapping[index]);
					 index=path[index];
				 }
			 }
			 DijkLine d=new DijkLine(mapping[x],mapping[i],distance[x][i],stack);
			 list.add(d);
		 }
		 return list;
	}
}
