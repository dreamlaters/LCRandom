public class Q273 {
    static String[] gw={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static String[] sw={"Zero","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] sjw={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tw={"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num==0){
            return gw[0];
        }
        StringBuilder sb=new StringBuilder();
        int tws=1_000_000_000;
        for (int i = 3; i >=0 ; i--) {
            int a=num/tws;
            if(a!=0){
                String h=getH(a);
                sb.append(h).append(' ').append(tw[i]).append(' ');
            }
            num=num%tws;
            tws/=1000;
        }
        return sb.toString().trim();
    }

    private String getH(int a) {
        StringBuilder sb=new StringBuilder();
        if(a>=100){
            int bw=a/100;
            if(a%100==0){
                sb.append(gw[bw]).append(" Hundred");
            }else{
                sb.append(gw[bw]).append(" Hundred ").append(getH(a%100));
            }
        }else if(a>=20){
            int sws=a/10;
            if(a%10==0){
                sb.append(sw[sws]);
            }else{
                sb.append(sw[sws]).append(' ').append(getH(a%10));
            }
        }else if(a>=10){
            sb.append(sjw[a%10]);
        }else {
            sb.append(gw[a]);
        }
        return sb.toString();
    }
}
