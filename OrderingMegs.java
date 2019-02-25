package February;

import java.util.Scanner;

//吃货联盟订餐系统
public class OrderingMegs {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//数据主体，一个订单信息
		String[] names = new String[4];		//订餐人
		String[] dishMegs = new String[4];	//所定餐品信息
		int[] times = new int[4];			//送餐时间
		String[] addresses = new String[4];	//送餐地址
		int[] states = new int[4]; 			//订单状态，0：已预订，1：已完成
		double[] sumPrices = new double[4];	//总金额
		
		//初始化2条订单信息
		names[0] = "张晴";
		dishMegs[0] = "鱼香肉丝 1份";
		times[0] = 12;
		addresses[0] = "天成路209号";
		states[0] = 1;											
		sumPrices[0] = 24.0;
		
		names[1] = "张晴";
		dishMegs[1] = "红烧带鱼 2份";
		times[1] = 12;
		addresses[1] = "天成路209号";
		states[1] = 0;
		sumPrices[1] = 76.0;
		
		//数据主体：餐品信息
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices = {38.0,18.0,10.0};
		int[] praiseNums = new int[3];
		
		Scanner input = new Scanner(System.in);
		//循环（do-while）

		int num = -1;						//记录用户输入的数字
		do{
			//循环操作
			//显示主菜单
			System.out.println("*******************************");
			System.out.println("1:我要订餐");
			System.out.println("2:查看餐袋");
			System.out.println("3:删除订单");
			System.out.println("4:签收订单");
			System.out.println("5:我要点赞");
			System.out.println("6:退出系统");
			System.out.println("*******************************");
			
			//提示用户输入功能编号，并执行相应功能
			System.out.println("请选择：");
			int choose = input.nextInt();
			
			boolean isAdd = false;	//ture:记录找到一个空位置，false：未找到
			
			switch(choose){
			case 1:
				//1.我要订餐
				System.out.println("*****我要订餐*****");
				//（1、寻找需要插入的位置，循环遍历订餐人中第一个为空的位置；若找到，则此位置便是要插入数据的位置
				for(int i=0;i<names.length;i++){
					if(names[i] == null){
						//执行插入操作
						isAdd = true;	//记录已找到一个为空的位置
						//（2、执行添加数据操作：
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0;j<dishNames.length;j++){
							String price = prices[j] + "元";
							String praise = praiseNums[j] + "赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//（3、显示订单信息（所定餐品、订餐人、送餐时间、送餐地址、金额）
						//a、显示所有可供选择的餐品信息（用户可选餐品编号及份数）
						System.out.println("请选择所订餐品编号：");
						int chooseDish = input.nextInt();
						System.out.println("请输入所需份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + " "+number+"份";
						
						//b、输入订餐人的姓名
						System.out.println("请输入订餐人姓名：");
						String name = input.next();
						
						//c、输入送餐时间（10~20点之间整点送餐）；若输入信息有误，可重新输入
						System.out.println("请输入送餐时间（10~20点整点送餐）：");
						int time = input.nextInt();
						while(time<10	||	time>20){
							System.out.println("您输入有误，请输入10~20之间的整数：");
							time = input.nextInt();
						}
						
						//d、输入送餐地址
						System.out.println("请输入送餐地址：");
						String address = input.next();
						double sumPrice = prices[chooseDish-1] * number;
						
						//e、计算餐品总金额=餐品单价*份数+送餐费6元（若总金额大于50，减免配送费）
						double deliCharge = sumPrice>=50?0.0:6.0;
						
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您订的是："+dishMeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间"+time+"点");
						System.out.println("送餐地址："+address);
						System.out.println("餐费："+sumPrice+"元"+"\t送餐费："+deliCharge+"元");
						System.out.println("总金额："+(sumPrice+deliCharge));
						
						//（4、向数组中保存数据
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice+deliCharge;
						
						break;
					}
				}
				//若未找到，则显示餐袋已满
				if(isAdd == false){
					System.out.println("抱歉，您的餐袋已满！");
				}

				break;
			case 2:
				//2.查看餐袋
				System.out.println("*****查看餐袋*****");
				System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
				//遍历数组
				for(int i=0;i<names.length;i++){
					if(names[i] != null){
						String time = times[i]+"点";
						String sumPrice = sumPrices[i]+"元";
						String state = states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				//3.删除订单
				//（1）、输入需要删除的订单序号（序号从1 开始）
				System.out.println("*****删除订单*****");
				System.out.println("请输入要删除的订单序号：");
				int delId = input.nextInt();
				int delIndex = -1;							//待删除订单序号的下标
				boolean isDelFind = false;					//记录是否找到该订单
				//（2）、循环查找该订单
				for(int i=0;i<names.length;i++){
					//a、找到，已签收
					if(names[i] != null && states[i] == 1 && delId == i+1){
						//记录该订单序号
						delIndex = i;
						isDelFind = true;
						break;
					//b、找到，未签收，提示需签收
					}else if(names[i] != null && states[i] == 0 && delId == i+1){
						System.out.println("您选择的订单未签收，不可删除！");
						isDelFind = true;
						break;
					}
				}
				//c、未找到，提示无此订单
				if(!isDelFind){
					System.out.println("抱歉，该订单不存在！");
				}
				
				//执行删除操作（删除操作：循环移位）
				if(delIndex != -1){
					for(int i=delIndex+1;i<=names.length-1;i++){
						names[i-1] = names[i];
						dishMegs[i-1]  = dishMegs[i];
						times[i-1] =times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
				//最后一位清空
					names[names.length-1] = null;
					dishMegs[names.length-1] = null;
					times[names.length-1] = 0;
					addresses[names.length-1]= null;
					states[names.length-1]= 0;
					System.out.println("订单删除成功！");
				}
				break;
			case 4:
				//4.签收订单
				System.out.println("*****签收订单*****");
				//（1、要求用户输入一个签收的订单号
				System.out.println("请输入要签收的订单序号：");
				int signOrderId = input.nextInt();
				boolean isFind = false;				//记录是否找到订单，true：找到，false：未找到
				//2、查找该条订单（循环遍历）
				for(int i=0;i<names.length;i++){
					//a、找到，状态是已完成：提示不能再次签收
					//b、找到，状态是已预订：可签收
					
					if(names[i] != null && states[i] == 1 && signOrderId == i+1){
						System.out.println("抱歉，您选择的订单已完成签收，不可再次签收");
						isFind = true;
						break;
					}else if(names[i] != null && states[i] == 0 && signOrderId == i+1){
						states[i] = 1;				//状态值修改为已完成
						System.out.println("订单签收成功");
						isFind = true;
					}
				}
				////c、未找到：提示信息没有找到；条件判断，若未找到该条订单，方可提示未找到
				if(!isFind){
					System.out.println("抱歉，该订单不存在！");
				}
				
				
				break;
			case 5:
				//5.我要点赞
				System.out.println("*****我要点赞*****");
				//（1）、显示可点赞的餐品列表
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0;j<dishNames.length;j++){
					String price = prices[j] + "元";
					String praise = praiseNums[j] + "赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//（2）、输入点赞的餐品序号
				System.out.println("请输入要点赞的餐品序号：");
				int dishId = input.nextInt();
				//（3）、点赞数+1
				praiseNums[dishId-1]++;
				//（4）、显示
				System.out.println("点赞成功！");
				System.out.println(dishNames[dishId-1]+"  "+praiseNums[dishId-1]+"赞");
				break;
			case 6:
				//6.退出系统			
				//(1、当显示主菜单之后，用户输入6或者1~6之外的数据
				//(2、执行完相应功能之后，提示输入0返回时，输入一个非0的数字
				break;
			default:
				//用户输入超出范围时
				
				break;
			}
			//当用户输入的功能编号为1~5之外的数字时，退出循环，否则将提示输入0返回
			if(choose<1 || choose>5){
				break;
			}else{
				//提示输入0返回
				System.out.println("输入0返回：");
				num = input.nextInt();
			}
			
		}while(num == 0);
		System.out.println("谢谢使用，欢迎下次光临！");
	}
}
