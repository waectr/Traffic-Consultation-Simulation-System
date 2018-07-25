package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import person.DijkLine;

public class Disjkstra {

	private int[] mapping;//��ͼ�Ľ��
	private int[][] matrix;//��ͼ�Ķ�ά����
	private int end;

	//��ʼ��ͼ�Ķ���
	public Disjkstra(int[][] a,int[] b) {  //��new�����ʱ��ͨ��vertexes�����еĽ�㴫�˽���
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
	
	//diji�㷨ʵ�����·��
	public List<DijkLine> Dijkstra(int start,int endl) {
		end=endl;
		int length=mapping.length;
		int x=-1;
		for(int i=0;i<length;i++) {//�˴���Ѱ�����
			if(mapping[i]==start) {
				x=i;
				break;
			}
		}
		if(x==-1) {
			throw new RuntimeException("·��������");
		}
		
		int[] s=new int[length];//��ʼ��Ϊ0
		int[][] distance=matrix;//�洢��������֮�����̾���
		int[] path=new int[length];//�洢·��
		
		//��ʼ��path����
		for(int i=0;i<length;i++) {  //�Դ洢�����ͼ��·�����в��ң������ֵΪ0��֤����������û����ϵ
			if(matrix[x][i]>0) {
				path[i]=x;//�ɴ��ֵ
			}else {
				path[i]=-1;//���ɵ��ǰһ������Ϊ-1
			}
		}
		
		s[x]=1;//��������s
		
		for(int i=0;i<length;i++)
		 {
			 int min=Integer.MAX_VALUE;//������ҪѰ��start���㵽��������̵�·��
			 int v=0;  //��¼x����������̵�
			 for(int j=0;j<length;j++)
			 {
				  if(s[j]!=1&&x!=j&&distance[x][j]!=0&&distance[x][j]<min)//
				  {
					  min=distance[x][j];
					  v=j;
				  }
			 }
			  //v��Ŀǰx����������̵�
			 s[v]=1;
			 //�������·��distance����̾���path
			 for(int j=0;j<length;j++)
			 {
				 if(s[j]!=1&&distance[v][j]!=0&&(min+distance[v][j]<distance[x][j]||distance[x][j]==0))
				 {
					 //˵���������м䶥��֮���ҵ��˸��̵�·��
					 distance[x][j]=min+distance[v][j];
					 path[j]=v;	 
				 }
			 }
		 }
		//�˴�����������ȡ����,����һ��int�͵Ķ�
		 List<DijkLine> list=new ArrayList<DijkLine>();
		 Stack <Integer>stack=new Stack<Integer>();
		 for(int i=0;i<length;i++)
		 {
			 if(distance[x][i]!=0)
			 {
				 System.out.println(mapping[x]+"-->"+mapping[i]+" "+distance[x][i]);
				 //path�洢·��������������������Խ���ջʵ���������
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
