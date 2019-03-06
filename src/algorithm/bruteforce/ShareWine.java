package algorithm.bruteforce;

public class ShareWine {
	
    private int b1 = 12;
    private int b2 = 8;
    private int b3 = 5;
    private int m =6;

    public void shareWine(int bb1,int bb2,int bb3) {
        System.out.println("bb1:"+bb1+",bb2:"+bb2+",bb3:"+bb3);
        if(bb1 ==m || bb2 ==m || bb3 ==m) {
            System.out.println("Done "+m);
            return;
        }
        if(bb2!=0&&bb3!=b3) {
            if(bb2+bb3<=b3) {
                shareWine(bb1,0,bb2+bb3);
            }else {
                shareWine(bb1,bb2-(b3-bb3),b3);
            }
        }else if(bb3 ==b3) {
            if(bb3+bb1<=b1) {
                shareWine(bb1+bb3,bb2,0);
            }else {
                shareWine(b1,bb2,bb3-(b1-bb1));
            }
        }else if(bb2==0) {
            if(bb1<=b2) {
                shareWine(0,bb1,bb3);
            }else {
                shareWine(bb1-b2,b2,bb2+bb3);
            }
        }
    }

    public static void main(String[] args) {
        ShareWine sw = new ShareWine();
        sw.shareWine(12, 0, 0);
    }

}