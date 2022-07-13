class pro_sam {
    public static String solution(String s) {
        String answer = "";

        int tmp = 0;

        for (String str : s.split(" ")){
            for (String str2 : str.split("")){
                char st1 = 0;
                if (tmp == 0 || tmp % 2 == 0) {
                    st1 = str2.charAt(0);
                    st1 = (char)(st1 - 32);
                    answer += st1;
                }else{
                    answer += str2;
                }
                tmp++;
            }
            if (answer.length() < s.length()){
                answer += " ";
            }
            tmp = 0;
        }

        return answer;
    }

    public static void main(String[] args){
        String s ="try hello world";
        solution(s);
    }
}