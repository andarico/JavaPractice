package February;

import java.util.Scanner;

//�Ի����˶���ϵͳ
public class OrderingMegs {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�������壬һ��������Ϣ
		String[] names = new String[4];		//������
		String[] dishMegs = new String[4];	//������Ʒ��Ϣ
		int[] times = new int[4];			//�Ͳ�ʱ��
		String[] addresses = new String[4];	//�Ͳ͵�ַ
		int[] states = new int[4]; 			//����״̬��0����Ԥ����1�������
		double[] sumPrices = new double[4];	//�ܽ��
		
		//��ʼ��2��������Ϣ
		names[0] = "����";
		dishMegs[0] = "������˿ 1��";
		times[0] = 12;
		addresses[0] = "���·209��";
		states[0] = 1;											
		sumPrices[0] = 24.0;
		
		names[1] = "����";
		dishMegs[1] = "���մ��� 2��";
		times[1] = 12;
		addresses[1] = "���·209��";
		states[1] = 0;
		sumPrices[1] = 76.0;
		
		//�������壺��Ʒ��Ϣ
		String[] dishNames = {"���մ���","������˿","ʱ���߲�"};
		double[] prices = {38.0,18.0,10.0};
		int[] praiseNums = new int[3];
		
		Scanner input = new Scanner(System.in);
		//ѭ����do-while��

		int num = -1;						//��¼�û����������
		do{
			//ѭ������
			//��ʾ���˵�
			System.out.println("*******************************");
			System.out.println("1:��Ҫ����");
			System.out.println("2:�鿴�ʹ�");
			System.out.println("3:ɾ������");
			System.out.println("4:ǩ�ն���");
			System.out.println("5:��Ҫ����");
			System.out.println("6:�˳�ϵͳ");
			System.out.println("*******************************");
			
			//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			System.out.println("��ѡ��");
			int choose = input.nextInt();
			
			boolean isAdd = false;	//ture:��¼�ҵ�һ����λ�ã�false��δ�ҵ�
			
			switch(choose){
			case 1:
				//1.��Ҫ����
				System.out.println("*****��Ҫ����*****");
				//��1��Ѱ����Ҫ�����λ�ã�ѭ�������������е�һ��Ϊ�յ�λ�ã����ҵ������λ�ñ���Ҫ�������ݵ�λ��
				for(int i=0;i<names.length;i++){
					if(names[i] == null){
						//ִ�в������
						isAdd = true;	//��¼���ҵ�һ��Ϊ�յ�λ��
						//��2��ִ��������ݲ�����
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishNames.length;j++){
							String price = prices[j] + "Ԫ";
							String praise = praiseNums[j] + "��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//��3����ʾ������Ϣ��������Ʒ�������ˡ��Ͳ�ʱ�䡢�Ͳ͵�ַ����
						//a����ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ���û���ѡ��Ʒ��ż�������
						System.out.println("��ѡ��������Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.println("���������������");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + " "+number+"��";
						
						//b�����붩���˵�����
						System.out.println("�����붩����������");
						String name = input.next();
						
						//c�������Ͳ�ʱ�䣨10~20��֮�������Ͳͣ�����������Ϣ���󣬿���������
						System.out.println("�������Ͳ�ʱ�䣨10~20�������Ͳͣ���");
						int time = input.nextInt();
						while(time<10	||	time>20){
							System.out.println("����������������10~20֮���������");
							time = input.nextInt();
						}
						
						//d�������Ͳ͵�ַ
						System.out.println("�������Ͳ͵�ַ��");
						String address = input.next();
						double sumPrice = prices[chooseDish-1] * number;
						
						//e�������Ʒ�ܽ��=��Ʒ����*����+�Ͳͷ�6Ԫ�����ܽ�����50���������ͷѣ�
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("�������ǣ�"+dishMeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ��"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+address);
						System.out.println("�ͷѣ�"+sumPrice+"Ԫ"+"\t�Ͳͷѣ�"+deliCharge+"Ԫ");
						System.out.println("�ܽ�"+(sumPrice+deliCharge));
						
						//��4���������б�������
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice+deliCharge;
						
						break;
					}
				}
				//��δ�ҵ�������ʾ�ʹ�����
				if(isAdd == false){
					System.out.println("��Ǹ�����Ĳʹ�������");
				}

				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("*****�鿴�ʹ�*****");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				//��������
				for(int i=0;i<names.length;i++){
					if(names[i] != null){
						String time = times[i]+"��";
						String sumPrice = sumPrices[i]+"Ԫ";
						String state = states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				//3.ɾ������
				//��1����������Ҫɾ���Ķ�����ţ���Ŵ�1 ��ʼ��
				System.out.println("*****ɾ������*****");
				System.out.println("������Ҫɾ���Ķ�����ţ�");
				int delId = input.nextInt();
				int delIndex = -1;							//��ɾ��������ŵ��±�
				boolean isDelFind = false;					//��¼�Ƿ��ҵ��ö���
				//��2����ѭ�����Ҹö���
				for(int i=0;i<names.length;i++){
					//a���ҵ�����ǩ��
					if(names[i] != null && states[i] == 1 && delId == i+1){
						//��¼�ö������
						delIndex = i;
						isDelFind = true;
						break;
					//b���ҵ���δǩ�գ���ʾ��ǩ��
					}else if(names[i] != null && states[i] == 0 && delId == i+1){
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind = true;
						break;
					}
				}
				//c��δ�ҵ�����ʾ�޴˶���
				if(!isDelFind){
					System.out.println("��Ǹ���ö��������ڣ�");
				}
				
				//ִ��ɾ��������ɾ��������ѭ����λ��
				if(delIndex != -1){
					for(int i=delIndex+1;i<=names.length-1;i++){
						names[i-1] = names[i];
						dishMegs[i-1]  = dishMegs[i];
						times[i-1] =times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
				//���һλ���
					names[names.length-1] = null;
					dishMegs[names.length-1] = null;
					times[names.length-1] = 0;
					addresses[names.length-1]= null;
					states[names.length-1]= 0;
					System.out.println("����ɾ���ɹ���");
				}
				break;
			case 4:
				//4.ǩ�ն���
				System.out.println("*****ǩ�ն���*****");
				//��1��Ҫ���û�����һ��ǩ�յĶ�����
				System.out.println("������Ҫǩ�յĶ�����ţ�");
				int signOrderId = input.nextInt();
				boolean isFind = false;				//��¼�Ƿ��ҵ�������true���ҵ���false��δ�ҵ�
				//2�����Ҹ���������ѭ��������
				for(int i=0;i<names.length;i++){
					//a���ҵ���״̬������ɣ���ʾ�����ٴ�ǩ��
					//b���ҵ���״̬����Ԥ������ǩ��
					
					if(names[i] != null && states[i] == 1 && signOrderId == i+1){
						System.out.println("��Ǹ����ѡ��Ķ��������ǩ�գ������ٴ�ǩ��");
						isFind = true;
						break;
					}else if(names[i] != null && states[i] == 0 && signOrderId == i+1){
						states[i] = 1;				//״ֵ̬�޸�Ϊ�����
						System.out.println("����ǩ�ճɹ�");
						isFind = true;
					}
				}
				////c��δ�ҵ�����ʾ��Ϣû���ҵ��������жϣ���δ�ҵ�����������������ʾδ�ҵ�
				if(!isFind){
					System.out.println("��Ǹ���ö��������ڣ�");
				}
				
				
				break;
			case 5:
				//5.��Ҫ����
				System.out.println("*****��Ҫ����*****");
				//��1������ʾ�ɵ��޵Ĳ�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishNames.length;j++){
					String price = prices[j] + "Ԫ";
					String praise = praiseNums[j] + "��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//��2����������޵Ĳ�Ʒ���
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishId = input.nextInt();
				//��3����������+1
				praiseNums[dishId-1]++;
				//��4������ʾ
				System.out.println("���޳ɹ���");
				System.out.println(dishNames[dishId-1]+"  "+praiseNums[dishId-1]+"��");
				break;
			case 6:
				//6.�˳�ϵͳ			
				//(1������ʾ���˵�֮���û�����6����1~6֮�������
				//(2��ִ������Ӧ����֮����ʾ����0����ʱ������һ����0������
				break;
			default:
				//�û����볬����Χʱ
				
				break;
			}
			//���û�����Ĺ��ܱ��Ϊ1~5֮�������ʱ���˳�ѭ����������ʾ����0����
			if(choose<1 || choose>5){
				break;
			}else{
				//��ʾ����0����
				System.out.println("����0���أ�");
				num = input.nextInt();
			}
			
		}while(num == 0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
	}
}
